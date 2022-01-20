package dev.tigr.mesh.impl.entity.living.mob.hostile.raider;

import dev.tigr.mesh.api.entity.living.mob.hostile.raider.EntityEvoker;

public class EntityEvokerMesh<T extends net.minecraft.entity.monster.EntityEvoker> extends EntityIllagerSpellcasterMesh<T> implements EntityEvoker<T> {
    public EntityEvokerMesh(T value) {
        super(value);
    }
}
