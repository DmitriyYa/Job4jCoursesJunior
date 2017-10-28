import org.apache.log4j.Logger;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 21:54
 * Copyright © LLP JazzSoft
 */
class ElfMag extends Character implements AttackMage {
    private static final Logger log = Logger.getLogger(ElfMag.class);

    public ElfMag() {
        setRace(Race.Elf);
        setRole(Role.ElfMag);
    }

    //    наложение улучшения на персонажа своего отряда
    public void giveAnImprovement(Character character) {
        if (character.getRace().equals(Race.Elf)) {
            character.setPrivileged(true);
        }
    }

    //    нанесение урона персонажу противника магией на 10 HP
    public void magicAttack(Character character) {
        setAttackPower(10);
        if (!character.getRace().equals(Race.Elf)) {
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
        return "Маг Эльф";
    }
}
