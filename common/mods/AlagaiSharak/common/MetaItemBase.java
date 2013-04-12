package mods.AlagaiSharak.common;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class MetaItemBase extends Item {
	private String[] names;
	private String[] textures;
	private Icon[] icons;

	public MetaItemBase(int id, String[] names, String[] textures) {
		super(id);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.textures = textures;
		this.names = names;
		this.icons = new Icon[textures.length];
		this.setCreativeTab(AlagaiSharak.tabAlagaiSharak);
	}

	@Override
	public void updateIcons(IconRegister register) {
		for (int i = 0; i < this.textures.length; i++) {
			this.icons[i] = register.registerIcon(textures[i]);

		}
	}

	@Override
	public Icon getIconFromDamage(int meta) {
		return this.icons[meta];
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return this.names[stack.getItemDamage()];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(int itemID, CreativeTabs tab, List list) {
		for (int i = 0; i < this.icons.length; i++) {
			list.add(new ItemStack(itemID, 1, i));
		}
	}
}