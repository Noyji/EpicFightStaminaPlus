/*    */ package net.mcreator.epicfightstaminaplus;
/*    */ 
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.minecraft.world.effect.MobEffectInstance;
/*    */ import net.minecraft.world.effect.MobEffects;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraftforge.event.entity.living.LivingEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class StaminaMonitor {
/*    */   @SubscribeEvent
/*    */   public static void onPlayerTick(LivingEvent.LivingTickEvent event) {
/* 19 */     LivingEntity livingEntity = event.getEntity(); if (livingEntity instanceof Player) { Player player = (Player)livingEntity;
/* 20 */       PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/*    */       
/* 22 */       if (playerPatch != null) {
/* 23 */         float currentStamina = playerPatch.getStamina();
/*    */ 
/*    */         
/* 26 */         if (currentStamina <= 0.0F) {
/*    */           
/* 28 */           player.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 100, 3, true, false, false));
/* 29 */           player.m_7292_(new MobEffectInstance(MobEffects.f_19613_, 100, 3, true, false, false));
/* 30 */           player.m_7292_(new MobEffectInstance((MobEffect)ModEffects.FATIGUE.get(), 100, 1, true, false, false));
/*    */ 
/*    */           
/* 33 */           player.m_6858_(false);
/*    */         } 
/*    */       }  }
/*    */   
/*    */   }
/*    */ }


/* Location:              D:\Сохранки\Mcreator\New_Life\MC\epic_fight_stamina_plus-1.0.0-forge-1.20.1.jar!\net\mcreator\epicfightstaminaplus\StaminaMonitor.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */