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

import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import projects.cromotus.carbonage.data.tags.CarbonAgeTags;
import projects.cromotus.carbonage.init.CarbonAgeItems;

public class CarbonAgeItemTagsProvider extends ItemTagsProvider {

    public CarbonAgeItemTagsProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerTags() {
        getBuilder(CarbonAgeTags.Items.MORTAR).add(CarbonAgeItems.MORTAR_STONE)
                .add(CarbonAgeItems.MORTAR_IRON)
                .add(CarbonAgeItems.MORTAR_DIAMOND);
        copy(CarbonAgeTags.Blocks.CARBON_BLOCK, CarbonAgeTags.Items.CARBON_BLOCK);
    }
}
