package com.themastergeneral.magickassist.items;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class FireStaffItem extends CraftingItemDamage
{
	private Block containedBlock;
	public FireStaffItem(String name, String modid, int durability) 
	{
		super(name, modid, durability);
	}
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	 {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		if (playerIn.isSneaking())
		{
			Block blocktotest = Blocks.NETHERRACK;
			boolean flag = this.containedBlock == blocktotest;
			RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, flag);
			if (raytraceresult == null)
			{
				return new ActionResult(EnumActionResult.PASS, itemstack);
			}
			else if (raytraceresult.typeOfHit != RayTraceResult.Type.BLOCK)
			{
				return new ActionResult(EnumActionResult.PASS, itemstack);
			}
			else
			{
				BlockPos blockpos = raytraceresult.getBlockPos();
	            if (!worldIn.isBlockModifiable(playerIn, blockpos))
	            {
	                return new ActionResult(EnumActionResult.FAIL, itemstack);
	            }
	            if (!playerIn.canPlayerEdit(blockpos.offset(raytraceresult.sideHit), raytraceresult.sideHit, itemstack))
	            {
                   return new ActionResult(EnumActionResult.FAIL, itemstack);
	            }
               else
               {
               	IBlockState iblockstate = worldIn.getBlockState(blockpos);
               	if (iblockstate == blocktotest.getDefaultState())
               	{
               		worldIn.setBlockState(blockpos, Blocks.MAGMA.getDefaultState(), 11);
               		itemstack.damageItem(1, playerIn);
               		return new ActionResult(EnumActionResult.PASS, itemstack);
               	}
               	else
               	{
               		return new ActionResult(EnumActionResult.FAIL, itemstack);
               	}
               }
			}
	 	}
		else
		{
			RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, false);
			if (raytraceresult == null)
			{
				return new ActionResult(EnumActionResult.PASS, itemstack);
			}
			else if (raytraceresult.typeOfHit != RayTraceResult.Type.BLOCK)
			{
				return new ActionResult(EnumActionResult.PASS, itemstack);
			}
			else
			{
				BlockPos blockpos = raytraceresult.getBlockPos();
	            if (!worldIn.isBlockModifiable(playerIn, blockpos.offset(raytraceresult.sideHit)))
	            {
	                return new ActionResult(EnumActionResult.FAIL, itemstack);
	            }
	            if (!playerIn.canPlayerEdit(blockpos.offset(raytraceresult.sideHit), raytraceresult.sideHit, itemstack))
	            {
                   return new ActionResult(EnumActionResult.FAIL, itemstack);
	            }
               else
               {
	               	if (worldIn.isAirBlock(blockpos.offset(raytraceresult.sideHit)))
	                {
	               		worldIn.setBlockState(blockpos.offset(raytraceresult.sideHit), Blocks.FIRE.getDefaultState(), 11);
	               		itemstack.damageItem(1, playerIn);
	               		return new ActionResult(EnumActionResult.PASS, itemstack);
	               	}
	               	else
	               	{
	               		return new ActionResult(EnumActionResult.FAIL, itemstack);
	               	}
               }
			}
		}
	 }
}
