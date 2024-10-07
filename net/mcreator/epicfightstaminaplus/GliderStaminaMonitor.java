/*    */ package net.mcreator.epicfightstaminaplus;
/*    */ 
/*    */ import java.util.Optional;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.item.ItemStack;
/*    */ import net.minecraftforge.event.entity.living.LivingEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import net.venturecraft.gliders.common.compat.trinket.CuriosTrinketsUtil;
/*    */ import net.venturecraft.gliders.common.item.GliderItem;
/*    */ import net.venturecraft.gliders.util.GliderUtil;
/*    */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*    */ import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class GliderStaminaMonitor
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onPlayerTick(LivingEvent.LivingTickEvent event) {
/* 24 */     if (((Boolean)EpicFightStaminaPlusConfig.enableGliderStamina.get()).booleanValue()) {
/* 25 */       LivingEntity livingEntity = event.getEntity(); if (livingEntity instanceof Player) { Player player = (Player)livingEntity;
/*    */         
/* 27 */         PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/*    */         
/* 29 */         if (playerPatch != null)
/*    */         {
/* 31 */           if (GliderUtil.isGlidingWithActiveGlider((LivingEntity)player)) {
/*    */             
/* 33 */             float currentStamina = playerPatch.getStamina();
/*    */             
/* 35 */             double weight = player.m_21133_((Attribute)EpicFightAttributes.WEIGHT.get());
/*    */ 
/*    */             
/* 38 */             float staminaCost = (float)(weight * 0.014D + (float)((Double)EpicFightStaminaPlusConfig.gliderStaminaCost.get()).doubleValue());
/*    */             
/* 40 */             float newStamina = Math.max(0.0F, currentStamina - staminaCost);
/*    */ 
/*    */             
/* 43 */             playerPatch.setStamina(newStamina);
/*    */             
/* 45 */             playerPatch.resetActionTick();
/*    */ 
/*    */             
/* 48 */             if (newStamina <= 0.0F) {
/* 49 */               Optional<ItemStack> gliderItem = Optional.ofNullable(
/* 50 */                   CuriosTrinketsUtil.getInstance().findGliders((LivingEntity)player, new String[] { CuriosTrinketsUtil.BACK.identifier() }));
/*    */               
/* 52 */               gliderItem.ifPresent(itemStack -> GliderItem.setGlide(itemStack, false));
/*    */             } 
/*    */           } 
/*    */         } }
/*    */     
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Сохранки\Mcreator\New_Life\MC\epic_fight_stamina_plus-1.0.0-forge-1.20.1.jar!\net\mcreator\epicfightstaminaplus\GliderStaminaMonitor.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */