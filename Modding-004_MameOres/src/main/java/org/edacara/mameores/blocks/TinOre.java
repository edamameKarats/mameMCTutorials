package org.edacara.mameores.blocks;

import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class TinOre  extends OreBlock
{
    public TinOre()
    {
        super(BlockBehaviour.Properties
                .of(Material.STONE, MaterialColor.METAL)
                .strength(3.0F, 3.0F)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL));
    }
}