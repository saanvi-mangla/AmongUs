package io.github.unjoinable.amongus.gui.guis;

import io.github.unjoinable.amongus.gui.GUI;
import net.minestom.server.entity.Player;
import net.minestom.server.inventory.InventoryType;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.Material;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.github.unjoinable.amongus.util.MiniMessageTemplate.MM;

/**
 * @since 1.0.0
 * @author unjoinable
 */
public class GUIUnlockManifolds extends GUI {
    //0,1   - 2,3,4,5,6,-      7,8
    //9,10  -11,12,13,14,15-  16,17,
    public GUIUnlockManifolds() {
        super(InventoryType.CHEST_2_ROW, MM."tasks.unlock_manifold");
    }

    @Override
    public void open(@NotNull Player player) {
        List<Integer> slots = new ArrayList<>(List.of(2, 3, 4, 5, 6, 11, 12, 13, 14, 15));
        Collections.shuffle(slots);
        for (int i = 0; i < 10; i++) {
            setItem(slots.get(i), ItemStack.of(Material.GLASS_PANE, i+1));;
        }
    player.openInventory(this.build());
    }
}
