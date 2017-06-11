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

public class ItemConjurersWand extends CraftingItemDamage {

	private Block containedBlock;
	public ItemConjurersWand(String name, String modid, int damage)
	{
		super(name, modid, damage);
	}
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	 {
		Block blocktotest = Blocks.ENCHANTING_TABLE;
		boolean flag = this.containedBlock == blocktotest;
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, flag);
		//Lets convert the enchantment table into the rune infuser.
		if (playerIn.isSneaking())
		{
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
                		worldIn.setBlockState(blockpos, Blocks.DIAMOND_BLOCK.getDefaultState(), 11);
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
			return new ActionResult(EnumActionResult.FAIL, itemstack);
		}
	 }
}
