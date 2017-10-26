/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 22:47
 * Copyright © LLP JazzSoft
 */
public class OrgWar extends Character implements AttackWar {

    public OrgWar() {
        setRace(Race.Org);
        setRole(Role.OrgWar);
    }

    //    атака дубиной (нанесение урона 20 HP)
    public void attackWar(Character character) {
        if (isPrivileged()) {
            character.setDamageLiveValue(20 * 1.5);
        } else
            character.setDamageLiveValue(20);
    }
}
