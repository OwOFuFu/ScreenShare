/*
 *
 *   Copyright (c) 2022. YumaHisai
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, andor sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in all
 *   copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *   SO
 */

package it.skymc.screensharecore.events;


import it.skymc.screensharecore.utils.ABS;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * SwitchClickEvent Created 4/30/2022
 * By YumaHisai at 9:04 PM
 */

public class SwitchClickEvent extends ABS implements Listener {


    @EventHandler
    @Deprecated
    public void PetsMove(InventoryClickEvent e) {

        if (e.getView().getTitle().equalsIgnoreCase(format.color("&c&l       - CONTROLLO -"))) {
            Player player = (Player) e.getWhoClicked();
            switch (e.getCurrentItem().getType()) {
                case GRAY_STAINED_GLASS_PANE:
                    break;
                case GREEN_STAINED_GLASS_PANE:
                    Bukkit.getOnlinePlayers().forEach(all -> bapi.sendPlayerToServer(all, "hub"));
                    break;
                case ORANGE_STAINED_GLASS_PANE:
                    player.sendMessage(format.color("&a&lUSA /tempban target 14d Ammissione Hack -s"));
                    break;
                case RED_STAINED_GLASS_PANE:
                    player.sendMessage(format.color("&a&lUSA /tempban target 30d Blatant -s"));
                    break;
            }
            e.setCancelled(true);
        }
    }
}

