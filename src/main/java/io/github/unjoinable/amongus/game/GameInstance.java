package io.github.unjoinable.amongus.game;

import io.github.unjoinable.amongus.AmongUs;
import io.github.unjoinable.amongus.TaskRegistry;
import io.github.unjoinable.amongus.data.Constants;
import io.github.unjoinable.amongus.enums.CrewmateColor;
import io.github.unjoinable.amongus.task.GameTask;
import io.github.unjoinable.amongus.util.PlayerHeader;
import net.minestom.server.entity.Player;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.anvil.AnvilLoader;
import org.jetbrains.annotations.NotNull;

import java.util.*;

import static io.github.unjoinable.amongus.util.MiniMessageTemplate.MM;
import static io.github.unjoinable.amongus.util.MiniMessageTemplate.fromComponent;

/**
 * @since 1.0.0
 * @author unjoinable
 */
public class GameInstance {
    private final HashMap<Player, CrewmateColor> instancePlayers = new HashMap<>();
    private final List<Crewmate> instanceCrewmates = new ArrayList<>();
    private final UUID instanceUUID;
    private final InstanceContainer mcInstance;

    /**
     * @param uuid UUID of the game instance
     * @since 1.0.0
     * @author unjoinable
     */
    public GameInstance(UUID uuid) {
        this.instanceUUID = uuid;
        mcInstance = AmongUs.getInstanceManager().createInstanceContainer(Constants.DIMENSION);
        mcInstance.setChunkLoader(new AnvilLoader(Constants.WORLD_PATH));
        AmongUs.getLogger().info("Creating a new instance for {}", instanceUUID);
    }

    public void start() {
        instancePlayers.forEach((player, _) -> {
            player.setInstance(mcInstance, Constants.SKELD_SPAWN_POS);
            PlayerHeader.setSussyHeader(player, instancePlayers.get(player));
            AmongUs.getLogger().info("Added {} to game instance {}", fromComponent(player.getName()), instanceUUID);
            player.sendMessage(MM."<green>Added to game instance \{instanceUUID}");
        });
    }

    /**
     * @param player The player we are adding to game instance
     * @param crewmateColor The kind of crewmateColor we are adding to game instance
     * @since 1.0.0
     * @author unjoinable
     */
    public void addPlayer(Player player, CrewmateColor crewmateColor) {
        if (player != null && crewmateColor != null) {
            //instanceCrewmates.add(new Crewmate(player, crewmateColor, ))
            instancePlayers.put(player, crewmateColor);
        } else {
            throw new IllegalArgumentException("null");
        }
    }

    /**
     * @param crewmateColor The type of crewmateColor to check
     * @return If the provided crewmateColor is already in the game instance
     * @since 1.0.0
     * @author unjoinable
     */
    public boolean contains(@NotNull CrewmateColor crewmateColor) {
        return instancePlayers.containsValue(crewmateColor);
    }

    /**
     * @return UUID on which instance is operating
     * @since 1.0.0
     * @author unjoinable
     */
    public UUID getInstanceUUID() {
        return instanceUUID;
    }

}
