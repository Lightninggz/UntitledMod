package me.lightningz.untitledmod.items;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class ThunderAxe extends AxeItem {

    public ThunderAxe(Tier toolMaterial, Properties properties) {
        super(toolMaterial, 3, -2.4F, properties);
    }

    @Nonnull
    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        // Lightning Travel Point
        double rayLength = 100.0;
        Vec3 playerRotation = player.getViewVector(0);
        Vec3 rayPath = playerRotation.scale(rayLength);

        // Start and end point
        Vec3 from = player.getEyePosition(0);
        Vec3 to = from.add(rayPath);

        ClipContext rayCtx = new ClipContext(from, to, ClipContext.Block.OUTLINE, ClipContext.Fluid.ANY, null);
        HitResult rayHit = level.clip(rayCtx);

        if (rayHit.getType() == HitResult.Type.MISS){
            return InteractionResultHolder.fail(stack);
        }
        else {
            Vec3 hitLoc = rayHit.getLocation();
            if (!level.isClientSide()) {
                LightningBolt Lightning = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
                Lightning.setPos(hitLoc.x(), hitLoc.y(), hitLoc.z());
                level.addFreshEntity(Lightning);
            }
        }



        return InteractionResultHolder.success(stack);
    }
}
