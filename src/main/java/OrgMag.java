import org.apache.log4j.Logger;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 22:46
 * Copyright © LLP JazzSoft
 */
public class OrgMag extends Character implements AttackMage {

    private static final Logger log = Logger.getLogger(OrgMag.class);

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

    @Override
    public void makeMove(Team team, Team oponent) {
        int i = 0 + (int) (Math.random() * 2);
        Character characterTeam = team.getRandomLiveCharacter();
        Character characterOponent = oponent.getRandomLiveCharacter();
        if (i == 0) {
            this.giveAnImprovement(characterTeam);
        }
        else {
            this.magicAttack(characterOponent);
        }

        //логи
        if (characterOponent.isLive()) {
            System.out.println("Ход - " + Game.count + ", атаковал - " + this + ", кого - " + characterOponent + ", нанес урон - " + getAttackPower());
            log.info("Ход - " + Game.count + ", атаковал - " + this + ", кого - " + characterOponent + ", нанес урон - " + getAttackPower());
        }
        else {
            System.out.println("Ход - " + Game.count + ", атаковал - " + this + ", кого - " + characterOponent + ", нанес урон - " + getAttackPower()+" он умер!");
            log.info("Ход - " + Game.count + ", атаковал - " + this + ", кого - " + characterOponent + ", нанес урон - " + getAttackPower()+" он умер!");
        }

        Game.count++;
    }
    @Override
    public String toString() {
        return "Маг орг";
    }
}
