package org.edacara.mamedoors.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.edacara.mamedoors.init.BlockInit;
import org.edacara.mamedoors.params.Door1x2Param;
import org.edacara.mamedoors.params.MDProperties;

import javax.annotation.Nullable;

public class Door1x2 extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final BooleanProperty ISOPEN = BlockStateProperties.OPEN;
    public static final EnumProperty<Door1x2Param> PARAM = MDProperties.DOOR_1X2_PARAM;

    private static final VoxelShape V_NORTH = Block.box(0,0,0,16,16,1);
    private static final VoxelShape V_EAST = Block.box(15,0,0,16,16,16);
    private static final VoxelShape V_SOUTH = Block.box(0,0,15,16,16,16);
    private static final VoxelShape V_WEST = Block.box(0,0,0,1,16,16);

    public Door1x2(){
        this(Properties.of(Material.WOOD, MaterialColor.WOOD).strength(5.0f)
                .sound(SoundType.WOOD));
    }
    public Door1x2(Properties props) {
        super(props);
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter reader, BlockPos pos, CollisionContext context) {
        Direction direction = blockState.getValue(FACING);
        boolean isOpen=blockState.getValue(ISOPEN);
        if(isOpen){
            switch(direction) {
                case NORTH:
                    return V_WEST;
                case SOUTH:
                    return V_EAST;
                case EAST:
                    return V_NORTH;
                default:
                    return V_SOUTH;
            }
        }else{
            switch(direction) {
                case NORTH:
                    return V_NORTH;
                case SOUTH:
                    return V_SOUTH;
                case EAST:
                    return V_EAST;
                default:
                    return V_WEST;
            }
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Direction direction = blockPlaceContext.getClickedFace();
        Direction.Axis direction_axis = direction.getAxis();
        BlockState blockstate;
        if (direction_axis == Direction.Axis.Y) {
            blockstate = this.defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite())
                    .setValue(ISOPEN,false).setValue(PARAM,Door1x2Param.P_11);
        } else {
            blockstate = this.defaultBlockState().setValue(FACING, direction)
                    .setValue(ISOPEN,false).setValue(PARAM,Door1x2Param.P_11);
        }
        return blockstate;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING,ISOPEN,PARAM);
    }

    @SuppressWarnings("deprecation")
    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        if(!blockState.getValue(ISOPEN)) {
            level.playSound(null, blockPos, SoundEvents.WOODEN_DOOR_OPEN, SoundSource.BLOCKS, 2.0F, 1.0F);
        }else {
            level.playSound(null, blockPos, SoundEvents.WOODEN_DOOR_CLOSE, SoundSource.BLOCKS, 2.0F, 1.0F);
        }

        BlockPos[] posList=new BlockPos[2];
        BlockState[] stateList=new BlockState[2];
        posList[0]=blockPos;
        stateList[0]=blockState;
        if(blockState.getValue(PARAM)==Door1x2Param.P_11) {
            posList[1] = blockPos.above();
        }else {
            posList[1] = blockPos.below();
        }
        stateList[1]=level.getBlockState(posList[1]);

        for(int i=0;i<posList.length;i++){
            level.setBlock(posList[i], BlockInit.DOOR_1X2.get().defaultBlockState()
                    .setValue(FACING,stateList[i].getValue(FACING)).setValue(ISOPEN,!stateList[i].getValue(ISOPEN))
                    .setValue(PARAM,stateList[i].getValue(PARAM)), 3);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, @Nullable LivingEntity placerEntity, ItemStack itemStack) {
        if(blockState.getValue(PARAM)==Door1x2Param.P_11){
            level.setBlock(blockPos.above(),BlockInit.DOOR_1X2.get().defaultBlockState()
                    .setValue(FACING,blockState.getValue(FACING)).setValue(ISOPEN,false)
                    .setValue(PARAM,Door1x2Param.P_12),3);
        }
    }
    @Override
    public void playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        super.playerWillDestroy(level, blockPos, blockState, player);
        if(blockState.getValue(PARAM)==Door1x2Param.P_11){
            level.setBlock(blockPos.above(), Blocks.AIR.defaultBlockState(), 35);
        }else{
            level.setBlock(blockPos.below(), Blocks.AIR.defaultBlockState(), 35);
        }
    }

}


