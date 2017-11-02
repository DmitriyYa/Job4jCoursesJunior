package ru.dima.game.character.implement;

import org.apache.log4j.Logger;
import ru.dima.game.alianse.Team;
import ru.dima.game.character.AttackArcher;
import ru.dima.game.character.Character;
import ru.dima.game.character.Race;
import ru.dima.game.character.Role;
import ru.dima.game.gameoneteam.Game;
import ru.dima.game.utils.MyLog;
import ru.dima.game.utils.Random;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 23:01
 * Copyright © LLP JazzSoft
 */
public class NoLivsArcher extends Character implements AttackArcher {

    private static final Logger log = Logger.getLogger(NoLivsArcher.class);

    public NoLivsArcher() {
        setRace(Race.Nolivs);
        setRole(Role.NoLivsArcher);
    }

    //    стрелять из лука (нанесение урона 4 HP)
    public void shoot(Character character) {
        setAttackPower(4);
        character.setDamageLiveValue(getAttackPower());
    }

    //    атаковать (нанесение урона 2 HP)
    public void attackArcher(Character character) {
        setAttackPower(2);
        character.setDamageLiveValue(getAttackPower());
    }

    @Override
    public void makeMove(Team team, Team oponent) {
        int i = Random.randomInt(0, 2);
        Character character = oponent.getRandomLiveCharacter();
        if (i == 0) {
            this.shoot(character);
        }
        else {
            this.attackArcher(character);
        }
        //        снимаем привелегию
        this.setPrivileged(false);

        //логи
        MyLog.readLog(log,Game.count,this,character,getAttackPower(),character.isLive());
        Game.count++;
    }

    @Override
    public String toString() {
        return "Лучник нежить";
    }
}
