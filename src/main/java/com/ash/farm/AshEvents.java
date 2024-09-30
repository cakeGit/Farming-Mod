package com.ash.farm;

import com.ash.farm.access.MinecraftAccessor;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.CropBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

@EventBusSubscriber(Dist.CLIENT)
public class AshEvents {
    
    public static InteractionHand lastInteractionHand = null;
    public static InteractionHand lastUsedInteractionHand = InteractionHand.MAIN_HAND;
    
    public static boolean noCooldownPeriodActive = false;
    public static InteractionHand noCooldownPeriodHand = InteractionHand.MAIN_HAND;
    
    @SubscribeEvent
    public static void tickNoCooldownInteractions(ClientTickEvent.Pre event) {
        if (lastInteractionHand != null)
            lastUsedInteractionHand = lastInteractionHand;
        lastInteractionHand = null;
        
        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null || mc.player == null) return;
        if (!mc.level.isClientSide) return;
        
        if (!mc.options.keyUse.isDown()) {
            lastUsedInteractionHand = InteractionHand.MAIN_HAND;
            noCooldownPeriodHand = InteractionHand.MAIN_HAND;
            noCooldownPeriodActive = false;
            return;
        }
        
        InteractionHand hand = noCooldownPeriodActive ? noCooldownPeriodHand : lastUsedInteractionHand;
        ItemStack stack = mc.player.getItemInHand(hand);
        Item item = stack.getItem();
        
        if (isNoCooldownItem(item)) {
            noCooldownPeriodActive = true;
            noCooldownPeriodHand = hand;
            
            ((MinecraftAccessor) Minecraft.getInstance()).farming_Mod$removeCooldown();
        }
        
    }
    
    private static boolean isNoCooldownItem(Item item) {
        return (item instanceof BlockItem blockItem && blockItem.getBlock() instanceof CropBlock) || item instanceof HoeItem;
    }
    
}
