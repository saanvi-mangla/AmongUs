package io.github.unjoinable.amongus.task.tasks;

import io.github.unjoinable.amongus.enums.GameMap;
import io.github.unjoinable.amongus.enums.TaskLength;
import io.github.unjoinable.amongus.task.GameTask;
import net.minestom.server.event.inventory.InventoryPreClickEvent;
import org.jetbrains.annotations.NotNull;

public class TaskUnlockManifolds implements GameTask {
    @Override
    public @NotNull String name() {
        return "Unlock Manifolds";
    }

    @Override
    public @NotNull TaskLength taskLength() {
        return TaskLength.SHORT;
    }

    @Override
    public @NotNull GameMap location() {
        return GameMap.THE_SKELD.REACTOR;
    }

    @Override
    public @NotNull String key() {
        return "tasks.unlock_manifold";
    }

    @Override
    public void run(InventoryPreClickEvent event) {
        //assuming this event is caused by a TaskUnlockManifolds GUI

    }
}
