package com.themastergeneral.magickassist.proxy;

import com.themastergeneral.magickassist.blocks.ModBlocks;
import com.themastergeneral.magickassist.items.ModItems;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent e) 
    {
		ModBlocks.init();
		ModItems.loaditems();
    }
    public void init(FMLInitializationEvent e) 
    {
    	
    }
    public void postInit(FMLPostInitializationEvent e) 
    {

    }
}
