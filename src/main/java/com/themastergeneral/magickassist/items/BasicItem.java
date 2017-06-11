package com.themastergeneral.magickassist.items;

import net.minecraft.item.ItemStack;

import com.themastergeneral.ctdcore.client.ItemModelProvider;
import com.themastergeneral.ctdcore.item.CTDItem;
import com.themastergeneral.magickassist.MagickaAssist;

public class BasicItem extends CTDItem implements ItemModelProvider
{
	public BasicItem(String name, String modid) 
	{
		super(name, modid);
		this.setUnlocalizedName(name);
		this.setCreativeTab(MagickaAssist.creativeTab);
	}
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack)
	{
		 return false;
	}
}
