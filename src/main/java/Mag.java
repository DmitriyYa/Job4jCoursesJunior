public class Mag  {

    //    Начальная жизнь при создании пресонажа.
    private int liveValue = 100;

    //    Живой
    private boolean isLive = true;

    //    привелегированный
    private boolean isPrivileged = false;

    public boolean isPrivileged() {
        return isPrivileged;
    }

    public void setPrivileged(boolean privileged) {
        isPrivileged = privileged;
    }

    /**
     * @return оставшаяся жизнь
     */
    public int getLiveValue() {
        return liveValue;
    }

    /**
     * @param damage - урон наносимый противником
     */
    public void setLiveValue(int damage) {
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
}
