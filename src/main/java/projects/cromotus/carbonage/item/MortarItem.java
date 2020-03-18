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

package projects.cromotus.carbonage.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import projects.cromotus.carbonage.init.CarbonAgeItems;

import java.util.function.Consumer;

public class MortarItem extends Item {

    private int simultaneousCrafts;

    public MortarItem(Properties properties, int simultaneousCrafts) {
        super(properties);
        this.simultaneousCrafts = simultaneousCrafts;
    }

    //TODO Add config values to enable or disable each of the methods to get tiny coal dust
    //TODO Add tags so every mortar can be used for crafting not just the stone one

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        final ItemStack stack = playerIn.getHeldItem(handIn);
        if (handIn == Hand.MAIN_HAND) {
            for (int i = 0; i < simultaneousCrafts; i++) {
                if (stack.getMaxDamage() != stack.getDamage()) {
                    stack.damageItem(1, playerIn, playerEntity -> {} );
                } else {
                    break;
                }
                if (!worldIn.isRemote) {
                    int index = playerIn.inventory.findSlotMatchingUnusedItem(new ItemStack(() -> Items.COAL));
                    if (index != -1) {
                        playerIn.inventory.getStackInSlot(index).setCount(playerIn.inventory.getStackInSlot(index).getCount() - 1);
                        playerIn.inventory.addItemStackToInventory(new ItemStack(() -> CarbonAgeItems.TINY_COAL_DUST, 1));
                    } else {
                        break;
                    }
                }
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        if (itemStack.getMaxDamage() == itemStack.getDamage()) {
            return new ItemStack(() -> null);
        } else {
            ItemStack newItemStack = itemStack.copy();
            newItemStack.setDamage(itemStack.getDamage() + 1);
            return newItemStack;
        }
    }
}
