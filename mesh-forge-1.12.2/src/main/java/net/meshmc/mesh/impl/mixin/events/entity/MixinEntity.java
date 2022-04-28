package net.meshmc.mesh.impl.mixin.events.entity;

import dev.tigr.simpleevents.EventManager;
import net.meshmc.mesh.Mesh;
import net.meshmc.mesh.api.entity.living.player.EntityPlayer;
import net.meshmc.mesh.api.math.Box;
import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.event.events.entity.EntityEvent;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.meshmc.mesh.event.MeshEvent.Era.AFTER;
import static net.meshmc.mesh.event.MeshEvent.Era.BEFORE;

@Mixin(Entity.class)
public class MixinEntity {
    @Shadow private int entityId;
    
    EventManager EVENT_MANAGER = Mesh.getMesh().getEventManager();

    @Inject(method = "onKillCommand", at = @At("HEAD"), cancellable = true)
    public void beforeKill(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.kill(entityId, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "onKillCommand", at = @At("RETURN"))
    public void afterKill(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.kill(entityId, AFTER));
    }

    @Inject(method = "setDead", at = @At("HEAD"), cancellable = true)
    public void beforeDiscard(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.discard(entityId, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "setDead", at = @At("RETURN"))
    public void afterDiscard(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.discard(entityId, AFTER));
    }

    @Inject(method = "onUpdate", at = @At("HEAD"), cancellable = true)
    public void beforeTick(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.tick(entityId, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "onUpdate", at = @At("RETURN"))
    public void afterTick(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.tick(entityId, AFTER));
    }

    @Inject(method = "onEntityUpdate", at = @At("HEAD"), cancellable = true)
    public void beforeBaseTick(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.baseTick(entityId, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "onEntityUpdate", at = @At("RETURN"))
    public void afterBaseTick(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.baseTick(entityId, AFTER));
    }

    @Inject(method = "outOfWorld", at = @At("HEAD"), cancellable = true)
    public void beforeTickInVoid(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.tickInVoid(entityId, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "outOfWorld", at = @At("RETURN"))
    public void afterTickInVoid(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.tickInVoid(entityId, AFTER));
    }

    @Inject(method = "move", at = @At("HEAD"), cancellable = true)
    public void beforeMove(MoverType moverType, double x, double y, double z, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.move(entityId, BEFORE, MeshEnum.moverType(moverType), x, y, z)).isCancelled()) ci.cancel();
    }
    @Inject(method = "move", at = @At("RETURN"))
    public void afterMove(MoverType moverType, double x, double y, double z, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.move(entityId, AFTER, MeshEnum.moverType(moverType), x, y, z));
    }

    @Inject(method = "doBlockCollisions", at = @At("HEAD"), cancellable = true)
    public void beforeCheckBlockCollision(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.checkBlockCollision(entityId, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "doBlockCollisions", at = @At("RETURN"))
    public void afterCheckBlockCollision(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.checkBlockCollision(entityId, AFTER));
    }

    @Inject(method = "spawnRunningParticles", at = @At("HEAD"), cancellable = true)
    public void beforeSpawnSprintingParticles(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.spawnSprintingParticles(entityId, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "spawnRunningParticles", at = @At("RETURN"))
    public void afterSpawnSprintingParticles(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.spawnSprintingParticles(entityId, AFTER));
    }

    @Inject(method = "moveRelative", at = @At("HEAD"), cancellable = true)
    public void beforeMoveRelative(float strafe, float up, float forward, float friction, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.moveRelative(entityId, BEFORE, strafe, Vec3d.create(up, forward, friction))).isCancelled()) ci.cancel();
    }
    @Inject(method = "moveRelative", at = @At("RETURN"))
    public void afterMoveRelative(float strafe, float up, float forward, float friction, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.moveRelative(entityId, AFTER, strafe, Vec3d.create(up, forward, friction)));
    }

    @Inject(method = "setPositionAndRotation", at = @At("HEAD"), cancellable = true)
    public void beforeUpdatePositionAndAngles(double x, double y, double z, float yaw, float pitch, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.updatePositionAndAngles(entityId, BEFORE, x, y, z, yaw, pitch)).isCancelled()) ci.cancel();
    }
    @Inject(method = "setPositionAndRotation", at = @At("RETURN"))
    public void afterUpdatePositionAndAngles(double x, double y, double z, float yaw, float pitch, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.updatePositionAndAngles(entityId, AFTER, x, y, z, yaw, pitch));
    }

    @Inject(method = "onCollideWithPlayer", at = @At("HEAD"), cancellable = true)
    public void beforePlayerCollision(net.minecraft.entity.player.EntityPlayer player, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.onPlayerCollision(entityId, BEFORE, (EntityPlayer) player)).isCancelled()) ci.cancel();
    }
    @Inject(method = "onCollideWithPlayer", at = @At("RETURN"))
    public void afterPlayerCollision(net.minecraft.entity.player.EntityPlayer player, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.onPlayerCollision(entityId, BEFORE, (EntityPlayer) player));
    }

    @Inject(method = "applyEntityCollision", at = @At("HEAD"), cancellable = true)
    public void beforePushAwayFrom(Entity entity, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.pushAwayFrom(entityId, BEFORE, (net.meshmc.mesh.api.entity.Entity) entity)).isCancelled()) ci.cancel();
    }
    @Inject(method = "applyEntityCollision", at = @At("RETURN"))
    public void afterPushAwayFrom(Entity entity, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.pushAwayFrom(entityId, AFTER, (net.meshmc.mesh.api.entity.Entity) entity));
    }

    @Inject(method = "updateRidden", at = @At("HEAD"), cancellable = true)
    public void beforeTickRiding(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.tickRiding(entityId, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "updateRidden", at = @At("RETURN"))
    public void afterTickRiding(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.tickRiding(entityId, AFTER));
    }

    @Inject(method = "updatePassenger", at = @At("HEAD"), cancellable = true)
    public void beforeUpdateRiderPosition(Entity passenger, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.updateRiderPosition(entityId, BEFORE, (net.meshmc.mesh.api.entity.Entity) passenger)).isCancelled()) ci.cancel();
    }
    @Inject(method = "updatePassenger", at = @At("RETURN"))
    public void afterUpdateRiderPosition(Entity passenger, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.updateRiderPosition(entityId, AFTER, (net.meshmc.mesh.api.entity.Entity) passenger));
    }

    @Inject(method = "applyOrientationToEntity", at = @At("HEAD"), cancellable = true)
    public void beforeRiderLookAround(Entity passenger, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.onRiderLookAround(entityId, BEFORE, (net.meshmc.mesh.api.entity.Entity) passenger)).isCancelled()) ci.cancel();
    }
    @Inject(method = "applyOrientationToEntity", at = @At("RETURN"))
    public void afterRiderLookAround(Entity passenger, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.onRiderLookAround(entityId, AFTER, (net.meshmc.mesh.api.entity.Entity) passenger));
    }

    @Inject(method = "startRiding(Lnet/minecraft/entity/Entity;Z)Z", at = @At("HEAD"), cancellable = true)
    public void beforeRiderLookAround(Entity entity, boolean force, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.startRidingEntity event = EVENT_MANAGER.post(new EntityEvent.startRidingEntity(entityId, BEFORE, cir.getReturnValue(), (net.meshmc.mesh.api.entity.Entity) entity, force));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "startRiding(Lnet/minecraft/entity/Entity;Z)Z", at = @At("RETURN"), cancellable = true)
    public void afterRiderLookAround(Entity entity, boolean force, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.startRidingEntity event = EVENT_MANAGER.post(new EntityEvent.startRidingEntity(entityId, AFTER, cir.getReturnValue(), (net.meshmc.mesh.api.entity.Entity) entity, force));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "removePassengers", at = @At("HEAD"), cancellable = true)
    public void beforeRemoveRiders(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.removeRiders(entityId, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "removePassengers", at = @At("RETURN"))
    public void afterRemoveRiders(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.removeRiders(entityId, AFTER));
    }

    @Inject(method = "dismountRidingEntity", at = @At("HEAD"), cancellable = true)
    public void beforeDismountVehicle(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.dismountVehicle(entityId, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "dismountRidingEntity", at = @At("RETURN"))
    public void afterDismountVehicle(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.dismountVehicle(entityId, AFTER));
    }

    @Inject(method = "addPassenger", at = @At("HEAD"), cancellable = true)
    public void beforeAddRider(Entity passenger, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.addRider(entityId, BEFORE, (net.meshmc.mesh.api.entity.Entity) passenger)).isCancelled()) ci.cancel();
    }
    @Inject(method = "addPassenger", at = @At("RETURN"))
    public void afterAddRider(Entity passenger, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.addRider(entityId, AFTER, (net.meshmc.mesh.api.entity.Entity) passenger));
    }

    @Inject(method = "removePassenger", at = @At("HEAD"), cancellable = true)
    public void beforeRemoveRider(Entity passenger, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.removeRider(entityId, BEFORE, (net.meshmc.mesh.api.entity.Entity) passenger)).isCancelled()) ci.cancel();
    }
    @Inject(method = "removePassenger", at = @At("RETURN"))
    public void afterRemoveRider(Entity passenger, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.removeRider(entityId, AFTER, (net.meshmc.mesh.api.entity.Entity) passenger));
    }

    @Inject(method = "canFitPassenger", at = @At("HEAD"), cancellable = true)
    public void beforeCanAddRider(Entity passenger, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.canAddRider event = EVENT_MANAGER.post(new EntityEvent.canAddRider(entityId, BEFORE, cir.getReturnValue(), (net.meshmc.mesh.api.entity.Entity) passenger));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "canFitPassenger", at = @At("RETURN"))
    public void afterCanAddRider(Entity passenger, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.canAddRider event = EVENT_MANAGER.post(new EntityEvent.canAddRider(entityId, AFTER, cir.getReturnValue(), (net.meshmc.mesh.api.entity.Entity) passenger));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "setPositionAndRotationDirect", at = @At("HEAD"), cancellable = true)
    public void beforeUpdateTrackedPositionAndAngles(double x, double y, double z, float yaw, float pitch, int interpolationSteps, boolean interpolate, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.updateTrackedPositionAndAngles(entityId, BEFORE, x, y, z, yaw, pitch, interpolationSteps, interpolate)).isCancelled()) ci.cancel();
    }
    @Inject(method = "setPositionAndRotationDirect", at = @At("RETURN"))
    public void afterUpdateTrackedPositionAndAngles(double x, double y, double z, float yaw, float pitch, int interpolationSteps, boolean interpolate, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.updateTrackedPositionAndAngles(entityId, AFTER, x, y, z, yaw, pitch, interpolationSteps, interpolate));
    }

    @Inject(method = "getPortalCooldown", at = @At("HEAD"), cancellable = true)
    public void beforeGetDefaultNetherPortalCooldown(CallbackInfoReturnable<Integer> cir) {
        EntityEvent.getDefaultNetherPortalCooldown event = EVENT_MANAGER.post(new EntityEvent.getDefaultNetherPortalCooldown(entityId, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getPortalCooldown", at = @At("RETURN"))
    public void afterGetDefaultNetherPortalCooldown(CallbackInfoReturnable<Integer> cir) {
        EntityEvent.getDefaultNetherPortalCooldown event = EVENT_MANAGER.post(new EntityEvent.getDefaultNetherPortalCooldown(entityId, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "handleStatusUpdate", at = @At("HEAD"), cancellable = true)
    public void beforeHandleStatus(byte status, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.handleStatus(entityId, BEFORE, status)).isCancelled()) ci.cancel();
    }
    @Inject(method = "handleStatusUpdate", at = @At("RETURN"))
    public void afterHandleStatus(byte status, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.handleStatus(entityId, AFTER, status));
    }

    @Inject(method = "performHurtAnimation", at = @At("HEAD"), cancellable = true)
    public void beforeHandleStatus(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.performHurtAnimation(entityId, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "performHurtAnimation", at = @At("RETURN"))
    public void afterPerformHurtAnimation(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.performHurtAnimation(entityId, AFTER));
    }

    @Inject(method = "isBurning", at = @At("HEAD"), cancellable = true)
    public void beforeIsOnFire(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isOnFire event = EVENT_MANAGER.post(new EntityEvent.isOnFire(entityId, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isBurning", at = @At("RETURN"), cancellable = true)
    public void afterIsOnFire(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isOnFire event = EVENT_MANAGER.post(new EntityEvent.isOnFire(entityId, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "isRiding", at = @At("HEAD"), cancellable = true)
    public void beforeHasVehicle(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasVehicle event = EVENT_MANAGER.post(new EntityEvent.hasVehicle(entityId, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isRiding", at = @At("RETURN"), cancellable = true)
    public void afterHasVehicle(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasVehicle event = EVENT_MANAGER.post(new EntityEvent.hasVehicle(entityId, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "isBeingRidden", at = @At("HEAD"), cancellable = true)
    public void beforeHasRiders(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasRiders event = EVENT_MANAGER.post(new EntityEvent.hasRiders(entityId, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isBeingRidden", at = @At("RETURN"), cancellable = true)
    public void afterHasPassengers(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasRiders event = EVENT_MANAGER.post(new EntityEvent.hasRiders(entityId, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "isSneaking", at = @At("HEAD"), cancellable = true)
    public void beforeIsSneaking(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isSneaking event = EVENT_MANAGER.post(new EntityEvent.isSneaking(entityId, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isSneaking", at = @At("RETURN"), cancellable = true)
    public void afterIsSneaking(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isSneaking event = EVENT_MANAGER.post(new EntityEvent.isSneaking(entityId, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "setSneaking", at = @At("HEAD"), cancellable = true)
    public void beforeSetSneaking(boolean sneaking, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.setSneaking(entityId, BEFORE, sneaking)).isCancelled()) ci.cancel();
    }
    @Inject(method = "setSneaking", at = @At("RETURN"))
    public void afterSetSneaking(boolean sneaking, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.setSneaking(entityId, AFTER, sneaking));
    }

    @Inject(method = "isSprinting", at = @At("HEAD"), cancellable = true)
    public void beforeIsSprinting(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isSprinting event = EVENT_MANAGER.post(new EntityEvent.isSprinting(entityId, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isSprinting", at = @At("RETURN"), cancellable = true)
    public void afterIsSprinting(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isSprinting event = EVENT_MANAGER.post(new EntityEvent.isSprinting(entityId, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "setSprinting", at = @At("HEAD"), cancellable = true)
    public void beforeSetSprinting(boolean sprinting, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.setSprinting(entityId, BEFORE, sprinting)).isCancelled()) ci.cancel();
    }
    @Inject(method = "setSprinting", at = @At("RETURN"))
    public void afterSetSprinting(boolean sprinting, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.setSprinting(entityId, AFTER, sprinting));
    }

    @Inject(method = "isInvisible", at = @At("HEAD"), cancellable = true)
    public void beforeIsInvisible(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isInvisible event = EVENT_MANAGER.post(new EntityEvent.isInvisible(entityId, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isInvisible", at = @At("RETURN"), cancellable = true)
    public void afterIsInvisible(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isInvisible event = EVENT_MANAGER.post(new EntityEvent.isInvisible(entityId, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "isInvisibleToPlayer", at = @At("HEAD"), cancellable = true)
    public void beforeIsInvisibleTo(net.minecraft.entity.player.EntityPlayer player, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isInvisibleTo event = EVENT_MANAGER.post(new EntityEvent.isInvisibleTo(entityId, BEFORE, cir.getReturnValue(), (EntityPlayer) player));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isInvisibleToPlayer", at = @At("RETURN"), cancellable = true)
    public void afterIsInvisibleTo(net.minecraft.entity.player.EntityPlayer player, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isInvisibleTo event = EVENT_MANAGER.post(new EntityEvent.isInvisibleTo(entityId, AFTER, cir.getReturnValue(), (EntityPlayer) player));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "setInvisible", at = @At("HEAD"), cancellable = true)
    public void beforeSetInvisible(boolean invisible, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.setInvisible(entityId, BEFORE, invisible)).isCancelled()) ci.cancel();
    }
    @Inject(method = "setInvisible", at = @At("RETURN"))
    public void afterSetInvisible(boolean invisible, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.setInvisible(entityId, AFTER, invisible));
    }

    @Inject(method = "getFlag", at = @At("HEAD"), cancellable = true)
    public void beforeGetFlag(int index, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.getFlag event = EVENT_MANAGER.post(new EntityEvent.getFlag(entityId, BEFORE, cir.getReturnValue(), index));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getFlag", at = @At("RETURN"), cancellable = true)
    public void afterGetFlag(int index, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.getFlag event = EVENT_MANAGER.post(new EntityEvent.getFlag(entityId, AFTER, cir.getReturnValue(), index));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "setFlag", at = @At("HEAD"), cancellable = true)
    public void beforeSetFlag(int index, boolean value, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.setFlag(entityId, BEFORE, index, value)).isCancelled()) ci.cancel();
    }
    @Inject(method = "setFlag", at = @At("RETURN"))
    public void afterSetFlag(int index, boolean value, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.setFlag(entityId, AFTER, index, value));
    }

    @Inject(method = "getAir", at = @At("HEAD"), cancellable = true)
    public void beforeGetAir(CallbackInfoReturnable<Integer> cir) {
        EntityEvent.getAir event = EVENT_MANAGER.post(new EntityEvent.getAir(entityId, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getAir", at = @At("RETURN"), cancellable = true)
    public void afterGetAir(CallbackInfoReturnable<Integer> cir) {
        EntityEvent.getAir event = EVENT_MANAGER.post(new EntityEvent.getAir(entityId, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "setAir", at = @At("HEAD"), cancellable = true)
    public void beforeSetAir(int air, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.setAir(entityId, BEFORE, air)).isCancelled()) ci.cancel();
    }
    @Inject(method = "setAir", at = @At("RETURN"))
    public void afterStAir(int air, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.setAir(entityId, AFTER, air));
    }

    @Inject(method = "pushOutOfBlocks", at = @At("HEAD"), cancellable = true)
    public void beforePushOutOfBlocks(double x, double y, double z, CallbackInfoReturnable<Boolean> cir) {
        if(EVENT_MANAGER.post(new EntityEvent.pushOutOfSolidBlock(entityId, BEFORE, x, y, z)).isCancelled()) {
            cir.setReturnValue(false);
            cir.cancel();
        }
    }
    @Inject(method = "pushOutOfBlocks", at = @At("RETURN"))
    public void afterPushOutOfBlocks(double x, double y, double z, CallbackInfoReturnable<Boolean> cir) {
        EVENT_MANAGER.post(new EntityEvent.pushOutOfSolidBlock(entityId, AFTER, x, y, z));
    }

    @Inject(method = "canBeAttackedWithItem", at = @At("HEAD"), cancellable = true)
    public void isAttackable1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isAttackable event = EVENT_MANAGER.post(new EntityEvent.isAttackable(entityId, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "canBeAttackedWithItem", at = @At("RETURN"), cancellable = true)
    public void isAttackable2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isAttackable event = EVENT_MANAGER.post(new EntityEvent.isAttackable(entityId, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "hitByEntity", at = @At("HEAD"), cancellable = true)
    public void handleAttack1(Entity attacker, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.handleAttack event = EVENT_MANAGER.post(new EntityEvent.handleAttack(entityId, BEFORE, cir.getReturnValue(), (net.meshmc.mesh.api.entity.Entity) attacker));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "hitByEntity", at = @At("RETURN"), cancellable = true)
    public void handleAttack2(Entity attacker, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.handleAttack event = EVENT_MANAGER.post(new EntityEvent.handleAttack(entityId, AFTER, cir.getReturnValue(), (net.meshmc.mesh.api.entity.Entity) attacker));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "copyLocationAndAnglesFrom", at = @At("HEAD"), cancellable = true)
    public void copyPositionAndRotation1(Entity entity, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.copyPositionAndRotation(entityId, BEFORE, (net.meshmc.mesh.api.entity.Entity) entity)).isCancelled()) ci.cancel();
    }
    @Inject(method = "copyLocationAndAnglesFrom", at = @At("RETURN"))
    public void copyPositionAndRotation2(Entity entity, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.copyPositionAndRotation(entityId, AFTER, (net.meshmc.mesh.api.entity.Entity) entity));
    }

    @Inject(method = "copyDataFromOld", at = @At("HEAD"), cancellable = true)
    public void copyFrom1(Entity original, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.copyFrom(entityId, BEFORE, (net.meshmc.mesh.api.entity.Entity) original)).isCancelled()) ci.cancel();
    }
    @Inject(method = "copyDataFromOld", at = @At("RETURN"))
    public void copyFrom2(Entity original, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.copyFrom(entityId, AFTER, (net.meshmc.mesh.api.entity.Entity) original));
    }

    @Inject(method = "getMaxFallHeight", at = @At("HEAD"), cancellable = true)
    public void getSafeFallDistance1(CallbackInfoReturnable<Integer> cir) {
        EntityEvent.getSafeFallDistance event = EVENT_MANAGER.post(new EntityEvent.getSafeFallDistance(entityId, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getMaxFallHeight", at = @At("RETURN"), cancellable = true)
    public void getSafeFallDistance2(CallbackInfoReturnable<Integer> cir) {
        EntityEvent.getSafeFallDistance event = EVENT_MANAGER.post(new EntityEvent.getSafeFallDistance(entityId, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "doesEntityNotTriggerPressurePlate", at = @At("HEAD"), cancellable = true)
    public void canAvoidTraps1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.canAvoidTraps event = EVENT_MANAGER.post(new EntityEvent.canAvoidTraps(entityId, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "doesEntityNotTriggerPressurePlate", at = @At("RETURN"), cancellable = true)
    public void canAvoidTraps2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.canAvoidTraps event = EVENT_MANAGER.post(new EntityEvent.canAvoidTraps(entityId, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "canRenderOnFire", at = @At("HEAD"), cancellable = true)
    public void doesRenderOnFire1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.doesRenderOnFire event = EVENT_MANAGER.post(new EntityEvent.doesRenderOnFire(entityId, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "canRenderOnFire", at = @At("RETURN"), cancellable = true)
    public void doesRenderOnFire2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.doesRenderOnFire event = EVENT_MANAGER.post(new EntityEvent.doesRenderOnFire(entityId, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "isPushedByWater", at = @At("HEAD"), cancellable = true)
    public void isPushedByFluids1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isPushedByFluids event = EVENT_MANAGER.post(new EntityEvent.isPushedByFluids(entityId, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isPushedByWater", at = @At("RETURN"), cancellable = true)
    public void isPushedByFluids2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isPushedByFluids event = EVENT_MANAGER.post(new EntityEvent.isPushedByFluids(entityId, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "hasCustomName", at = @At("HEAD"), cancellable = true)
    public void hasCustomNameTag1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasCustomNameTag event = EVENT_MANAGER.post(new EntityEvent.hasCustomNameTag(entityId, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "hasCustomName", at = @At("RETURN"), cancellable = true)
    public void hasCustomNameTag2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasCustomNameTag event = EVENT_MANAGER.post(new EntityEvent.hasCustomNameTag(entityId, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "getAlwaysRenderNameTag", at = @At("HEAD"), cancellable = true)
    public void isCustomNameTagVisible1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isCustomNameTagVisible event = EVENT_MANAGER.post(new EntityEvent.isCustomNameTagVisible(entityId, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getAlwaysRenderNameTag", at = @At("RETURN"), cancellable = true)
    public void isCustomNameTagVisible2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isCustomNameTagVisible event = EVENT_MANAGER.post(new EntityEvent.isCustomNameTagVisible(entityId, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "setAlwaysRenderNameTag", at = @At("HEAD"), cancellable = true)
    public void setCustomNameTagVisible1(boolean visible, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.setCustomNameTagVisible(entityId, BEFORE, visible)).isCancelled()) ci.cancel();
    }
    @Inject(method = "setAlwaysRenderNameTag", at = @At("RETURN"))
    public void setCustomNameTagVisible2(boolean visible, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.setCustomNameTagVisible(entityId, AFTER, visible));
    }

    @Inject(method = "setPositionAndUpdate", at = @At("HEAD"), cancellable = true)
    public void teleport1(double destX, double destY, double destZ, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.teleport(entityId, BEFORE, destX, destY, destZ)).isCancelled()) ci.cancel();
    }
    @Inject(method = "setPositionAndUpdate", at = @At("RETURN"))
    public void teleport2(double destX, double destY, double destZ, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.teleport(entityId, BEFORE, destX, destY, destZ));
    }

    @Inject(method = "getAlwaysRenderNameTagForRender", at = @At("HEAD"), cancellable = true)
    public void shouldRenderName1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.shouldRenderName event = EVENT_MANAGER.post(new EntityEvent.shouldRenderName(entityId, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getAlwaysRenderNameTagForRender", at = @At("RETURN"), cancellable = true)
    public void shouldRenderName2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.shouldRenderName event = EVENT_MANAGER.post(new EntityEvent.shouldRenderName(entityId, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "getHorizontalFacing", at = @At("HEAD"), cancellable = true)
    public void getHorizontalFacing1(CallbackInfoReturnable<EnumFacing> cir) {
        EntityEvent.getHorizontalFacing event = EVENT_MANAGER.post(new EntityEvent.getHorizontalFacing(entityId, BEFORE, null));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(MCEnum.facing(event.returnValue));
        cir.cancel();
    }
    @Inject(method = "getHorizontalFacing", at = @At("RETURN"), cancellable = true)
    public void getHorizontalFacing2(CallbackInfoReturnable<EnumFacing> cir) {
        EntityEvent.getHorizontalFacing event = EVENT_MANAGER.post(new EntityEvent.getHorizontalFacing(entityId, BEFORE, MeshEnum.facing(cir.getReturnValue())));
        if(!event.isCancelled()) return;

        cir.setReturnValue(MCEnum.facing(event.returnValue));
        cir.cancel();
    }

    @Inject(method = "getAdjustedHorizontalFacing", at = @At("HEAD"), cancellable = true)
    public void getMovementDirection1(CallbackInfoReturnable<EnumFacing> cir) {
        EntityEvent.getMovementDirection event = EVENT_MANAGER.post(new EntityEvent.getMovementDirection(entityId, BEFORE, null));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(MCEnum.facing(event.returnValue));
        cir.cancel();
    }
    @Inject(method = "getAdjustedHorizontalFacing", at = @At("RETURN"), cancellable = true)
    public void getMovementDirection2(CallbackInfoReturnable<EnumFacing> cir) {
        EntityEvent.getMovementDirection event = EVENT_MANAGER.post(new EntityEvent.getMovementDirection(entityId, BEFORE, MeshEnum.facing(cir.getReturnValue())));
        if(!event.isCancelled()) return;

        cir.setReturnValue(MCEnum.facing(event.returnValue));
        cir.cancel();
    }

    @Inject(method = "getRenderBoundingBox", at = @At("HEAD"), cancellable = true)
    public void getRenderBoundingBox1(CallbackInfoReturnable<AxisAlignedBB> cir) {
        EntityEvent.getRenderBoundingBox event = EVENT_MANAGER.post(new EntityEvent.getRenderBoundingBox(entityId, BEFORE, (Box) cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue((AxisAlignedBB) event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getRenderBoundingBox", at = @At("RETURN"), cancellable = true)
    public void getRenderBoundingBox2(CallbackInfoReturnable<AxisAlignedBB> cir) {
        EntityEvent.getRenderBoundingBox event = EVENT_MANAGER.post(new EntityEvent.getRenderBoundingBox(entityId, AFTER, (Box) cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue((AxisAlignedBB) event.returnValue);
        cir.cancel();
    }

    @Inject(method = "isImmuneToExplosions", at = @At("HEAD"), cancellable = true)
    public void isImmuneToExplosion1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isImmuneToExplosion event = EVENT_MANAGER.post(new EntityEvent.isImmuneToExplosion(entityId, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isImmuneToExplosions", at = @At("RETURN"), cancellable = true)
    public void isImmuneToExplosion2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isImmuneToExplosion event = EVENT_MANAGER.post(new EntityEvent.isImmuneToExplosion(entityId, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "ignoreItemEntityData", at = @At("HEAD"), cancellable = true)
    public void entityDataRequiresOperator1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.entityDataRequiresOperator event = EVENT_MANAGER.post(new EntityEvent.entityDataRequiresOperator(entityId, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "ignoreItemEntityData", at = @At("RETURN"), cancellable = true)
    public void entityDataRequiresOperator2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.entityDataRequiresOperator event = EVENT_MANAGER.post(new EntityEvent.entityDataRequiresOperator(entityId, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "getControllingPassenger", at = @At("HEAD"), cancellable = true)
    public void getControllingRider1(CallbackInfoReturnable<Entity> cir) {
        EntityEvent.getControllingRider event = EVENT_MANAGER.post(new EntityEvent.getControllingRider(entityId, BEFORE, (net.meshmc.mesh.api.entity.Entity) cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue((Entity) event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getControllingPassenger", at = @At("RETURN"), cancellable = true)
    public void getControllingRider2(CallbackInfoReturnable<Entity> cir) {
        EntityEvent.getControllingRider event = EVENT_MANAGER.post(new EntityEvent.getControllingRider(entityId, AFTER, (net.meshmc.mesh.api.entity.Entity) cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue((Entity) event.returnValue);
        cir.cancel();
    }

    @Inject(method = "isPassenger", at = @At("HEAD"), cancellable = true)
    public void hasRider1(Entity passenger, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasRider event = EVENT_MANAGER.post(new EntityEvent.hasRider(entityId, BEFORE, cir.getReturnValue(), (net.meshmc.mesh.api.entity.Entity) passenger));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isPassenger", at = @At("RETURN"), cancellable = true)
    public void hasRider2(Entity passenger, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasRider event = EVENT_MANAGER.post(new EntityEvent.hasRider(entityId, AFTER, cir.getReturnValue(), (net.meshmc.mesh.api.entity.Entity) passenger));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "getLowestRidingEntity", at = @At("HEAD"), cancellable = true)
    public void getLowestVehicle1(CallbackInfoReturnable<Entity> cir) {
        EntityEvent.getLowestVehicle event = EVENT_MANAGER.post(new EntityEvent.getLowestVehicle(entityId, BEFORE, (net.meshmc.mesh.api.entity.Entity) cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue((Entity) event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getLowestRidingEntity", at = @At("RETURN"), cancellable = true)
    public void getLowestVehicle2(CallbackInfoReturnable<Entity> cir) {
        EntityEvent.getLowestVehicle event = EVENT_MANAGER.post(new EntityEvent.getLowestVehicle(entityId, AFTER, (net.meshmc.mesh.api.entity.Entity) cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue((Entity) event.returnValue);
        cir.cancel();
    }

    @Inject(method = "getFireImmuneTicks", at = @At("HEAD"), cancellable = true)
    public void getBurningDuration1(CallbackInfoReturnable<Integer> cir) {
        EntityEvent.getBurningDuration event = EVENT_MANAGER.post(new EntityEvent.getBurningDuration(entityId, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getFireImmuneTicks", at = @At("RETURN"))
    public void getBurningDuration2(CallbackInfoReturnable<Integer> cir) {
        EntityEvent.getBurningDuration event = EVENT_MANAGER.post(new EntityEvent.getBurningDuration(entityId, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
}
