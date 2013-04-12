package mods.AlagaiSharak.common;

import mods.AlagaiSharak.common.AlagaiSharak;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemDefenceWards extends Item{

	public ItemDefenceWards(int par1) {
		super(par1);
		setMaxStackSize(16);
		this.setCreativeTab(AlagaiSharak.tabAlagaiSharak);
	}
	
	public void updateIcons(IconRegister iconRegister)
	{
	         iconIndex = iconRegister.registerIcon("AlagaiSharak:");
	}
	
}
