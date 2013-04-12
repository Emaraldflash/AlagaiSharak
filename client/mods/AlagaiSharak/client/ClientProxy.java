package mods.AlagaiSharak.client;

import mods.AlagaiSharak.common.ServerProxy;
import cpw.mods.fml.client.registry.RenderingRegistry;



public class ClientProxy extends ServerProxy {
	
	@Override
	public void registerRenderers() {
	
	}
		
	
	@Override
	public int addArmor(String armor) {
		
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
