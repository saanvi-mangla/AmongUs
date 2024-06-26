package io.github.unjoinable.amongus.commands;

import net.kyori.adventure.key.Key;
import net.minestom.server.command.ServerSender;
import net.minestom.server.command.builder.Command;
import net.minestom.server.entity.Player;
import net.minestom.server.inventory.Inventory;
import net.minestom.server.inventory.InventoryType;

import static io.github.unjoinable.amongus.util.MiniMessageTemplate.MM;

public class ResourceTest extends Command {

    public ResourceTest() {
        super("resource");
        setDefaultExecutor((sender, _) -> {
            //((Player) sender).openInventory(new Inventory(InventoryType.CHEST_5_ROW, MM."<white>ᴀ".font(Key.key("guessthenumber"))));
            sender.sendPlayerListHeader(MM."s1".font(Key.key("the_skeld_map")));
        });
    }
}
