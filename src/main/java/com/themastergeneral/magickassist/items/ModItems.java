package com.themastergeneral.magickassist.items;

import com.themastergeneral.ctdcore.item.RegisterItem;
import com.themastergeneral.magickassist.MagickaAssist;

public class ModItems extends RegisterItem 
{
	public static BasicItem gemmined;
	
	public static GlowingItem gemmagic;
	
	public static ItemRunes rune;
	
	public static ItemConjurersWand wand;
	
	public static FireStaffItem firestaff;
	public static EnderStaffItem enderstaff;
	public static RockStaffItem rockstaff;
	public static void loaditems()
	{
		gemmined = register(new BasicItem("gemmined",MagickaAssist.MODID));
		gemmagic = register(new GlowingItem("gemmagic",MagickaAssist.MODID));
		rune = register(new ItemRunes("rune", MagickaAssist.MODID));
		wand = register(new ItemConjurersWand("wand", MagickaAssist.MODID, 54));
		firestaff = register(new FireStaffItem("firestaff", MagickaAssist.MODID, 128));
		enderstaff = register(new EnderStaffItem("enderstaff", MagickaAssist.MODID, 128));
		rockstaff = register(new RockStaffItem("rockstaff", MagickaAssist.MODID, 128));
	}
}
