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

public class EnderStaffItem extends CraftingItemDamage {

	private Block containedBlock;
	public EnderStaffItem(String name, String modid, int damage)
	{
		super(name, modid, damage);
	}
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	 {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, false);
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
                	if (iblockstate == Blocks.COBBLESTONE.getDefaultState())
                	{
                		worldIn.setBlockState(blockpos, Blocks.END_STONE.getDefaultState(), 11);
                		itemstack.damageItem(1, playerIn);
                		return new ActionResult(EnumActionResult.PASS, itemstack);
                	}
                	if (iblockstate == Blocks.NETHERRACK.getDefaultState())
                	{
                		worldIn.setBlockState(blockpos, Blocks.END_STONE.getDefaultState(), 11);
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