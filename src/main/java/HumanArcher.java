/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 22:40
 * Copyright © LLP JazzSoft
 */
public class HumanArcher extends Character implements AttackArcher {
    public HumanArcher() {
        setRace(Race.Human);
        setRole(Role.HumanArcher);
    }

    //    стрелять из арбалета (нанесение урона 5 HP)
    public void shoot(Character character) {
            if (isPrivileged()) {
                character.setDamageLiveValue(5 * 1.5);
            } else
                character.setDamageLiveValue(5);
    }

    //     атаковать (нанесение урона 3 HP)
    public void attackArcher(Character character) {
            if (isPrivileged()) {
                character.setDamageLiveValue(3 * 1.5);
            } else
                character.setDamageLiveValue(3);
    }
}
