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

package it.skymc.screensharecore.commands;

import it.skymc.screensharecore.utils.ABS;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * SetupLocation Created 4/30/2022
 * By YumaHisai at 7:23 PM
 */


public class SetupLocations extends ABS implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            messages.commandBlocked(sender);
            return true;
        }

        Player player = (Player) sender;

        if(luck.hasPermission(luck.getUser(player), "skymc.controlli.setup")){
            if(args.length == 0){
                messages.setUsage(player);
            }

            if(args.length >= 1){
                if(args[0].equals("set")){
                    if(args[1].equals("sospetto")){
                        setSospettoLoc(player);
                        messages.locationSet(player);
                    }
                    if(args[1].equals("staffer")){
                        setStafferLoc(player);
                        messages.locationSet(player);
                    }
                }
            }
        } else {
            messages.noPerms(player);
        }

        return false;
    }
}
