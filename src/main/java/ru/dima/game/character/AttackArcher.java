package ru.dima.game.character;

/**
 * Атака лучника
 */
public interface AttackArcher {

    /**
     * стрелять.
     * @param character противник.
     */
    void shoot(Character character);


    /**
     * атаковать.
     * @param character противник.
     */
    void attackArcher(Character character);

}
