import org.apache.log4j.Logger;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 23:01
 * Copyright © LLP JazzSoft
 */
public class NoLivsArcher extends Character implements AttackArcher {

    private static final Logger log = Logger.getLogger(NoLivsArcher.class);

    public NoLivsArcher() {
        setRace(Race.Nolivs);
        setRole(Role.NoLivsArcher);
    }

    //    стрелять из лука (нанесение урона 4 HP)
    public void shoot(Character character) {
        setAttackPower(4);
        character.setDamageLiveValue(getAttackPower());
    }

    //    атаковать (нанесение урона 2 HP)
    public void attackArcher(Character character) {
        setAttackPower(2);
        character.setDamageLiveValue(getAttackPower());
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
        return "Лучник нежить";
    }
}
