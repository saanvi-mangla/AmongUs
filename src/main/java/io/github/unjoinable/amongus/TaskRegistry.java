package io.github.unjoinable.amongus;

import io.github.unjoinable.amongus.task.GameTask;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TaskRegistry {
    private static final TaskRegistry instance = new TaskRegistry();
    private final Map<String, GameTask> tasks;

    private TaskRegistry() {
        this.tasks = new ConcurrentHashMap<>();
    }

    public void add(String taskName, GameTask task) {
        this.tasks.put(taskName, task);
    }

    public GameTask get(String taskName) {
        return this.tasks.get(taskName);
    }

    /**
     * @return The instance of registry
     */
    public static TaskRegistry instance() {
        return instance;
    }

    public static void register() {
        Reflections reflections = new Reflections("io.github.unjoinable.amongus.task.tasks");
        Set<Class<? extends GameTask>> taskClasses = reflections.getSubTypesOf(GameTask.class);
        taskClasses.stream().map(subClass -> {
            try {
                return (GameTask) subClass.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                return null;
            }
        }).filter(java.util.Objects::nonNull).forEach(subClass -> {
            TaskRegistry.instance.add(subClass.key(), subClass);
        });
    }

}
