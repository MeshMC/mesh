package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.raider;

import net.meshmc.mesh.api.entity.living.mob.hostile.raider.EntityEvoker;
import net.minecraft.entity.mob.EvokerEntity;

public class EntityEvokerMesh<T extends EvokerEntity> extends EntityIllagerSpellcasterMesh<T> implements EntityEvoker {
    public EntityEvokerMesh(T value) {
        super(value);
    }
}
