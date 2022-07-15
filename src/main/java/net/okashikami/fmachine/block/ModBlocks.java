package net.okashikami.fmachine.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.okashikami.fmachine.FMachine;
import net.okashikami.fmachine.block.custom.EggplantCropBlock;
import net.okashikami.fmachine.block.custom.JumpyBlock;
import net.okashikami.fmachine.block.custom.TanzaniteLampBlock;
import net.okashikami.fmachine.item.ModItemGroup;

public class ModBlocks {
    public static final Block TANZANITE_BLOCK = registerBlock("tanzanite_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.TANZANITE);

    public static final Block TANZANITE_ORE = registerBlock("tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.TANZANITE);
    public static final Block DEEPSLATE_TANZANITE_ORE = registerBlock("deepslate_tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.TANZANITE);
    public static final Block NETHERRACK_TANZANITE_ORE = registerBlock("netherrack_tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.TANZANITE);
    public static final Block ENDSTONE_TANZANITE_ORE = registerBlock("endstone_tanzanite_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.TANZANITE);

    public static final Block JUMPY_BLOCK = registerBlock("jumpy_block",
            new JumpyBlock(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.TANZANITE);

    public static final Block TANZANITE_LAMP = registerBlock("tanzanite_lamp",
            new TanzaniteLampBlock(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()
                    .luminance(state -> state.get(TanzaniteLampBlock.LIT) ? 15 : 0)), ModItemGroup.TANZANITE);

    public static final Block EGGPLANT_CROP = registerBlockWithoutItem("eggplant_crop",
            new EggplantCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)));



    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(FMachine.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(FMachine.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(FMachine.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks() {
        FMachine.LOGGER.debug("Registering ModBlocks for " + FMachine.MOD_ID);
    }
}
