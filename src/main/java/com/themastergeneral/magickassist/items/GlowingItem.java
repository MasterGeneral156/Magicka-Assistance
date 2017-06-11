package com.themastergeneral.magickassist.items;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GlowingItem extends BasicItem
{
	public GlowingItem(String name, String modid) 
	{
		super(name, modid);
	}
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack) 
	{
	     par1ItemStack.setTagInfo("ench", new NBTTagList());
	     return true;
	}
}
