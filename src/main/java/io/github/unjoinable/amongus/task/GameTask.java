package io.github.unjoinable.amongus.task;

import io.github.unjoinable.amongus.enums.GameMap;
import io.github.unjoinable.amongus.enums.Task;
import io.github.unjoinable.amongus.enums.TaskLength;
import net.minestom.server.event.inventory.InventoryPreClickEvent;
import org.jetbrains.annotations.NotNull;

public interface GameTask {

    /**
     * @return Absolute name of the task, Primarily planned to be used to show current tasks
     */
    @NotNull String name();

    /**
     * @return The type of task
     */
    @NotNull TaskLength taskLength();

    /**
     * @return Location of where this task can be found in game
     */
    @NotNull GameMap location();

    /**
     * @return An overall key which would be used to handle entire logic such as texture for gui, maybe to detect the task from gui
     */
    @NotNull String key();

    /**
     * @param event The event on which we are going to work from
     * The execution to be done when an event is fired for a respective task type
     */
    void run(InventoryPreClickEvent event);

}
