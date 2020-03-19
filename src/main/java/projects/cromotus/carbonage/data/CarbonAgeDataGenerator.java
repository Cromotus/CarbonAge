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

package projects.cromotus.carbonage.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import projects.cromotus.carbonage.CarbonAge;
import projects.cromotus.carbonage.data.provider.CarbonAgeBlockTagsProvider;
import projects.cromotus.carbonage.data.provider.CarbonAgeItemTagsProvider;
import projects.cromotus.carbonage.data.provider.CarbonAgeRecipeProvider;

@Mod.EventBusSubscriber(modid = CarbonAge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CarbonAgeDataGenerator {

    @SubscribeEvent
    public static void genData(GatherDataEvent event){
        final DataGenerator generator = event.getGenerator();
        if (event.includeServer()){
            generator.addProvider(new CarbonAgeBlockTagsProvider(generator));
            generator.addProvider(new CarbonAgeItemTagsProvider(generator));
            generator.addProvider(new CarbonAgeRecipeProvider(generator));
        }
    }

}
