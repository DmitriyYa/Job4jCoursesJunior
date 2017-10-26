/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 22:47
 * Copyright © LLP JazzSoft
 */
public class OrgArcher extends Character implements AttackArcher {

    public OrgArcher() {
        setRace(Race.Org);
        setRole(Role.OrgArcher);
    }

    //    стрелять из лука (нанесение урона 3 HP)
    public void shoot(Character character) {
        if (isPrivileged()) {
            character.setDamageLiveValue(3 * 1.5);
        } else
            character.setDamageLiveValue(3);
    }

    //    удар клинком (нанесение урона 2 HP)
    public void attackArcher(Character character) {
        if (isPrivileged()) {
            character.setDamageLiveValue(2 * 1.5);
        } else
            character.setDamageLiveValue(2);
    }
}
