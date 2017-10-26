/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 22:46
 * Copyright © LLP JazzSoft
 */
public class OrgMag extends Character implements AttackMage {
    public OrgMag() {
        setRace(Race.Org);
        setRole(Role.OrgMag);
    }

    //наложение улучшения на персонажа своего отряда.
    public void giveAnImprovement(Character character) {
        if (character.getRace().equals(Race.Org)) {
            character.setPrivileged(true);
        }
    }

    //наложение проклятия (снятие улучшения с персонажа противника для следующего хода)
    public void magicAttack(Character character) {
        if (!character.getRace().equals(Race.Org)) {
            character.setPrivileged(false);
        }
    }
}
