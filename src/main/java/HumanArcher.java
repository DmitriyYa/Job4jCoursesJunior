import org.apache.log4j.Logger;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 22:40
 * Copyright © LLP JazzSoft
 */
public class HumanArcher extends Character implements AttackArcher {

    private static final Logger log = Logger.getLogger(HumanArcher.class);

    public HumanArcher() {
        setRace(Race.Human);
        setRole(Role.HumanArcher);
    }

    //    стрелять из арбалета (нанесение урона 5 HP)
    public void shoot(Character character) {
            if (isPrivileged()) {
                setAttackPower(5 * 1.5);
                character.setDamageLiveValue(getAttackPower());
            } else
                setAttackPower(5);
                character.setDamageLiveValue(getAttackPower());
    }

    //     атаковать (нанесение урона 3 HP)
    public void attackArcher(Character character) {
            if (isPrivileged()) {
                character.setDamageLiveValue(3 * 1.5);
            } else
                character.setDamageLiveValue(3);
    }

    @Override
    public void makeMove(Team team, Team oponent) {
        int i = 0 + (int) (Math.random() * 2);
        Character character = oponent.getRandomLiveCharacter();
        if (i == 0) {
            this.shoot(character);
        }
        else {
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
        return "Лучник Человек";
    }
}
