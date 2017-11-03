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
 * Created: 25.10.17 23:01
 * Copyright © LLP JazzSoft
 */
public class NoLivsMag extends Character implements AttackMage {
    /**
     * Логируем действия в классе.
     */
    private static final Logger log = Logger.getLogger(NoLivsMag.class);

    /**
     * В конструкторе присваиваем рассу и роль.
     */
    public NoLivsMag() {
        setRace(Race.Nolivs);
        setRole(Role.NoLivsMag);
    }

    /**
     * наслать недуг (уменьшение силы урона персонажа противника на 50% на один ход).
     * @param character противник.
     */
    public void giveAnImprovement(Character character) {
        if (!character.getRace().equals(Race.Nolivs)) {
            character.setAttackPower(character.getAttackPower() / 2);
        }
    }

    /**
     * атака (нанесение урона 5 HP).
     * @param character противник.
     */
    public void magicAttack(Character character) {
        setAttackPower(5);
        character.setDamageLiveValue(getAttackPower());
    }

    /**
     * @param team    команда нападающего.
     * @param oponent команда противника.
     */
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

    /**
     * @return возвращаем рассу и роль персонажа.
     */
    @Override
    public String toString() {
        return "Лучник нежить";
    }
}
