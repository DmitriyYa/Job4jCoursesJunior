/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 21:54
 * Copyright © LLP JazzSoft
 */
class ElfMag extends Character implements AttackMage {

    public ElfMag() {
        setRace(Race.Elf);
        setRole(Role.ElfMag);
    }

    //    наложение улучшения на персонажа своего отряда
    public void giveAnImprovement(Character character) {
        if (character.getRace().equals(Race.Elf)) {
            character.setPrivileged(true);
        }
    }

    //    нанесение урона персонажу противника магией на 10 HP
    public void magicAttack(Character character) {
        if (!character.getRace().equals(Race.Elf)) {
            character.setDamageLiveValue(10);
        }
    }
}
