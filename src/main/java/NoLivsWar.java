import org.apache.log4j.Logger;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 23:02
 * Copyright © LLP JazzSoft
 */
public class NoLivsWar extends Character implements AttackWar {

    private static final Logger log = Logger.getLogger(NoLivsWar.class);

    public NoLivsWar() {
        setRace(Race.Nolivs);
        setRole(Role.NoLivsWar);
    }

    //    удар копьем (нанесение урона 18 HP)
    public void attackWar(Character character) {
        setAttackPower(18);
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
        return "Воин нежить";
    }
}
