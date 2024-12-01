package com.balugaq.rsceditor.implementation.items.machines.container;

import com.balugaq.rsceditor.api.AbstractContainer;
import com.balugaq.rsceditor.api.MenuMatrix;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ArmorPieceContainer extends AbstractContainer {
    private static final MenuMatrix matrix = new MenuMatrix()
            .addLine("nitBBBrrr")
            .addLine("NITBBBrrr")
            .addLine("pppppBrrr")
            .addLine("PPPPPBBBB")
            .addLine("ppppppppp")
            .addLine("PPPPPPPPP")
            .addItem("B", ChestMenuUtils.getBackground());
    public ArmorPieceContainer(@NotNull SlimefunItemStack item) {
        super(item);
    }

    @Override
    public BlockMenuPreset setBlockMenuPreset() {
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
}
