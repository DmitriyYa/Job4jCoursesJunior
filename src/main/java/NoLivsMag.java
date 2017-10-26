/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 23:01
 * Copyright © LLP JazzSoft
 */
public class NoLivsMag extends Character implements AttackMage {

    public NoLivsMag() {
        setRace(Race.Nolivs);
        setRole(Role.NoLivsMag);
    }

    //    наслать недуг (уменьшение силы урона персонажа противника на 50% на один ход)
    public void giveAnImprovement(Character character) {
        if (!character.getRace().equals(Race.Nolivs)) {
            character.setAttackPower(character.getAttackPower() / 2);
        }
    }

    //    атака (нанесение урона 5 HP)
    public void magicAttack(Character character) {
            character.setDamageLiveValue(5);
    }
}
