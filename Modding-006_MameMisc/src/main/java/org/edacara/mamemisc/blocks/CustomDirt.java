package org.edacara.mamemisc.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;

public class CustomDirt extends Block {
    public CustomDirt(){
        super(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT).strength(0.5F).sound(SoundType.GRASS));
    }
    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos,
                                 Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        System.out.println("This block is used.");
        System.out.println("Position is ["+blockPos.getX()+","+blockPos.getY()+","+blockPos.getZ()+"].");
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

}
