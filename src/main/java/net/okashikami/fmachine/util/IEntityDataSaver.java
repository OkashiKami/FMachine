package net.okashikami.fmachine.util;

import net.minecraft.nbt.NbtCompound;

public interface IEntityDataSaver {
    NbtCompound getPersistentData();
}
