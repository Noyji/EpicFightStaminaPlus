/*    */ package net.mcreator.epicfightstaminaplus;
/*    */ 
/*    */ import com.divot.efct.client.IIntegratedPlayerPatch;
/*    */ import com.divot.efct.network.CPCancelEpic;
/*    */ import com.divot.efct.network.NetworkHandler;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import net.minecraftforge.event.entity.living.LivingEvent;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import net.venturecraft.gliders.util.GliderUtil;
/*    */ import yesman.epicfight.client.world.capabilites.entitypatch.player.LocalPlayerPatch;
/*    */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber
/*    */ public class GliderModeManager
/*    */ {
/*    */   private static boolean gliding = false;
/*    */   
/*    */   @SubscribeEvent
/*    */   public static void onPlayerTick(LivingEvent.LivingTickEvent event) {
/* 26 */     LivingEntity livingEntity = event.getEntity(); if (livingEntity instanceof Player) { Player player = (Player)livingEntity;
/*    */       
/* 28 */       LocalPlayerPatch ppplayer = (LocalPlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, LocalPlayerPatch.class);
/* 29 */       IIntegratedPlayerPatch iplayer = (IIntegratedPlayerPatch)ppplayer;
/*    */       
/* 31 */       if (ppplayer != null) {
/*    */         
/* 33 */         boolean isGliding = GliderUtil.isGlidingWithActiveGlider((LivingEntity)player);
/*    */         
/* 35 */         if (isGliding && !gliding) {
/*    */           
/* 37 */           iplayer.setEpicCancelled(true);
/* 38 */           ppplayer.toMiningMode(true);
/* 39 */           NetworkHandler.sendToServer(new CPCancelEpic(true));
/*    */           
/* 41 */           gliding = true;
/* 42 */         } else if (!isGliding && gliding) {
/*    */           
/* 44 */           iplayer.setEpicCancelled(false);
/* 45 */           ppplayer.toBattleMode(true);
/* 46 */           NetworkHandler.sendToServer(new CPCancelEpic(false));
/*    */           
/* 48 */           gliding = false;
/*    */         } 
/*    */       }  }
/*    */   
/*    */   }
/*    */ }


/* Location:              D:\Сохранки\Mcreator\New_Life\MC\epic_fight_stamina_plus-1.0.0-forge-1.20.1.jar!\net\mcreator\epicfightstaminaplus\GliderModeManager.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */