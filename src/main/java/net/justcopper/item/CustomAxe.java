package net.justcopper.item;

import net.justcopper.JustCopperTools;
import net.minecraft.item.*;
import net.minecraft.util.collection.DefaultedList;

public class CustomAxe extends AxeItem implements ChangeGroupSort {
    public CustomAxe(ToolMaterial toolMaterial, float f, float g, Settings settings) {
        super(toolMaterial, f, g, settings);
    }

    @Override
    public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
        appendAndSort(group, stacks);
    }

    @Override
    public Item getSortPrevItem() {
        return JustCopperTools.COPPER_PICKAXE;
    }
}
