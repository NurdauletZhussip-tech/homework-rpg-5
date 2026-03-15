package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

public class PreparationService {
    public String prepare(HeroProfile hero, BossEnemy boss, AttackAction action) {
        if (hero == null || boss == null || action == null) {
            return "Failed: Missing hero, boss, or action!";        }
        return "success:"+hero.getName()+"is entering the dungeon to face"+boss.getName()+
                " armed with ["+action.getActionName()+"].";
    }
}
