/*     */ package net.mcreator.epicfightstaminaplus;
/*     */ 
/*     */ import net.minecraftforge.common.ForgeConfigSpec;
/*     */ import net.minecraftforge.fml.ModLoadingContext;
/*     */ import net.minecraftforge.fml.common.Mod;
/*     */ import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
/*     */ import net.minecraftforge.fml.config.IConfigSpec;
/*     */ import net.minecraftforge.fml.config.ModConfig;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @EventBusSubscriber(modid = "epicfightstaminaplus", bus = Mod.EventBusSubscriber.Bus.MOD)
/*     */ public class EpicFightStaminaPlusConfig
/*     */ {
/*     */   public static final ForgeConfigSpec SERVER_CONFIG;
/*     */   public static final ForgeConfigSpec.DoubleValue axeStaminaCost;
/*     */   public static final ForgeConfigSpec.DoubleValue swordStaminaCost;
/*     */   public static final ForgeConfigSpec.DoubleValue spearStaminaCost;
/*     */   public static final ForgeConfigSpec.DoubleValue greatswordStaminaCost;
/*     */   public static final ForgeConfigSpec.DoubleValue daggerStaminaCost;
/*     */   public static final ForgeConfigSpec.DoubleValue bowStaminaCost;
/*     */   public static final ForgeConfigSpec.DoubleValue crossbowStaminaCost;
/*     */   public static final ForgeConfigSpec.DoubleValue tridentStaminaCost;
/*     */   public static final ForgeConfigSpec.DoubleValue uchigatanaStaminaCost;
/*     */   public static final ForgeConfigSpec.DoubleValue tachiStaminaCost;
/*     */   public static final ForgeConfigSpec.DoubleValue longswordStaminaCost;
/*     */   public static final ForgeConfigSpec.DoubleValue hoeStaminaCost;
/*     */   public static final ForgeConfigSpec.DoubleValue shovelStaminaCost;
/*     */   public static final ForgeConfigSpec.DoubleValue pickaxeStaminaCost;
/*     */   public static final ForgeConfigSpec.DoubleValue gliderStaminaCost;
/*     */   public static final ForgeConfigSpec.DoubleValue sprintStaminaCost;
/*     */   public static final ForgeConfigSpec.DoubleValue shieldStaminaMultiplier;
/*     */   public static final ForgeConfigSpec.DoubleValue maxStartStamina;
/*     */   public static final ForgeConfigSpec.BooleanValue enableSprintStamina;
/*     */   public static final ForgeConfigSpec.BooleanValue enableAttackStamina;
/*     */   public static final ForgeConfigSpec.BooleanValue enableGliderStamina;
/*     */   public static final ForgeConfigSpec.BooleanValue enableShieldStamina;
/*     */   
/*     */   static {
/*  48 */     ForgeConfigSpec.Builder serverBuilder = new ForgeConfigSpec.Builder();
/*     */ 
/*     */     
/*  51 */     serverBuilder.push("Weapon Stamina Costs");
/*     */ 
/*     */ 
/*     */     
/*  55 */     axeStaminaCost = serverBuilder.comment("Stamina cost for using an axe (Default: 2.0)").defineInRange("axeStaminaCost", 2.0D, 0.1D, 10.0D);
/*     */ 
/*     */ 
/*     */     
/*  59 */     swordStaminaCost = serverBuilder.comment("Stamina cost for using a sword (Default: 2.5)").defineInRange("swordStaminaCost", 2.5D, 0.1D, 10.0D);
/*     */ 
/*     */ 
/*     */     
/*  63 */     spearStaminaCost = serverBuilder.comment("Stamina cost for using a spear (Default: 3.0)").defineInRange("spearStaminaCost", 3.0D, 0.1D, 10.0D);
/*     */ 
/*     */ 
/*     */     
/*  67 */     greatswordStaminaCost = serverBuilder.comment("Stamina cost for using a greatsword (Default: 4.0)").defineInRange("greatswordStaminaCost", 4.0D, 0.1D, 10.0D);
/*     */ 
/*     */ 
/*     */     
/*  71 */     daggerStaminaCost = serverBuilder.comment("Stamina cost for using a dagger (Default: 1.2)").defineInRange("daggerStaminaCost", 1.2D, 0.1D, 10.0D);
/*     */ 
/*     */ 
/*     */     
/*  75 */     bowStaminaCost = serverBuilder.comment("Stamina cost for using a bow (Default: 0.5)").defineInRange("bowStaminaCost", 0.5D, 0.1D, 10.0D);
/*     */ 
/*     */ 
/*     */     
/*  79 */     crossbowStaminaCost = serverBuilder.comment("Stamina cost for using a crossbow (Default: 0.8)").defineInRange("crossbowStaminaCost", 0.8D, 0.1D, 10.0D);
/*     */ 
/*     */ 
/*     */     
/*  83 */     tridentStaminaCost = serverBuilder.comment("Stamina cost for using a trident (Default: 3.5)").defineInRange("tridentStaminaCost", 3.5D, 0.1D, 10.0D);
/*     */ 
/*     */ 
/*     */     
/*  87 */     uchigatanaStaminaCost = serverBuilder.comment("Stamina cost for using an uchigatana (Default: 3.5)").defineInRange("uchigatanaStaminaCost", 3.5D, 0.1D, 10.0D);
/*     */ 
/*     */ 
/*     */     
/*  91 */     tachiStaminaCost = serverBuilder.comment("Stamina cost for using a tachi (Default: 3.2)").defineInRange("tachiStaminaCost", 3.2D, 0.1D, 10.0D);
/*     */ 
/*     */ 
/*     */     
/*  95 */     longswordStaminaCost = serverBuilder.comment("Stamina cost for using a longsword (Default: 3.0)").defineInRange("longswordStaminaCost", 3.0D, 0.1D, 10.0D);
/*     */ 
/*     */ 
/*     */     
/*  99 */     hoeStaminaCost = serverBuilder.comment("Stamina cost for using a hoe (Default: 1.5)").defineInRange("hoeStaminaCost", 1.5D, 0.1D, 10.0D);
/*     */ 
/*     */ 
/*     */     
/* 103 */     shovelStaminaCost = serverBuilder.comment("Stamina cost for using a shovel (Default: 1.5)").defineInRange("shovelStaminaCost", 1.5D, 0.1D, 10.0D);
/*     */ 
/*     */ 
/*     */     
/* 107 */     pickaxeStaminaCost = serverBuilder.comment("Stamina cost for using a pickaxe (Default: 1.8)").defineInRange("pickaxeStaminaCost", 1.8D, 0.1D, 10.0D);
/*     */     
/* 109 */     serverBuilder.pop();
/*     */ 
/*     */     
/* 112 */     serverBuilder.push("Glider Stamina Cost");
/*     */ 
/*     */     
/* 115 */     gliderStaminaCost = serverBuilder.comment("Stamina cost per tick while gliding with the glider (Default: 0.3)").defineInRange("gliderStaminaCost", 0.3D, 0.1D, 10.0D);
/* 116 */     serverBuilder.pop();
/*     */ 
/*     */     
/* 119 */     serverBuilder.push("Sprint Stamina Cost");
/*     */ 
/*     */     
/* 122 */     sprintStaminaCost = serverBuilder.comment("Stamina cost per tick while sprinting (Default: 1.0)").defineInRange("sprintStaminaCost", 1.0D, 0.1D, 10.0D);
/* 123 */     serverBuilder.pop();
/*     */ 
/*     */     
/* 126 */     serverBuilder.push("Shield Block Stamina Multiplier");
/*     */ 
/*     */     
/* 129 */     shieldStaminaMultiplier = serverBuilder.comment("Multiplier for stamina cost based on blocked damage (Default: 1.2)").defineInRange("shieldStaminaMultiplier", 1.2D, 0.1D, 10.0D);
/* 130 */     serverBuilder.pop();
/*     */     
/* 132 */     serverBuilder.push("Starter stamina");
/*     */ 
/*     */     
/* 135 */     maxStartStamina = serverBuilder.comment("Base stamina in start(Default: 100.0)").defineInRange("sprintStaminaCost", 100.0D, 1.0D, 1024.0D);
/* 136 */     serverBuilder.pop();
/*     */ 
/*     */     
/* 139 */     serverBuilder.push("Stamina Cost Toggles");
/*     */ 
/*     */     
/* 142 */     enableSprintStamina = serverBuilder.comment("Enable or disable stamina cost for sprinting (Default: true)").define("enableSprintStamina", true);
/*     */ 
/*     */ 
/*     */     
/* 146 */     enableAttackStamina = serverBuilder.comment("Enable or disable stamina cost for attacks (Default: true)").define("enableAttackStamina", true);
/*     */ 
/*     */ 
/*     */     
/* 150 */     enableGliderStamina = serverBuilder.comment("Enable or disable stamina cost for gliding (Default: true)").define("enableGliderStamina", true);
/*     */ 
/*     */ 
/*     */     
/* 154 */     enableShieldStamina = serverBuilder.comment("Enable or disable stamina cost for blocking with shield (Default: true)").define("enableShieldStamina", true);
/*     */     
/* 156 */     serverBuilder.pop();
/* 157 */     SERVER_CONFIG = serverBuilder.build();
/*     */   }
/*     */   
/*     */   public static void register() {
/* 161 */     ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, (IConfigSpec)SERVER_CONFIG);
/*     */   }
/*     */ }


/* Location:              D:\Сохранки\Mcreator\New_Life\MC\epic_fight_stamina_plus-1.0.0-forge-1.20.1.jar!\net\mcreator\epicfightstaminaplus\EpicFightStaminaPlusConfig.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */