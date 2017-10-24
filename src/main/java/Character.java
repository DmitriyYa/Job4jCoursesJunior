/**
 * Персонаж.
 */
public abstract class Character {

    //    Начальная жизнь при создании пресонажа.
    private int liveValue = 100;

    //    Живой
    private boolean isLive = true;

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
