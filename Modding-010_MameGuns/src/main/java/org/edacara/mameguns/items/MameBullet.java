package org.edacara.mameguns.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.edacara.mameguns.projectiles.MameBulletProjectile;

public class MameBullet  extends Item {
    public MameBullet(Item.Properties p_40512_) {
        super(p_40512_);
    }

    public AbstractArrow createArrow(Level level, ItemStack itemStack, LivingEntity livingEntity) {
        MameBulletProjectile bullet = new MameBulletProjectile(level, livingEntity);
        return bullet;
    }

    public boolean isInfinite(ItemStack stack, ItemStack gun, net.minecraft.world.entity.player.Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper
                .getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, gun);
        return enchant <= 0 ? false : this.getClass() == MameBullet.class;
    }
}
