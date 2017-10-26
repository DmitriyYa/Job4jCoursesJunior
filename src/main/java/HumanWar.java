/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 22:41
 * Copyright © LLP JazzSoft
 */
public class HumanWar extends Character implements AttackWar {
    public HumanWar() {
        setRace(Race.Human);
        setRole(Role.HumanWar);
    }

    //    атаковать мечом (нанесение урона 18 HP)
    public void attackWar(Character character) {
            if (isPrivileged()) {
                character.setDamageLiveValue(18 * 1.5);
            } else
                character.setDamageLiveValue(18);
    }
}
