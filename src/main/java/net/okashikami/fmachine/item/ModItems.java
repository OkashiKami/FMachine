package net.okashikami.fmachine.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.okashikami.fmachine.FMachine;
import net.okashikami.fmachine.block.ModBlocks;
import net.okashikami.fmachine.item.custom.EightBallItem;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item RAW_TANZANITE = registerItem("raw_tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));
    public static final Item TANZANITE = registerItem("tanzanite",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)));

    public static final Item EIGHT_BALL = registerItem("eight_ball",
            new EightBallItem(new FabricItemSettings().group(ModItemGroup.TANZANITE).maxCount(1)));
    public static final Item EGGPLANT_SEEDS = registerItem("eggplant_seeds",
            new AliasedBlockItem(ModBlocks.EGGPLANT_CROP,
                    new FabricItemSettings().group(ModItemGroup.TANZANITE)));
    public static final Item EGGPLANT = registerItem("eggplant",
            new Item(new FabricItemSettings().group(ModItemGroup.TANZANITE)
                    .food(new FoodComponent.Builder().hunger(4).saturationModifier(4f).build())));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(FMachine.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FMachine.LOGGER.debug("Registering Mod Items for " + FMachine.MOD_ID);
    }
}
