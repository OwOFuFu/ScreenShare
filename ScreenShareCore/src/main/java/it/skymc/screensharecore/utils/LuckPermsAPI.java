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

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
import net.luckperms.api.node.Node;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * LuckPermsAPI Created 4/30/2022
 * By YumaHisai at 7:24 PM
 */
public class LuckPermsAPI {

    public LuckPerms api = LuckPermsProvider.get();

    public User user(Player player){
        return api.getPlayerAdapter(Player.class).getUser(player);
    }

    public User getUser(UUID uniqueId) {
        UserManager userManager = api.getUserManager();
        CompletableFuture<User> userFuture = userManager.loadUser(uniqueId);

        return userFuture.join();
    }

    public boolean isGroup(UUID uniqueId, String group) {
        User user = (User) api.getUserManager().loadUser(uniqueId);

        Collection<Group> inheritedGroups = user.getInheritedGroups(user.getQueryOptions());
        return inheritedGroups.stream().anyMatch(g -> g.getName().equals(group));
    }

    public void addPermission(User user, String permission) {

        user.data().add(Node.builder(permission).build());

        api.getUserManager().saveUser(user);
    }

    public boolean hasPermission(User user, String permission) {
        return user.getCachedData().getPermissionData().checkPermission(permission).asBoolean();
    }


    public String getPrefixGroup(Player player){
        return api.getGroupManager().getGroup(api.getUserManager().getUser(player.getUniqueId()).getPrimaryGroup()).getCachedData().getMetaData().getPrefix();
    }

    public User getUser(Player player){
        return api.getPlayerAdapter(Player.class).getUser(player);
    }

}
