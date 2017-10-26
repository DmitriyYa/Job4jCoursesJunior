/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 22:26
 * Copyright © LLP JazzSoft
 */
public class ElfArcher extends Character implements AttackArcher {


    public ElfArcher() {
        setRace(Race.Elf);
        setRole(Role.ElfArcher);
    }

    //стрелять из лука (нанесение урона 7 HP)
    public void shoot(Character character) {
        if (isPrivileged()) {
            character.setDamageLiveValue(7 * 1.5);
        } else
            character.setDamageLiveValue(7);
    }

    //    атаковать противника (нанесение урона 3 HP)
    public void attackArcher(Character character) {
            if (isPrivileged()) {
                character.setDamageLiveValue(3 * 1.5);
            } else
                character.setDamageLiveValue(3);
    }
}
