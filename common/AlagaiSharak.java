package mods.AlagaiSharak.common;

import mods.AlagaiSharak.common.AlagaiSharak;
import mods.AlagaiSharak.common.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "AlagaiSharak" , name = "AlagaiSharak" , version = "Alpha")
@NetworkMod(clientSideRequired = true , serverSideRequired = false)

public class AlagaiSharak {




	@Instance("AlagaiSharak")
	public static AlagaiSharak instance;

	
	public static CreativeTabs tabAlagaiSharak = new CreativeTabs("Alagai'Sharak") {
		public ItemStack getIconItemStack() {
			return new ItemStack(Block.blockNetherQuartz, 1, 0);
		}
	};
	
	//Wards
	public static Item OffenceWards;
	int OffenceWardsID;
	public static Item DefenceWards;
	int DefenceWardsID;
	public static Item BodyWards;
	int BodyWardsID;
	public static Item Runes;
	public static Item Runes1;
	int MetaItemID;
	
	
	
	//Wards
	@PreInit
	public void preInt(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();	

		//Wards
		OffenceWardsID = config.get("Block IDs","Offence Wards ID", 2500).getInt();
		DefenceWardsID = config.get("Block IDs","Defence Wards ID", 2501).getInt();
		BodyWardsID = config.get("Block IDs","Body Wards ID", 2502).getInt();
		MetaItemID = config.get("Block IDs","Runes ID", 2503).getInt();
			
		config.save();
		}
	
	@SidedProxy(clientSide = "mods.AlagaiSharak.client.ClientProxy", serverSide = "mods.AlagaiSharak.common.ServerProxy")
	public static ServerProxy proxy;
	
	@Init
	public void load(FMLInitializationEvent event){

		//Wards 
		OffenceWards = new ItemOffenceWards (OffenceWardsID).setUnlocalizedName("Offence Wards");
		DefenceWards = new ItemDefenceWards (DefenceWardsID).setUnlocalizedName("Defence Wards");
		BodyWards = new ItemBodyWards (BodyWardsID).setUnlocalizedName("Body Wards");
		Runes = new ItemBodyWards (MetaItemID).setUnlocalizedName("Runes");
		Runes1 = new ItemBodyWards (MetaItemID).setUnlocalizedName("Runes1");
		
		gameRegisters();
		languageRegisters();
		craftingRecipes();
		proxy.registerRenderers();


	}

	private void craftingRecipes() {
		GameRegistry.addRecipe(new ItemStack(OffenceWards, 1), new Object[]{" P ", "PIP", " P ", 'p', Item.paper , 'I', Item.ingotIron });
		GameRegistry.addRecipe(new ItemStack(DefenceWards, 1), new Object[]{" P ", "PIP", " P ", 'p', Item.paper , 'I', Block.stone });
		GameRegistry.addRecipe(new ItemStack(BodyWards, 1), new Object[]{" P ", "PIP", " P ", 'p', Item.paper , 'I', Item.appleRed });

		
		
	}

	private static void gameRegisters() {
		GameRegistry.registerItem(OffenceWards, "Offence Ward");
		GameRegistry.registerItem(DefenceWards, "Defence Wards");
		GameRegistry.registerItem(BodyWards, "Body Wards");
		GameRegistry.registerItem(Runes, "Runes");
		GameRegistry.registerItem(Runes1, "Runes1");
	}
	
	private static void languageRegisters(){
		LanguageRegistry.addName(OffenceWards, "Offence Ward");
		LanguageRegistry.addName(DefenceWards, "Defence Wards");
		LanguageRegistry.addName(BodyWards, "Body Wards");
		LanguageRegistry.addName(Runes, "Runes");
		LanguageRegistry.addName(Runes1, "Runes1");
	
	}
}
