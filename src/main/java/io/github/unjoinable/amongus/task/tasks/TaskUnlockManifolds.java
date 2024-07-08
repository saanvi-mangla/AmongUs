package io.github.unjoinable.amongus.task.tasks;

import io.github.unjoinable.amongus.enums.GameMap;
import io.github.unjoinable.amongus.enums.TaskLength;
import io.github.unjoinable.amongus.task.GameTask;
import net.minestom.server.event.inventory.InventoryPreClickEvent;
import net.minestom.server.inventory.Inventory;
import net.minestom.server.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class TaskUnlockManifolds extends GameTask {
    @Override
    public @NotNull String name() {
        return "Unlock Manifolds";
    }

    @Override
    public @NotNull TaskLength taskLength() {
        return TaskLength.SHORT;
    }

    @Override
    public @NotNull GameMap location() {
        return GameMap.THE_SKELD.REACTOR;
    }

    @Override
    public @NotNull String key() {
        return "tasks.unlock_manifold";
    }

    @Override
    public void run(InventoryPreClickEvent event) {
        //assuming this event is caused by a TaskUnlockManifolds GUI
        List<Integer> slots = new ArrayList<>(List.of(2, 3, 4, 5, 6, 11, 12, 13, 14, 15));
        if (slots.contains(event.getSlot())) {
            System.out.println("Yes this is the required event");
            TreeMap<Integer, Integer> taskItems = new TreeMap<>(); //quantity vs slot map
            Inventory inventory = event.getInventory();
            slots.forEach(slot -> {
                ItemStack taskItem = inventory.getItemStack(slot);
                if (!taskItem.isAir()) {
                    taskItems.put(taskItem.amount(), slot);
                }
            });
            System.out.println(taskItems);
        }
    }
}
