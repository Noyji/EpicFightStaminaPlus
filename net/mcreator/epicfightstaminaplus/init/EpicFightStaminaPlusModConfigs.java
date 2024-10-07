/*    */ package net.mcreator.epicfightstaminaplus.init;
/*    */ 
/*    */ import net.mcreator.epicfightstaminaplus.EpicFightStaminaPlusConfig;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.ModLoadingContext;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*    */ import net.minecraftforge.fml.config.IConfigSpec;
/*    */ import net.minecraftforge.fml.config.ModConfig;
/*    */ import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
/*    */ 
/*    */ 
/*    */ @EventBusSubscriber(modid = "epic_fight_stamina_plus", bus = Mod.EventBusSubscriber.Bus.MOD)
/*    */ public class EpicFightStaminaPlusModConfigs
/*    */ {
/*    */   @SubscribeEvent
/*    */   public static void register(FMLConstructModEvent event) {
/* 18 */     event.enqueueWork(() -> ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, (IConfigSpec)EpicFightStaminaPlusConfig.SERVER_CONFIG));
/*    */   }
/*    */ }


/* Location:              D:\Сохранки\Mcreator\New_Life\MC\epic_fight_stamina_plus-1.0.0-forge-1.20.1.jar!\net\mcreator\epicfightstaminaplus\init\EpicFightStaminaPlusModConfigs.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */