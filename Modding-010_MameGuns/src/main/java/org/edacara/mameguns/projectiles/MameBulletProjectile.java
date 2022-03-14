package org.edacara.mameguns.projectiles;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.edacara.mameguns.init.EntityInit;


public class MameBulletProjectile extends AbstractArrow {
    private int life;

    public MameBulletProjectile(EntityType<? extends MameBulletProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public MameBulletProjectile(Level level, LivingEntity livingEntity) {
        super(EntityInit.MAME_BULLET.get(), livingEntity, level);
    }

    protected ItemStack getPickupItem() {
        return new ItemStack(Items.AIR);
    }

    protected void tickDespawn() {
        ++this.life;
        if (this.life >= 10) {
            this.discard();
        }
    }
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return null;
    }
}
