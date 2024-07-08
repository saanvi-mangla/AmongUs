package io.github.unjoinable.amongus.task;

import io.github.unjoinable.amongus.enums.GameMap;
import io.github.unjoinable.amongus.enums.TaskLength;
import net.minestom.server.event.inventory.InventoryPreClickEvent;
import org.jetbrains.annotations.NotNull;

public abstract class GameTask {
    private boolean isDone = false;

    /**
     * @return Absolute name of the task, Primarily planned to be used to show current tasks
     */
    public abstract @NotNull String name();

    /**
     * @return The type of task
     */
    public abstract @NotNull TaskLength taskLength();

    /**
     * @return Location of where this task can be found in game
     */
    public abstract @NotNull GameMap location();

    /**
     * @return An overall key which would be used to handle entire logic such as texture for gui, maybe to detect the task from gui
     */
    public abstract @NotNull String key();

    /**
     * @param event The event on which we are going to work from
     * The execution to be done when an event is fired for a respective task type
     */
    public abstract void run(InventoryPreClickEvent event);

    /**
     * @return Whether the task is done or not
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Mark the task as finished!
     */
    public void setDone() {
        this.isDone = true;
    }
}
