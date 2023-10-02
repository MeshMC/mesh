package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.raider;

import net.meshmc.mesh.api.entity.living.mob.hostile.raider.EntityEvoker;

public class EntityEvokerMesh<T extends net.minecraft.entity.monster.EntityEvoker> extends EntityIllagerSpellcasterMesh<T> implements EntityEvoker {
    public EntityEvokerMesh(T value) {
        super(value);
    }
}
