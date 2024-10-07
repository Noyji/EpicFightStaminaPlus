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
/*    */ public class VigorEffect extends MobEffect {
/* 13 */   private static final UUID STAMINA_REGEN_BOOST_UUID = UUID.fromString("7d68acb3-635b-4b48-86a6-999f3123e79b");
/*    */   
/*    */   public VigorEffect() {
/* 16 */     super(MobEffectCategory.BENEFICIAL, 65280);
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_6742_(LivingEntity entity, int amplifier) {
/* 21 */     if (entity instanceof Player) { Player player = (Player)entity;
/*    */       
/* 23 */       if (player.m_21051_((Attribute)EpicFightAttributes.STAMINA_REGEN.get()) != null) {
/* 24 */         AttributeModifier regenBoost = new AttributeModifier(STAMINA_REGEN_BOOST_UUID, "Vigor stamina regen boost", 0.2D * (amplifier + 1), AttributeModifier.Operation.MULTIPLY_TOTAL);
/* 25 */         if (player.m_21051_((Attribute)EpicFightAttributes.STAMINA_REGEN.get()).m_22111_(STAMINA_REGEN_BOOST_UUID) == null) {
/* 26 */           player.m_21051_((Attribute)EpicFightAttributes.STAMINA_REGEN.get()).m_22118_(regenBoost);
/*    */         }
/*    */       }  }
/*    */   
/*    */   }
/*    */ 
/*    */   
/*    */   public void m_6386_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
/* 34 */     if (entity instanceof Player) { Player player = (Player)entity;
/* 35 */       if (player.m_21051_((Attribute)EpicFightAttributes.STAMINA_REGEN.get()) != null) {
/* 36 */         player.m_21051_((Attribute)EpicFightAttributes.STAMINA_REGEN.get()).m_22120_(STAMINA_REGEN_BOOST_UUID);
/*    */       } }
/*    */     
/* 39 */     super.m_6386_(entity, attributeMap, amplifier);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean m_6584_(int duration, int amplifier) {
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\Сохранки\Mcreator\New_Life\MC\epic_fight_stamina_plus-1.0.0-forge-1.20.1.jar!\net\mcreator\epicfightstaminaplus\VigorEffect.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */