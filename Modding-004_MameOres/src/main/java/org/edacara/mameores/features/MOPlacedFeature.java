package org.edacara.mameores.features;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.edacara.mameores.MameOres;

import java.util.List;

@Mod.EventBusSubscriber
public class MOPlacedFeature {
    public static PlacedFeature TIN_ORE_OVERWORLD;

    public static void registerPlacedFeatures()
    {
        TIN_ORE_OVERWORLD = MOConfiguredFeature.TIN_ORE_FEATURE
                .placed(commonOrePlacement(25,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(40),
                                VerticalAnchor.absolute(200))));

        Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(MameOres.modid, "tin_ore"), TIN_ORE_OVERWORLD);

    }

    @SubscribeEvent
    public static void registerBiomeModification(final BiomeLoadingEvent event)
    {
        event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(() -> TIN_ORE_OVERWORLD);
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_)
    {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_)
    {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_)
    {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

}
