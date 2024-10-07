/*    */ package net.mcreator.epicfightstaminaplus;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.minecraft.world.effect.MobEffectCategory;
/*    */ import net.minecraft.world.entity.LivingEntity;
/*    */ import net.minecraft.world.entity.ai.attributes.Attribute;
/*    */ import net.minecraft.world.entity.ai.attributes.AttributeMap;
/*    */ import net.minecraft.world.entity.ai.attributes.AttributeModifier;
/*    */ import net.minecraft.world.entity.player.Player;
/*    */ import yesman.epicfight.world.entity.ai.attribute.EpicFightAttributes;
/*    */ 
/*    */ public class StrengthSurgeEffect extends MobEffect {
/* 13 */   private static final UUID STAMINA_INCREASE_UUID = UUID.fromString("82f3a6c7-7525-4f4f-8fa1-7b2b72246d93");
/*    */   
/*    */   public StrengthSurgeEffect() {
/* 16 */     super(MobEffectCategory.BENEFICIAL, 255);
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_6742_(LivingEntity entity, int amplifier) {
/* 21 */     if (entity instanceof Player) { Player player = (Player)entity;
/* 22 */       if (player.m_21051_((Attribute)EpicFightAttributes.MAX_STAMINA.get()) != null) {
/* 23 */         AttributeModifier staminaIncrease = new AttributeModifier(STAMINA_INCREASE_UUID, "Strength Surge stamina increase", (10 * (amplifier + 1)), AttributeModifier.Operation.ADDITION);
/* 24 */         if (player.m_21051_((Attribute)EpicFightAttributes.MAX_STAMINA.get()).m_22111_(STAMINA_INCREASE_UUID) == null) {
/* 25 */           player.m_21051_((Attribute)EpicFightAttributes.MAX_STAMINA.get()).m_22118_(staminaIncrease);
/*    */         }
/*    */       }  }
/*    */   
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_6386_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
/* 33 */     if (entity instanceof Player) { Player player = (Player)entity;
/* 34 */       if (player.m_21051_((Attribute)EpicFightAttributes.MAX_STAMINA.get()) != null) {
/* 35 */         player.m_21051_((Attribute)EpicFightAttributes.MAX_STAMINA.get()).m_22120_(STAMINA_INCREASE_UUID);
/*    */       } }
/*    */     
/* 38 */     super.m_6386_(entity, attributeMap, amplifier);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_6584_(int duration, int amplifier) {
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Сохранки\Mcreator\New_Life\MC\epic_fight_stamina_plus-1.0.0-forge-1.20.1.jar!\net\mcreator\epicfightstaminaplus\StrengthSurgeEffect.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */