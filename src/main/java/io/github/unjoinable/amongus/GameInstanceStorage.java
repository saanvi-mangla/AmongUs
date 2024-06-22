package io.github.unjoinable.amongus;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GameInstanceStorage {
    private final Map<UUID, GameInstance> gameInstances = new HashMap<>();

    public @NotNull GameInstance createInstance() {
        GameInstance instance = new GameInstance(UUID.randomUUID());
        gameInstances.put(instance.getInstanceUUID(), instance);
        return instance;
    }

    /**
     * @return All active instances
     */
    public @NotNull Map<UUID, GameInstance> getInstances() {
        return gameInstances;
    }
}
