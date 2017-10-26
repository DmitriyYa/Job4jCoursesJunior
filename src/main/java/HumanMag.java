/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 22:40
 * Copyright © LLP JazzSoft
 */
public class HumanMag extends Character implements AttackMage {
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
        if (!character.getRace().equals(Race.Human)) {
            character.setDamageLiveValue(4);
        }
    }
}
