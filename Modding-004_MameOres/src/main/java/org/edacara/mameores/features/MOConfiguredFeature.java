package org.edacara.mameores.features;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.fml.common.Mod;
import org.edacara.mameores.MameOres;
import org.edacara.mameores.init.BlockInit;

import java.util.List;

@Mod.EventBusSubscriber
public class MOConfiguredFeature {
    public static List<OreConfiguration.TargetBlockState> TIN_ORE_TARGET_LIST;

    public static ConfiguredFeature<?,?> TIN_ORE_FEATURE;

    public static void registerConfiguredFeatures()
    {
        TIN_ORE_TARGET_LIST = List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.TIN_ORE.get().defaultBlockState()));

        TIN_ORE_FEATURE = Feature.ORE.configured(new OreConfiguration(TIN_ORE_TARGET_LIST, 9));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(MameOres.modid, "tin_ore"), TIN_ORE_FEATURE);

    }

}
