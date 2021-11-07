package net.justcopper.recipe;

import net.justcopper.JustCopperTools;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ToolItem;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.apache.commons.compress.utils.Lists;

import java.util.ArrayList;

public class RepairCopperItemRecipe extends SpecialCraftingRecipe {
    private static final ArrayList<ItemStack> EMPTY_LIST = Lists.newArrayList();

    public RepairCopperItemRecipe(Identifier identifier) {
        super(identifier);
    }

    protected MatchResult matchResult(CraftingInventory inventory) {
        ItemStack toolStack = ItemStack.EMPTY;
        ItemStack materialStack = ItemStack.EMPTY;

        for (int i = 0; i < inventory.size(); i++) {
            ItemStack stack = inventory.getStack(i);

            if (!stack.isEmpty()) {
                Item item = stack.getItem();

                if (item instanceof ToolItem && ((ToolItem) item).getMaterial() == JustCopperTools.COPPER_MATERIAL) {
                    if (!toolStack.isEmpty()) {
                        return MatchResult.EMPTY;
                    }

                    toolStack = stack;
                    continue;
                } else if (item == Items.COPPER_INGOT || item == Items.RAW_COPPER) {
                    if (!materialStack.isEmpty()) {
                        return MatchResult.EMPTY;
                    }

                    materialStack = stack;
                    continue;
                }

                return MatchResult.EMPTY;
            }
        }

        return new MatchResult(toolStack, materialStack);
    }

    @Override
    public boolean matches(CraftingInventory inventory, World world) {
        return matchResult(inventory).matches();
    }

    @Override
    public ItemStack craft(CraftingInventory inventory) {
        MatchResult matchResult = matchResult(inventory);

        if (matchResult.matches()) {
            ItemStack toolStack = matchResult.getToolStack();
            ItemStack materialStack = matchResult.getMaterialStack();

            Item materialItem = materialStack.getItem();

            int damageRepair = 10;

            if (materialItem == Items.COPPER_INGOT) {
                damageRepair = 20;
            }

            ItemStack craftStack = toolStack.copy();

            int damage = Math.max(craftStack.getDamage() - damageRepair, 0);

            craftStack.setDamage(damage);

            return craftStack;
        }

        return ItemStack.EMPTY;
    }

    @Override
    public boolean fits(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return JustCopperTools.REPAIR_COPPER_ITEM;
    }

    private static class MatchResult {
        public static final MatchResult EMPTY = new MatchResult(ItemStack.EMPTY, ItemStack.EMPTY);

        private final ItemStack toolStack, materialStack;

        private MatchResult(ItemStack toolStack, ItemStack materialStack) {
            this.toolStack = toolStack;
            this.materialStack = materialStack;
        }

        public ItemStack getToolStack() {
            return toolStack;
        }

        public ItemStack getMaterialStack() {
            return materialStack;
        }

        public boolean matches() {
            return this == EMPTY || !toolStack.isEmpty() && !materialStack.isEmpty();
        }
    }
}
