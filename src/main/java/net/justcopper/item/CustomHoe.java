package net.justcopper.item;

import net.justcopper.JustCopperTools;
import net.minecraft.item.*;
import net.minecraft.util.collection.DefaultedList;

public class CustomHoe extends HoeItem implements ChangeGroupSort {
    public CustomHoe(ToolMaterial toolMaterial, int i, float f, Settings settings) {
        super(toolMaterial, i, f, settings);
    }

    @Override
    public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
        appendAndSort(group, stacks);
    }

    @Override
    public Item getSortPrevItem() {
        return JustCopperTools.COPPER_AXE;
    }
}
