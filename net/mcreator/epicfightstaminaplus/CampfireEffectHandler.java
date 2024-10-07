/*    */ package net.mcreator.epicfightstaminaplus;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import net.minecraft.core.BlockPos;
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.minecraft.world.effect.MobEffectInstance;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraft.world.level.block.Blocks;
/*    */ import net.minecraft.world.level.block.state.BlockState;
/*    */ import net.minecraftforge.event.TickEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class CampfireEffectHandler
/*    */ {
/* 18 */   private static final Map<Player, Integer> campfireTimeMap = new HashMap<>();
/*    */   private static final int REQUIRED_TICKS = 1200;
/*    */   private static final int EFFECT_DURATION = 6000;
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
/* 24 */     if (event.phase == TickEvent.Phase.START) {
/* 25 */       Player player = event.player;
/*    */ 
/*    */       
/* 28 */       if (player.m_6047_()) {
/* 29 */         boolean nearCampfire = false;
/*    */ 
/*    */         
/* 32 */         BlockPos playerPos = player.m_20183_();
/* 33 */         for (int x = -4; x <= 4; x++) {
/* 34 */           for (int y = -4; y <= 4; y++) {
/* 35 */             for (int z = -4; z <= 4; z++) {
/* 36 */               BlockPos checkPos = playerPos.m_7918_(x, y, z);
/* 37 */               BlockState blockState = player.m_9236_().m_8055_(checkPos);
/*    */ 
/*    */               
/* 40 */               if (blockState.m_60713_(Blocks.f_50683_) || blockState.m_60713_(Blocks.f_50684_)) {
/* 41 */                 nearCampfire = true;
/*    */                 break;
/*    */               } 
/*    */             } 
/* 45 */             if (nearCampfire)
/*    */               break; 
/* 47 */           }  if (nearCampfire) {
/*    */             break;
/*    */           }
/*    */         } 
/* 51 */         if (nearCampfire) {
/* 52 */           int timeNearCampfire = ((Integer)campfireTimeMap.getOrDefault(player, Integer.valueOf(0))).intValue() + 1;
/* 53 */           campfireTimeMap.put(player, Integer.valueOf(timeNearCampfire));
/*    */ 
/*    */           
/* 56 */           if (timeNearCampfire >= 1200) {
/*    */             
/* 58 */             player.m_7292_(new MobEffectInstance((MobEffect)ModEffects.STRENGTH_SURGE.get(), 6000, 0, true, false, false));
/* 59 */             player.m_7292_(new MobEffectInstance((MobEffect)ModEffects.VIGOR.get(), 6000, 0, true, false, false));
/*    */ 
/*    */             
/* 62 */             campfireTimeMap.put(player, Integer.valueOf(0));
/*    */           } 
/*    */         } else {
/*    */           
/* 66 */           campfireTimeMap.remove(player);
/*    */         } 
/*    */       } else {
/*    */         
/* 70 */         campfireTimeMap.remove(player);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Сохранки\Mcreator\New_Life\MC\epic_fight_stamina_plus-1.0.0-forge-1.20.1.jar!\net\mcreator\epicfightstaminaplus\CampfireEffectHandler.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */