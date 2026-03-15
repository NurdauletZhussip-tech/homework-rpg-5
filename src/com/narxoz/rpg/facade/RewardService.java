package com.narxoz.rpg.facade;

public class RewardService {
    public String determineReward(AdventureResult battleResult) {
        if (battleResult == null||battleResult.getWinner()==null) {
            return "battle reward is unknown";
        }
        if(battleResult.getWinner().equalsIgnoreCase("Hero")){return "67 gold coins and epic chest";}
        else{return "you were defeated";}
}}
