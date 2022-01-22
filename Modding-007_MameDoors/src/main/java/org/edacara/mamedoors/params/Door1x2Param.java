package org.edacara.mamedoors.params;

import net.minecraft.util.StringRepresentable;

public enum Door1x2Param implements StringRepresentable {
    P_11,
    P_12;

    public String toString() { return this.getSerializedName(); }

    public String getSerializedName() { return this.name().toLowerCase(); }

}