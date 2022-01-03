package org.edacara.mametrees.features;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import org.edacara.mametrees.init.BlockInit;

public class MTConfiguredFeature {
    public static final ConfiguredFeature<TreeConfiguration, ?> SAKURA =
            Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, "sakura", Feature.TREE.configured(
                    (new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(Blocks.OAK_LOG),
                            new StraightTrunkPlacer(4, 2, 0),
                            BlockStateProvider.simple(BlockInit.SAKURA_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1))
                    ).ignoreVines().build()
            ));
}