package org.edacara.mametrees.growers;

import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import org.edacara.mametrees.features.MTConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class SakuraTreeGrower extends AbstractTreeGrower {
    @Nullable
    protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random p_60038_, boolean p_60039_) {
        return MTConfiguredFeature.SAKURA;
    }
}