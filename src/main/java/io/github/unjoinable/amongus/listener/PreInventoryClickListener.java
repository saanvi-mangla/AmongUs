package io.github.unjoinable.amongus.listener;

import io.github.unjoinable.amongus.TaskRegistry;
import io.github.unjoinable.amongus.task.GameTask;
import io.github.unjoinable.amongus.util.MiniMessageTemplate;
import net.minestom.server.event.EventListener;
import net.minestom.server.event.inventory.InventoryPreClickEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @since 1.0.0
 * @author unjoinable
 */
public class PreInventoryClickListener implements EventListener<InventoryPreClickEvent> {
    @Override
    public @NotNull Class<InventoryPreClickEvent> eventType() {
        return InventoryPreClickEvent.class;
    }

    @NotNull @Override
    public Result run(@NotNull InventoryPreClickEvent event) {
        String inventoryName = MiniMessageTemplate.fromComponent(Objects.requireNonNull(event.getInventory()).getTitle());
        if (TaskRegistry.instance().contains(inventoryName)) {
            GameTask task = TaskRegistry.instance().get(inventoryName);
            task.run(event);
        }
        return Result.SUCCESS;
    }
}
