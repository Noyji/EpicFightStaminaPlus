/*    */ package net.mcreator.epicfightstaminaplus;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.minecraft.world.effect.MobEffectCategory;
/*    */ import net.minecraft.world.entity.Entity;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*    */ import net.minecraft.world.entity.ai.attributes.AttributeMap;
/*    */ import net.minecraft.world.entity.ai.attributes.AttributeModifier;
/*    */ import net.minecraft.world.entity.ai.attributes.Attributes;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import yesman.epicfight.world.capabilities.EpicFightCapabilities;
/*    */ import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
/*    */ import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;
/*    */ 
/*    */ public class FatigueEffect extends MobEffect {
/* 17 */   private static final UUID ATTACK_SPEED_MODIFIER_UUID = UUID.fromString("d24fefea-36bb-4ac5-9517-df2e9d7f4907");
/* 18 */   private static final UUID STAMINA_REGEN_MODIFIER_UUID = UUID.fromString("12f3c2ef-58d2-4a23-9e30-53fd7bb2e2f3");
/*    */   
/*    */   public FatigueEffect() {
/* 21 */     super(MobEffectCategory.HARMFUL, 8421504);
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_6742_(LivingEntity entity, int amplifier) {
/* 26 */     if (entity instanceof Player) { Player player = (Player)entity;
/* 27 */       PlayerPatch<?> playerPatch = (PlayerPatch)EpicFightCapabilities.getEntityPatch((Entity)player, PlayerPatch.class);
/* 28 */       if (playerPatch != null) {
/* 29 */         player.m_6858_(false);
/*    */         
/* 31 */         if (player.m_21051_(Attributes.f_22283_) != null) {
/* 32 */           AttributeModifier attackSpeedModifier = new AttributeModifier(ATTACK_SPEED_MODIFIER_UUID, "Fatigue attack speed reduction", -0.8D, AttributeModifier.Operation.MULTIPLY_TOTAL);
/* 33 */           if (player.m_21051_(Attributes.f_22283_).m_22111_(ATTACK_SPEED_MODIFIER_UUID) == null) {
/* 34 */             player.m_21051_(Attributes.f_22283_).m_22118_(attackSpeedModifier);
/*    */           }
/*    */         } 
/*    */ 
/*    */         
/* 39 */         if (player.m_21051_((Attribute)EpicFightAttributes.STAMINA_REGEN.get()) != null) {
/* 40 */           AttributeModifier staminaRegenModifier = new AttributeModifier(STAMINA_REGEN_MODIFIER_UUID, "Fatigue stamina regen reduction", -0.5D, AttributeModifier.Operation.MULTIPLY_TOTAL);
/* 41 */           if (player.m_21051_((Attribute)EpicFightAttributes.STAMINA_REGEN.get()).m_22111_(STAMINA_REGEN_MODIFIER_UUID) == null) {
/* 42 */             player.m_21051_((Attribute)EpicFightAttributes.STAMINA_REGEN.get()).m_22118_(staminaRegenModifier);
/*    */           }
/*    */         } 
/*    */       }  }
/*    */   
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_6386_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
/* 51 */     if (entity instanceof Player) { Player player = (Player)entity;
/*    */       
/* 53 */       if (player.m_21051_(Attributes.f_22283_) != null) {
/* 54 */         player.m_21051_(Attributes.f_22283_).m_22120_(ATTACK_SPEED_MODIFIER_UUID);
/*    */       }
/*    */ 
/*    */       
/* 58 */       if (player.m_21051_((Attribute)EpicFightAttributes.STAMINA_REGEN.get()) != null) {
/* 59 */         player.m_21051_((Attribute)EpicFightAttributes.STAMINA_REGEN.get()).m_22120_(STAMINA_REGEN_MODIFIER_UUID);
/*    */       } }
/*    */ 
/*    */     
/* 63 */     super.m_6386_(entity, attributeMap, amplifier);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_6584_(int duration, int amplifier) {
/* 68 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Сохранки\Mcreator\New_Life\MC\epic_fight_stamina_plus-1.0.0-forge-1.20.1.jar!\net\mcreator\epicfightstaminaplus\FatigueEffect.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */