package baraclese.babyzombie_drops.mixin;

import net.minecraft.entity.mob.ZombieEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(ZombieEntity.class)
public class ZombieEntityMixin
{
    // give baby zombie 12 xp to drop
    @Inject(method = "setBaby(Z)V", at = @At("TAIL"))
    private void setBaby(CallbackInfo ci)
    {
        ZombieEntity self = ((ZombieEntity)(Object)this);
        if (self.isBaby())
        {
            ((MobEntityAccessor)(self)).setExperiencePoints(12);
        }
    }

    // don't drop iron ingot, carrot or potato
    @Inject(method = "method_2672(I)V", at = @At("HEAD"), cancellable = true)
    private void discard_drops(CallbackInfo ci)
    {
        if (((ZombieEntity)(Object)this).isBaby())
        {
            ci.cancel();
        }
    }

}
