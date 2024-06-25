package io.github.unjoinable.amongus.enums;

import java.util.Arrays;
import java.util.Collection;

/*
Currently Planned Tasks
 */
public enum Task {
    FIX_WIRING(TaskType.SHORT),
    SWIPE_CARD(TaskType.SHORT),
    CLEAN_O2_FILTER(TaskType.SHORT),
    CLEAR_ASTEROIDS(TaskType.LONG),
    DIVERT_POWER(TaskType.VERY_LONG),
    DOWNLOAD_AND_UPLOAD(TaskType.VERY_LONG),
    EMPTY_GARBAGE(TaskType.SHORT),
    FUEL_ENGINE(TaskType.SHORT),
    INSPECT_SAMPLE(TaskType.LONG),
    START_REACTOR(TaskType.VERY_LONG),
    SCAN(TaskType.LONG),
    ;

    private final TaskType taskType;
    private static final Collection<Task> VALUES = Arrays.asList(values());

    Task(TaskType taskType) {
        this.taskType = taskType;
    }

    /**
     * @return Returns the severity of tasks used to calculate the amount of task points given
     */
    public TaskType getTaskType() {
        return taskType;
    }

    /**
     * @return Get all Tasks as a collection
     */
    public static Collection<Task> getValues() {
        return VALUES;
    }
}
