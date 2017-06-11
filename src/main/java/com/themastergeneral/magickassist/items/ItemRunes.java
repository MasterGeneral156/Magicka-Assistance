package com.themastergeneral.magickassist.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemRunes extends BasicItem {

	public ItemRunes(String name, String modid) 
	{
		super(name, modid);
		this.setHasSubtypes(true);
	}
	@Override
	public String getUnlocalizedName(ItemStack stack) 
	{
		int i = stack.getMetadata();
        return super.getUnlocalizedName() + "." + i;
	}
	@SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems)
    {
        for (int i = 0; i < 4; ++i)
        {
            subItems.add(new ItemStack(itemIn, 1, i));
        }
    }
}
