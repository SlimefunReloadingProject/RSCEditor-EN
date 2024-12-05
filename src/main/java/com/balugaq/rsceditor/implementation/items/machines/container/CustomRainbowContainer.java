package com.balugaq.rsceditor.implementation.items.machines.container;

import com.balugaq.rsceditor.api.base.AbstractContainer;
import com.balugaq.rsceditor.api.objects.MenuMatrix;
import com.balugaq.rsceditor.utils.Icons;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CustomRainbowContainer extends AbstractContainer {
    private static final MenuMatrix matrix = new MenuMatrix()
            .addLine("rrrrrrrrR")
            .addLine("rrrrrrrrR")
            .addLine("rrrrrrrrR")
            .addLine("rrrrrrrrR")
            .addLine("rrrrrrrrR")
            .addLine("rrrrrrrrR")
            .addItem("R", Icons.custom_rainbow_block);

    public CustomRainbowContainer(@NotNull SlimefunItemStack item) {
        super(item);
    }

    @Override
    public @NotNull BlockMenuPreset setBlockMenuPreset() {
        return new BlockMenuPreset(getId(), getItemName()) {
            @Override
            public void init() {
                matrix.build(this);
            }

            @Override
            public boolean canOpen(@NotNull Block block, @NotNull Player player) {
                return player.isOp();
            }

            @Override
            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow itemTransportFlow) {
                return new int[0];
            }
        };
    }

    public @NotNull List<Material> getMaterials(@NotNull BlockMenu menu) {
        List<Material> materials = new ArrayList<>();
        for (int slot : matrix.getChars("r")) {
            ItemStack itemStack = menu.getItemInSlot(slot);
            if (itemStack != null && itemStack.getType() != Material.AIR) {
                if (!itemStack.getType().isAir() && itemStack.getType().isBlock()) {
                    materials.add(itemStack.getType());
                }
            }
        }

        return materials;
    }
}
