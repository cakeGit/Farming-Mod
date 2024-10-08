package com.ash.farm;

import com.ash.farm.watering_over.FarmingBlockTypes;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

@Mod(AshFarm.MODID)
public class AshFarm {
    
    public static final String MODID = "ashfarming";
    private static final Logger LOGGER = LogUtils.getLogger();
    
    public AshFarm(IEventBus modEventBus, ModContainer modContainer) {
        FarmingBlockTypes.register();
    }
    
}
