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

import net.minecraft.item.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import projects.cromotus.carbonage.CarbonAge;
import projects.cromotus.carbonage.item.CarbonAgeItemTier;
import projects.cromotus.carbonage.item.MortarItem;

@Mod.EventBusSubscriber(modid = CarbonAge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CarbonAgeItems {

    //Declaration of all added Items
    //Coal/Carbon Related
    public static final Item TINY_COAL_DUST = new Item(new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP));
    public static final Item COAL_DUST = new Item(new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP));
    public static final Item DENSE_COAL_DUST = new Item(new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP));
    public static final Item CARBON_MASS = new Item(new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP));
    public static final Item CARBON_PLATE = new Item(new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP));
    public static final Item DENSE_CARBON_PLATE = new Item(new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP));

    //Tools
    //TODO replace Simultaneous Crafts number with config value
    public static final Item MORTAR_STONE = new MortarItem(new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP).maxStackSize(1).maxDamage(256), 1);
    public static final Item MORTAR_IRON = new MortarItem(new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP).maxStackSize(1).maxDamage(1024), 5);
    public static final Item MORTAR_DIAMOND = new MortarItem(new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP).maxStackSize(1).maxDamage(4096), 10);

    public static final Item CARBON_SWORD = new SwordItem(CarbonAgeItemTier.CARBON, 1, 5f, new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP));
    public static final Item CARBON_PICKAXE = new PickaxeItem(CarbonAgeItemTier.CARBON, 1, 5f, new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP));
    public static final Item CARBON_AXE = new AxeItem(CarbonAgeItemTier.CARBON, 1, 5f, new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP));
    public static final Item CARBON_SHOVEL = new ShovelItem(CarbonAgeItemTier.CARBON, 1, 5f, new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP));
    public static final Item CARBON_HOE = new HoeItem(CarbonAgeItemTier.CARBON, 5f, new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP));

    public static final Item DENSE_CARBON_SWORD = new SwordItem(CarbonAgeItemTier.DENSE_CARBON, 1, 5f, new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP));
    public static final Item DENSE_CARBON_PICKAXE = new PickaxeItem(CarbonAgeItemTier.DENSE_CARBON, 1, 5f, new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP));
    public static final Item DENSE_CARBON_AXE = new AxeItem(CarbonAgeItemTier.DENSE_CARBON, 1, 5f, new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP));
    public static final Item DENSE_CARBON_SHOVEL = new ShovelItem(CarbonAgeItemTier.DENSE_CARBON, 1, 5f, new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP));
    public static final Item DENSE_CARBON_HOE = new HoeItem(CarbonAgeItemTier.DENSE_CARBON, 5f, new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP));

    //Crafting Items
    public static final Item STONE_BOWL = new Item(new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP));
    public static final Item IRON_STICK = new Item(new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP));
    public static final Item MOLD_EMPTY = new Item(new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP));
    public static final Item MOLD_FILLED = new Item(new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP));
    public static final Item MOLD_DRIED = new Item(new Item.Properties().group(CarbonAgeItemGroups.MAIN_GROUP).containerItem(MOLD_EMPTY));


    //Registers all Items used in the CarbonAge Mod
    @SubscribeEvent
    public static void registerEvent(RegistryEvent.Register<Item> event){
        final IForgeRegistry<Item> registry = event.getRegistry();

        //Coal/Carbon Related
        registry.register(TINY_COAL_DUST.setRegistryName("tiny_coal_dust"));
        registry.register(COAL_DUST.setRegistryName("coal_dust"));
        registry.register(DENSE_COAL_DUST.setRegistryName("dense_coal_dust"));
        registry.register(CARBON_MASS.setRegistryName("carbon_mass"));
        registry.register(CARBON_PLATE.setRegistryName("carbon_plate"));
        registry.register(DENSE_CARBON_PLATE.setRegistryName("dense_carbon_plate"));

        //Tools
        registry.register(MORTAR_STONE.setRegistryName("mortar_stone"));
        registry.register(MORTAR_IRON.setRegistryName("mortar_iron"));
        registry.register(MORTAR_DIAMOND.setRegistryName("mortar_diamond"));

        registry.register(CARBON_SWORD.setRegistryName("carbon_sword"));
        registry.register(CARBON_PICKAXE.setRegistryName("carbon_pickaxe"));
        registry.register(CARBON_AXE.setRegistryName("carbon_axe"));
        registry.register(CARBON_SHOVEL.setRegistryName("carbon_shovel"));
        registry.register(CARBON_HOE.setRegistryName("carbon_hoe"));

        registry.register(DENSE_CARBON_SWORD.setRegistryName("dense_carbon_sword"));
        registry.register(DENSE_CARBON_PICKAXE.setRegistryName("dense_carbon_pickaxe"));
        registry.register(DENSE_CARBON_AXE.setRegistryName("dense_carbon_axe"));
        registry.register(DENSE_CARBON_SHOVEL.setRegistryName("dense_carbon_shovel"));
        registry.register(DENSE_CARBON_HOE.setRegistryName("dense_carbon_hoe"));

        //Crafting Items
        registry.register(STONE_BOWL.setRegistryName("stone_bowl"));
        registry.register(IRON_STICK.setRegistryName("iron_stick"));
        registry.register(MOLD_EMPTY.setRegistryName("mold_empty"));
        registry.register(MOLD_FILLED.setRegistryName("mold_filled"));
        registry.register(MOLD_DRIED.setRegistryName("mold_dried"));

    }

}
