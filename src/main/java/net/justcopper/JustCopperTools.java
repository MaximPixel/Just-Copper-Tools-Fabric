package net.justcopper;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.yarn.constants.MiningLevels;
import net.justcopper.item.*;
import net.justcopper.recipe.RepairCopperItemRecipe;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JustCopperTools implements ModInitializer {
    public static final ToolMaterial COPPER_MATERIAL = new CustomToolMaterial(MiningLevels.STONE, 131, 12F, 1F, 14, () -> Ingredient.ofItems(Items.COPPER_INGOT));

    public static final Item COPPER_SWORD = new CustomSword(COPPER_MATERIAL, 3, -2.4F, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item COPPER_SHOVEL = new CustomShovel(COPPER_MATERIAL, 1.5F, -3.0F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final Item COPPER_PICKAXE = new CustomPickaxe(COPPER_MATERIAL, 1, -2.8F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final Item COPPER_AXE = new CustomAxe(COPPER_MATERIAL, 6F, -3.1F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final Item COPPER_HOE = new CustomHoe(COPPER_MATERIAL, -2, -1F, new Item.Settings().group(ItemGroup.TOOLS));

    public static final SpecialRecipeSerializer<RepairCopperItemRecipe> REPAIR_COPPER_ITEM = new SpecialRecipeSerializer<>(RepairCopperItemRecipe::new);

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("jct", "copper_sword"), COPPER_SWORD);
        Registry.register(Registry.ITEM, new Identifier("jct", "copper_shovel"), COPPER_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("jct", "copper_pickaxe"), COPPER_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("jct", "copper_axe"), COPPER_AXE);
        Registry.register(Registry.ITEM, new Identifier("jct", "copper_hoe"), COPPER_HOE);

        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier("jct", "repair_copper_item"), REPAIR_COPPER_ITEM);
    }
}
