package com.themastergeneral.magickassist.items;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class CraftingItemDamage extends CraftingItem
{
	private Block containedBlock;
	public CraftingItemDamage(String name, String modid, int damage) 
	{
		super(name, modid);
		this.setMaxDamage(damage - 1);
	}
	@Override
	 public boolean getShareTag()
	 {
		 return true;
	 }
	 public boolean hasContainerItem(ItemStack itemStack)
	 {
		 return true;
	 }
	 @Override
	 public ItemStack getContainerItem(ItemStack itemStack)
	 {
		 ItemStack stack = itemStack.copy();
		 this.maxStackSize = 1;
		 return stack;
	 }
}
