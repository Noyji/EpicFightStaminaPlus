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
/*    */ public class WeaknessEffect extends MobEffect {
/* 13 */   private static final UUID STAMINA_REDUCTION_UUID = UUID.fromString("2839bde9-f64d-4a2a-a251-924f31f80b67");
/*    */   
/*    */   public WeaknessEffect() {
/* 16 */     super(MobEffectCategory.HARMFUL, 16711680);
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_6742_(LivingEntity entity, int amplifier) {
/* 21 */     if (entity instanceof Player) { Player player = (Player)entity;
/* 22 */       if (player.m_21051_((Attribute)EpicFightAttributes.MAX_STAMINA.get()) != null) {
/* 23 */         AttributeModifier staminaReduction = new AttributeModifier(STAMINA_REDUCTION_UUID, "Weakness stamina reduction", (-10 * (amplifier + 1)), AttributeModifier.Operation.ADDITION);
/* 24 */         if (player.m_21051_((Attribute)EpicFightAttributes.MAX_STAMINA.get()).m_22111_(STAMINA_REDUCTION_UUID) == null) {
/* 25 */           player.m_21051_((Attribute)EpicFightAttributes.MAX_STAMINA.get()).m_22118_(staminaReduction);
/*    */         }
/*    */       }  }
/*    */   
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_6386_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
/* 33 */     if (entity instanceof Player) { Player player = (Player)entity;
/* 34 */       if (player.m_21051_((Attribute)EpicFightAttributes.MAX_STAMINA.get()) != null) {
/* 35 */         player.m_21051_((Attribute)EpicFightAttributes.MAX_STAMINA.get()).m_22120_(STAMINA_REDUCTION_UUID);
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


/* Location:              D:\Сохранки\Mcreator\New_Life\MC\epic_fight_stamina_plus-1.0.0-forge-1.20.1.jar!\net\mcreator\epicfightstaminaplus\WeaknessEffect.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */