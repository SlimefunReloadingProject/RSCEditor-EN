package com.balugaq.rsceditor.implementation.items.machines.builder;

import com.balugaq.rsceditor.api.base.AbstractContainer;
import com.balugaq.rsceditor.api.items.BooleanTypeItem;
import com.balugaq.rsceditor.api.items.IntegerTypeItem;
import com.balugaq.rsceditor.api.items.MachineRecipeItem;
import com.balugaq.rsceditor.api.items.TextTypeItem;
import com.balugaq.rsceditor.api.objects.MenuMatrix;
import com.balugaq.rsceditor.api.objects.types.ItemFlowType;
import com.balugaq.rsceditor.api.objects.types.MachineRecipe;
import com.balugaq.rsceditor.implementation.items.machines.container.ItemFlowContainer;
import com.balugaq.rsceditor.implementation.items.machines.container.MenuContainer;
import com.balugaq.rsceditor.utils.ClipboardUtil;
import com.balugaq.rsceditor.utils.Icons;
import com.balugaq.rsceditor.utils.ItemUtil;
import com.balugaq.rsceditor.utils.YamlWriter;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.collections.Pair;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.CraftingRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MultiBlockRecipeBuilder extends AbstractContainer {
    private static final MenuMatrix matrix = new MenuMatrix()
            .addLine("GBIIIIIII")
            .addLine("BBIIIIIII")
            .addLine("IIIIIIIII")
            .addLine("IIIIIIIII")
            .addLine("IIIIIIIII")
            .addLine("IIIIIIIII")
            .addItem("G", Icons.build_multi_block_recipe)
            .addItem("B", Icons.white_background);

    public MultiBlockRecipeBuilder(@NotNull SlimefunItemStack item) {
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
                // Build button
                menu.addMenuClickHandler(matrix.getChar("G"), (p, s, i, a) -> {
                    YamlWriter writer = new YamlWriter();
                    writer.setRoot("recipes");

                    Pair<Boolean, List<ItemStack>> itemStacks = ItemUtil.isItems(menu, matrix, "I");
                    if (itemStacks.getFirstValue()) {
                        List<ItemStack> itemStackList = itemStacks.getSecondValue();
                        for (ItemStack itemStack : itemStackList) {
                            SlimefunItem slimefunItem = SlimefunItem.getByItem(itemStack);
                            if (slimefunItem == null) {
                                // 非 Slimefun 物品，尝试获取 Minecraft 配方
                                Recipe[] recipes = Slimefun.getMinecraftRecipeService().getRecipesFor(itemStack);
                                if (recipes != null && recipes.length > 0) {
                                    Recipe availableRecipe = recipes[0];
                                    if (availableRecipe instanceof ShapedRecipe sr) {
                                        String[] shape = sr.getShape();
                                        Map<Character, RecipeChoice> choiceMap = sr.getChoiceMap();
                                        List<ItemStack> recipe = new ArrayList<>();
                                        for (String row : shape) {
                                            for (char c : row.toCharArray()) {
                                                RecipeChoice choice = choiceMap.get(c);
                                                if (choice == null) {
                                                    recipe.add(null);
                                                } else {
                                                    recipe.add(choice.getItemStack());
                                                }
                                            }
                                        }

                                        for (int m = 0; m < recipe.size(); m++) {
                                            ItemStack item = recipe.get(m);
                                            if (item != null && item.getType() != Material.AIR) {
                                                writer.set(item.getType().name().toLowerCase() + ".input." + m, item.clone(), false);
                                            }
                                        }
                                        continue;
                                    } else if (availableRecipe instanceof ShapelessRecipe sr) {
                                        List<RecipeChoice> choiceList = sr.getChoiceList();
                                        for (int m = 0; m < choiceList.size(); m++) {
                                            RecipeChoice choice = choiceList.get(m);
                                            if (choice == null) {
                                                continue;
                                            }
                                            ItemStack item = choice.getItemStack();
                                            if (item != null && item.getType() != Material.AIR) {
                                                writer.set(item.getType().name().toLowerCase() + ".input." + m, item.clone(), false);
                                            }
                                        }
                                    }
                                }
                                continue;
                            }

                            String id = slimefunItem.getId();
                            ItemStack item = slimefunItem.getItem();
                            ItemStack[] recipe = slimefunItem.getRecipe();
                            if (recipe == null) {
                                continue;
                            }

                            for (int k = 0; k < recipe.length; k++) {
                                ItemStack input = recipe[k];
                                if (input == null || input.getType() == Material.AIR) {
                                    continue;
                                }
                                writer.set(id.toLowerCase() + ".input." + k, input.clone(), false);
                            }

                            writer.set(id.toLowerCase() + ".output", item.clone(), false);
                        }
                    } else {
                        p.sendMessage("&c你还没有放置物品");
                        return false;
                    }

                    ClipboardUtil.send(p, writer.toString());
                    p.sendMessage("&a已编辑完毕");

                    return false;
                });
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
