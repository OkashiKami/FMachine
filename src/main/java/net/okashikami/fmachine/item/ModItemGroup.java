package net.okashikami.fmachine.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.okashikami.fmachine.FMachine;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup TANZANITE = FabricItemGroupBuilder.build(
            new Identifier(FMachine.MOD_ID, "tanzanite"), () -> new ItemStack(ModItems.TANZANITE));
}
