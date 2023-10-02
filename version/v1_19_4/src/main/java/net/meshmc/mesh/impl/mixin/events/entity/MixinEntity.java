package net.meshmc.mesh.impl.mixin.events.entity;

import dev.tigr.simpleevents.EventManager;
import net.meshmc.mesh.MeshAPI;
import net.meshmc.mesh.api.entity.living.player.EntityPlayer;
import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.event.events.entity.EntityEvent;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.Mappings;
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

    EventManager EVENT_MANAGER = MeshAPI.getEventManager();

    @Inject(method = "kill", at = @At("HEAD"), cancellable = true)
    public void kill1(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.kill(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "kill", at = @At("RETURN"))
    public void kill2(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.kill(id, AFTER));
    }

    @Inject(method = "discard", at = @At("HEAD"), cancellable = true)
    public void discard1(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.discard(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "discard", at = @At("RETURN"))
    public void discard2(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.discard(id, AFTER));
    }

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    public void tick1(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.tick(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "tick", at = @At("RETURN"))
    public void tick2(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.tick(id, AFTER));
    }

    @Inject(method = "baseTick", at = @At("HEAD"), cancellable = true)
    public void baseTick1(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.baseTick(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "baseTick", at = @At("RETURN"))
    public void baseTick2(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.baseTick(id, AFTER));
    }

    @Inject(method = "tickInVoid", at = @At("HEAD"), cancellable = true)
    public void tickInVoid1(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.tickInVoid(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "tickInVoid", at = @At("RETURN"))
    public void tickInVoid2(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.tickInVoid(id, AFTER));
    }

    @Inject(method = "move", at = @At("HEAD"), cancellable = true)
    public void move1(MovementType movementType, net.minecraft.util.math.Vec3d movement, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.move(id, BEFORE, MeshEnum.moverType(movementType), movement.getX(), movement.getY(), movement.getZ())).isCancelled()) ci.cancel();
    }
    @Inject(method = "move", at = @At("RETURN"))
    public void move2(MovementType movementType, net.minecraft.util.math.Vec3d movement, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.move(id, AFTER, MeshEnum.moverType(movementType), movement.getX(), movement.getY(), movement.getZ()));
    }

    @Inject(method = "checkBlockCollision", at = @At("HEAD"), cancellable = true)
    public void checkBlockCollision1(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.checkBlockCollision(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "checkBlockCollision", at = @At("RETURN"))
    public void checkBlockCollision2(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.checkBlockCollision(id, AFTER));
    }

    @Inject(method = "updateSwimming", at = @At("HEAD"), cancellable = true)
    public void updateSwimming1(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.updateSwimming(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "updateSwimming", at = @At("RETURN"))
    public void updateSwimming2(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.updateSwimming(id, AFTER));
    }

    @Inject(method = "spawnSprintingParticles", at = @At("HEAD"), cancellable = true)
    public void spawnSprintingParticles1(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.spawnSprintingParticles(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "spawnSprintingParticles", at = @At("RETURN"))
    public void spawnSprintingParticles2(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.spawnSprintingParticles(id, AFTER));
    }

    @Inject(method = "updateVelocity", at = @At("HEAD"), cancellable = true)
    public void moveRelative1(float speed, net.minecraft.util.math.Vec3d movementInput, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.moveRelative(id, BEFORE, speed, (Vec3d) movementInput)).isCancelled()) ci.cancel();
    }
    @Inject(method = "updateVelocity", at = @At("RETURN"))
    public void moveRelative2(float speed, net.minecraft.util.math.Vec3d movementInput, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.moveRelative(id, AFTER, speed, (Vec3d) movementInput));
    }

    @Inject(method = "updatePositionAndAngles", at = @At("HEAD"), cancellable = true)
    public void updatePositionAndAngles1(double x, double y, double z, float yaw, float pitch, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.updatePositionAndAngles(id, BEFORE, x, y, z, yaw, pitch)).isCancelled()) ci.cancel();
    }
    @Inject(method = "updatePositionAndAngles", at = @At("RETURN"))
    public void updatePositionAndAngles2(double x, double y, double z, float yaw, float pitch, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.updatePositionAndAngles(id, AFTER, x, y, z, yaw, pitch));
    }

    @Inject(method = "onPlayerCollision", at = @At("HEAD"), cancellable = true)
    public void onPlayerCollision1(PlayerEntity player, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.onPlayerCollision(id, BEFORE, (EntityPlayer) Mappings.entity(player))).isCancelled()) ci.cancel();
    }
    @Inject(method = "onPlayerCollision", at = @At("RETURN"))
    public void onPlayerCollision2(PlayerEntity player, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.onPlayerCollision(id, BEFORE, (EntityPlayer) Mappings.entity(player)));
    }

    @Inject(method = "pushAwayFrom", at = @At("HEAD"), cancellable = true)
    public void pushAwayFrom1(net.minecraft.entity.Entity entity, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.pushAwayFrom(id, BEFORE, Mappings.entity(entity))).isCancelled()) ci.cancel();
    }
    @Inject(method = "pushAwayFrom", at = @At("RETURN"))
    public void pushAwayFrom2(net.minecraft.entity.Entity entity, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.pushAwayFrom(id, AFTER, Mappings.entity(entity)));
    }

    @Inject(method = "tickRiding", at = @At("HEAD"), cancellable = true)
    public void tickRiding1(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.tickRiding(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "tickRiding", at = @At("RETURN"))
    public void tickRiding2(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.tickRiding(id, AFTER));
    }

    @Inject(method = "updatePassengerPosition(Lnet/minecraft/entity/Entity;)V", at = @At("HEAD"), cancellable = true)
    public void updateRiderPosition1(net.minecraft.entity.Entity passenger, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.updateRiderPosition(id, BEFORE, Mappings.entity(passenger))).isCancelled()) ci.cancel();
    }
    @Inject(method = "updatePassengerPosition(Lnet/minecraft/entity/Entity;)V", at = @At("RETURN"))
    public void updateRiderPosition2(net.minecraft.entity.Entity passenger, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.updateRiderPosition(id, AFTER, Mappings.entity(passenger)));
    }

    @Inject(method = "onPassengerLookAround", at = @At("HEAD"), cancellable = true)
    public void onRiderLookAround1(net.minecraft.entity.Entity passenger, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.onRiderLookAround(id, BEFORE, Mappings.entity(passenger))).isCancelled()) ci.cancel();
    }
    @Inject(method = "onPassengerLookAround", at = @At("RETURN"))
    public void onRiderLookAround2(net.minecraft.entity.Entity passenger, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.onRiderLookAround(id, AFTER, Mappings.entity(passenger)));
    }

    @Inject(method = "startRiding(Lnet/minecraft/entity/Entity;Z)Z", at = @At("HEAD"), cancellable = true)
    public void startRidingEntity1(net.minecraft.entity.Entity entity, boolean force, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.startRidingEntity event = EVENT_MANAGER.post(new EntityEvent.startRidingEntity(id, BEFORE, cir.getReturnValue(), Mappings.entity(entity), force));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "startRiding(Lnet/minecraft/entity/Entity;Z)Z", at = @At("RETURN"), cancellable = true)
    public void startRidingEntity2(net.minecraft.entity.Entity entity, boolean force, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.startRidingEntity event = EVENT_MANAGER.post(new EntityEvent.startRidingEntity(id, AFTER, cir.getReturnValue(), Mappings.entity(entity), force));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "removeAllPassengers", at = @At("HEAD"), cancellable = true)
    public void removeRiders1(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.removeRiders(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "removeAllPassengers", at = @At("RETURN"))
    public void removeRiders2(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.removeRiders(id, AFTER));
    }

    @Inject(method = "dismountVehicle", at = @At("HEAD"), cancellable = true)
    public void dismountVehicle1(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.dismountVehicle(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "dismountVehicle", at = @At("RETURN"))
    public void dismountVehicle2(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.dismountVehicle(id, AFTER));
    }

    @Inject(method = "addPassenger", at = @At("HEAD"), cancellable = true)
    public void addRider1(net.minecraft.entity.Entity passenger, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.addRider(id, BEFORE, Mappings.entity(passenger)).isCancelled())) ci.cancel();
    }
    @Inject(method = "addPassenger", at = @At("RETURN"))
    public void addRider2(net.minecraft.entity.Entity passenger, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.addRider(id, AFTER, Mappings.entity(passenger)));
    }

    @Inject(method = "removePassenger", at = @At("HEAD"), cancellable = true)
    public void removeRider1(net.minecraft.entity.Entity passenger, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.removeRider(id, BEFORE, Mappings.entity(passenger)).isCancelled())) ci.cancel();
    }
    @Inject(method = "removePassenger", at = @At("RETURN"))
    public void removeRider2(net.minecraft.entity.Entity passenger, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.removeRider(id, AFTER, Mappings.entity(passenger)));
    }

    @Inject(method = "canAddPassenger", at = @At("HEAD"), cancellable = true)
    public void canAddRider1(net.minecraft.entity.Entity passenger, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.canAddRider event = EVENT_MANAGER.post(new EntityEvent.canAddRider(id, BEFORE, cir.getReturnValue(), Mappings.entity(passenger)));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "canAddPassenger", at = @At("RETURN"))
    public void canAddRider2(net.minecraft.entity.Entity passenger, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.canAddRider event = EVENT_MANAGER.post(new EntityEvent.canAddRider(id, AFTER, cir.getReturnValue(), Mappings.entity(passenger)));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "updateTrackedPositionAndAngles", at = @At("HEAD"), cancellable = true)
    public void updateTrackedPositionAndAngles1(double x, double y, double z, float yaw, float pitch, int interpolationSteps, boolean interpolate, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.updateTrackedPositionAndAngles(id, BEFORE, x, y, z, yaw, pitch, interpolationSteps, interpolate)).isCancelled()) ci.cancel();
    }
    @Inject(method = "updateTrackedPositionAndAngles", at = @At("RETURN"))
    public void updateTrackedPositionAndAngles2(double x, double y, double z, float yaw, float pitch, int interpolationSteps, boolean interpolate, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.updateTrackedPositionAndAngles(id, AFTER, x, y, z, yaw, pitch, interpolationSteps, interpolate));
    }

    @Inject(method = "getDefaultNetherPortalCooldown", at = @At("HEAD"), cancellable = true)
    public void getDefaultNetherPortalCooldown1(CallbackInfoReturnable<Integer> cir) {
        EntityEvent.getDefaultNetherPortalCooldown event = EVENT_MANAGER.post(new EntityEvent.getDefaultNetherPortalCooldown(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getDefaultNetherPortalCooldown", at = @At("RETURN"))
    public void getDefaultNetherPortalCooldown2(CallbackInfoReturnable<Integer> cir) {
        EntityEvent.getDefaultNetherPortalCooldown event = EVENT_MANAGER.post(new EntityEvent.getDefaultNetherPortalCooldown(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "handleStatus", at = @At("HEAD"), cancellable = true)
    public void handleStatus1(byte status, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.handleStatus(id, BEFORE, status)).isCancelled()) ci.cancel();
    }
    @Inject(method = "handleStatus", at = @At("RETURN"))
    public void handleStatus2(byte status, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.handleStatus(id, AFTER, status));
    }

    @Inject(method = "animateDamage", at = @At("HEAD"), cancellable = true)
    public void performHurtAnimation1(CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.performHurtAnimation(id, BEFORE)).isCancelled()) ci.cancel();
    }
    @Inject(method = "animateDamage", at = @At("RETURN"))
    public void performHurtAnimation2(CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.performHurtAnimation(id, AFTER));
    }

    @Inject(method = "isOnFire", at = @At("HEAD"), cancellable = true)
    public void isOnFire1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isOnFire event = EVENT_MANAGER.post(new EntityEvent.isOnFire(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isOnFire", at = @At("RETURN"), cancellable = true)
    public void isOnFire2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isOnFire event = EVENT_MANAGER.post(new EntityEvent.isOnFire(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "hasVehicle", at = @At("HEAD"), cancellable = true)
    public void hasVehicle1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasVehicle event = EVENT_MANAGER.post(new EntityEvent.hasVehicle(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "hasVehicle", at = @At("RETURN"), cancellable = true)
    public void hasVehicle2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasVehicle event = EVENT_MANAGER.post(new EntityEvent.hasVehicle(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "hasPassengers", at = @At("HEAD"), cancellable = true)
    public void hasRiders1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasRiders event = EVENT_MANAGER.post(new EntityEvent.hasRiders(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "hasPassengers", at = @At("RETURN"), cancellable = true)
    public void hasRiders2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasRiders event = EVENT_MANAGER.post(new EntityEvent.hasRiders(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "isSneaking", at = @At("HEAD"), cancellable = true)
    public void isSneaking1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isSneaking event = EVENT_MANAGER.post(new EntityEvent.isSneaking(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isSneaking", at = @At("RETURN"), cancellable = true)
    public void isSneaking2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isSneaking event = EVENT_MANAGER.post(new EntityEvent.isSneaking(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "setSneaking", at = @At("HEAD"), cancellable = true)
    public void setSneaking1(boolean sneaking, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.setSneaking(id, BEFORE, sneaking)).isCancelled()) ci.cancel();
    }
    @Inject(method = "setSneaking", at = @At("RETURN"))
    public void setSneaking2(boolean sneaking, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.setSneaking(id, AFTER, sneaking));
    }

    @Inject(method = "getPose", at = @At("HEAD"), cancellable = true)
    public void getStance1(CallbackInfoReturnable<EntityPose> cir) {
        EntityEvent.getStance event = EVENT_MANAGER.post(new EntityEvent.getStance(id, BEFORE, null));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(MCEnum.stance(event.returnValue));
        cir.cancel();
    }
    @Inject(method = "getPose", at = @At("RETURN"), cancellable = true)
    public void getStance2(CallbackInfoReturnable<EntityPose> cir) {
        EntityEvent.getStance event = EVENT_MANAGER.post(new EntityEvent.getStance(id, AFTER, MeshEnum.stance(cir.getReturnValue())));
        if(!event.isCancelled()) return;

        cir.setReturnValue(MCEnum.stance(event.returnValue));
        cir.cancel();
    }

    @Inject(method = "setPose", at = @At("HEAD"), cancellable = true)
    public void setStance1(EntityPose pose, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.setStance(id, BEFORE, MeshEnum.stance(pose))).isCancelled()) ci.cancel();
    }
    @Inject(method = "setPose", at = @At("RETURN"))
    public void setStance2(EntityPose pose, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.setStance(id, AFTER, MeshEnum.stance(pose)));
    }

    @Inject(method = "isSprinting", at = @At("HEAD"), cancellable = true)
    public void isSprinting1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isSprinting event = EVENT_MANAGER.post(new EntityEvent.isSprinting(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isSprinting", at = @At("RETURN"), cancellable = true)
    public void isSprinting2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isSprinting event = EVENT_MANAGER.post(new EntityEvent.isSprinting(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "setSprinting", at = @At("HEAD"), cancellable = true)
    public void setSprinting1(boolean sprinting, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.setSprinting(id, BEFORE, sprinting)).isCancelled()) ci.cancel();
    }
    @Inject(method = "setSprinting", at = @At("RETURN"))
    public void setSprinting2(boolean sprinting, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.setSprinting(id, AFTER, sprinting));
    }

    @Inject(method = "isInvisible", at = @At("HEAD"), cancellable = true)
    public void isInvisible1(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isInvisible event = EVENT_MANAGER.post(new EntityEvent.isInvisible(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isInvisible", at = @At("RETURN"), cancellable = true)
    public void isInvisible2(CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isInvisible event = EVENT_MANAGER.post(new EntityEvent.isInvisible(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "isInvisibleTo", at = @At("HEAD"), cancellable = true)
    public void isInvisibleTo1(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isInvisibleTo event = EVENT_MANAGER.post(new EntityEvent.isInvisibleTo(id, BEFORE, cir.getReturnValue(), (EntityPlayer) Mappings.entity(player)));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "isInvisibleTo", at = @At("RETURN"), cancellable = true)
    public void isInvisibleTo2(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.isInvisibleTo event = EVENT_MANAGER.post(new EntityEvent.isInvisibleTo(id, AFTER, cir.getReturnValue(), (EntityPlayer) Mappings.entity(player)));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "setInvisible", at = @At("HEAD"), cancellable = true)
    public void setInvisible1(boolean invisible, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.setInvisible(id, BEFORE, invisible)).isCancelled()) ci.cancel();
    }
    @Inject(method = "setInvisible", at = @At("RETURN"))
    public void setInvisible2(boolean invisible, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.setInvisible(id, AFTER, invisible));
    }

    @Inject(method = "getFlag", at = @At("HEAD"), cancellable = true)
    public void getFlag1(int index, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.getFlag event = EVENT_MANAGER.post(new EntityEvent.getFlag(id, BEFORE, cir.getReturnValue(), index));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getFlag", at = @At("RETURN"), cancellable = true)
    public void getFlag2(int index, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.getFlag event = EVENT_MANAGER.post(new EntityEvent.getFlag(id, AFTER, cir.getReturnValue(), index));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "setFlag", at = @At("HEAD"), cancellable = true)
    public void setFlag1(int index, boolean value, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.setFlag(id, BEFORE, index, value)).isCancelled()) ci.cancel();
    }
    @Inject(method = "setFlag", at = @At("RETURN"))
    public void setFlag2(int index, boolean value, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.setFlag(id, AFTER, index, value));
    }

    @Inject(method = "getAir", at = @At("HEAD"), cancellable = true)
    public void getAir1(CallbackInfoReturnable<Integer> cir) {
        EntityEvent.getAir event = EVENT_MANAGER.post(new EntityEvent.getAir(id, BEFORE, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getAir", at = @At("RETURN"), cancellable = true)
    public void getAir2(CallbackInfoReturnable<Integer> cir) {
        EntityEvent.getAir event = EVENT_MANAGER.post(new EntityEvent.getAir(id, AFTER, cir.getReturnValue()));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "setAir", at = @At("HEAD"), cancellable = true)
    public void setAir1(int air, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.setAir(id, BEFORE, air)).isCancelled()) ci.cancel();
    }
    @Inject(method = "setAir", at = @At("RETURN"))
    public void setAir2(int air, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.setAir(id, AFTER, air));
    }

    @Inject(method = "pushOutOfBlocks", at = @At("HEAD"), cancellable = true)
    public void pushOutOfSolidBlock1(double x, double y, double z, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.pushOutOfSolidBlock(id, BEFORE, x, y, z)).isCancelled()) ci.cancel();
    }
    @Inject(method = "pushOutOfBlocks", at = @At("RETURN"))
    public void pushOutOfSolidBlock2(double x, double y, double z, CallbackInfo ci) {
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
        EntityEvent.handleAttack event = EVENT_MANAGER.post(new EntityEvent.handleAttack(id, BEFORE, cir.getReturnValue(), Mappings.entity(attacker)));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "handleAttack", at = @At("RETURN"), cancellable = true)
    public void handleAttack2(Entity attacker, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.handleAttack event = EVENT_MANAGER.post(new EntityEvent.handleAttack(id, AFTER, cir.getReturnValue(), Mappings.entity(attacker)));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "copyPositionAndRotation", at = @At("HEAD"), cancellable = true)
    public void copyPositionAndRotation1(Entity entity, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.copyPositionAndRotation(id, BEFORE, Mappings.entity(entity)).isCancelled())) ci.cancel();
    }
    @Inject(method = "copyPositionAndRotation", at = @At("RETURN"))
    public void copyPositionAndRotation2(Entity entity, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.copyPositionAndRotation(id, AFTER, Mappings.entity(entity)));
    }

    @Inject(method = "copyFrom", at = @At("HEAD"), cancellable = true)
    public void copyFrom1(Entity original, CallbackInfo ci) {
        if(EVENT_MANAGER.post(new EntityEvent.copyFrom(id, BEFORE, Mappings.entity(original)).isCancelled())) ci.cancel();
    }
    @Inject(method = "copyFrom", at = @At("RETURN"))
    public void copyFrom2(Entity original, CallbackInfo ci) {
        EVENT_MANAGER.post(new EntityEvent.copyFrom(id, AFTER, Mappings.entity(original)));
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
        EntityEvent.getControllingRider event = EVENT_MANAGER.post(new EntityEvent.getControllingRider(id, BEFORE, Mappings.entity(cir.getReturnValue())));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue((Entity) event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getPrimaryPassenger", at = @At("RETURN"), cancellable = true)
    public void getControllingRider2(CallbackInfoReturnable<Entity> cir) {
        EntityEvent.getControllingRider event = EVENT_MANAGER.post(new EntityEvent.getControllingRider(id, AFTER, Mappings.entity(cir.getReturnValue())));
        if(!event.isCancelled()) return;

        cir.setReturnValue((Entity) event.returnValue);
        cir.cancel();
    }

    @Inject(method = "hasPassenger", at = @At("HEAD"), cancellable = true)
    public void hasRider1(Entity passenger, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasRider event = EVENT_MANAGER.post(new EntityEvent.hasRider(id, BEFORE, cir.getReturnValue(), Mappings.entity(passenger)));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }
    @Inject(method = "hasPassenger", at = @At("RETURN"), cancellable = true)
    public void hasRider2(Entity passenger, CallbackInfoReturnable<Boolean> cir) {
        EntityEvent.hasRider event = EVENT_MANAGER.post(new EntityEvent.hasRider(id, AFTER, cir.getReturnValue(), Mappings.entity(passenger)));
        if(!event.isCancelled()) return;

        cir.setReturnValue(event.returnValue);
        cir.cancel();
    }

    @Inject(method = "getRootVehicle", at = @At("HEAD"), cancellable = true)
    public void getLowestVehicle1(CallbackInfoReturnable<Entity> cir) {
        EntityEvent.getLowestVehicle event = EVENT_MANAGER.post(new EntityEvent.getLowestVehicle(id, BEFORE, Mappings.entity(cir.getReturnValue())));
        if(!event.isCancelled()) return;

        if(event.returnValue == null) throw new NullPointerException("Return value on cancelled " + event.getName() + " with Era:BEFORE is null!");
        cir.setReturnValue((Entity) event.returnValue);
        cir.cancel();
    }
    @Inject(method = "getRootVehicle", at = @At("RETURN"), cancellable = true)
    public void getLowestVehicle2(CallbackInfoReturnable<Entity> cir) {
        EntityEvent.getLowestVehicle event = EVENT_MANAGER.post(new EntityEvent.getLowestVehicle(id, AFTER, Mappings.entity(cir.getReturnValue())));
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
