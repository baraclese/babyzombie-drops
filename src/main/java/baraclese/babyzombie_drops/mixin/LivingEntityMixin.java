package baraclese.babyzombie_drops.mixin;

import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;


// let isBaby() return false so that xp and picked up items are allowed to drop similar to normal zombies
@Mixin(LivingEntity.class)
public class LivingEntityMixin
{
	@Redirect(method = "dropXp()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;isBaby()Z"))
	private boolean isBaby1(LivingEntity entity)
	{
		return false;
	}

	@Redirect(method = "onKilled(Lnet/minecraft/entity/damage/DamageSource;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;isBaby()Z"))
	private boolean isBaby2(LivingEntity entity)
	{
		return false;
	}
}
