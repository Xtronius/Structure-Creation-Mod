package mod.xtronius.scm.handlers;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class SCMIDHandler {
	 
	public static void RegConfigIDs(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

        int idI = 20000;
        int idB = 2750;
        int idGui = 1;
        
//		  BlockIDs.airID = config.get("AirID", "AirID", idB++).getInt();
		  
		  config.save();
	}
}
