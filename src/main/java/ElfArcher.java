import org.apache.log4j.Logger;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 22:26
 * Copyright © LLP JazzSoft
 */
public class ElfArcher extends Character implements AttackArcher {

    private static final Logger log = Logger.getLogger(ElfArcher.class);

    public ElfArcher() {
        setRace(Race.Elf);
        setRole(Role.ElfArcher);
    }

    //стрелять из лука (нанесение урона 7 HP)
    public void shoot(Character character) {
        if (isPrivileged()) {
            setAttackPower(7 * 1.5);
            character.setDamageLiveValue(getAttackPower());
        } else
            setAttackPower(7);
        character.setDamageLiveValue(getAttackPower());
    }

    //    атаковать противника (нанесение урона 3 HP)
    public void attackArcher(Character character) {
        if (isPrivileged()) {
            setAttackPower(3 * 1.5);
            character.setDamageLiveValue(getAttackPower());
        } else
            setAttackPower(3);
        character.setDamageLiveValue(getAttackPower());
    }

    @Override
    public void makeMove(Team team, Team oponent) {
        int i = (int) 0 + (int) (Math.random() * 2);
        Character character = oponent.getRandomLiveCharacter();
        if (i == 0) {
            this.shoot(character);
        } else {
            this.attackArcher(character);
        }
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
        return "Лучник Эльф";
    }
}
