package io.github.unjoinable.amongus.enums;

import java.util.Arrays;
import java.util.Collection;

/*
Currently Planned Tasks
 */
public enum Task {
    FIX_WIRING(TaskLength.SHORT),
    SWIPE_CARD(TaskLength.SHORT),
    CLEAN_O2_FILTER(TaskLength.SHORT),
    CLEAR_ASTEROIDS(TaskLength.LONG),
    DIVERT_POWER(TaskLength.VERY_LONG),
    DOWNLOAD_AND_UPLOAD(TaskLength.VERY_LONG),
    EMPTY_GARBAGE(TaskLength.SHORT),
    FUEL_ENGINE(TaskLength.SHORT),
    INSPECT_SAMPLE(TaskLength.LONG),
    START_REACTOR(TaskLength.VERY_LONG),
    SCAN(TaskLength.LONG),
    ;

    private final TaskLength taskLength;
    private static final Collection<Task> VALUES = Arrays.asList(values());

    Task(TaskLength taskLength) {
        this.taskLength = taskLength;
    }

    /**
     * @return Returns the severity of tasks used to calculate the amount of task points given
     */
    public TaskLength getTaskType() {
        return taskLength;
    }

    /**
     * @return Get all Tasks as a collection
     */
    public static Collection<Task> getValues() {
        return VALUES;
    }
}
