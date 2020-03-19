/*
 * This file is part of CarbonAge, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2020 Cromotus
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package projects.cromotus.carbonage.data.provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.MatchTool;
import net.minecraft.world.storage.loot.conditions.SurvivesExplosion;
import net.minecraft.world.storage.loot.functions.ApplyBonus;
import net.minecraft.world.storage.loot.functions.ExplosionDecay;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import projects.cromotus.carbonage.init.CarbonAgeBlocks;

import java.io.IOException;
import java.nio.file.Path;
import java.util.function.BiConsumer;

public class CarbonAgeLootTableProvider implements IDataProvider {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private final DataGenerator generator;

    public CarbonAgeLootTableProvider(DataGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void act(DirectoryCache cache) throws IOException {
        registerLootTables((id, lootTable) -> {
            final Path path = getPath(id);
            try {
                IDataProvider.save(GSON, cache, LootTableManager.toJson(lootTable), path);
            } catch (IOException e) {
                LOGGER.error("Couldn't save loot table {}", path, e);
            }
        });
    }

    private Path getPath(ResourceLocation id) {
        return generator.getOutputFolder().resolve("data/" + id.getNamespace() + "/loot_tables/" + id.getPath() + ".json");
    }

    @Override
    public String getName() {
        return "LootTables";
    }

    protected void registerLootTables(BiConsumer<ResourceLocation, LootTable> consumer) {
        registerBlock(CarbonAgeBlocks.CARBON_BLOCK, addBasicBlockLootTable(CarbonAgeBlocks.CARBON_BLOCK), consumer);
        registerBlock(CarbonAgeBlocks.DENSE_CARBON_BLOCK, addBasicBlockLootTable(CarbonAgeBlocks.DENSE_CARBON_BLOCK), consumer);
    }

    private static void registerBlock(Block block, LootTable lootTable, BiConsumer<ResourceLocation, LootTable> consumer) {
        final ResourceLocation registryName = block.getRegistryName();
        consumer.accept(new ResourceLocation(registryName.getNamespace(), "blocks/" + registryName.getPath()), lootTable);
    }

    //For all Blocks that just drop themselves e.g. (Iron Block, Iron Ore, Logs Dirt)
    private static LootTable addBasicBlockLootTable(IItemProvider itemProvider) {
        return LootTable.builder()
                .setParameterSet(LootParameterSets.BLOCK)
                .addLootPool(LootPool.builder()
                        .rolls(ConstantRange.of(1))
                        .addEntry(ItemLootEntry.builder(itemProvider))
                        .acceptCondition(SurvivesExplosion.builder()))
                .build();
    }

    //For Blocks that get different results depending on Silktouch and fortune
    private static LootTable addOreBlockLootTable(Block block, IItemProvider itemProvider) {
        return LootTable.builder()
                .setParameterSet(LootParameterSets.BLOCK)
                .addLootPool(LootPool.builder()
                        .rolls(ConstantRange.of(1))
                        .addEntry(ItemLootEntry.builder(block)
                                .acceptCondition(MatchTool.builder(ItemPredicate.Builder.create()
                                        .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
                                .func_216080_a(ItemLootEntry.builder(itemProvider)
                                        .acceptFunction(ApplyBonus.func_215869_a(Enchantments.FORTUNE))
                                        .acceptFunction(ExplosionDecay.func_215863_b()))))
                .build();
    }

}
