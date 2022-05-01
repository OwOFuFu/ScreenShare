package it.skymc.screenshareapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class ScreenShareAPI extends JavaPlugin {

    public static String urlSite = "https://yumahisai.cf/api/ScreenShareAPI.jar";

    URL url = new URL(urlSite);
    HttpURLConnection huc =  (HttpURLConnection)  url.openConnection();

    public ScreenShareAPI() throws IOException {
    }

    @Override
    public void onEnable() {
        try {
            if(huc.getResponseCode() == 200){
                Bukkit.getLogger().info("[YUMA-API] Successfully Enabled");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
