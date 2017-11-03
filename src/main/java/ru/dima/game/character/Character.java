package ru.dima.game.character;

import ru.dima.game.alianse.Team;

/**
 * Персонаж.
 */
public abstract class Character {

    /**
     * Начальная жизнь при создании пресонажа.
     */
    private double liveValue = 100;

    /**
     * Живой.
     */
    private boolean isLive = true;

    /**
     * привелегированный.
     */
    private boolean isPrivileged = false;

    /**
     * расса.
     */
    private Race race;

    /**
     * сила атаки.
     */
    private double attackPower;

    /**
     * роль.
     */
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }



    public double getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(double attackPower) {
        this.attackPower = attackPower;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public boolean isPrivileged() {
        return isPrivileged;
    }

    public void setPrivileged(boolean privileged) {
        isPrivileged = privileged;
    }

    /**
     * @return оставшаяся жизнь
     */
    public double getLiveValue() {
        return liveValue;
    }

    /**
     * @param damage - урон наносимый противником
     */
    public void setDamageLiveValue(double damage) {
        this.liveValue = this.liveValue - damage;
        if (this.liveValue < 0) {
            isLive = false;
        }
    }

    /**
     * @return жив или нет.
     */
    public boolean isLive() {
        return isLive;
    }

    /**
     * сделать ход
     * @param team команда нападающего
     * @param oponent команда противника
     */
    public abstract void makeMove(Team team, Team oponent);
}
