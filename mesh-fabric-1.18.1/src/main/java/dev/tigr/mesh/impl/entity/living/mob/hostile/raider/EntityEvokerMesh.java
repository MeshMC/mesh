package dev.tigr.mesh.impl.entity.living.mob.hostile.raider;

import dev.tigr.mesh.api.entity.living.mob.hostile.raider.EntityEvoker;
import net.minecraft.entity.mob.EvokerEntity;

public class EntityEvokerMesh<T extends EvokerEntity> extends EntityIllagerSpellcasterMesh<T> implements EntityEvoker<T> {
    public EntityEvokerMesh(T value) {
        super(value);
    }
}
