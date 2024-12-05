package com.balugaq.rsceditor.implementation.items.machines.container;

import com.balugaq.rsceditor.api.base.AbstractContainer;
import com.balugaq.rsceditor.api.items.ArmorPiece;
import com.balugaq.rsceditor.api.objects.MenuMatrix;
import com.balugaq.rsceditor.api.items.TextTypeItem;
import com.balugaq.rsceditor.utils.Icons;
import com.balugaq.rsceditor.utils.ItemUtil;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.collections.Pair;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ArmorPieceContainer extends AbstractContainer {
    private static final MenuMatrix matrix = new MenuMatrix()
            .addLine("nitBBBrrr")
            .addLine("NITBBBrrr")
            .addLine("pppppBrrr")
            .addLine("PPPPPBBBB")
            .addLine("ppppppppp")
            .addLine("PPPPPPPPP")
            .addItem("B", ChestMenuUtils.getBackground())
            .addItem("N", Icons.id)
            .addItem("I", Icons.item)
            .addItem("T", Icons.recipe_type)
            .addItem("P", Icons.potion);

    public ArmorPieceContainer(@NotNull SlimefunItemStack item) {
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
            public void newInstance(@NotNull BlockMenu menu, @NotNull Block b) {

                for (int slot : matrix.getChars("p")) {
                    menu.addMenuClickHandler(slot, (p, s, i, a) -> {
                        if (SlimefunItem.getByItem(i) instanceof TextTypeItem typeItem) {
                            p.closeInventory(InventoryCloseEvent.Reason.PLUGIN);
                            ChatUtils.awaitInput(p, text -> {
                                typeItem.setContent(i, text);
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

    public @Nullable ArmorPiece getArmorPiece(@NotNull BlockMenu menu) {
        Pair<Boolean, String> p0 = ItemUtil.isString(menu, matrix, "n");
        if (!p0.getFirstValue()) {
            return null;
        }

        String id = p0.getSecondValue();

        Pair<Boolean, ItemStack> p1 = ItemUtil.isItem(menu, matrix, "i");
        if (!p1.getFirstValue()) {
            return null;
        }

        ItemStack item = p1.getSecondValue();
        SlimefunItemStack sfis = new SlimefunItemStack(id, item);

        Pair<Boolean, RecipeType> p2 = ItemUtil.isRecipeTypeItem(menu, matrix, "t");
        RecipeType recipeType = RecipeType.NULL;
        if (p2.getFirstValue()) {
            recipeType = p2.getSecondValue();
        }

        ItemStack[] recipe = new ItemStack[9];
        int index = 0;
        for (int slot : matrix.getChars("r")) {
            ItemStack itemStack = menu.getItemInSlot(slot);
            recipe[index] = itemStack;
            index++;
        }

        List<String> potions = new ArrayList<>();
        Pair<Boolean, List<String>> p3 = ItemUtil.isStrings(menu, matrix, "p");
        if (p3.getFirstValue()) {
            potions.addAll(p3.getSecondValue());
        }

        return new ArmorPiece(sfis, recipeType, recipe, potions);
    }
}
