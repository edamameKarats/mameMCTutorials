package org.edacara.mamedoors.blocks.be;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.edacara.mamedoors.init.BEInit;

public class Door1x2BE  extends BlockEntity {

    public int ticks;
    public int direction;
    public boolean moving;

    public Door1x2BE(BlockPos pos, BlockState state) {
        super(BEInit.DOOR_1X2_BE.get(), pos, state);
        ticks=0;
        direction=0;
        moving=false;
    }

    public void tickClient(){
        if(moving){
            if(direction==0){
                ticks=ticks+10;
                if(ticks==90){
                    direction=1;
                    moving=false;
                }
            }else{
                ticks=ticks-10;
                if (ticks==0){
                    direction=0;
                    moving=false;
                }
            }
        }
    }

    public void tickServer() {
        setChanged();
    }


}