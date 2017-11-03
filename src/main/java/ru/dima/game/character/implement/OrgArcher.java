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
 * Created: 25.10.17 22:47
 * Copyright © LLP JazzSoft
 */
public class OrgArcher extends Character implements AttackArcher {
    /**
     * Логируем действия в классе.
     */
    private static final Logger log = Logger.getLogger(OrgArcher.class);

    /**
     * В конструкторе присваиваем рассу и роль.
     */
    public OrgArcher() {
        setRace(Race.Org);
        setRole(Role.OrgArcher);
    }

    /**
     * стрелять из лука (нанесение урона 3 HP).
     *
     * @param character противник.
     */
    public void shoot(Character character) {
        if (isPrivileged()) {
            setAttackPower(3 * 1.5);
            character.setDamageLiveValue(getAttackPower());
        } else {
            setAttackPower(3);
            character.setDamageLiveValue(getAttackPower());
        }
    }

    /**
     * удар клинком (нанесение урона 2 HP).
     *
     * @param character противник.
     */
    public void attackArcher(Character character) {
        if (isPrivileged()) {
            setAttackPower(2 * 1.5);
            character.setDamageLiveValue(getAttackPower());
        } else {
            setAttackPower(2);
            character.setDamageLiveValue(getAttackPower());
        }
    }

    /**
     * @param team    команда нападающего.
     * @param oponent команда противника.
     */
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
        MyLog.readLog(log, Game.count, this, character, getAttackPower(), character.isLive());
        Game.count++;
    }

    /**
     * @return возвращаем рассу и роль персонажа.
     */
    @Override
    public String toString() {
        return "Лучник орг";
    }
}
