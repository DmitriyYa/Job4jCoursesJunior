import org.apache.log4j.Logger;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 22:47
 * Copyright © LLP JazzSoft
 */
public class OrgWar extends Character implements AttackWar {

    private static final Logger log = Logger.getLogger(OrgWar.class);

    public OrgWar() {
        setRace(Race.Org);
        setRole(Role.OrgWar);
    }

    //    атака дубиной (нанесение урона 20 HP)
    public void attackWar(Character character) {
        if (isPrivileged()) {
            setAttackPower(20 * 1.5);
            character.setDamageLiveValue(getAttackPower());
        } else
            setAttackPower(20);
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
        return "Воин орг";
    }
}
