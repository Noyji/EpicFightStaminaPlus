/*     */ package net.mcreator.epicfightstaminaplus;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.minecraft.world.InteractionHand;
/*     */ import net.minecraft.world.entity.Entity;
/*     */ import net.minecraft.world.entity.LivingEntity;
/*     */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*     */ import net.minecraft.world.entity.player.Player;
/*     */ import net.minecraft.world.item.Item;
/*     */ import net.minecraft.world.item.Items;
/*     */ import net.minecraftforge.event.entity.living.LivingEvent;
/*     */ import net.minecraftforge.event.entity.living.ShieldBlockEvent;
/*     */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*     */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*     */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*     */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*     */ import yesman.epicfight.world.capabilities.item.CapabilityItem;
/*     */ import yesman.epicfight.world.capabilities.item.WeaponCategory;
/*     */ import yesman.epicfight.world.entity.eventlistener.BasicAttackEvent;
/*     */ import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @EventBusSubscriber
/*     */ public class CustomStaminaHandler
/*     */ {
/*  31 */   private static final Map<CapabilityItem.WeaponCategories, Float> weaponStaminaCosts = new HashMap<>();
/*     */   
/*     */   static {
/*  34 */     weaponStaminaCosts.put(CapabilityItem.WeaponCategories.AXE, Float.valueOf((float)((Double)EpicFightStaminaPlusConfig.axeStaminaCost.get()).doubleValue()));
/*  35 */     weaponStaminaCosts.put(CapabilityItem.WeaponCategories.SWORD, Float.valueOf((float)((Double)EpicFightStaminaPlusConfig.swordStaminaCost.get()).doubleValue()));
/*  36 */     weaponStaminaCosts.put(CapabilityItem.WeaponCategories.SPEAR, Float.valueOf((float)((Double)EpicFightStaminaPlusConfig.spearStaminaCost.get()).doubleValue()));
/*  37 */     weaponStaminaCosts.put(CapabilityItem.WeaponCategories.GREATSWORD, Float.valueOf((float)((Double)EpicFightStaminaPlusConfig.greatswordStaminaCost.get()).doubleValue()));
/*  38 */     weaponStaminaCosts.put(CapabilityItem.WeaponCategories.DAGGER, Float.valueOf((float)((Double)EpicFightStaminaPlusConfig.daggerStaminaCost.get()).doubleValue()));
/*  39 */     weaponStaminaCosts.put(CapabilityItem.WeaponCategories.TRIDENT, Float.valueOf((float)((Double)EpicFightStaminaPlusConfig.tridentStaminaCost.get()).doubleValue()));
/*  40 */     weaponStaminaCosts.put(CapabilityItem.WeaponCategories.UCHIGATANA, Float.valueOf((float)((Double)EpicFightStaminaPlusConfig.uchigatanaStaminaCost.get()).doubleValue()));
/*  41 */     weaponStaminaCosts.put(CapabilityItem.WeaponCategories.TACHI, Float.valueOf((float)((Double)EpicFightStaminaPlusConfig.tachiStaminaCost.get()).doubleValue()));
/*  42 */     weaponStaminaCosts.put(CapabilityItem.WeaponCategories.LONGSWORD, Float.valueOf((float)((Double)EpicFightStaminaPlusConfig.longswordStaminaCost.get()).doubleValue()));
/*  43 */     weaponStaminaCosts.put(CapabilityItem.WeaponCategories.HOE, Float.valueOf((float)((Double)EpicFightStaminaPlusConfig.hoeStaminaCost.get()).doubleValue()));
/*  44 */     weaponStaminaCosts.put(CapabilityItem.WeaponCategories.SHOVEL, Float.valueOf((float)((Double)EpicFightStaminaPlusConfig.shovelStaminaCost.get()).doubleValue()));
/*  45 */     weaponStaminaCosts.put(CapabilityItem.WeaponCategories.PICKAXE, Float.valueOf((float)((Double)EpicFightStaminaPlusConfig.pickaxeStaminaCost.get()).doubleValue()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  50 */   private static final float BOW_STAMINA_COST = (float)((Double)EpicFightStaminaPlusConfig.bowStaminaCost.get()).doubleValue();
/*  51 */   private static final float CROSSBOW_STAMINA_COST = (float)((Double)EpicFightStaminaPlusConfig.crossbowStaminaCost.get()).doubleValue();
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onPlayerTick(LivingEvent.LivingTickEvent event) {
/*  55 */     LivingEntity livingEntity = event.getEntity(); if (livingEntity instanceof Player) { Player player = (Player)livingEntity;
/*  56 */       PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/*     */       
/*  58 */       if (playerPatch != null) {
/*  59 */         float currentStamina = playerPatch.getStamina();
/*     */ 
/*     */         
/*  62 */         if (player.m_20142_() && ((Boolean)EpicFightStaminaPlusConfig.enableSprintStamina.get()).booleanValue()) {
/*  63 */           float sprintStaminaCost = (float)((Double)EpicFightStaminaPlusConfig.sprintStaminaCost.get()).doubleValue();
/*  64 */           playerPatch.setStamina(Math.max(0.0F, currentStamina - sprintStaminaCost));
/*     */           
/*  66 */           playerPatch.resetActionTick();
/*     */         } 
/*     */ 
/*     */         
/*  70 */         if (((Boolean)EpicFightStaminaPlusConfig.enableAttackStamina.get()).booleanValue()) {
/*  71 */           Item activeItem = player.m_21211_().m_41720_();
/*     */           
/*  73 */           if (currentStamina <= 0.0F) {
/*  74 */             if (activeItem == Items.f_42411_ && player.m_6117_()) {
/*  75 */               player.m_21253_();
/*  76 */             } else if (activeItem == Items.f_42717_ && player.m_6117_()) {
/*  77 */               player.m_21253_();
/*     */             }
/*     */           
/*  80 */           } else if (activeItem == Items.f_42411_ && player.m_6117_()) {
/*  81 */             playerPatch.setStamina(Math.max(0.0F, currentStamina - BOW_STAMINA_COST));
/*  82 */             playerPatch.resetActionTick();
/*  83 */           } else if (activeItem == Items.f_42717_ && player.m_6117_()) {
/*  84 */             playerPatch.setStamina(Math.max(0.0F, currentStamina - CROSSBOW_STAMINA_COST));
/*  85 */             playerPatch.resetActionTick();
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/*  91 */         playerPatch.getEventListener().addEventListener(PlayerEventListener.EventType.BASIC_ATTACK_EVENT, ((Player)playerPatch.getOriginal()).m_20148_(), basicAttackEvent -> {
/*     */               if (((Boolean)EpicFightStaminaPlusConfig.enableAttackStamina.get()).booleanValue() && playerPatch.isBattleMode()) {
/*     */                 CapabilityItem weaponCapability = playerPatch.getHoldingItemCapability(InteractionHand.MAIN_HAND);
/*     */                 if (weaponCapability != null) {
/*     */                   double weaponDamage = player.m_21051_(Attributes.f_22281_).m_22135_();
/*     */                   WeaponCategory weaponCategory = weaponCapability.getWeaponCategory();
/*     */                   if (weaponCategory instanceof CapabilityItem.WeaponCategories) {
/*     */                     CapabilityItem.WeaponCategories weaponType = (CapabilityItem.WeaponCategories)weaponCategory;
/*     */                     float weaponStaminaCost = ((Float)weaponStaminaCosts.getOrDefault(weaponType, Float.valueOf(1.0F))).floatValue();
/*     */                     float attackStaminaCost = (float)(weaponDamage * 0.54D + weaponStaminaCost);
/*     */                     float newStamina = Math.max(0.0F, playerPatch.getStamina() - attackStaminaCost);
/*     */                     playerPatch.setStamina(newStamina);
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             });
/*     */       }  }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void whenEntityBlocksWithShield(ShieldBlockEvent event) {
/* 116 */     if (((Boolean)EpicFightStaminaPlusConfig.enableShieldStamina.get()).booleanValue()) {
/* 117 */       LivingEntity livingEntity = event.getEntity(); if (livingEntity instanceof Player) { Player player = (Player)livingEntity;
/* 118 */         PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/*     */         
/* 120 */         if (playerPatch != null) { float currentStamina = playerPatch.getStamina();
/* 121 */           if (currentStamina <= 0.0F) {
/* 122 */             player.m_5810_();
/*     */           } else {
/* 124 */             float blockedDamage = event.getBlockedDamage();
/* 125 */             float staminaCost = blockedDamage * (float)((Double)EpicFightStaminaPlusConfig.shieldStaminaMultiplier.get()).doubleValue();
/*     */ 
/*     */             
/* 128 */             float newStamina = Math.max(0.0F, playerPatch.getStamina() - staminaCost);
/* 129 */             playerPatch.setStamina(newStamina);
/* 130 */             playerPatch.resetActionTick();
/*     */           }  }
/*     */          }
/*     */     
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\Сохранки\Mcreator\New_Life\MC\epic_fight_stamina_plus-1.0.0-forge-1.20.1.jar!\net\mcreator\epicfightstaminaplus\CustomStaminaHandler.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */