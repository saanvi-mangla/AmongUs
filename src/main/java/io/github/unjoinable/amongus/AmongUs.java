package io.github.unjoinable.amongus;

import io.github.unjoinable.amongus.commands.ResourceTest;
import io.github.unjoinable.amongus.commands.TestCommand;
import io.github.unjoinable.amongus.data.Constants;
import io.github.unjoinable.amongus.game.GameInstanceStorage;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.minestom.server.MinecraftServer;
import net.minestom.server.command.CommandManager;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.extras.MojangAuth;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.InstanceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.github.unjoinable.amongus.data.Constants.DIMENSION;

public class AmongUs {
    private static final MiniMessage miniMessage = MiniMessage.miniMessage();
    private static final Logger logger = LoggerFactory.getLogger(AmongUs.class);
    private static InstanceContainer hubInstance;
    private static InstanceManager instanceManager;
    private static GameInstanceStorage instanceStorage;

    public static void main(String[] args) {
        //Initialization
        MinecraftServer server = MinecraftServer.init();
        MojangAuth.init();
        MinecraftServer.setBrandName(Constants.BRAND);
        instanceManager = MinecraftServer.getInstanceManager();
        instanceStorage = new GameInstanceStorage();

        hubInstance = instanceManager.createInstanceContainer(DIMENSION);
        logger.info("Starting server on port {}. Powered by Minestom, Engineered by unjoinable", Constants.PORT);

        GlobalEventHandler eventHandler = MinecraftServer.getGlobalEventHandler();

        eventHandler.addListener(AsyncPlayerConfigurationEvent.class, event -> {
            event.setSpawningInstance(hubInstance);
        });

        CommandManager commandManager = MinecraftServer.getCommandManager();
        commandManager.register(new TestCommand()); // FOR TESTING PURPOSES ONLY
        commandManager.register(new ResourceTest());
        server.start("0.0.0.0", Constants.PORT);
    }


    /**
     * @return The instance manager
     */
    public static InstanceManager getInstanceManager() {
        return instanceManager;
    }

    /**
     * @return The logger instance
     */
    public static Logger getLogger() {
        return logger;
    }

    /**
     * @return Instance storage of all ACTIVE games or operate on game instance logic
     */
    public static GameInstanceStorage getInstanceStorage() {
        return instanceStorage;
    }

    /**
     * @return Initialized instance of Mini Message utils
     */
    public static MiniMessage getMiniMessage() {
        return miniMessage;
    }
}