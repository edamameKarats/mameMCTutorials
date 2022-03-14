package org.edacara.mameguns.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.edacara.mameguns.MameGuns;
import org.edacara.mameguns.items.MameBullet;
import org.edacara.mameguns.items.MameGun;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MameGuns.modid);
    public static final RegistryObject<MameGun> MAME_GUN = ITEMS.register("mame_gun", () ->
            new MameGun(new Item.Properties().durability(384).tab(MameGuns.mameguns)));
    public static final RegistryObject<MameBullet> MAME_BULLET = ITEMS.register("mame_bullet", () ->
            new MameBullet(new Item.Properties().tab(MameGuns.mameguns)));
}
