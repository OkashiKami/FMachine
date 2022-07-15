package net.okashikami.fmachine.painting;

import net.okashikami.fmachine.FMachine;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPaintings {
    public static final PaintingVariant SUNSET = registerPainting("sunset", new PaintingVariant(32, 16));
    public static final PaintingVariant PLANT = registerPainting("plant", new PaintingVariant(16, 16));
    public static final PaintingVariant WANDERER = registerPainting("wanderer", new PaintingVariant(16, 32));


    private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
        return Registry.register(Registry.PAINTING_VARIANT, new Identifier(FMachine.MOD_ID, name), paintingVariant);
    }

    public static void registerPaintings() {
        FMachine.LOGGER.debug("Registering Paintings for " + FMachine.MOD_ID);
    }
}
