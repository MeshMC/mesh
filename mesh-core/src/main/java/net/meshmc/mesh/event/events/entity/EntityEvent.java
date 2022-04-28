package net.meshmc.mesh.event.events.entity;

import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.entity.MoverType;
import net.meshmc.mesh.api.entity.living.player.EntityPlayer;
import net.meshmc.mesh.api.math.Box;
import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.event.MeshEvent;
import net.meshmc.mesh.util.entity.Stance;
import net.meshmc.mesh.util.math.Facing;

import static net.meshmc.mesh.event.events.entity.EntityEvent.Method.*;

/**
 * @author Makrennel 04/26/2022
 *
 * All fields except returnValue are marked as final - they will not be passed back
 * so modifying them will not change anything.
 */
public class EntityEvent extends MeshEvent {
    public enum Method {
        kill,
        discard,
        tick,
        baseTick,
        tickInVoid,
        move,
        checkBlockCollision,
        updateSwimming,
        spawnSprintingParticles,
        moveRelative,
        updatePositionAndAngles,
        onPlayerCollision,
        pushAwayFrom,
        tickRiding,
        updateRiderPosition,
        onRiderLookAround,
        startRidingEntity,
        removeRiders,
        dismountVehicle,
        addRider,
        removeRider,
        canAddRider,
        updateTrackedPositionAndAngles,
        getDefaultNetherPortalCooldown,
        handleStatus,
        performHurtAnimation,
        isOnFire,
        hasVehicle,
        hasRiders,
        isSneaking,
        setSneaking,
        getStance,
        setStance,
        isSprinting,
        setSprinting,
        isInvisible,
        isInvisibleTo,
        setInvisible,
        getFlag,
        setFlag,
        getAir,
        setAir,
        pushOutOfSolidBlock,
        isAttackable,
        handleAttack,
        copyPositionAndRotation,
        copyFrom,
        getSafeFallDistance,
        canAvoidTraps,
        doesRenderOnFire,
        isPushedByFluids,
        hasCustomNameTag,
        isCustomNameTagVisible,
        setCustomNameTagVisible,
        teleport,
        shouldRenderName,
        getHorizontalFacing,
        getMovementDirection,
        getRenderBoundingBox,
        isImmuneToExplosion,
        entityDataRequiresOperator,
        getControllingRider,
        hasRider,
        getLowestVehicle,
        getBurningDuration
    }

    public final int entityID;
    public final Method method;

    private EntityEvent(int entityID, Method method, Era era) {
        super("entity" + entityID + "_" + method.name(), era);
        this.entityID = entityID;
        this.method = method;
    }

    private static class Returnable<R> extends EntityEvent {
        public R returnValue;

        private Returnable(int entityID, Method method, Era era, R returnValue) {
            super(entityID, method, era);
            this.returnValue = returnValue;
        }
    }

    public static final class kill extends EntityEvent {
        public kill(int entityID, Era era) {
            super(entityID, kill, era);
        }
    }

    public static final class discard extends EntityEvent {
        public discard(int entityID, Era era) {
            super(entityID, discard, era);
        }
    }

    public static final class tick extends EntityEvent {
        public tick(int entityID, Era era) {
            super(entityID, tick, era);
        }
    }

    public static final class baseTick extends EntityEvent {
        public baseTick(int entityID, Era era) {
            super(entityID, baseTick, era);
        }
    }

    public static final class tickInVoid extends EntityEvent {
        public tickInVoid(int entityID, Era era) {
            super(entityID, tickInVoid, era);
        }
    }

    public static final class move extends EntityEvent {
        public final MoverType moverType;
        public final double x, y, z;

        public move(int entityID, Era era, MoverType moverType, double x, double y, double z) {
            super(entityID, move, era);
            this.moverType = moverType;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static final class checkBlockCollision extends EntityEvent {
        public checkBlockCollision(int entityID, Era era) {
            super(entityID, checkBlockCollision, era);
        }
    }

    public static final class updateSwimming extends EntityEvent {
        public updateSwimming(int entityID, Era era) {
            super(entityID, updateSwimming, era);
        }
    }

    public static final class spawnSprintingParticles extends EntityEvent {
        public spawnSprintingParticles(int entityID, Era era) {
            super(entityID, spawnSprintingParticles, era);
        }
    }

    public static final class moveRelative extends EntityEvent {
        public final float speed;
        public final Vec3d movementInput;

        public moveRelative(int entityID, Era era, float speed, Vec3d movementInput) {
            super(entityID, moveRelative, era);
            this.speed = speed;
            this.movementInput = movementInput;
        }
    }

    public static final class updatePositionAndAngles extends EntityEvent {
        public final double x, y, z;
        public final float yaw, pitch;

        public updatePositionAndAngles(int entityID, Era era, double x, double y, double z, float yaw, float pitch) {
            super(entityID, updatePositionAndAngles, era);
            this.x = x;
            this.y = y;
            this.z = z;
            this.yaw = yaw;
            this.pitch = pitch;
        }
    }

    public static final class onPlayerCollision extends EntityEvent {
        public final EntityPlayer player;

        public onPlayerCollision(int entityID, Era era, EntityPlayer player) {
            super(entityID, onPlayerCollision, era);
            this.player = player;
        }
    }

    public static final class pushAwayFrom extends EntityEvent {
        public final Entity entity;

        public pushAwayFrom(int entityID, Era era, Entity entity) {
            super(entityID, pushAwayFrom, era);
            this.entity = entity;
        }
    }

    public static final class tickRiding extends EntityEvent {
        public tickRiding(int entityID, Era era) {
            super(entityID, tickRiding, era);
        }
    }

    public static final class updateRiderPosition extends EntityEvent {
        public final Entity entity;

        public updateRiderPosition(int entityID, Era era, Entity entity) {
            super(entityID, updateRiderPosition, era);
            this.entity = entity;
        }
    }

    public static final class onRiderLookAround extends EntityEvent {
        public final Entity entity;

        public onRiderLookAround(int entityID, Era era, Entity entity) {
            super(entityID, onRiderLookAround, era);
            this.entity = entity;
        }
    }

    public static final class startRidingEntity extends Returnable<Boolean> {
        public final Entity entity;
        public final boolean force;

        public startRidingEntity(int entityID, Era era, Boolean returnValue, Entity entity, boolean force) {
            super(entityID, startRidingEntity, era, returnValue);
            this.entity = entity;
            this.force = force;
        }
    }

    public static final class removeRiders extends EntityEvent {
        public removeRiders(int entityID, Era era) {
            super(entityID, removeRiders, era);
        }
    }

    public static final class dismountVehicle extends EntityEvent {
        public dismountVehicle(int entityID, Era era) {
            super(entityID, dismountVehicle, era);
        }
    }

    public static final class addRider extends EntityEvent {
        public final Entity entity;

        public addRider(int entityID, Era era, Entity entity) {
            super(entityID, addRider, era);
            this.entity = entity;
        }
    }

    public static final class removeRider extends EntityEvent {
        public final Entity entity;

        public removeRider(int entityID, Era era, Entity entity) {
            super(entityID, removeRider, era);
            this.entity = entity;
        }
    }

    public static final class canAddRider extends Returnable<Boolean> {
        public final Entity entity;

        public canAddRider(int entityID, Era era, Boolean returnValue, Entity entity) {
            super(entityID, canAddRider, era, returnValue);
            this.entity = entity;
        }
    }

    public static final class updateTrackedPositionAndAngles extends EntityEvent {
        public final double x, y, z;
        public final float yaw, pitch;
        public final int interpolationSteps;
        public final boolean interpolate;

        public updateTrackedPositionAndAngles(int entityID, Era era, double x, double y, double z, float yaw, float pitch, int interpolationSteps, boolean interpolate) {
            super(entityID, updateTrackedPositionAndAngles, era);
            this.x = x;
            this.y = y;
            this.z = z;
            this.yaw = yaw;
            this.pitch = pitch;
            this.interpolationSteps = interpolationSteps;
            this.interpolate = interpolate;
        }
    }

    public static final class getDefaultNetherPortalCooldown extends Returnable<Integer> {
        public getDefaultNetherPortalCooldown(int entityID, Era era, Integer returnValue) {
            super(entityID, getDefaultNetherPortalCooldown, era, returnValue);
        }
    }

    public static final class handleStatus extends EntityEvent {
        public final byte status;

        public handleStatus(int entityID, Era era, byte status) {
            super(entityID, handleStatus, era);
            this.status = status;
        }
    }

    public static final class performHurtAnimation extends EntityEvent {
        public performHurtAnimation(int entityID, Era era) {
            super(entityID, performHurtAnimation, era);
        }
    }

    public static final class isOnFire extends Returnable<Boolean> {
        public isOnFire(int entityID, Era era, Boolean returnValue) {
            super(entityID, isOnFire, era, returnValue);
        }
    }

    public static final class hasVehicle extends Returnable<Boolean> {
        public hasVehicle(int entityID, Era era, Boolean returnValue) {
            super(entityID, hasVehicle, era, returnValue);
        }
    }

    public static final class hasRiders extends Returnable<Boolean> {
        public hasRiders(int entityID, Era era, Boolean returnValue) {
            super(entityID, hasRiders, era, returnValue);
        }
    }

    public static final class isSneaking extends Returnable<Boolean> {
        public isSneaking(int entityID, Era era, Boolean returnValue) {
            super(entityID, isSneaking, era, returnValue);
        }
    }

    public static final class setSneaking extends EntityEvent {
        public final boolean sneaking;

        public setSneaking(int entityID, Era era, boolean sneaking) {
            super(entityID, setSneaking, era);
            this.sneaking = sneaking;
        }
    }

    public static final class getStance extends Returnable<Stance> {
        public getStance(int entityID, Era era, Stance returnValue) {
            super(entityID, getStance, era, returnValue);
        }
    }

    public static final class setStance extends EntityEvent {
        public final Stance stance;

        public setStance(int entityID, Era era, Stance stance) {
            super(entityID, setStance, era);
            this.stance = stance;
        }
    }

    public static final class isSprinting extends Returnable<Boolean> {
        public isSprinting(int entityID, Era era, Boolean returnValue) {
            super(entityID, isSprinting, era, returnValue);
        }
    }

    public static final class setSprinting extends EntityEvent {
        public final boolean sprinting;

        public setSprinting(int entityID, Era era, boolean sprinting) {
            super(entityID, setSprinting, era);
            this.sprinting = sprinting;
        }
    }

    public static final class isInvisible extends Returnable<Boolean> {
        public isInvisible(int entityID, Era era, Boolean returnValue) {
            super(entityID, isInvisible, era, returnValue);
        }
    }

    public static final class isInvisibleTo extends Returnable<Boolean> {
        public final EntityPlayer player;

        public isInvisibleTo(int entityID, Era era, Boolean returnValue, EntityPlayer player) {
            super(entityID, isInvisibleTo, era, returnValue);
            this.player = player;
        }
    }

    public static final class setInvisible extends EntityEvent {
        public final boolean invisible;

        public setInvisible(int entityID, Era era, boolean invisible) {
            super(entityID, setInvisible, era);
            this.invisible = invisible;
        }
    }

    public static final class getFlag extends Returnable<Boolean> {
        public final int index;

        public getFlag(int entityID, Era era, Boolean returnValue, int index) {
            super(entityID, getFlag, era, returnValue);
            this.index = index;
        }
    }

    public static final class setFlag extends EntityEvent {
        public final int index;
        public final boolean value;

        public setFlag(int entityID, Era era, int index, boolean value) {
            super(entityID, setFlag, era);
            this.index = index;
            this.value = value;
        }
    }

    public static final class getAir extends Returnable<Integer> {
        public getAir(int entityID, Era era, Integer returnValue) {
            super(entityID, getAir, era, returnValue);
        }
    }

    public static final class setAir extends EntityEvent {
        public final int air;

        public setAir(int entityID, Era era, int air) {
            super(entityID, setAir, era);
            this.air = air;
        }
    }

    public static final class pushOutOfSolidBlock extends EntityEvent {
        public final double x, y, z;

        public pushOutOfSolidBlock(int entityID, Era era, double x, double y, double z) {
            super(entityID, pushOutOfSolidBlock, era);
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static final class isAttackable extends Returnable<Boolean> {
        public isAttackable(int entityID, Era era, Boolean returnValue) {
            super(entityID, isAttackable, era, returnValue);
        }
    }

    public static final class handleAttack extends Returnable<Boolean> {
        public final Entity attacker;

        public handleAttack(int entityID, Era era, Boolean returnValue, Entity attacker) {
            super(entityID, handleAttack, era, returnValue);
            this.attacker = attacker;
        }
    }

    public static final class copyPositionAndRotation extends EntityEvent {
        public final Entity original;

        public copyPositionAndRotation(int entityID, Era era, Entity original) {
            super(entityID, copyPositionAndRotation, era);
            this.original = original;
        }
    }

    public static final class copyFrom extends EntityEvent {
        public final Entity original;

        public copyFrom(int entityID, Era era, Entity original) {
            super(entityID, copyFrom, era);
            this.original = original;
        }
    }

    public static final class getSafeFallDistance extends Returnable<Integer> {
        public getSafeFallDistance(int entityID, Era era, Integer returnValue) {
            super(entityID, getSafeFallDistance, era, returnValue);
        }
    }

    public static final class canAvoidTraps extends Returnable<Boolean> {
        public canAvoidTraps(int entityID, Era era, Boolean returnValue) {
            super(entityID, canAvoidTraps, era, returnValue);
        }
    }

    public static final class doesRenderOnFire extends Returnable<Boolean> {
        public doesRenderOnFire(int entityID, Era era, Boolean returnValue) {
            super(entityID, doesRenderOnFire, era, returnValue);
        }
    }

    public static final class isPushedByFluids extends Returnable<Boolean> {
        public isPushedByFluids(int entityID, Era era, Boolean returnValue) {
            super(entityID, isPushedByFluids, era, returnValue);
        }
    }

    public static final class hasCustomNameTag extends Returnable<Boolean> {
        public hasCustomNameTag(int entityID, Era era, Boolean returnValue) {
            super(entityID, hasCustomNameTag, era, returnValue);
        }
    }

    public static final class isCustomNameTagVisible extends Returnable<Boolean> {
        public isCustomNameTagVisible(int entityID, Era era, Boolean returnValue) {
            super(entityID, isCustomNameTagVisible, era, returnValue);
        }
    }

    public static final class setCustomNameTagVisible extends EntityEvent {
        public final boolean visible;

        public setCustomNameTagVisible(int entityID, Era era, boolean visible) {
            super(entityID, setCustomNameTagVisible, era);
            this.visible = visible;
        }
    }

    public static final class teleport extends EntityEvent {
        public final double x, y, z;

        public teleport(int entityID, Era era, double x, double y, double z) {
            super(entityID, teleport, era);
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static final class shouldRenderName extends Returnable<Boolean> {
        public shouldRenderName(int entityID, Era era, Boolean returnValue) {
            super(entityID, shouldRenderName, era, returnValue);
        }
    }

    public static final class getHorizontalFacing extends Returnable<Facing> {
        public getHorizontalFacing(int entityID, Era era, Facing returnValue) {
            super(entityID, getHorizontalFacing, era, returnValue);
        }
    }

    public static final class getMovementDirection extends Returnable<Facing> {
        public getMovementDirection(int entityID, Era era, Facing returnValue) {
            super(entityID, getMovementDirection, era, returnValue);
        }
    }

    public static final class getRenderBoundingBox extends Returnable<Box> {
        public getRenderBoundingBox(int entityID, Era era, Box returnValue) {
            super(entityID, getRenderBoundingBox, era, returnValue);
        }
    }

    public static final class isImmuneToExplosion extends Returnable<Boolean> {
        public isImmuneToExplosion(int entityID, Era era, Boolean returnValue) {
            super(entityID, isImmuneToExplosion, era, returnValue);
        }
    }

    public static final class entityDataRequiresOperator extends Returnable<Boolean> {
        public entityDataRequiresOperator(int entityID, Era era, Boolean returnValue) {
            super(entityID, entityDataRequiresOperator, era, returnValue);
        }
    }

    public static final class getControllingRider extends Returnable<Entity> {
        public getControllingRider(int entityID, Era era, Entity returnValue) {
            super(entityID, getControllingRider, era, returnValue);
        }
    }

    public static final class hasRider extends Returnable<Boolean> {
        public final Entity rider;

        public hasRider(int entityID, Era era, Boolean returnValue, Entity rider) {
            super(entityID, hasRider, era, returnValue);
            this.rider = rider;
        }
    }

    public static final class getLowestVehicle extends Returnable<Entity> {
        public getLowestVehicle(int entityID, Era era, Entity returnValue) {
            super(entityID, getLowestVehicle, era, returnValue);
        }
    }

    public static final class getBurningDuration extends Returnable<Integer> {
        public getBurningDuration(int entityID, Era era, Integer returnValue) {
            super(entityID, getBurningDuration, era, returnValue);
        }
    }
}
