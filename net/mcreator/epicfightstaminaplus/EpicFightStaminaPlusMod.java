/*    */ package net.mcreator.epicfightstaminaplus;
/*    */ 
/*    */ import java.util.AbstractMap;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.ConcurrentLinkedQueue;
/*    */ import java.util.function.BiConsumer;
/*    */ import java.util.function.Function;
/*    */ import java.util.function.Supplier;
/*    */ import net.minecraft.network.FriendlyByteBuf;
/*    */ import net.minecraft.resources.ResourceLocation;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ import net.minecraftforge.event.TickEvent;
/*    */ import net.minecraftforge.eventbus.api.IEventBus;
/*    */ import net.minecraftforge.eventbus.api.SubscribeEvent;
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
/*    */ import net.minecraftforge.fml.util.thread.SidedThreadGroups;
/*    */ import net.minecraftforge.network.NetworkEvent;
/*    */ import net.minecraftforge.network.NetworkRegistry;
/*    */ import net.minecraftforge.network.simple.SimpleChannel;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mod("epic_fight_stamina_plus")
/*    */ public class EpicFightStaminaPlusMod
/*    */ {
/* 31 */   public static final Logger LOGGER = LogManager.getLogger(EpicFightStaminaPlusMod.class);
/*    */   
/*    */   public static final String MODID = "epic_fight_stamina_plus";
/*    */   private static final String PROTOCOL_VERSION = "1";
/*    */   
/*    */   public EpicFightStaminaPlusMod() {
/* 37 */     MinecraftForge.EVENT_BUS.register(this);
/* 38 */     IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 47 */   public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation("epic_fight_stamina_plus", "epic_fight_stamina_plus"), () -> "1", "1"::equals, "1"::equals);
/* 48 */   private static int messageID = 0;
/*    */   
/*    */   public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
/* 51 */     PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
/* 52 */     messageID++;
/*    */   }
/*    */   
/* 55 */   private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();
/*    */   
/*    */   public static void queueServerWork(int tick, Runnable action) {
/* 58 */     if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
/* 59 */       workQueue.add(new AbstractMap.SimpleEntry<>(action, Integer.valueOf(tick))); 
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void tick(TickEvent.ServerTickEvent event) {
/* 64 */     if (event.phase == TickEvent.Phase.END) {
/* 65 */       List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
/* 66 */       workQueue.forEach(work -> {
/*    */             work.setValue(Integer.valueOf(((Integer)work.getValue()).intValue() - 1));
/*    */             if (((Integer)work.getValue()).intValue() == 0)
/*    */               actions.add(work); 
/*    */           });
/* 71 */       actions.forEach(e -> ((Runnable)e.getKey()).run());
/* 72 */       workQueue.removeAll(actions);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\Сохранки\Mcreator\New_Life\MC\epic_fight_stamina_plus-1.0.0-forge-1.20.1.jar!\net\mcreator\epicfightstaminaplus\EpicFightStaminaPlusMod.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */