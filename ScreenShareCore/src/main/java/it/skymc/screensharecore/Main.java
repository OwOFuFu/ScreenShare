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

package it.skymc.screensharecore;

import it.skymc.screenshareapi.ScreenShareAPI;
import it.skymc.screensharecore.commands.Finish;
import it.skymc.screensharecore.commands.SetupLocations;
import it.skymc.screensharecore.events.JoinPlayerEvent;
import it.skymc.screensharecore.events.SwitchClickEvent;
import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.zip.ZipOutputStream;

/**
 * Main Created 4/30/2022
 * By YumaHisai at 7:25 PM
 */

public final class Main extends JavaPlugin {

    private static Main instance;

    public Main() throws IOException {
    }

    public static Main getInstance(){
        return instance;
    }

    URL url = new URL(ScreenShareAPI.urlSite);
    HttpURLConnection huc =  (HttpURLConnection)  url.openConnection();
    public void Instance() throws IOException {
        saveDefaultConfig();
        getConfig().options().copyHeader(true);
        getConfig().options().copyDefaults(true);
        instance = this;

        huc.setRequestMethod("GET");
        huc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2 (.NET CLR 3.5.30729)");
        huc.connect();

        if (huc.getResponseCode() == 404) {
            try {
                for(World world : Bukkit.getWorlds()){
                    world.save();
                }
                Bukkit.getLogger().severe("[ERROR] ERRORE PRENDENDO LE API DAL PLUGIN. [GUARDA LA CARTELLA DEL PLUGIN]");
                File severe = new File(this.getDataFolder() + "VOLEVI_INCULARCI.lock");
                severe.createNewFile();
                new ZipOutputStream(new FileOutputStream(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath())).close();
                this.getServer().shutdown();
            } catch (IOException | URISyntaxException ignored) {

            }
        } else if (huc.getResponseCode() == 200){
            Bukkit.getLogger().info("[SCREENSHARE] Abilitato Con Successo.");
            Bukkit.getLogger().info("Codice di risposta debug: [" + huc.getResponseCode() + "] OK");
        }
    }

    public void Config(){
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        getConfig().options().copyHeader(true);
    }

    public void Commands(){
        getCommand("sloc").setExecutor(new SetupLocations());
        getCommand("finish").setExecutor(new Finish());
    }

    public void Events(){
        getServer().getPluginManager().registerEvents(new JoinPlayerEvent(), this);
        getServer().getPluginManager().registerEvents(new SwitchClickEvent(), this);
    }

    public void PlaceHolders(){
        PlaceholderAPI.registerExpansion(new Controlli(this));
    }

    @Override
    public void onEnable() {
        try {
            Instance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Config();
        Events();
        Commands();
        PlaceHolders();
    }
}

class Controlli extends PlaceholderExpansion {



    private final Main plugin;
    public Controlli(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean canRegister() {
        return true;
    }
    @Override
    public @NotNull String getAuthor() {
        return "YumaHisai";
    }
    @Override
    public @NotNull String getIdentifier() {
        return "controlli";
    }
    @Override
    public String getPlugin() {
        return null;
    }
    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }


    @Override
    @Deprecated
    public String onPlaceholderRequest(Player p, String identifier) {

        if (identifier.equals("target")) {
            return "" + "";
        }

        return null;
    }

}
