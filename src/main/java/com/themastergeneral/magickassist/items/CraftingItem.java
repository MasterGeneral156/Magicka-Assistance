package com.themastergeneral.magickassist.items;

import net.minecraft.item.ItemStack;

public class CraftingItem extends BasicItem 
{

	public CraftingItem(String name, String modid) 
	{
		super(name, modid);
	}
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack)
	{
		 return false;
	}
}
