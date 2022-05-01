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

package it.skymc.screensharecore.utils;

import it.skymc.screensharecore.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * ABS Created 4/30/2022
 * By YumaHisai at 7:24 PM
 */

public abstract class ABS {

    public Format format = new Format();

    public LuckPermsAPI luck = new LuckPermsAPI();

    public Messages messages = new Messages();

    public Stack stack = new Stack();

    public BungeeAPI bapi = new BungeeAPI();




    public FileConfiguration ssConfig(){
        return Main.getInstance().getConfig();
    }

    public double getXSospetto(){
        return Main.getInstance().getConfig().getDouble("controllo.sospetto.x");
    }
    public double getYSospetto(){
        return Main.getInstance().getConfig().getDouble("controllo.sospetto.y");
    }
    public double getZSospetto(){
        return Main.getInstance().getConfig().getDouble("controllo.sospetto.z");
    }

    public double getXStaffer(){
        return Main.getInstance().getConfig().getDouble("controllo.staffer.x");
    }
    public double getYStaffer(){
        return Main.getInstance().getConfig().getDouble("controllo.staffer.y");
    }
    public double getZStaffer(){
        return Main.getInstance().getConfig().getDouble("controllo.staffer.z");
    }

    public String getWorld(){
        return Main.getInstance().getConfig().getString("controllo.world");
    }
    public void teleportStaffer(Player player){
        player.teleport(new Location(Bukkit.getWorld(getWorld()), getXStaffer(), getYStaffer() ,getZStaffer()));
    }
    public void teleportSospetto(Player player){
        player.teleport(new Location(Bukkit.getWorld(getWorld()), getXSospetto(), getYSospetto() ,getZSospetto()));
    }


    public void getWorld(Player player){
        ssConfig().set("controllo.world", player.getWorld().getName());
    }

    public void setSospettoLoc(Player player){
        ssConfig().set("controllo.sospetto.x", player.getLocation().getBlockX());
        ssConfig().set("controllo.sospetto.y", player.getLocation().getBlockY());
        ssConfig().set("controllo.sospetto.z", player.getLocation().getBlockZ());
    }

    public void setStafferLoc(Player player){
        ssConfig().set("controllo.staffer.x", player.getLocation().getBlockX());
        ssConfig().set("controllo.staffer.y", player.getLocation().getBlockY());
        ssConfig().set("controllo.staffer.z", player.getLocation().getBlockZ());
    }

}
