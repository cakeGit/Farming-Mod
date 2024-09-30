package com.ash.farm.mixin;

import com.ash.farm.access.MinecraftAccessor;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Minecraft.class)
public class MinecraftAccessorMixin implements MinecraftAccessor {
    
    @Shadow
    private int rightClickDelay;
    
    @Override
    public void farming_Mod$removeCooldown() {
        rightClickDelay = 0;
    }
    
}
