package com.simibubi.create.foundation.utility;

import java.util.Collections;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.tags.NetworkTagManager;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ITickList;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapData;

public class WrappedWorld extends World {

	protected World world;

	public WrappedWorld(World world) {
		super(world.getWorldInfo(), world.getDimension().getType(), (w, d) -> world.getChunkProvider(),
				world.getProfiler(), world.isRemote);
		this.world = world;
	}

	@Override
	public World getWorld() {
		return world;
	}

	@Override
	public int getLight(BlockPos pos) {
		return 15;
	}

	@Override
	public int getLightSubtracted(BlockPos pos, int amount) {
		return 15 - amount;
	}

	@Override
	public void notifyBlockUpdate(BlockPos pos, BlockState oldState, BlockState newState, int flags) {
		world.notifyBlockUpdate(pos, oldState, newState, flags);
	}

	@Override
	public ITickList<Block> getPendingBlockTicks() {
		return world.getPendingBlockTicks();
	}

	@Override
	public ITickList<Fluid> getPendingFluidTicks() {
		return world.getPendingFluidTicks();
	}

	@Override
	public void playEvent(PlayerEntity player, int type, BlockPos pos, int data) {
	}

	@Override
	public List<? extends PlayerEntity> getPlayers() {
		return Collections.emptyList();
	}

	@Override
	public void playSound(PlayerEntity player, double x, double y, double z, SoundEvent soundIn, SoundCategory category,
			float volume, float pitch) {
	}

	@Override
	public void playMovingSound(PlayerEntity p_217384_1_, Entity p_217384_2_, SoundEvent p_217384_3_,
			SoundCategory p_217384_4_, float p_217384_5_, float p_217384_6_) {
	}

	@Override
	public Entity getEntityByID(int id) {
		return null;
	}

	@Override
	public MapData getMapData(String mapName) {
		return null;
	}

	@Override
	public boolean addEntity(Entity entityIn) {
		entityIn.setWorld(world);
		return world.addEntity(entityIn);
	}

	@Override
	public void registerMapData(MapData mapDataIn) {
	}

	@Override
	public int getNextMapId() {
		return 0;
	}

	@Override
	public void sendBlockBreakProgress(int breakerId, BlockPos pos, int progress) {
	}

	@Override
	public Scoreboard getScoreboard() {
		return world.getScoreboard();
	}

	@Override
	public RecipeManager getRecipeManager() {
		return world.getRecipeManager();
	}

	@Override
	public NetworkTagManager getTags() {
		return world.getTags();
	}

	@Override
	public int getMaxHeight() {
		return 256;
	}

}
