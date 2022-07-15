package net.okashikami.fmachine;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.render.RenderLayer;
import net.okashikami.fmachine.block.ModBlocks;
import net.okashikami.fmachine.client.ThirstHudOverlay;
import net.okashikami.fmachine.event.KeyInputHandler;
import net.okashikami.fmachine.networking.ModMessages;

public class FMachineClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EGGPLANT_CROP, RenderLayer.getCutout());

        KeyInputHandler.register();
        ModMessages.registerS2CPackets();

        HudRenderCallback.EVENT.register(new ThirstHudOverlay());
    }

}
