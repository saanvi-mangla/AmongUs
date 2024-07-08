package io.github.unjoinable.amongus.task;

import io.github.unjoinable.amongus.enums.GameMap;
import io.github.unjoinable.amongus.enums.TaskLength;
import net.minestom.server.event.inventory.InventoryPreClickEvent;
import org.jetbrains.annotations.NotNull;

/**
 * @since 1.0.0
 * @author unjoinable
 */
public abstract class GameTask {
    private boolean isDone = false;

    /**
     * @return Absolute name of the task, Primarily planned to be used to show current tasks
     * @since 1.0.0
     * @author unjoinable
     */
    public abstract @NotNull String name();

    /**
     * @return The type of task.
     * @since 1.0.0
     * @author unjoinable
     */
    public abstract @NotNull TaskLength taskLength();

    /**
     * @return Location of where this task can be found in game.
     * @since 1.0.0
     * @author unjoinable
     */
    public abstract @NotNull GameMap location();

    /**
     * @return An overall key which would be used to handle entire logic such as texture for gui, maybe to detect the task from gui.
     * @since 1.0.0
     * @author unjoinable
     */
    public abstract @NotNull String key();

    /**
     * @param event The event on which we are going to work from.
     * The execution to be done when an event is fired for a respective task type.
     * @since 1.0.0
     * @author unjoinable
     */
    public abstract void run(InventoryPreClickEvent event);

    /**
     * @return Whether the task is done or not.
     * @since 1.0.0
     * @author unjoinable
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Mark the task as finished!
     * @since 1.0.0
     * @author unjoinable
     */
    public void setDone() {
        this.isDone = true;
    }
}
