import org.apache.log4j.Logger;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 23:01
 * Copyright © LLP JazzSoft
 */
public class NoLivsMag extends Character implements AttackMage {

    private static final Logger log = Logger.getLogger(NoLivsMag.class);

    public NoLivsMag() {
        setRace(Race.Nolivs);
        setRole(Role.NoLivsMag);
    }

    //    наслать недуг (уменьшение силы урона персонажа противника на 50% на один ход)
    public void giveAnImprovement(Character character) {
        if (!character.getRace().equals(Race.Nolivs)) {
            character.setAttackPower(character.getAttackPower() / 2);
        }
    }

    //    атака (нанесение урона 5 HP)
    public void magicAttack(Character character) {
        setAttackPower(5);
        character.setDamageLiveValue(getAttackPower());
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
        return "Лучник нежить";
    }
}
