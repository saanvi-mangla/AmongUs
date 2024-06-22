package io.github.unjoinable.amongus;

import io.github.unjoinable.amongus.commands.TestCommand;
import io.github.unjoinable.amongus.data.Constants;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.minestom.server.MinecraftServer;
import net.minestom.server.command.CommandManager;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.extras.MojangAuth;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.InstanceManager;
import net.minestom.server.registry.DynamicRegistry;
import net.minestom.server.world.DimensionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmongUs {
    private static final MiniMessage miniMessage = MiniMessage.miniMessage();
    private static final Logger logger = LoggerFactory.getLogger(AmongUs.class);
    private static InstanceContainer hubInstance;
    private static InstanceManager instanceManager;
    private static GameInstanceStorage instanceStorage;
    private static GlobalEventHandler eventHandler;

    public static void main(String[] args) {
        //Initialization
        MinecraftServer server = MinecraftServer.init();
        MojangAuth.init();
        MinecraftServer.setBrandName(Constants.BRAND);
        instanceManager = MinecraftServer.getInstanceManager();
        instanceStorage = new GameInstanceStorage();

        DynamicRegistry.Key<DimensionType> dimension = MinecraftServer.getDimensionTypeRegistry().register("hub", Constants.FULL_BRIGHT_DIM);
        hubInstance = instanceManager.createInstanceContainer(dimension);
        logger.info("Starting server on port {}. Powered by Minestom, Engineered by unjoinable", Constants.PORT);

        eventHandler = MinecraftServer.getGlobalEventHandler();

        eventHandler.addListener(AsyncPlayerConfigurationEvent.class, event -> {
            event.setSpawningInstance(hubInstance);
        });

        CommandManager commandManager = MinecraftServer.getCommandManager();
        commandManager.register(new TestCommand());

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