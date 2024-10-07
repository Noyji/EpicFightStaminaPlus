/*    */ package net.mcreator.epicfightstaminaplus;
/*    */ 
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*    */ import net.minecraft.world.entity.ai.attributes.AttributeInstance;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraftforge.event.entity.player.PlayerEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*    */ import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;
/*    */ 
/*    */ @EventBusSubscriber(modid = "epic_fight_stamina_plus")
/*    */ public class StaminaResetHandler
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
/* 19 */     resetPlayerStaminaAndMaxStamina(event.getEntity());
/*    */   }
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
/* 25 */     resetPlayerStaminaAndMaxStamina(event.getEntity());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static void resetPlayerStaminaAndMaxStamina(Player player) {
/* 31 */     PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/*    */     
/* 33 */     if (playerPatch != null) {
/*    */       
/* 35 */       playerPatch.setStamina((float)((Double)EpicFightStaminaPlusConfig.maxStartStamina.get()).doubleValue());
/*    */ 
/*    */       
/* 38 */       AttributeInstance maxStaminaAttr = player.m_21051_((Attribute)EpicFightAttributes.MAX_STAMINA.get());
/* 39 */       if (maxStaminaAttr != null)
/* 40 */         maxStaminaAttr.m_22100_(((Double)EpicFightStaminaPlusConfig.maxStartStamina.get()).doubleValue()); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Сохранки\Mcreator\New_Life\MC\epic_fight_stamina_plus-1.0.0-forge-1.20.1.jar!\net\mcreator\epicfightstaminaplus\StaminaResetHandler.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */