package com.themastergeneral.magickassist;

import com.themastergeneral.magickassist.client.CreativeTab;
import com.themastergeneral.magickassist.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MagickaAssist.MODID, name = MagickaAssist.MODNAME, version = MagickaAssist.VERSION, dependencies = MagickaAssist.DEPENDENCIES, acceptedMinecraftVersions = MagickaAssist.acceptedMinecraftVersions, updateJSON = MagickaAssist.updateJSON)
public class MagickaAssist 
{
	public static final String MODID = "magickaassist";
	public static final String MODNAME = "Magicka Assist";
	public static final String acceptedMinecraftVersions = "1.12";
	public static final String VERSION = acceptedMinecraftVersions + "-0.0.0.0";
	public static final String DEPENDENCIES = "required-after:ctdcore@[1.1.6,]";
	public static final String updateJSON = "https://raw.githubusercontent.com/MasterGeneral156/Version/master/MagickaAssist.json";
	
	public static final CreativeTab creativeTab = new CreativeTab();
	 
	@Instance
	public static MagickaAssist instance = new MagickaAssist();
	 
	@SidedProxy(clientSide="com.themastergeneral.magickassist.proxy.Client", serverSide="com.themastergeneral.magickassist.proxy.Server")
	public static CommonProxy proxy;
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) 
	{
		proxy.preInit(e);
	}
	@EventHandler
	public void init(FMLInitializationEvent e) 
	{
		proxy.init(e);
	}
	    
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) 
	{
		proxy.postInit(e);
	}
}
