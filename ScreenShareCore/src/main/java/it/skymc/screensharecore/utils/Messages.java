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

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Messages Created 4/30/2022
 * By YumaHisai at 7:25 PM
 */

public class Messages {
    Format format = new Format();
    public void noPerms(Player player){
        player.sendMessage(format.color("&c&l[!] &cAccesso Negato in caso tu pensi di avere il permesso di utilizzare questo comando contatta un Superiore &4&l/discord"));
    }

    public void setUsage(Player player){
        player.sendMessage(format.color("&e&lUSA &6/&esloc &6<&esospetto&6/&estaffer&6> &7# Imposta gli spawn controllo"));
    }

    public void messageSospettoTeleport(Player player){
        player.sendMessage(format.color("&c&lATTENZIONE Sei stato messo sotto controllo \n &cper prima cosa esegui questi passaggi \n &c1) Scarica AnyDesk \n &chttps://anydesk.com/it/ \n &c2) Fornisci il codice di 9 cifre di AnyDesk allo staffer \n &c3) Per ultima cosa non sloggare questo comporta il &c&lBAN"));
    }

    public void locationSet(Player player){
        player.sendMessage(format.color("&aZona Impostata Con Successo..."));
    }

    public void commandBlocked(CommandSender player){
        player.sendMessage(format.color("&c[!] Comando Bloccato In Console."));
    }

}
