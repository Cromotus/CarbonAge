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
 *  copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package projects.cromotus.carbonage.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import projects.cromotus.carbonage.CarbonAge;
import projects.cromotus.carbonage.block.BasicBlockItem;

@Mod.EventBusSubscriber(modid = CarbonAge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CarbonAgeBlocks {

    public static final Block CARBON_BLOCK = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.5F, 6F).harvestTool(ToolType.PICKAXE).harvestLevel(2));
    public static final Block DENSE_CARBON_BLOCK = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.5F, 12F).harvestTool(ToolType.PICKAXE).harvestLevel(3));

    @SubscribeEvent
    public static void registerEvent(RegistryEvent.Register<Block> event){
        final IForgeRegistry<Block> registry = event.getRegistry();

        registry.register(CARBON_BLOCK.setRegistryName("carbon_block"));
        registry.register(DENSE_CARBON_BLOCK.setRegistryName("dense_carbon_block"));

    }

    @SubscribeEvent
    public static void registerEventBlockItem(RegistryEvent.Register<Item> event){
        final IForgeRegistry<Item> registry = event.getRegistry();

        registry.register(new BasicBlockItem(CARBON_BLOCK));
        registry.register(new BasicBlockItem(DENSE_CARBON_BLOCK));

    }

}
