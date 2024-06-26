package io.github.unjoinable.amongus.game;

import io.github.unjoinable.amongus.AmongUs;
import io.github.unjoinable.amongus.data.Constants;
import io.github.unjoinable.amongus.enums.Crewmate;
import io.github.unjoinable.amongus.util.PlayerHeader;
import net.minestom.server.entity.Player;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.anvil.AnvilLoader;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;

import static io.github.unjoinable.amongus.util.MiniMessageTemplate.MM;
import static io.github.unjoinable.amongus.util.MiniMessageTemplate.fromComponent;

public class GameInstance {
    private final HashMap<Player, Crewmate> instancePlayers = new HashMap<>();
    private final UUID instanceUUID;
    private final InstanceContainer mcInstance;

    /**
     * @param uuid UUID of the game instance
     */
    public GameInstance(UUID uuid) {
        this.instanceUUID = uuid;
        mcInstance = AmongUs.getInstanceManager().createInstanceContainer(Constants.DIMENSION);
        mcInstance.setChunkLoader(new AnvilLoader(Constants.WORLD_PATH));
        AmongUs.getLogger().info("Creating a new instance for {}", instanceUUID);
    }

    public void start() {
        instancePlayers.forEach((player, _) -> {
            try {
                player.setInstance(mcInstance, Constants.SKELD_SPAWN_POS);
                PlayerHeader.setSussyHeader(player, instancePlayers.get(player));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            AmongUs.getLogger().info("Added {} to game instance {}", fromComponent(player.getName()), instanceUUID);
            player.sendMessage(MM."<green>Added to game instance \{instanceUUID}");
        });
    }

    /**
     * @param player The player we are adding to game instance
     * @param crewmate The kind of crewmate we are adding to game instance
     */
    public void addPlayer(@NotNull Player player, @NotNull Crewmate crewmate) {
        instancePlayers.put(player, crewmate);
    }

    /**
     * @param crewmate The type of crewmate to check
     * @return If the provided crewmate is already in the game instance
     */
    public @NotNull Boolean contains(@NotNull Crewmate crewmate) {
        return instancePlayers.containsValue(crewmate);
    }

    /**
     * @return UUID on which instance is operating
     */
    public UUID getInstanceUUID() {
        return instanceUUID;
    }
}
