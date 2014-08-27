package mod.xtronius.scm.core;

import mod.xtronius.scm.handlers.SCMBlockInitializer;
import mod.xtronius.scm.handlers.SCMBlockRegistry;
import mod.xtronius.scm.handlers.SCMIDHandler;
import mod.xtronius.scm.handlers.SCMItemInitializer;
import mod.xtronius.scm.handlers.SCMItemRegistry;
import mod.xtronius.scm.lib.Reference;
import mod.xtronius.scm.proxy.CommonProxy;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)

public class SCM {
	
	public SCM() {}
	
	@Instance(Reference.MOD_ID)
	public static SCM instance;
	
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	
	public static CommonProxy proxy;
	private static SCMBlockInitializer rcblockinitializer;
	public static SCMBlockRegistry BlockReg;
	public static SCMItemRegistry ItemReg;
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent event) {
		
		SCMIDHandler.RegConfigIDs(event);
		new SCMBlockInitializer();
		new SCMItemInitializer();	
    }   
    
	@EventHandler
	public void init(FMLInitializationEvent event) {

		SCMBlockRegistry.BlockReg();
		SCMItemRegistry.ItemReg();
//		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
	}
    	
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	proxy.registerRenderInformation();
    	proxy.initSounds();
    }
    
    @EventHandler
    public void serverStart(FMLServerStartingEvent event)
    {
    	 MinecraftServer server = MinecraftServer.getServer();
    	 ICommandManager command = server.getCommandManager();
    	 ServerCommandManager manager = (ServerCommandManager) command;
//    	 manager.registerCommand(new ResetLvlNBT());
    }
}

