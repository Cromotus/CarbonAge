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

package projects.cromotus.carbonage.data.tags;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import projects.cromotus.carbonage.CarbonAge;

public class CarbonAgeTags {

    public static class Items{

        public static final Tag<Item> MORTAR = makeTag(CarbonAge.MOD_ID, "mortar");
        public static final Tag<Item> CARBON_BLOCK = makeTag(CarbonAge.MOD_ID, "carbon_block");

        private static Tag<Item> makeTag(String modid, String name){
            return new ItemTags.Wrapper(new ResourceLocation(modid, name));
        }

    }

    public static class Blocks{

        public static final Tag<Block> CARBON_BLOCK = makeTag(CarbonAge.MOD_ID, "carbon_block");

        private static Tag<Block> makeTag(String modid, String name){
            return new BlockTags.Wrapper(new ResourceLocation(modid, name));
        }

    }

}
