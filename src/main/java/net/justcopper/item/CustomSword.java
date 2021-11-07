package net.justcopper.item;

import net.minecraft.item.*;
import net.minecraft.util.collection.DefaultedList;

public class CustomSword extends SwordItem implements ChangeGroupSort {
    public CustomSword(ToolMaterial toolMaterial, int i, float f, Settings settings) {
        super(toolMaterial, i, f, settings);
    }

    @Override
    public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
        appendAndSort(group, stacks);
    }

    @Override
    public Item getSortPrevItem() {
        return Items.NETHERITE_SWORD;
    }
}
