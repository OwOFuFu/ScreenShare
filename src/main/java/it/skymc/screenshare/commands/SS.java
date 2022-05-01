package it.skymc.screenshare.commands;

import it.skymc.screenshare.utils.Format;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * SS Created 4/30/2022
 * By YumaHisai at 6:20 PM
 */

public class SS extends Command {
    public SS(String name) {
        super("ss");
    }

    public SS(String name, String permission, String... aliases) {
        super("ss", "skymc.command.ss", "controllo");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        ProxiedPlayer player = (ProxiedPlayer) sender;
        ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
        ServerInfo scontrolli = ProxyServer.getInstance().getServerInfo("controlli");

        if(args.length == 0){
            player.sendMessage(Format.color("&e&lUSA &6/&ess &7<&6utente&7> &7# Manda nel server controlli."));
        }

        if(args.length >= 1){
            target.connect(scontrolli);
            player.connect(scontrolli);
            player.sendMessage(Format.color("&e&lCONTROLLI &eSei andato nel server controllo insieme a &7[&6" + target.getName() + "&7]"));
        }

    }
}
