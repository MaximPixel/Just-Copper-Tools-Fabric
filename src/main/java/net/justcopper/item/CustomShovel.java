package net.justcopper.item;

import net.minecraft.item.*;
import net.minecraft.util.collection.DefaultedList;

public class CustomShovel extends ShovelItem implements ChangeGroupSort {
    public CustomShovel(ToolMaterial toolMaterial, float f, float g, Settings settings) {
        super(toolMaterial, f, g, settings);
    }

    @Override
    public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
        appendAndSort(group, stacks);
    }

    @Override
    public Item getSortPrevItem() {
        return Items.NETHERITE_HOE;
    }
}
