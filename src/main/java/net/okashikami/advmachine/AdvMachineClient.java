package net.okashikami.advmachine;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.okashikami.advmachine.block.ModBlocks;
import net.okashikami.advmachine.client.ThirstHudOverlay;
import net.okashikami.advmachine.event.KeyInputHandler;
import net.okashikami.advmachine.networking.ModMessages;
import net.minecraft.client.render.RenderLayer;

public class AdvMachineClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EGGPLANT_CROP, RenderLayer.getCutout());

        KeyInputHandler.register();
        ModMessages.registerS2CPackets();

        HudRenderCallback.EVENT.register(new ThirstHudOverlay());
    }
}
