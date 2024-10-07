/*    */ package net.mcreator.epicfightstaminaplus;
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.world.effect.MobEffect;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
/*    */ import net.minecraftforge.registries.DeferredRegister;
/*    */ import net.minecraftforge.registries.ForgeRegistries;
/*    */ import net.minecraftforge.registries.RegistryObject;
/*    */ 
/*    */ @EventBusSubscriber(modid = "epic_fight_stamina_plus", bus = Mod.EventBusSubscriber.Bus.MOD)
/*    */ public class ModEffects {
/* 13 */   public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "epic_fight_stamina_plus");
/*    */   
/* 15 */   public static final RegistryObject<MobEffect> FATIGUE = MOB_EFFECTS.register("fatigue", FatigueEffect::new);
/* 16 */   public static final RegistryObject<MobEffect> VIGOR = MOB_EFFECTS.register("vigor", VigorEffect::new);
/* 17 */   public static final RegistryObject<MobEffect> WEAKNESS = MOB_EFFECTS.register("weakness", WeaknessEffect::new);
/* 18 */   public static final RegistryObject<MobEffect> STRENGTH_SURGE = MOB_EFFECTS.register("strength_surge", StrengthSurgeEffect::new);
/*    */   
/*    */   static {
/* 21 */     MOB_EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
/*    */   }
/*    */ }


/* Location:              D:\Сохранки\Mcreator\New_Life\MC\epic_fight_stamina_plus-1.0.0-forge-1.20.1.jar!\net\mcreator\epicfightstaminaplus\ModEffects.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */