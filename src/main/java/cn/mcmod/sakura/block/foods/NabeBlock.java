package cn.mcmod.sakura.block.foods;

import java.util.Random;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod_mmf.mmlib.block.entity.HeatableBlockEntity;
import cn.mcmod_mmf.mmlib.item.info.FoodInfo;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class NabeBlock extends Block implements HeatableBlockEntity{
    public static final BooleanProperty IS_COOKED = BooleanProperty.create("is_cooked");
    public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 3);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D);
    private final FoodInfo info;
    public NabeBlock(FoodInfo info) {
        super(Properties.copy(BlockRegistry.COOKING_POT.get()));
        this.info = info;
        this.registerDefaultState(this.stateDefinition.any().setValue(IS_COOKED, false).setValue(FACING, Direction.NORTH).setValue(BITES, 0));
    }
    
    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(IS_COOKED);
    }
    
    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random rand) {
        if(state.getValue(IS_COOKED)) return;
        if(this.isHeated(level, pos) && rand.nextInt(10) == 0) {
            level.playSound(null, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 1F, 0.8F);
            level.setBlock(pos, state.setValue(IS_COOKED, true), UPDATE_ALL);
        }
    }
    
    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, Random rand) {
        if(state.getValue(IS_COOKED)) return;
        if(this.isHeated(level, pos) && rand.nextInt(4) == 0) {
            double x = (double) pos.getX() + 0.5D + (rand.nextDouble() * 0.6D - 0.3D);
            double y = (double) pos.getY() + 0.75D;
            double z = (double) pos.getZ() + 0.5D + (rand.nextDouble() * 0.6D - 0.3D);
            level.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(IS_COOKED, FACING, BITES);
    }
    public FoodInfo getFoodInfo() {
        return this.info;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
            BlockHitResult hitResult) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (level.isClientSide) {
            if (eat(level, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }
            if (itemstack.isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }
        return eat(level, pos, state, player);
    }
    
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    protected InteractionResult eat(LevelAccessor level, BlockPos pos, BlockState state, Player player) {
        if (!state.getValue(IS_COOKED)) {
            player.displayClientMessage(new TranslatableComponent(SakuraMod.MODID + ".block.nabe.not_cooked"), true);
            return InteractionResult.FAIL;
        }else if (!player.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            player.getFoodData().eat(this.getFoodInfo().getAmount(), this.getFoodInfo().getCalories());
            int i = state.getValue(BITES);
            level.gameEvent(player, GameEvent.EAT, pos);
            if (i < 3) {
                level.setBlock(pos, state.setValue(BITES, Integer.valueOf(i + 1)), 3);
            } else {
                level.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.PLAYERS, 0.8F, 0.8F);
                level.setBlock(pos, BlockRegistry.COOKING_POT.get().defaultBlockState().setValue(FACING, state.getValue(FACING)), UPDATE_ALL);
            }

            return InteractionResult.SUCCESS;
        }
    }
}
