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
 * Created: 25.10.17 22:37
 * Copyright © LLP JazzSoft
 */
public class ElfWar extends Character implements AttackWar {
    /**
     * Логируем действия в классе.
     */
    private static final Logger log = Logger.getLogger(ElfWar.class);

    /**
     * В конструкторе присваиваем рассу и роль.
     */
    public ElfWar() {
        setRace(Race.Elf);
        setRole(Role.ElfWar);
    }

    /**
     * атаковать мечом (нанесение урона 15 HP).
     *
     * @param character противник.
     */
    public void attackWar(Character character) {
        if (isPrivileged()) {
            setAttackPower(15 * 1.5);
            character.setDamageLiveValue(getAttackPower());
        } else {
            setAttackPower(15);
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
        this.attackWar(character);
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
        return "Воин Эльф";
    }
}
