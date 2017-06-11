package com.themastergeneral.magickassist.client;

import com.themastergeneral.magickassist.MagickaAssist;
import com.themastergeneral.magickassist.items.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs 
{
	public CreativeTab() 
	{
		super(MagickaAssist.MODID);
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ModItems.gemmined); //shown icon on creative tab
	}
	
	 @Override
	 public boolean hasSearchBar() 
	 {
		 return false;
	 }
}
