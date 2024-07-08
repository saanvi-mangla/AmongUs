package io.github.unjoinable.amongus.game;

import io.github.unjoinable.amongus.enums.CrewmateColor;
import io.github.unjoinable.amongus.task.GameTask;
import net.minestom.server.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public record Crewmate (@NotNull Player player, @NotNull CrewmateColor color, @NotNull HashMap<GameTask, Boolean> tasks) {

    public Crewmate {
        if (tasks.isEmpty()) {
            throw new IllegalStateException("Crewmate has no tasks");
        }
    }
}
