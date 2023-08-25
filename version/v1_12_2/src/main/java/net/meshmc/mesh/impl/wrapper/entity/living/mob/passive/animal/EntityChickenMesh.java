package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.EntityChicken;

public class EntityChickenMesh<T extends net.minecraft.entity.passive.EntityChicken> extends EntityAnimalMesh<T> implements EntityChicken {
    public EntityChickenMesh(T value) {
        super(value);
    }
}
