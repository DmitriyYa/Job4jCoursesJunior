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
 * Created: 25.10.17 22:26
 * Copyright © LLP JazzSoft
 */
public class ElfArcher extends Character implements AttackArcher {

    private static final Logger log = Logger.getLogger(ElfArcher.class);

    public ElfArcher() {
        setRace(Race.Elf);
        setRole(Role.ElfArcher);
    }

    //стрелять из лука (нанесение урона 7 HP)
    public void shoot(Character character) {
        if (isPrivileged()) {
            setAttackPower(7 * 1.5);
            character.setDamageLiveValue(getAttackPower());
        } else
            setAttackPower(7);
        character.setDamageLiveValue(getAttackPower());
    }

    //    атаковать противника (нанесение урона 3 HP)
    public void attackArcher(Character character) {
        if (isPrivileged()) {
            setAttackPower(3 * 1.5);
            character.setDamageLiveValue(getAttackPower());
        } else
            setAttackPower(3);
        character.setDamageLiveValue(getAttackPower());
    }

    @Override
    public void makeMove(Team team, Team oponent) {
        int i = Random.randomInt(0, 2);
        Character character = oponent.getRandomLiveCharacter();
        if (i == 0) {
            this.shoot(character);
        } else {
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
        return "Лучник Эльф";
    }
}
