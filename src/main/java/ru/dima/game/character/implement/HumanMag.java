package ru.dima.game.character.implement;

import org.apache.log4j.Logger;
import ru.dima.game.alianse.Team;
import ru.dima.game.character.AttackMage;
import ru.dima.game.character.Character;
import ru.dima.game.character.Race;
import ru.dima.game.character.Role;
import ru.dima.game.gameoneteam.Game;
import ru.dima.game.utils.MyLog;
import ru.dima.game.utils.Random;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 22:40
 * Copyright © LLP JazzSoft
 */
public class HumanMag extends Character implements AttackMage {

    private static final Logger log = Logger.getLogger(HumanMag.class);

    public HumanMag() {
        setRace(Race.Human);
        setRole(Role.HumanMag);
    }

    //    наложение улучшения на персонажа своего отряда.
    public void giveAnImprovement(Character character) {
        if (character.getRace().equals(Race.Human)) {
            character.setPrivileged(true);
        }
    }

    //    атаковать магией (нанесение урона 4 HP)
    public void magicAttack(Character character) {
        setAttackPower(4);
        if (!character.getRace().equals(Race.Human)) {
            character.setDamageLiveValue(getAttackPower());
        }
    }

    @Override
    public void makeMove(Team team, Team oponent) {
        int i = Random.randomInt(0, 2);
        Character characterTeam = team.getRandomLiveCharacter();
        Character characterOponent = oponent.getRandomLiveCharacter();
        if (i == 0) {
            this.giveAnImprovement(characterTeam);
        }
        else {
            this.magicAttack(characterOponent);
        }

        //логи
        MyLog.readLog(log,Game.count,this,characterOponent,getAttackPower(),characterOponent.isLive());
        Game.count++;
    }

    @Override
    public String toString() {
        return "Маг Человек";
    }
}