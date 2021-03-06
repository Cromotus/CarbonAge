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

import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import projects.cromotus.carbonage.CarbonAge;
import projects.cromotus.carbonage.data.tags.CarbonAgeTags;
import projects.cromotus.carbonage.init.CarbonAgeBlocks;
import projects.cromotus.carbonage.init.CarbonAgeItems;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CarbonAgeRecipeProvider extends RecipeProvider {
    public CarbonAgeRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        //Shaped Recipes
        //Mortars
        ShapedRecipeBuilder.shapedRecipe(CarbonAgeItems.MORTAR_STONE, 1)
                .patternLine("S")
                .patternLine("S")
                .patternLine("B")
                .key('S', Blocks.STONE)
                .key('B', CarbonAgeItems.STONE_BOWL)
                .addCriterion("has_stone", hasItem(Blocks.STONE))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "mortar_stone"));

        ShapedRecipeBuilder.shapedRecipe(CarbonAgeItems.MORTAR_IRON, 1)
                .patternLine("I")
                .patternLine("I")
                .patternLine("B")
                .key('I', Items.IRON_INGOT)
                .key('B', CarbonAgeItems.STONE_BOWL)
                .addCriterion("has_iron", hasItem(Items.IRON_INGOT))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "mortar_iron"));

        ShapedRecipeBuilder.shapedRecipe(CarbonAgeItems.MORTAR_DIAMOND, 1)
                .patternLine("D")
                .patternLine("D")
                .patternLine("B")
                .key('D', Items.DIAMOND)
                .key('B', CarbonAgeItems.STONE_BOWL)
                .addCriterion("has_diamond", hasItem(Items.DIAMOND))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "mortar_diamond"));

        //Crafting Items
        ShapedRecipeBuilder.shapedRecipe(CarbonAgeItems.STONE_BOWL, 1)
                .patternLine("S S")
                .patternLine("SSS")
                .key('S', Blocks.STONE)
                .addCriterion("has_stone", hasItem(Blocks.STONE))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "stone_bowl"));

        ShapedRecipeBuilder.shapedRecipe(CarbonAgeItems.CARBON_MASS, 1)
                .patternLine(" # ")
                .patternLine("#W#")
                .patternLine(" # ")
                .key('#', CarbonAgeItems.DENSE_COAL_DUST)
                .key('W', Items.WATER_BUCKET)
                .addCriterion("has_dense_coal_dust", hasItem(CarbonAgeItems.DENSE_COAL_DUST))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "carbon_mass"));

        ShapedRecipeBuilder.shapedRecipe(CarbonAgeItems.IRON_STICK, 4)
                .patternLine("I")
                .patternLine("I")
                .key('I', Items.IRON_INGOT)
                .addCriterion("has_iron_ingot", hasItem(Items.IRON_INGOT))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "iron_stick"));

        ShapedRecipeBuilder.shapedRecipe(CarbonAgeItems.MOLD_EMPTY, 1)
                .patternLine("III")
                .patternLine("S S")
                .patternLine("III")
                .key('I', Items.IRON_INGOT)
                .key('S', CarbonAgeItems.IRON_STICK)
                .addCriterion("has_iron_stick", hasItem(CarbonAgeItems.IRON_STICK))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "mold_empty"));

        ShapedRecipeBuilder.shapedRecipe(CarbonAgeItems.MOLD_FILLED, 1)
                .patternLine(" C ")
                .patternLine("CMC")
                .patternLine(" C ")
                .key('C', CarbonAgeItems.CARBON_MASS)
                .key('M', CarbonAgeItems.MOLD_EMPTY)
                .addCriterion("has_mold", hasItem(CarbonAgeItems.MOLD_EMPTY))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "mold_filled"));

        //Blocks
        ShapedRecipeBuilder.shapedRecipe(CarbonAgeBlocks.CARBON_BLOCK, 4)
                .patternLine(" C ")
                .patternLine("CSC")
                .patternLine(" C ")
                .key('C', CarbonAgeItems.CARBON_PLATE)
                .key('S', Blocks.STONE)
                .addCriterion("has_carbon", hasItem(CarbonAgeItems.CARBON_PLATE))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "carbon_block"));

        ShapedRecipeBuilder.shapedRecipe(CarbonAgeBlocks.DENSE_CARBON_BLOCK, 4)
                .patternLine(" C ")
                .patternLine("CSC")
                .patternLine(" C ")
                .key('C', CarbonAgeItems.DENSE_CARBON_PLATE)
                .key('S', Blocks.STONE)
                .addCriterion("has_dense_carbon", hasItem(CarbonAgeItems.DENSE_CARBON_PLATE))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "dense_carbon_block"));

        //Tools
        ShapedRecipeBuilder.shapedRecipe(CarbonAgeItems.CARBON_PICKAXE, 1)
                .patternLine("CCC")
                .patternLine(" S ")
                .patternLine(" S ")
                .key('C', CarbonAgeItems.CARBON_PLATE)
                .key('s', CarbonAgeItems.IRON_STICK)
                .addCriterion("has_carbon", hasItem(CarbonAgeItems.CARBON_PLATE))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "carbon_pickaxe"));

        ShapedRecipeBuilder.shapedRecipe(CarbonAgeItems.CARBON_SHOVEL, 1)
                .patternLine("C")
                .patternLine("S")
                .patternLine("S")
                .key('C', CarbonAgeItems.CARBON_PLATE)
                .key('s', CarbonAgeItems.IRON_STICK)
                .addCriterion("has_carbon", hasItem(CarbonAgeItems.CARBON_PLATE))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "carbon_shovel"));

        ShapedRecipeBuilder.shapedRecipe(CarbonAgeItems.CARBON_AXE, 1)
                .patternLine("CC ")
                .patternLine("CS ")
                .patternLine(" S ")
                .key('C', CarbonAgeItems.CARBON_PLATE)
                .key('s', CarbonAgeItems.IRON_STICK)
                .addCriterion("has_carbon", hasItem(CarbonAgeItems.CARBON_PLATE))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "carbon_axe"));

        ShapedRecipeBuilder.shapedRecipe(CarbonAgeItems.CARBON_SWORD, 1)
                .patternLine(" C ")
                .patternLine(" C ")
                .patternLine(" S ")
                .key('C', CarbonAgeItems.CARBON_PLATE)
                .key('s', CarbonAgeItems.IRON_STICK)
                .addCriterion("has_carbon", hasItem(CarbonAgeItems.CARBON_PLATE))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "carbon_sword"));

        ShapedRecipeBuilder.shapedRecipe(CarbonAgeItems.CARBON_HOE, 1)
                .patternLine("CC ")
                .patternLine(" S ")
                .patternLine(" S ")
                .key('C', CarbonAgeItems.CARBON_PLATE)
                .key('s', CarbonAgeItems.IRON_STICK)
                .addCriterion("has_carbon", hasItem(CarbonAgeItems.CARBON_PLATE))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "carbon_hoe"));

        ShapedRecipeBuilder.shapedRecipe(CarbonAgeItems.DENSE_CARBON_PICKAXE, 1)
                .patternLine("CCC")
                .patternLine(" S ")
                .patternLine(" S ")
                .key('C', CarbonAgeItems.DENSE_CARBON_PLATE)
                .key('s', CarbonAgeItems.IRON_STICK)
                .addCriterion("has_carbon", hasItem(CarbonAgeItems.DENSE_CARBON_PLATE))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "dense_carbon_pickaxe"));

        ShapedRecipeBuilder.shapedRecipe(CarbonAgeItems.DENSE_CARBON_SHOVEL, 1)
                .patternLine(" C ")
                .patternLine(" S ")
                .patternLine(" S ")
                .key('C', CarbonAgeItems.DENSE_CARBON_PLATE)
                .key('s', CarbonAgeItems.IRON_STICK)
                .addCriterion("has_carbon", hasItem(CarbonAgeItems.DENSE_CARBON_PLATE))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "dense_carbon_shovel"));

        ShapedRecipeBuilder.shapedRecipe(CarbonAgeItems.DENSE_CARBON_AXE, 1)
                .patternLine("CC ")
                .patternLine("CS ")
                .patternLine(" S ")
                .key('C', CarbonAgeItems.DENSE_CARBON_PLATE)
                .key('s', CarbonAgeItems.IRON_STICK)
                .addCriterion("has_carbon", hasItem(CarbonAgeItems.DENSE_CARBON_PLATE))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "dense_carbon_axe"));

        ShapedRecipeBuilder.shapedRecipe(CarbonAgeItems.DENSE_CARBON_SWORD, 1)
                .patternLine(" C ")
                .patternLine(" C ")
                .patternLine(" S ")
                .key('C', CarbonAgeItems.DENSE_CARBON_PLATE)
                .key('s', CarbonAgeItems.IRON_STICK)
                .addCriterion("has_carbon", hasItem(CarbonAgeItems.DENSE_CARBON_PLATE))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "dense_carbon_sword"));

        ShapedRecipeBuilder.shapedRecipe(CarbonAgeItems.DENSE_CARBON_HOE, 1)
                .patternLine("CC ")
                .patternLine(" S ")
                .patternLine(" S ")
                .key('C', CarbonAgeItems.DENSE_CARBON_PLATE)
                .key('s', CarbonAgeItems.IRON_STICK)
                .addCriterion("has_carbon", hasItem(CarbonAgeItems.DENSE_CARBON_PLATE))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "dense_carbon_hoe"));

        //Shapeless Recipes
        ShapelessRecipeBuilder.shapelessRecipe(CarbonAgeItems.TINY_COAL_DUST, 1)
                .addIngredient(Items.COAL, 1)
                .addIngredient(CarbonAgeTags.Items.MORTAR)
                .addCriterion("has_mortar", hasItem(CarbonAgeTags.Items.MORTAR))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "tiny_coal_dust"));

        ShapelessRecipeBuilder.shapelessRecipe(CarbonAgeItems.COAL_DUST, 1)
                .addIngredient(CarbonAgeItems.TINY_COAL_DUST, 4)
                .addCriterion("has_tiny_coal_dust", hasItem(CarbonAgeItems.TINY_COAL_DUST))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "coal_dust"));

        ShapelessRecipeBuilder.shapelessRecipe(CarbonAgeItems.DENSE_COAL_DUST, 1)
                .addIngredient(CarbonAgeItems.COAL_DUST, 4)
                .addCriterion("has_coal_dust", hasItem(CarbonAgeItems.COAL_DUST))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "dense_coal_dust"));

        ShapelessRecipeBuilder.shapelessRecipe(CarbonAgeItems.CARBON_PLATE, 1)
                .addIngredient(CarbonAgeItems.MOLD_DRIED)
                .addCriterion("has_mold_dried", hasItem(CarbonAgeItems.MOLD_DRIED))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "carbon_plate"));

        ShapelessRecipeBuilder.shapelessRecipe(CarbonAgeItems.DENSE_CARBON_PLATE, 1)
                .addIngredient(CarbonAgeItems.CARBON_PLATE, 9)
                .addCriterion("has_carbon_plate", hasItem(CarbonAgeItems.CARBON_PLATE))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "dense_carbon_plate"));


        //Smelting
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(CarbonAgeItems.MOLD_FILLED), CarbonAgeItems.MOLD_DRIED, 0.1f, 200)
                .addCriterion("has_mold_filled", hasItem(CarbonAgeItems.MOLD_FILLED))
                .build(consumer, new ResourceLocation(CarbonAge.MOD_ID, "mold_dried"));
    }

    //Use this method if a Recipe uses a tag that is not generated by CarbonAge
    private Ingredient getFakeIngredient(Tag<Item> tag){
        return Ingredient.fromItemListStream(Stream.of(new Ingredient.TagList(tag){
            @Override
            public Collection<ItemStack> getStacks() {
                //Item that is used here doesn't matter because it will be serialized as the tag inputted
                return Arrays.asList(new ItemStack(Items.ACACIA_BUTTON));
            }
        }));
    }
}
