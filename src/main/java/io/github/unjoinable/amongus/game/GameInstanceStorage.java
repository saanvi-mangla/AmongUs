package io.github.unjoinable.amongus.game;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @since 1.0.0
 * @author unjoinable
 */
public class GameInstanceStorage {
    private final Map<UUID, GameInstance> gameInstances = new HashMap<>();

    /**
     * @return Freshly created game instance.
     * @since 1.0.0
     * @author unjoinable
     */
    public @NotNull GameInstance createInstance() {
        GameInstance instance = new GameInstance(UUID.randomUUID());
        gameInstances.put(instance.getInstanceUUID(), instance);
        return instance;
    }

    /**
     * @return All active instances
     * @since 1.0.0
     * @author unjoinable
     */
    public @NotNull Map<UUID, GameInstance> getInstances() {
        return gameInstances;
    }
}
