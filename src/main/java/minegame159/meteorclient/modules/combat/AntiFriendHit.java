/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client/).
 * Copyright (c) 2021 Meteor Development.
 */

package minegame159.meteorclient.modules.combat;

//Created by squidoodly 16/07/2020
// Not empty class anymore :bruh: - notseanbased

import meteordevelopment.orbit.EventHandler;
import minegame159.meteorclient.events.entity.player.AttackEntityEvent;
import minegame159.meteorclient.friends.FriendManager;
import minegame159.meteorclient.modules.Category;
import minegame159.meteorclient.modules.Module;
import minegame159.meteorclient.modules.ModuleManager;
import net.minecraft.entity.player.PlayerEntity;

public class AntiFriendHit extends Module {
    public AntiFriendHit() {
        super(Category.Combat, "anti-friend-hit", "Cancels out attacks that would hit friends.");
    }

    @EventHandler
    private void onAttackEntity(AttackEntityEvent event) {
        if (event.entity instanceof PlayerEntity && ModuleManager.INSTANCE.get(AntiFriendHit.class).isActive() && !FriendManager.INSTANCE.attack((PlayerEntity) event.entity)) event.cancel();
    }
}
