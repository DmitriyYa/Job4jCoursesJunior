package ru.dima.game.character.implement;

import org.apache.log4j.Logger;
import ru.dima.game.alianse.Team;
import ru.dima.game.character.AttackWar;
import ru.dima.game.character.Character;
import ru.dima.game.character.Race;
import ru.dima.game.character.Role;
import ru.dima.game.gameoneteam.Game;
import ru.dima.game.utils.MyLog;
import ru.dima.game.utils.Random;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 22:47
 * Copyright © LLP JazzSoft
 */
public class OrgWar extends Character implements AttackWar {

    private static final Logger log = Logger.getLogger(OrgWar.class);

    public OrgWar() {
        setRace(Race.Org);
        setRole(Role.OrgWar);
    }

    //    атака дубиной (нанесение урона 20 HP)
    public void attackWar(Character character) {
        if (isPrivileged()) {
            setAttackPower(20 * 1.5);
            character.setDamageLiveValue(getAttackPower());
        } else
            setAttackPower(20);
            character.setDamageLiveValue(getAttackPower());
    }

    @Override
    public void makeMove(Team team, Team oponent) {
        int i = Random.randomInt(0, 2);
        Character character = oponent.getRandomLiveCharacter();
        this.attackWar(character);
        //        снимаем привелегию
        this.setPrivileged(false);

        //логи
        MyLog.readLog(log,Game.count,this,character,getAttackPower(),character.isLive());
        Game.count++;
    }

    @Override
    public String toString() {
        return "Воин орг";
    }
}
