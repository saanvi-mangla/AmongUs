package io.github.unjoinable.amongus.gui;

import net.kyori.adventure.text.Component;
import net.minestom.server.entity.Player;
import net.minestom.server.inventory.Inventory;
import net.minestom.server.inventory.InventoryType;
import net.minestom.server.item.ItemStack;
import net.minestom.server.tag.Tag;
import org.jetbrains.annotations.NotNull;

/**
 * @since 1.0.0
 * @author unjoinable
 */
public abstract class GUI {
    private final Inventory inventory;

    public GUI(InventoryType type, Component name) {
        this.inventory = new Inventory(type, name);
    }

    /**
     * @return Inventory itself
     * @since 1.0.0
     * @author unjoinable
     */
    public Inventory build() {
        return this.inventory;
    }

    /**
     * @param i The slot you want to set begins from 0
     * @param stack The item you want to place
     * @since 1.0.0
     * @author unjoinable
     */
    public void setItem(int i, @NotNull ItemStack stack) {
        this.inventory.setItemStack(i, stack);
    }

    /**
     * Adds a boolean true flag to make sure its a task item
     * @param i The slot you want to set begins from 0
     * @param stack The item you want to place
     * @since 1.0.0
     * @author unjoinable
     */
    public void setTaskItem(int i, @NotNull ItemStack stack) {
        ItemStack.Builder builder = stack.builder();
        builder.setTag(Tag.Boolean("taskItem"), true);
        setItem(i, builder.build());
    }

    /**
     * @param player The player for who you want to open gui.
     * @since 1.0.0
     * @author unjoinable
     */
    public abstract void open(@NotNull Player player);



}
