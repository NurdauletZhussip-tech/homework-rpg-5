package com.narxoz.rpg;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.decorator.BasicAttack;
import com.narxoz.rpg.decorator.CriticalFocusDecorator;
import com.narxoz.rpg.decorator.FireRuneDecorator;
import com.narxoz.rpg.decorator.PoisonCoatingDecorator;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.facade.AdventureResult;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.hero.HeroProfile;

public class Main {
    public static void main(String[] args) {
        System.out.println("   PART 1: DECORATOR PATTERN DEMO");
        // basic attack demo
        AttackAction baseAttack = new BasicAttack("Sword Slash", 15);
        System.out.println("--- Base Attack ---");
        System.out.println("Name: " + baseAttack.getActionName());
        System.out.println("Damage: " + baseAttack.getDamage());
        System.out.println("Effects:\n" + baseAttack.getEffectSummary());
        System.out.println();

        // decorator demo
        AttackAction ultimateAttack = new BasicAttack("Sword attack", 33);
        ultimateAttack = new FireRuneDecorator(ultimateAttack);
        ultimateAttack = new PoisonCoatingDecorator(ultimateAttack);
        ultimateAttack = new CriticalFocusDecorator(ultimateAttack);

        System.out.println("Name: " + ultimateAttack.getActionName());
        System.out.println("Total Damage: " + ultimateAttack.getDamage());
        System.out.println("Effects:\n" + ultimateAttack.getEffectSummary());
        System.out.println("\n");

        System.out.println("   PART 2: FACADE PATTERN DEMO");

        //  creating dungeon entity
        HeroProfile hero = new HeroProfile("Musashi Miyamoto", 130);
        BossEnemy boss = new BossEnemy("Sasaki Kojiro", 250, 15);

        // creating facade
        DungeonFacade dungeonFacade = new DungeonFacade();
        dungeonFacade.setRandomSeed(42L);

        // run project with one point
        AdventureResult result = dungeonFacade.runAdventure(hero, boss, ultimateAttack);

        // print result
        System.out.println("DUNGEON LOG");
        for (String logLine : result.getLog()) {
            System.out.println(logLine);
        }

        System.out.println("\nDUNGEON SUMMARY");
        System.out.println("Total Rounds: " + result.getRounds());
        System.out.println("Winner: " + result.getWinner());
        System.out.println("Reward: " + result.getReward());
    }
}
