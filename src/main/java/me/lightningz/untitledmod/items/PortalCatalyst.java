package me.lightningz.untitledmod.items;

import me.lightningz.untitledmod.blocks.BlockRegister;
import me.lightningz.untitledmod.blocks.EPortalBlock;
import me.lightningz.untitledmod.world.dimension.ExampleDimension;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class PortalCatalyst extends Item {
    public PortalCatalyst(Properties p_41383_) {
        super(p_41383_);
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(context.getPlayer() != null) {
            if(context.getPlayer().level().dimension() == ExampleDimension.EDIM_KEY
                    || context.getPlayer().level().dimension() == Level.OVERWORLD) {
                for(Direction direction : Direction.Plane.VERTICAL) {
                    BlockPos framePos = context.getClickedPos().relative(direction);
                    if(((EPortalBlock) BlockRegister.PORTAL.get()).trySpawnPortal(context.getLevel(), framePos)) {
                        context.getLevel().playSound(context.getPlayer(), framePos,
                                SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
                        return InteractionResult.CONSUME;
                    }
                    else return InteractionResult.FAIL;
                }
            }
        }
        return InteractionResult.FAIL;
    }
}
