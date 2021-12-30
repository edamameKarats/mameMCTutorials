package org.edacara.mameitems.init;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.edacara.mameitems.MameItems;
import org.edacara.mameitems.materials.ObsidianArmorMaterial;
import org.edacara.mameitems.materials.ObsidianToolMaterial;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MameItems.modid);

    public static final Tier OBSIDIAN_TOOL_MATERIAL = new ObsidianToolMaterial();

    public static final ArmorMaterial OBSIDIAN_ARMOR_MATERIAL = new ObsidianArmorMaterial();


    public static final RegistryObject<Item> OBSIDIAN_SWORD = ITEMS.register("obsidian_sword", () ->
            new SwordItem(OBSIDIAN_TOOL_MATERIAL, 5, -2.4f,new Item.Properties().tab(MameItems.mameitems)));
    public static final RegistryObject<Item> OBSIDIAN_PICKAXE = ITEMS.register("obsidian_pickaxe", () ->
            new PickaxeItem(OBSIDIAN_TOOL_MATERIAL,  3, -2.8f, new Item.Properties().tab(MameItems.mameitems)));
    public static final RegistryObject<Item> OBSIDIAN_AXE = ITEMS.register("obsidian_axe", () ->
            new AxeItem(OBSIDIAN_TOOL_MATERIAL, 7, -3.0f, new Item.Properties().tab(MameItems.mameitems)));
    public static final RegistryObject<Item> OBSIDIAN_SHOVEL = ITEMS.register("obsidian_shovel", () ->
            new ShovelItem(OBSIDIAN_TOOL_MATERIAL, 3, -3.0f, new Item.Properties().tab(MameItems.mameitems)));
    public static final RegistryObject<Item> OBSIDIAN_HOE = ITEMS.register("obsidian_hoe", () ->
            new HoeItem(OBSIDIAN_TOOL_MATERIAL, -2, -1.5f, new Item.Properties().tab(MameItems.mameitems)));

    public static final RegistryObject<Item> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet", () ->
            new ArmorItem(OBSIDIAN_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(MameItems.mameitems)));
    public static final RegistryObject<Item> OBSIDIAN_CHESTPLATE = ITEMS.register("obsidian_chestplate", () ->
            new ArmorItem(OBSIDIAN_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(MameItems.mameitems)));
    public static final RegistryObject<Item> OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings", () ->
            new ArmorItem(OBSIDIAN_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(MameItems.mameitems)));
    public static final RegistryObject<Item> OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots", () ->
            new ArmorItem(OBSIDIAN_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(MameItems.mameitems)));


}
