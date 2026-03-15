package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

import java.util.Random;

public class BattleService {
    private Random random = new Random(1L);

    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {
        AdventureResult result=new AdventureResult();
        int rounds=0;
        result.addLine("battle begin");
        result.addLine(hero.getName()+"(HP:"+hero.getHealth()+")VS"+boss.getName()+"(HP:"+boss.getHealth()+")");

        while (hero.isAlive() && boss.isAlive()){
            rounds++;
            result.addLine("\n--- Round "+rounds+" ---");

            int heroDamage = action.getDamage();
            boss.takeDamage(heroDamage);
            result.addLine(hero.getName()+" attacks with "+action.getActionName());
            result.addLine("It deals "+heroDamage+" damage. "+boss.getName()+"has"+boss.getHealth() + " HP left.");

            if(!boss.isAlive()){
                result.addLine(boss.getName()+"is defeated");
                break;
            }
            int randomBonus = random.nextInt(5);
            int bossDamage = boss.getAttackPower() + randomBonus;

            hero.takeDamage(bossDamage);
            result.addLine(boss.getName()+" strikes back for "+bossDamage+" damage");
            result.addLine(hero.getName()+" has "+hero.getHealth()+" HP left.");

            if(!hero.isAlive()){
                result.addLine(hero.getName()+" collapses...");
                break;
            }
        }
        result.setRounds(rounds);

        if(hero.isAlive()){
            result.setWinner("Hero");
            result.addLine("\nhero wins");
        }else{
            result.setWinner("Boss");
            result.addLine("\nboss wins");
        }
        return result;
    }
}
