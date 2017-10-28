import org.apache.log4j.Logger;

/**
 * Created by Dmitriy.Yakovlev
 * Created: 25.10.17 22:47
 * Copyright © LLP JazzSoft
 */
public class OrgArcher extends Character implements AttackArcher {

    private static final Logger log = Logger.getLogger(OrgArcher.class);

    public OrgArcher() {
        setRace(Race.Org);
        setRole(Role.OrgArcher);
    }

    //    стрелять из лука (нанесение урона 3 HP)
    public void shoot(Character character) {
        if (isPrivileged()) {
            setAttackPower(3 * 1.5);
            character.setDamageLiveValue(getAttackPower());
        } else
            setAttackPower(3);
            character.setDamageLiveValue(getAttackPower());
    }

    //    удар клинком (нанесение урона 2 HP)
    public void attackArcher(Character character) {
        if (isPrivileged()) {
            setAttackPower(2 * 1.5);
            character.setDamageLiveValue(getAttackPower());
        } else
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
        return "Лучник орг";
    }
}
