package org.edacara.mamerecipes;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod("mamerecipes")
public class MameRecipes {
    public MameRecipes(){
        MinecraftForge.EVENT_BUS.register(this);
    }
}
