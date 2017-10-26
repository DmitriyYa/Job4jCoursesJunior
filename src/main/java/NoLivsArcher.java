/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 23:01
 * Copyright © LLP JazzSoft
 */
public class NoLivsArcher extends Character implements AttackArcher {

    public NoLivsArcher() {
        setRace(Race.Nolivs);
        setRole(Role.NoLivsArcher);
    }

    //    стрелять из лука (нанесение урона 4 HP)
    public void shoot(Character character) {
            character.setDamageLiveValue(4);
    }

    //    атаковать (нанесение урона 2 HP)
    public void attackArcher(Character character) {
            character.setDamageLiveValue(2);
    }
}
