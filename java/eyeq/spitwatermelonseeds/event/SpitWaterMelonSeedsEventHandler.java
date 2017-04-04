package eyeq.spitwatermelonseeds.event;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SpitWaterMelonSeedsEventHandler {
    @SubscribeEvent
    public void onLivingEntityUseItemFinish(LivingEntityUseItemEvent.Finish event) {
        EntityLivingBase entity = event.getEntityLiving();
        World world = entity.getEntityWorld();
        if(world.isRemote) {
            return;
        }
        ItemStack itemStack = event.getItem();
        if(itemStack.getItem() != Items.MELON) {
            return;
        }
        if(itemStack.getItemUseAction() != EnumAction.EAT) {
            return;
        }

        BlockPos pos = entity.getPosition();
        Vec3d look = entity.getLookVec();
        EntityItem seeds = new EntityItem(world, pos.getX() + look.xCoord * 2, pos.getY(), pos.getZ() + look.zCoord * 2, new ItemStack(Items.MELON_SEEDS));
        seeds.addVelocity(look.xCoord, look.yCoord, look.zCoord);
        world.spawnEntity(seeds);
    }
}
