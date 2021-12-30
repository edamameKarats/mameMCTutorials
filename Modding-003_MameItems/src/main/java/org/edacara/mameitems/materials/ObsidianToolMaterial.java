package org.edacara.mameitems.materials;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

public class ObsidianToolMaterial  implements Tier {
    private static int miningLevel = 3;
    private static int durability = 1561;
    private static double miningSpeed = 8.0F;
    private static double attackDamage = 3.0F;
    private static int enchantability = 10;

    @Override
    public int getUses()
    {
        return durability;
    }

    @Override
    public float getSpeed()
    {
        return (float) miningSpeed;
    }

    @Override
    public float getAttackDamageBonus()
    {
        return (float) attackDamage;
    }

    @Override
    public int getLevel()
    {
        return miningLevel;
    }

    @Override
    public int getEnchantmentValue()
    {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.of(Tags.Items.OBSIDIAN);
    }
}
