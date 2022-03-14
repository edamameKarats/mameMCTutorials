package org.edacara.mameguns.init;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.edacara.mameguns.MameGuns;
import org.edacara.mameguns.projectiles.MameBulletProjectile;

import java.util.function.BiFunction;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, MameGuns.modid);
    public static final RegistryObject<EntityType<MameBulletProjectile>> MAME_BULLET
            = registerBasic("mame_bullet",MameBulletProjectile::new);

    private static <T extends Entity> RegistryObject<EntityType<T>>
                                        registerBasic(String id, BiFunction<EntityType<T>, Level, T> function)
    {
        EntityType<T> type = EntityType.Builder.of(function::apply, MobCategory.MISC).sized(0.25F, 0.25F)
                .setTrackingRange(100).setUpdateInterval(1).noSummon()
                .fireImmune().setShouldReceiveVelocityUpdates(true).build(id);
        return ENTITIES.register(id, () -> type);
    }

}
