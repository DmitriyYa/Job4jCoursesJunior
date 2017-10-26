/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 22:37
 * Copyright © LLP JazzSoft
 */
public class ElfWar extends Character implements AttackWar {

    public ElfWar() {
        setRace(Race.Elf);
        setRole(Role.ElfWar);
    }

    //    атаковать мечом (нанесение урона 15 HP)
    public void attackWar(Character character) {
            if (isPrivileged()) {
                character.setDamageLiveValue(15 * 1.5);
            } else
                character.setDamageLiveValue(15);
    }
}
