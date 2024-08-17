package io.github.unjoinable.amongus;

import io.github.unjoinable.amongus.task.GameTask;
import org.jetbrains.annotations.NotNull;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @since 1.0.0
 * @author unjoinable
 */
public class TaskRegistry {
    private static final TaskRegistry instance = new TaskRegistry();
    private final Map<String, Class<? extends GameTask>> tasks;

    private TaskRegistry() {
        this.tasks = new ConcurrentHashMap<>();
    }

    public void add(@NotNull String taskName, @NotNull Class<? extends GameTask> task) {
        this.tasks.put(taskName, task);
    }

    public boolean contains(@NotNull String taskName) {
        return this.tasks.containsKey(taskName);
    }

    public Class<? extends GameTask> get(@NotNull String taskName) {
        return this.tasks.get(taskName);
    }

    /**
     * @return The instance of this registry
     */
    public static TaskRegistry instance() {
        return instance;
    }

    public static void register() {
        Reflections reflections = new Reflections("io.github.unjoinable.amongus.task.tasks");
        Set<Class<? extends GameTask>> taskClasses = reflections.getSubTypesOf(GameTask.class);
        taskClasses.stream().map(subClass -> (Class <? extends GameTask>) subClass).filter(java.util.Objects::nonNull).forEach(subClass -> {
            try {
                TaskRegistry.instance.add(subClass.getDeclaredConstructor().newInstance().key(), subClass);
            } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
