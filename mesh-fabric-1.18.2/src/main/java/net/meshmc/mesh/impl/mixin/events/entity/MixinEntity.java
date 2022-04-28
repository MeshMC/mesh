package net.meshmc.mesh.impl.mixin.events.entity;

import dev.tigr.simpleevents.EventManager;
import net.meshmc.mesh.Mesh;
import net.meshmc.mesh.api.entity.living.player.EntityPlayer;
import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.event.events.entity.EntityEvent;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
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
    @Shadow private int id;

    EventManager EVENT_MANAGER = Mesh.getMesh().getEventManager();

    @Inject(method = "kill", at = @At("HEAD"), cancellable = true)
    public void beforeKill(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.kill(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "kill", at = @At("RETURN"))
    public void afterKill(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.kill(id, AFTER));
    }

    @Inject(method = "discard", at = @At("HEAD"), cancellable = true)
    public void beforeDiscard(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.discard(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "discard", at = @At("RETURN"))
    public void afterDiscard(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.discard(id, AFTER));
    }

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    public void beforeTick(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.tick(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "tick", at = @At("RETURN"))
    public void afterTick(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.tick(id, AFTER));
    }

    @Inject(method = "baseTick", at = @At("HEAD"), cancellable = true)
    public void beforeBaseTick(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.baseTick(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "baseTick", at = @At("RETURN"))
    public void afterBaseTick(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.baseTick(id, AFTER));
    }

    @Inject(method = "tickInVoid", at = @At("HEAD"), cancellable = true)
    public void beforeTickInVoid(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.tickInVoid(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "tickInVoid", at = @At("RETURN"))
    public void afterTickInVoid(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.tickInVoid(id, AFTER));
    }

    @Inject(method = "move", at = @At("HEAD"), cancellable = true)
    public void beforeMove(MovementType movementType, net.minecraft.util.math.Vec3d movement, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.move(id, BEFORE, MeshEnum.moverType(movementType), movement.getX(), movement.getY(), movement.getZ())).isCancelled()) ci.cancel();
    }
    @Inject(method = "move", at = @At("RETURN"))
    public void afterMove(MovementType movementType, net.minecraft.util.math.Vec3d movement, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.move(id, AFTER, MeshEnum.moverType(movementType), movement.getX(), movement.getY(), movement.getZ()));
    }

    @Inject(method = "checkBlockCollision", at = @At("HEAD"), cancellable = true)
    public void beforeCheckBlockCollision(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.checkBlockCollision(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "checkBlockCollision", at = @At("RETURN"))
    public void afterCheckBlockCollision(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.checkBlockCollision(id, AFTER));
    }

    @Inject(method = "updateSwimming", at = @At("HEAD"), cancellable = true)
    public void beforeUpdateSwimming(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.updateSwimming(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "updateSwimming", at = @At("RETURN"))
    public void afterUpdateSwimming(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.updateSwimming(id, AFTER));
    }

    @Inject(method = "spawnSprintingParticles", at = @At("HEAD"), cancellable = true)
    public void beforeSpawnSprintingParticles(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.spawnSprintingParticles(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "spawnSprintingParticles", at = @At("RETURN"))
    public void afterSpawnSprintingParticles(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.spawnSprintingParticles(id, AFTER));
    }

    @Inject(method = "updateVelocity", at = @At("HEAD"), cancellable = true)
    public void beforeMoveRelative(float speed, net.minecraft.util.math.Vec3d movementInput, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.moveRelative(id, BEFORE, speed, (Vec3d) movementInput)).isCancelled()) ci.cancel();
    }
    @Inject(method = "updateVelocity", at = @At("RETURN"))
    public void afterMoveRelative(float speed, net.minecraft.util.math.Vec3d movementInput, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.moveRelative(id, AFTER, speed, (Vec3d) movementInput));
    }

    @Inject(method = "updatePositionAndAngles", at = @At("HEAD"), cancellable = true)
    public void beforeUpdatePositionAndAngles(double x, double y, double z, float yaw, float pitch, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.updatePositionAndAngles(id, BEFORE, x, y, z, yaw, pitch)).isCancelled()) ci.cancel();
    }
    @Inject(method = "updatePositionAndAngles", at = @At("RETURN"))
    public void afterUpdatePositionAndAngles(double x, double y, double z, float yaw, float pitch, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.updatePositionAndAngles(id, AFTER, x, y, z, yaw, pitch));
    }

    @Inject(method = "onPlayerCollision", at = @At("HEAD"), cancellable = true)
    public void beforePlayerCollision(PlayerEntity player, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.onPlayerCollision(id, BEFORE, (EntityPlayer) player)).isCancelled()) ci.cancel();
    }
    @Inject(method = "onPlayerCollision", at = @At("RETURN"))
    public void afterPlayerCollision(PlayerEntity player, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.onPlayerCollision(id, BEFORE, (EntityPlayer) player));
    }

    @Inject(method = "pushAwayFrom", at = @At("HEAD"), cancellable = true)
    public void beforePushAwayFrom(net.minecraft.entity.Entity entity, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.pushAwayFrom(id, BEFORE, (net.meshmc.mesh.api.entity.Entity) entity)).isCancelled()) ci.cancel();
    }
    @Inject(method = "pushAwayFrom", at = @At("RETURN"))
    public void afterPushAwayFrom(net.minecraft.entity.Entity entity, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.pushAwayFrom(id, AFTER, (net.meshmc.mesh.api.entity.Entity) entity));
    }

    @Inject(method = "tickRiding", at = @At("HEAD"), cancellable = true)
    public void beforeTickRiding(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.tickRiding(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "tickRiding", at = @At("RETURN"))
    public void afterTickRiding(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.tickRiding(id, AFTER));
    }

    @Inject(method = "updatePassengerPosition(Lnet/minecraft/entity/Entity;)V", at = @At("HEAD"), cancellable = true)
    public void beforeUpdateRiderPosition(net.minecraft.entity.Entity passenger, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.updateRiderPosition(id, BEFORE, (net.meshmc.mesh.api.entity.Entity) passenger)).isCancelled()) ci.cancel();
    }
    @Inject(method = "updatePassengerPosition(Lnet/minecraft/entity/Entity;)V", at = @At("RETURN"))
    public void afterUpdateRiderPosition(net.minecraft.entity.Entity passenger, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.updateRiderPosition(id, AFTER, (net.meshmc.mesh.api.entity.Entity) passenger));
    }

    @Inject(method = "onPassengerLookAround", at = @At("HEAD"), cancellable = true)
    public void beforeRiderLookAround(net.minecraft.entity.Entity passenger, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.onRiderLookAround(id, BEFORE, (net.meshmc.mesh.api.entity.Entity) passenger)).isCancelled()) ci.cancel();
    }
    @Inject(method = "onPassengerLookAround", at = @At("RETURN"))
    public void afterRiderLookAround(net.minecraft.entity.Entity passenger, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.onRiderLookAround(id, AFTER, (net.meshmc.mesh.api.entity.Entity) passenger));
    }

    @Inject(method = "startRiding(Lnet/minecraft/entity/Entity;Z)Z", at = @At("HEAD"), cancellable = true)
    public void beforeRiderLookAround(net.minecraft.entity.Entity entity, boolean force, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.startRidingEntity event = EVENT_MANAGER.post(new EntityEvent.startRidingEntity(id, BEFORE, cir.getReturnValue(), (net.meshmc.mesh.api.entity.Entity) entity, force));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "startRiding(Lnet/minecraft/entity/Entity;Z)Z", at = @At("RETURN"), cancellable = true)
    public void afterRiderLookAround(net.minecraft.entity.Entity entity, boolean force, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.startRidingEntity event = EVENT_MANAGER.post(new EntityEvent.startRidingEntity(id, AFTER, cir.getReturnValue(), (net.meshmc.mesh.api.entity.Entity) entity, force));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "removeAllPassengers", at = @At("HEAD"), cancellable = true)
    public void beforeRemoveRiders(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.removeRiders(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "removeAllPassengers", at = @At("RETURN"))
    public void afterRemoveRiders(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.removeRiders(id, AFTER));
    }

    @Inject(method = "dismountVehicle", at = @At("HEAD"), cancellable = true)
    public void beforeDismountVehicle(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.dismountVehicle(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "dismountVehicle", at = @At("RETURN"))
    public void afterDismountVehicle(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.dismountVehicle(id, AFTER));
    }

    @Inject(method = "addPassenger", at = @At("HEAD"), cancellable = true)
    public void beforeAddRider(net.minecraft.entity.Entity passenger, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.addRider(id, BEFORE, (net.meshmc.mesh.api.entity.Entity) passenger)).isCancelled()) ci.cancel();
    }
    @Inject(method = "addPassenger", at = @At("RETURN"))
    public void afterAddRider(net.minecraft.entity.Entity passenger, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.addRider(id, AFTER, (net.meshmc.mesh.api.entity.Entity) passenger));
    }

    @Inject(method = "removePassenger", at = @At("HEAD"), cancellable = true)
    public void beforeRemoveRider(net.minecraft.entity.Entity passenger, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.removeRider(id, BEFORE, (net.meshmc.mesh.api.entity.Entity) passenger)).isCancelled()) ci.cancel();
    }
    @Inject(method = "removePassenger", at = @At("RETURN"))
    public void afterRemoveRider(net.minecraft.entity.Entity passenger, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.removeRider(id, AFTER, (net.meshmc.mesh.api.entity.Entity) passenger));
    }

    @Inject(method = "canAddPassenger", at = @At("HEAD"), cancellable = true)
    public void beforeCanAddRider(net.minecraft.entity.Entity passenger, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.canAddRider event = EVENT_MANAGER.post(new EntityEvent.canAddRider(id, BEFORE, cir.getReturnValue(), (net.meshmc.mesh.api.entity.Entity) passenger));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "canAddPassenger", at = @At("RETURN"))
    public void afterCanAddRider(net.minecraft.entity.Entity passenger, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.canAddRider event = EVENT_MANAGER.post(new EntityEvent.canAddRider(id, AFTER, cir.getReturnValue(), (net.meshmc.mesh.api.entity.Entity) passenger));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "updateTrackedPositionAndAngles", at = @At("HEAD"), cancellable = true)
    public void beforeUpdateTrackedPositionAndAngles(double x, double y, double z, float yaw, float pitch, int interpolationSteps, boolean interpolate, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.updateTrackedPositionAndAngles(id, BEFORE, x, y, z, yaw, pitch, interpolationSteps, interpolate)).isCancelled()) ci.cancel();
    }
    @Inject(method = "updateTrackedPositionAndAngles", at = @At("RETURN"))
    public void afterUpdateTrackedPositionAndAngles(double x, double y, double z, float yaw, float pitch, int interpolationSteps, boolean interpolate, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.updateTrackedPositionAndAngles(id, AFTER, x, y, z, yaw, pitch, interpolationSteps, interpolate));
    }

    @Inject(method = "getDefaultNetherPortalCooldown", at = @At("HEAD"), cancellable = true)
    public void beforeGetDefaultNetherPortalCooldown(CallbackInfoReturnable<Integer> cir) {
        EntityEvent.getDefaultNetherPortalCooldown event = EVENT_MANAGER.post(new EntityEvent.getDefaultNetherPortalCooldown(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getDefaultNetherPortalCooldown", at = @At("RETURN"))
    public void afterGetDefaultNetherPortalCooldown(CallbackInfoReturnable<Integer> cir) {
        EntityEvent.getDefaultNetherPortalCooldown event = EVENT_MANAGER.post(new EntityEvent.getDefaultNetherPortalCooldown(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "handleStatus", at = @At("HEAD"), cancellable = true)
    public void beforeHandleStatus(byte status, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.handleStatus(id, BEFORE, status)).isCancelled()) ci.cancel();
    }
    @Inject(method = "handleStatus", at = @At("RETURN"))
    public void afterHandleStatus(byte status, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.handleStatus(id, AFTER, status));
    }

    @Inject(method = "animateDamage", at = @At("HEAD"), cancellable = true)
    public void beforeHandleStatus(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.performHurtAnimation(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "animateDamage", at = @At("RETURN"))
    public void afterPerformHurtAnimation(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.performHurtAnimation(id, AFTER));
    }

    @Inject(method = "isOnFire", at = @At("HEAD"), cancellable = true)
    public void beforeIsOnFire(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isOnFire event = EVENT_MANAGER.post(new EntityEvent.isOnFire(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isOnFire", at = @At("RETURN"), cancellable = true)
    public void afterIsOnFire(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isOnFire event = EVENT_MANAGER.post(new EntityEvent.isOnFire(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "hasVehicle", at = @At("HEAD"), cancellable = true)
    public void beforeHasVehicle(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasVehicle event = EVENT_MANAGER.post(new EntityEvent.hasVehicle(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "hasVehicle", at = @At("RETURN"), cancellable = true)
    public void afterHasVehicle(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasVehicle event = EVENT_MANAGER.post(new EntityEvent.hasVehicle(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "hasPassengers", at = @At("HEAD"), cancellable = true)
    public void beforeHasRiders(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasRiders event = EVENT_MANAGER.post(new EntityEvent.hasRiders(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "hasPassengers", at = @At("RETURN"), cancellable = true)
    public void afterHasPassengers(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasRiders event = EVENT_MANAGER.post(new EntityEvent.hasRiders(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "isSneaking", at = @At("HEAD"), cancellable = true)
    public void beforeIsSneaking(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isSneaking event = EVENT_MANAGER.post(new EntityEvent.isSneaking(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isSneaking", at = @At("RETURN"), cancellable = true)
    public void afterIsSneaking(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isSneaking event = EVENT_MANAGER.post(new EntityEvent.isSneaking(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "setSneaking", at = @At("HEAD"), cancellable = true)
    public void beforeSetSneaking(boolean sneaking, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.setSneaking(id, BEFORE, sneaking)).isCancelled()) ci.cancel();
    }
    @Inject(method = "setSneaking", at = @At("RETURN"))
    public void afterSetSneaking(boolean sneaking, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.setSneaking(id, AFTER, sneaking));
    }

    @Inject(method = "getPose", at = @At("HEAD"), cancellable = true)
    public void beforeGetPose(CallbackInfoReturnable<EntityPose> cir) {
        EntityEvent.getStance event = EVENT_MANAGER.post(new EntityEvent.getStance(id, BEFORE, null));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(MCEnum.stance(event.returnValue));
        cir.cancel();
    }
    @Inject(method = "getPose", at = @At("RETURN"), cancellable = true)
    public void afterGetPose(CallbackInfoReturnable<EntityPose> cir) {
        EntityEvent.getStance event = EVENT_MANAGER.post(new EntityEvent.getStance(id, AFTER, MeshEnum.stance(cir.getReturnValue())));
        if(!event.isCancelled()) return;

        cir.setReturnValue(MCEnum.stance(event.returnValue));
        cir.cancel();
    }

    @Inject(method = "setPose", at = @At("HEAD"), cancellable = true)
    public void beforeSetPose(EntityPose pose, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.setStance(id, BEFORE, MeshEnum.stance(pose))).isCancelled()) ci.cancel();
    }
    @Inject(method = "setPose", at = @At("RETURN"))
    public void afterSetPose(EntityPose pose, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.setStance(id, AFTER, MeshEnum.stance(pose)));
    }

    @Inject(method = "isSprinting", at = @At("HEAD"), cancellable = true)
    public void beforeIsSprinting(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isSprinting event = EVENT_MANAGER.post(new EntityEvent.isSprinting(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isSprinting", at = @At("RETURN"), cancellable = true)
    public void afterIsSprinting(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isSprinting event = EVENT_MANAGER.post(new EntityEvent.isSprinting(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "setSprinting", at = @At("HEAD"), cancellable = true)
    public void beforeSetSprinting(boolean sprinting, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.setSprinting(id, BEFORE, sprinting)).isCancelled()) ci.cancel();
    }
    @Inject(method = "setSprinting", at = @At("RETURN"))
    public void afterSetSprinting(boolean sprinting, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.setSprinting(id, AFTER, sprinting));
    }

    @Inject(method = "isInvisible", at = @At("HEAD"), cancellable = true)
    public void beforeIsInvisible(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isInvisible event = EVENT_MANAGER.post(new EntityEvent.isInvisible(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isInvisible", at = @At("RETURN"), cancellable = true)
    public void afterIsInvisible(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isInvisible event = EVENT_MANAGER.post(new EntityEvent.isInvisible(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "isInvisibleTo", at = @At("HEAD"), cancellable = true)
    public void beforeIsInvisibleTo(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isInvisibleTo event = EVENT_MANAGER.post(new EntityEvent.isInvisibleTo(id, BEFORE, cir.getReturnValue(), (EntityPlayer) player));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isInvisibleTo", at = @At("RETURN"), cancellable = true)
    public void afterIsInvisibleTo(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isInvisibleTo event = EVENT_MANAGER.post(new EntityEvent.isInvisibleTo(id, AFTER, cir.getReturnValue(), (EntityPlayer) player));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "setInvisible", at = @At("HEAD"), cancellable = true)
    public void beforeSetInvisible(boolean invisible, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.setInvisible(id, BEFORE, invisible)).isCancelled()) ci.cancel();
    }
    @Inject(method = "setInvisible", at = @At("RETURN"))
    public void afterSetInvisible(boolean invisible, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.setInvisible(id, AFTER, invisible));
    }

    @Inject(method = "getFlag", at = @At("HEAD"), cancellable = true)
    public void beforeGetFlag(int index, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.getFlag event = EVENT_MANAGER.post(new EntityEvent.getFlag(id, BEFORE, cir.getReturnValue(), index));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getFlag", at = @At("RETURN"), cancellable = true)
    public void afterGetFlag(int index, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.getFlag event = EVENT_MANAGER.post(new EntityEvent.getFlag(id, AFTER, cir.getReturnValue(), index));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "setFlag", at = @At("HEAD"), cancellable = true)
    public void beforeSetFlag(int index, boolean value, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.setFlag(id, BEFORE, index, value)).isCancelled()) ci.cancel();
    }
    @Inject(method = "setFlag", at = @At("RETURN"))
    public void afterSetFlag(int index, boolean value, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.setFlag(id, AFTER, index, value));
    }

    @Inject(method = "getAir", at = @At("HEAD"), cancellable = true)
    public void beforeGetAir(CallbackInfoReturnable<Integer> cir) {
        EntityEvent.getAir event = EVENT_MANAGER.post(new EntityEvent.getAir(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getAir", at = @At("RETURN"), cancellable = true)
    public void afterGetAir(CallbackInfoReturnable<Integer> cir) {
        EntityEvent.getAir event = EVENT_MANAGER.post(new EntityEvent.getAir(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "setAir", at = @At("HEAD"), cancellable = true)
    public void beforeSetAir(int air, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.setAir(id, BEFORE, air)).isCancelled()) ci.cancel();
    }
    @Inject(method = "setAir", at = @At("RETURN"))
    public void afterStAir(int air, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.setAir(id, AFTER, air));
    }

    @Inject(method = "pushOutOfBlocks", at = @At("HEAD"), cancellable = true)
    public void beforePushOutOfBlocks(double x, double y, double z, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.pushOutOfSolidBlock(id, BEFORE, x, y, z)).isCancelled()) ci.cancel();
    }
    @Inject(method = "pushOutOfBlocks", at = @At("RETURN"))
    public void afterPushOutOfBlocks(double x, double y, double z, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.pushOutOfSolidBlock(id, AFTER, x, y, z));
    }

    @Inject(method = "isAttackable", at = @At("HEAD"), cancellable = true)
    public void isAttackable1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isAttackable event = EVENT_MANAGER.post(new EntityEvent.isAttackable(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isAttackable", at = @At("RETURN"), cancellable = true)
    public void isAttackable2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isAttackable event = EVENT_MANAGER.post(new EntityEvent.isAttackable(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "handleAttack", at = @At("HEAD"), cancellable = true)
    public void handleAttack1(Entity attacker, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.handleAttack event = EVENT_MANAGER.post(new EntityEvent.handleAttack(id, BEFORE, cir.getReturnValue(), (net.meshmc.mesh.api.entity.Entity) attacker));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "handleAttack", at = @At("RETURN"), cancellable = true)
    public void handleAttack2(Entity attacker, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.handleAttack event = EVENT_MANAGER.post(new EntityEvent.handleAttack(id, AFTER, cir.getReturnValue(), (net.meshmc.mesh.api.entity.Entity) attacker));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "copyPositionAndRotation", at = @At("HEAD"), cancellable = true)
    public void copyPositionAndRotation1(Entity entity, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.copyPositionAndRotation(id, BEFORE, (net.meshmc.mesh.api.entity.Entity) entity)).isCancelled()) ci.cancel();
    }
    @Inject(method = "copyPositionAndRotation", at = @At("RETURN"))
    public void copyPositionAndRotation2(Entity entity, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.copyPositionAndRotation(id, AFTER, (net.meshmc.mesh.api.entity.Entity) entity));
    }

    @Inject(method = "copyFrom", at = @At("HEAD"), cancellable = true)
    public void copyFrom1(Entity original, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.copyFrom(id, BEFORE, (net.meshmc.mesh.api.entity.Entity) original)).isCancelled()) ci.cancel();
    }
    @Inject(method = "copyFrom", at = @At("RETURN"))
    public void copyFrom2(Entity original, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.copyFrom(id, AFTER, (net.meshmc.mesh.api.entity.Entity) original));
    }

    @Inject(method = "getSafeFallDistance", at = @At("HEAD"), cancellable = true)
    public void getSafeFallDistance1(CallbackInfoReturnable<Integer> cir) {
        EntityEvent.getSafeFallDistance event = EVENT_MANAGER.post(new EntityEvent.getSafeFallDistance(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getSafeFallDistance", at = @At("RETURN"), cancellable = true)
    public void getSafeFallDistance2(CallbackInfoReturnable<Integer> cir) {
        EntityEvent.getSafeFallDistance event = EVENT_MANAGER.post(new EntityEvent.getSafeFallDistance(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "canAvoidTraps", at = @At("HEAD"), cancellable = true)
    public void canAvoidTraps1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.canAvoidTraps event = EVENT_MANAGER.post(new EntityEvent.canAvoidTraps(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "canAvoidTraps", at = @At("RETURN"), cancellable = true)
    public void canAvoidTraps2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.canAvoidTraps event = EVENT_MANAGER.post(new EntityEvent.canAvoidTraps(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "doesRenderOnFire", at = @At("HEAD"), cancellable = true)
    public void doesRenderOnFire1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.doesRenderOnFire event = EVENT_MANAGER.post(new EntityEvent.doesRenderOnFire(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "doesRenderOnFire", at = @At("RETURN"), cancellable = true)
    public void doesRenderOnFire2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.doesRenderOnFire event = EVENT_MANAGER.post(new EntityEvent.doesRenderOnFire(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "isPushedByFluids", at = @At("HEAD"), cancellable = true)
    public void isPushedByFluids1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isPushedByFluids event = EVENT_MANAGER.post(new EntityEvent.isPushedByFluids(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isPushedByFluids", at = @At("RETURN"), cancellable = true)
    public void isPushedByFluids2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isPushedByFluids event = EVENT_MANAGER.post(new EntityEvent.isPushedByFluids(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "hasCustomName", at = @At("HEAD"), cancellable = true)
    public void hasCustomNameTag1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasCustomNameTag event = EVENT_MANAGER.post(new EntityEvent.hasCustomNameTag(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "hasCustomName", at = @At("RETURN"), cancellable = true)
    public void hasCustomNameTag2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasCustomNameTag event = EVENT_MANAGER.post(new EntityEvent.hasCustomNameTag(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "isCustomNameVisible", at = @At("HEAD"), cancellable = true)
    public void isCustomNameTagVisible1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isCustomNameTagVisible event = EVENT_MANAGER.post(new EntityEvent.isCustomNameTagVisible(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isCustomNameVisible", at = @At("RETURN"), cancellable = true)
    public void isCustomNameTagVisible2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isCustomNameTagVisible event = EVENT_MANAGER.post(new EntityEvent.isCustomNameTagVisible(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "setCustomNameVisible", at = @At("HEAD"), cancellable = true)
    public void setCustomNameTagVisible1(boolean visible, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.setCustomNameTagVisible(id, BEFORE, visible)).isCancelled()) ci.cancel();
    }
    @Inject(method = "setCustomNameVisible", at = @At("RETURN"))
    public void setCustomNameTagVisible2(boolean visible, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.setCustomNameTagVisible(id, AFTER, visible));
    }

    @Inject(method = "teleport", at = @At("HEAD"), cancellable = true)
    public void teleport1(double destX, double destY, double destZ, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.teleport(id, BEFORE, destX, destY, destZ)).isCancelled()) ci.cancel();
    }
    @Inject(method = "teleport", at = @At("RETURN"))
    public void teleport2(double destX, double destY, double destZ, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.teleport(id, BEFORE, destX, destY, destZ));
    }

    @Inject(method = "shouldRenderName", at = @At("HEAD"), cancellable = true)
    public void shouldRenderName1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.shouldRenderName event = EVENT_MANAGER.post(new EntityEvent.shouldRenderName(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "shouldRenderName", at = @At("RETURN"), cancellable = true)
    public void shouldRenderName2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.shouldRenderName event = EVENT_MANAGER.post(new EntityEvent.shouldRenderName(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "getHorizontalFacing", at = @At("HEAD"), cancellable = true)
    public void getHorizontalFacing1(CallbackInfoReturnable<Direction> cir) {
        EntityEvent.getHorizontalFacing event = EVENT_MANAGER.post(new EntityEvent.getHorizontalFacing(id, BEFORE, null));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(MCEnum.facing(event.returnValue));
        cir.cancel();
    }
    @Inject(method = "getHorizontalFacing", at = @At("RETURN"), cancellable = true)
    public void getHorizontalFacing2(CallbackInfoReturnable<Direction> cir) {
        EntityEvent.getHorizontalFacing event = EVENT_MANAGER.post(new EntityEvent.getHorizontalFacing(id, BEFORE, MeshEnum.facing(cir.getReturnValue())));
        if(!event.isCancelled()) return;

        cir.setReturnValue(MCEnum.facing(event.returnValue));
        cir.cancel();
    }

    @Inject(method = "getMovementDirection", at = @At("HEAD"), cancellable = true)
    public void getMovementDirection1(CallbackInfoReturnable<Direction> cir) {
        EntityEvent.getMovementDirection event = EVENT_MANAGER.post(new EntityEvent.getMovementDirection(id, BEFORE, null));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(MCEnum.facing(event.returnValue));
        cir.cancel();
    }
    @Inject(method = "getMovementDirection", at = @At("RETURN"), cancellable = true)
    public void getMovementDirection2(CallbackInfoReturnable<Direction> cir) {
        EntityEvent.getMovementDirection event = EVENT_MANAGER.post(new EntityEvent.getMovementDirection(id, BEFORE, MeshEnum.facing(cir.getReturnValue())));
        if(!event.isCancelled()) return;

        cir.setReturnValue(MCEnum.facing(event.returnValue));
        cir.cancel();
    }

    @Inject(method = "getVisibilityBoundingBox", at = @At("HEAD"), cancellable = true)
    public void getRenderBoundingBox1(CallbackInfoReturnable<Box> cir) {
        EntityEvent.getRenderBoundingBox event = EVENT_MANAGER.post(new EntityEvent.getRenderBoundingBox(id, BEFORE, (net.meshmc.mesh.api.math.Box) cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue((Box) event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getVisibilityBoundingBox", at = @At("RETURN"), cancellable = true)
    public void getRenderBoundingBox2(CallbackInfoReturnable<Box> cir) {
        EntityEvent.getRenderBoundingBox event = EVENT_MANAGER.post(new EntityEvent.getRenderBoundingBox(id, AFTER, (net.meshmc.mesh.api.math.Box) cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue((Box) event.returnValue);
        cir.cancel();
    }

    @Inject(method = "isImmuneToExplosion", at = @At("HEAD"), cancellable = true)
    public void isImmuneToExplosion1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isImmuneToExplosion event = EVENT_MANAGER.post(new EntityEvent.isImmuneToExplosion(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isImmuneToExplosion", at = @At("RETURN"), cancellable = true)
    public void isImmuneToExplosion2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isImmuneToExplosion event = EVENT_MANAGER.post(new EntityEvent.isImmuneToExplosion(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "entityDataRequiresOperator", at = @At("HEAD"), cancellable = true)
    public void entityDataRequiresOperator1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.entityDataRequiresOperator event = EVENT_MANAGER.post(new EntityEvent.entityDataRequiresOperator(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "entityDataRequiresOperator", at = @At("RETURN"), cancellable = true)
    public void entityDataRequiresOperator2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.entityDataRequiresOperator event = EVENT_MANAGER.post(new EntityEvent.entityDataRequiresOperator(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "getPrimaryPassenger", at = @At("HEAD"), cancellable = true)
    public void getControllingRider1(CallbackInfoReturnable<Entity> cir) {
        EntityEvent.getControllingRider event = EVENT_MANAGER.post(new EntityEvent.getControllingRider(id, BEFORE, (net.meshmc.mesh.api.entity.Entity) cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue((Entity) event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getPrimaryPassenger", at = @At("RETURN"), cancellable = true)
    public void getControllingRider2(CallbackInfoReturnable<Entity> cir) {
        EntityEvent.getControllingRider event = EVENT_MANAGER.post(new EntityEvent.getControllingRider(id, AFTER, (net.meshmc.mesh.api.entity.Entity) cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue((Entity) event.returnValue);
        cir.cancel();
    }

    @Inject(method = "hasPassenger", at = @At("HEAD"), cancellable = true)
    public void hasRider1(Entity passenger, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasRider event = EVENT_MANAGER.post(new EntityEvent.hasRider(id, BEFORE, cir.getReturnValue(), (net.meshmc.mesh.api.entity.Entity) passenger));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "hasPassenger", at = @At("RETURN"), cancellable = true)
    public void hasRider2(Entity passenger, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasRider event = EVENT_MANAGER.post(new EntityEvent.hasRider(id, AFTER, cir.getReturnValue(), (net.meshmc.mesh.api.entity.Entity) passenger));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "getRootVehicle", at = @At("HEAD"), cancellable = true)
    public void getLowestVehicle1(CallbackInfoReturnable<Entity> cir) {
        EntityEvent.getLowestVehicle event = EVENT_MANAGER.post(new EntityEvent.getLowestVehicle(id, BEFORE, (net.meshmc.mesh.api.entity.Entity) cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue((Entity) event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getRootVehicle", at = @At("RETURN"), cancellable = true)
    public void getLowestVehicle2(CallbackInfoReturnable<Entity> cir) {
        EntityEvent.getLowestVehicle event = EVENT_MANAGER.post(new EntityEvent.getLowestVehicle(id, AFTER, (net.meshmc.mesh.api.entity.Entity) cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue((Entity) event.returnValue);
        cir.cancel();
    }

    @Inject(method = "getBurningDuration", at = @At("HEAD"), cancellable = true)
    public void getBurningDuration1(CallbackInfoReturnable<Integer> cir) {
        EntityEvent.getBurningDuration event = EVENT_MANAGER.post(new EntityEvent.getBurningDuration(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getBurningDuration", at = @At("RETURN"))
    public void getBurningDuration2(CallbackInfoReturnable<Integer> cir) {
        EntityEvent.getBurningDuration event = EVENT_MANAGER.post(new EntityEvent.getBurningDuration(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
}
