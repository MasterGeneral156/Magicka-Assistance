package com.themastergeneral.magickassist.blocks;

import net.minecraft.block.material.Material;

import com.themastergeneral.ctdcore.block.RegisterBlock;
import com.themastergeneral.magickassist.MagickaAssist;

public class ModBlocks extends RegisterBlock 
{
	public static BlockRuneInfuser infuserRune;
	public static void init()
	{
		infuserRune=register(new BlockRuneInfuser("infuserrune", MagickaAssist.MODID));
	}
}
