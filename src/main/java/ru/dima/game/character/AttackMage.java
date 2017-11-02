package ru.dima.game.character;

/**
 * Атака мага
 */

public interface AttackMage {

    /**
     * Дать улучшение
     */
    void giveAnImprovement(Character character);

    /**
     * Атакавать магией
     */
    void magicAttack(Character character);
}
