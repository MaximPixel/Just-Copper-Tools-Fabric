package net.justcopper.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public interface ChangeGroupSort {
    default void appendAndSort(ItemGroup group, DefaultedList<ItemStack> stacks) {
        ItemGroup itemGroup = asItem().getGroup();

        if (itemGroup != null && (group == ItemGroup.SEARCH || group == itemGroup)) {
            ItemStack stack = getDefaultStack();
            boolean flag = false;

            for (int i = 0; i < stacks.size(); i++) {
                if (stacks.get(i).isOf(getSortPrevItem())) {
                    stacks.add(i + 1, stack);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                stacks.add(stack);
            }
        }
    }

    Item asItem();

    ItemStack getDefaultStack();

    Item getSortPrevItem();
}
