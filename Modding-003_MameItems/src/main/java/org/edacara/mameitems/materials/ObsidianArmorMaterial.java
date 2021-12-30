package org.edacara.mameitems.materials;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import org.edacara.mameitems.MameItems;

public class ObsidianArmorMaterial  implements ArmorMaterial {
    private static int durabilityMultiplier = 33;
    private static int enchantability = 10;
    private static double toughness = 2.0;
    private static double knochback = 0;

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private static final int[] slotProtections = new int[]{1, 2, 3, 4};

    @Override
    public int getDurabilityForSlot(EquipmentSlot slot)
    {
        return HEALTH_PER_SLOT[slot.getIndex()] * durabilityMultiplier;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot)
    {
        return slotProtections[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue()
    {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return SoundEvents.ARMOR_EQUIP_DIAMOND;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.of(Tags.Items.OBSIDIAN);
    }

    @Override
    public String getName()
    {
        return MameItems.modid + ":" + "obsidian";
    }

    @Override
    public float getToughness()
    {
        return (float) toughness;
    }

    @Override
    public float getKnockbackResistance()
    {
        return (float) knochback;
    }

}
