package org.edacara.mametrees.blocks;

import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class MTLeaves  extends LeavesBlock {
    public MTLeaves(){
        super(Properties
                .of(Material.LEAVES)
                .strength(0.2F)
                .randomTicks()
                .sound(SoundType.GRASS)
                .noOcclusion()
        );
    }
}
