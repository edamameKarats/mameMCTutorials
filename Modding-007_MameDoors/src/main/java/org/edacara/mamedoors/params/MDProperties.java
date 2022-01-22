package org.edacara.mamedoors.params;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class MDProperties extends BlockStateProperties {
    public static final EnumProperty<Door1x2Param> DOOR_1X2_PARAM
            = EnumProperty.create("door_1x2_param", Door1x2Param.class);
}