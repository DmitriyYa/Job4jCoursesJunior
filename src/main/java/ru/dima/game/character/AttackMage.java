package ru.dima.game.character;

/**
 * Атака мага
 */

public interface AttackMage {


    /** Дать улучшение.
     * @param character свой персонаж.
     */
    void giveAnImprovement(Character character);


    /**
     * атакавать магией.
     * @param character противник.
     */
    void magicAttack(Character character);
}
