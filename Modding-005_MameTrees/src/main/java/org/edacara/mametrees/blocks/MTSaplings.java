package org.edacara.mametrees.blocks;


import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;

public class MTSaplings extends SaplingBlock {

    public MTSaplings(AbstractTreeGrower grower){
        this(grower, Properties.copy(Blocks.OAK_SAPLING));
    }

    public MTSaplings(AbstractTreeGrower grower, Properties properties){
        super(grower, properties);
    }
}
