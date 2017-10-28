import org.apache.log4j.Logger;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 22:40
 * Copyright © LLP JazzSoft
 */
public class HumanMag extends Character implements AttackMage {

    private static final Logger log = Logger.getLogger(HumanMag.class);

    public HumanMag() {
        setRace(Race.Human);
        setRole(Role.HumanMag);
    }

    //    наложение улучшения на персонажа своего отряда.
    public void giveAnImprovement(Character character) {
        if (character.getRace().equals(Race.Human)) {
            character.setPrivileged(true);
        }
    }

    //    атаковать магией (нанесение урона 4 HP)
    public void magicAttack(Character character) {
        setAttackPower(4);
        if (!character.getRace().equals(Race.Human)) {
            character.setDamageLiveValue(getAttackPower());
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
        return "Маг Человек";
    }
}
