package com.themastergeneral.magickassist.blocks;

import com.themastergeneral.magickassist.te.TERuneInfuser;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;

public class BlockRuneInfuser extends BlockTE<TERuneInfuser> 
{

	public BlockRuneInfuser(String name, String modid) {
		super(Material.ROCK, name, modid);
	}

	@Override
	public Class<TERuneInfuser> getTileEntityClass() {
		return null;
	}

	@Override
	public TERuneInfuser createTileEntity(World world, IBlockState state) {
		return null;
	}
	
}
