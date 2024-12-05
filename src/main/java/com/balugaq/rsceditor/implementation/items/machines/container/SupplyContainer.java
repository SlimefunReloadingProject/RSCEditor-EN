package com.balugaq.rsceditor.implementation.items.machines.container;

import com.balugaq.rsceditor.api.base.AbstractContainer;
import com.balugaq.rsceditor.api.items.IntegerTypeItem;
import com.balugaq.rsceditor.api.objects.MenuMatrix;
import com.balugaq.rsceditor.utils.Icons;
import com.balugaq.rsceditor.utils.ItemUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.collections.Pair;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupplyContainer extends AbstractContainer {
    private static final MenuMatrix matrix = new MenuMatrix()
            .addLine("OOOOOOOOA")
            .addLine("oooooooo1")
            .addLine("NNNNNNNNA")
            .addLine("nnnnnnnn2")
            .addLine("EEEEEEEEA")
            .addLine("eeeeeeee3")
            .addItem("A", Icons.amount)
            .addItem("1", Icons.overworld)
            .addItem("2", Icons.nether)
            .addItem("3", Icons.end);

    public SupplyContainer(@NotNull SlimefunItemStack item) {
        super(item);
    }

    @Override
    public @NotNull BlockMenuPreset setBlockMenuPreset() {
        return new BlockMenuPreset(getId(), getItemName()) {
            @Override
            public void init() {
                matrix.build(this);
            }

            public void newInstance(@NotNull BlockMenu menu, @NotNull Block b) {
                List<Integer> slots = new ArrayList<>();
                for (int slot : matrix.getChars("O")) {
                    slots.add(slot);
                }
                for (int slot : matrix.getChars("N")) {
                    slots.add(slot);
                }
                for (int slot : matrix.getChars("E")) {
                    slots.add(slot);
                }
                for (int slot : slots) {
                    menu.addMenuClickHandler(slot, (p, s, i, a) -> {
                        if (SlimefunItem.getByItem(i) instanceof IntegerTypeItem typeItem) {
                            p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                            ChatUtils.awaitInput(p, integer -> {
                                typeItem.setContent(i, integer);
                                menu.open(p);
                            });
                            return false;
                        }
                        return true;
                    });
                }
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

    public @NotNull Map<World.Environment, Map<Biome, Integer>> getSupply(@NotNull BlockMenu menu) {
        if (menu.getPreset().getID().equals(getId())) {
            Map<World.Environment, Map<Biome, Integer>> supply = new HashMap<>();

            Pair<Boolean, List<Integer>> p0 = ItemUtil.isIntegers(menu, matrix, "O");
            Pair<Boolean, List<Biome>> p1 = ItemUtil.isBiomes(menu, matrix, "o");
            if (p0.getFirstValue() && p1.getFirstValue()) {
                List<Integer> overworld_amounts = p0.getSecondValue();
                List<Biome> overworld_biomes = p1.getSecondValue();
                for (int index = 0; index < Math.min(overworld_amounts.size(), overworld_biomes.size()); index++) {
                    int amount = overworld_amounts.get(index);
                    Biome biome = overworld_biomes.get(index);
                    supply.computeIfAbsent(World.Environment.NORMAL, k -> new HashMap<>());
                    supply.get(World.Environment.NORMAL).put(biome, amount);
                }
            }

            Pair<Boolean, List<Integer>> p2 = ItemUtil.isIntegers(menu, matrix, "N");
            Pair<Boolean, List<Biome>> p3 = ItemUtil.isBiomes(menu, matrix, "n");
            if (p2.getFirstValue() && p3.getFirstValue()) {
                List<Integer> nether_amounts = p2.getSecondValue();
                List<Biome> nether_biomes = p3.getSecondValue();
                for (int index = 0; index < Math.min(nether_amounts.size(), nether_biomes.size()); index++) {
                    int amount = nether_amounts.get(index);
                    Biome biome = nether_biomes.get(index);
                    supply.computeIfAbsent(World.Environment.NETHER, k -> new HashMap<>());
                    supply.get(World.Environment.NETHER).put(biome, amount);
                }
            }

            Pair<Boolean, List<Integer>> p4 = ItemUtil.isIntegers(menu, matrix, "E");
            Pair<Boolean, List<Biome>> p5 = ItemUtil.isBiomes(menu, matrix, "e");
            if (p4.getFirstValue() && p5.getFirstValue()) {
                List<Integer> end_amounts = p4.getSecondValue();
                List<Biome> end_biomes = p5.getSecondValue();
                for (int index = 0; index < Math.min(end_amounts.size(), end_biomes.size()); index++) {
                    int amount = end_amounts.get(index);
                    Biome biome = end_biomes.get(index);
                    supply.computeIfAbsent(World.Environment.THE_END, k -> new HashMap<>());
                    supply.get(World.Environment.THE_END).put(biome, amount);
                }
            }

            return supply;
        }

        return new HashMap<>();
    }
}
