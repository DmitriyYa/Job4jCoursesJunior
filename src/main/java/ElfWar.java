import org.apache.log4j.Logger;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 22:37
 * Copyright © LLP JazzSoft
 */
public class ElfWar extends Character implements AttackWar {
    private static final Logger log = Logger.getLogger(ElfWar.class);

    public ElfWar() {
        setRace(Race.Elf);
        setRole(Role.ElfWar);
    }

    //    атаковать мечом (нанесение урона 15 HP)
    public void attackWar(Character character) {
            if (isPrivileged()) {
                setAttackPower(15 * 1.5);
                character.setDamageLiveValue(getAttackPower());
            } else
                setAttackPower(15);
                character.setDamageLiveValue(getAttackPower());
    }

    @Override
    public void makeMove(Team team, Team oponent) {
        int i = 0 + (int) (Math.random() * 2);
        Character character = oponent.getRandomLiveCharacter();
        this.attackWar(character);
        //        снимаем привелегию
        this.setPrivileged(false);

        //логи
        if (character.isLive()) {
            System.out.println("Ход - " + Game.count + ", атаковал - " + this + ", кого - " + character + ", нанес урон - " + getAttackPower());
            log.info("Ход - " + Game.count + ", атаковал - " + this + ", кого - " + character + ", нанес урон - " + getAttackPower());
        }
        else {
            System.out.println("Ход - " + Game.count + ", атаковал - " + this + ", кого - " + character + ", нанес урон - " + getAttackPower()+" он умер!");
            log.info("Ход - " + Game.count + ", атаковал - " + this + ", кого - " + character + ", нанес урон - " + getAttackPower()+" он умер!");
        }

        Game.count++;
    }

    @Override
    public String toString() {
        return "Воин Эльф";
    }
}
