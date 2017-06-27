/*
 * This file is part of Exvoc.
 *
 * Exvoc is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Exvoc is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Exvoc.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.stormbytes.exvoc.items;

import com.stormbytes.exvoc.Exvoc;
import com.stormbytes.exvoc.items.ore.ItemDust;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemManager {

    public static ItemDust dustCalcosite;
    public static ItemDust dustCassiterite;

    private static <T extends Item> T register(String name, T item) {
        GameRegistry.register(item);
        Exvoc.proxy.registerItemRenderer(item, 0, name);

        return item;
    }

    public static void regiterItems() {
        dustCalcosite = register("dust_calcosite", new ItemDust("dust_calcosite"));
        dustCassiterite = register("dust_cassiterite", new ItemDust("dust_cassiterite"));
    }

}
