package io.github.unjoinable.amongus.game;

import io.github.unjoinable.amongus.enums.CrewmateColor;
import io.github.unjoinable.amongus.task.GameTask;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

/**
 * @param player The player which is crewmate.
 * @param color Color of player.
 * @param tasks Tasks of player.
 * @since 1.0.0
 * @author unjoinable
 */
public record Crewmate (@NotNull Player player, @NotNull CrewmateColor color, @NotNull HashMap<GameTask, Boolean> tasks) {

    public Crewmate {
        if (tasks.isEmpty()) {
            throw new IllegalStateException("Crewmate has no tasks");
        }
    }
}
