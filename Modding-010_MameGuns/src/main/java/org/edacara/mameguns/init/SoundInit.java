package org.edacara.mameguns.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.edacara.mameguns.MameGuns;

public class SoundInit {
    public static final DeferredRegister<SoundEvent> SOUNDS
            = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MameGuns.modid);
    public static final RegistryObject<SoundEvent> FIRE
            = SOUNDS.register("item.fire", () ->
                    new SoundEvent(new ResourceLocation(MameGuns.modid, "item.fire")));
}
