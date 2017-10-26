/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 23:02
 * Copyright © LLP JazzSoft
 */
public class NoLivsWar extends Character implements AttackWar {

    public NoLivsWar() {
        setRace(Race.Nolivs);
        setRole(Role.NoLivsWar);
    }

    //    удар копьем (нанесение урона 18 HP)
    public void attackWar(Character character) {
            character.setDamageLiveValue(18);
    }
}
