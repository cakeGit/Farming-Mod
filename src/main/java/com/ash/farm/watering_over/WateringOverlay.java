package com.ash.farm.watering_over;

import com.ash.farm.AshFarm;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

public class WateringOverlay {
    public static ResourceLocation asResource(String location) {
        return ResourceLocation.fromNamespaceAndPath(AshFarm.MODID, location);
    }
    
    public static class DisplayOptions {
        public static int RANGE = 10;
        public static int VERTICAL_RANGE = 5;
        public static OverlaySelector SELECTOR = OverlaySelector.OFF;
        public static int SELECTOR_INDEX = 2;
    }
    
    public enum OverlayRenderType {
        BOX, ICON
    }

}
