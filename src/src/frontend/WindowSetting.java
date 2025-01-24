package src.frontend;

public class WindowSetting {

    private final int MAX_WIDTH = 1980;
    private final int MAX_HEIGHT = 1080;

    private int MEDIUM_WIDTH = 0;
    private int MEDIUM_HEIGHT = 0;

    private int MIN_WIDTH = 0;
    private int MIN_HEIGHT = 0;

    public int getMAX_WIDTH() {
        return MAX_WIDTH;
    }

    public int getMAX_HEIGHT() {
        return MAX_HEIGHT;
    }

    public int getMEDIUM_WIDTH() {
        return MEDIUM_WIDTH = MAX_WIDTH / 2;
    }

    public int getMEDIUM_HEIGHT() {
        return MEDIUM_HEIGHT = MAX_HEIGHT / 2;
    }

    public int getMIN_WIDTH() {
        return MIN_WIDTH = MAX_WIDTH / 3;
    }

    public int getMIN_HEIGHT() {
        return MIN_HEIGHT = MEDIUM_HEIGHT / 3;
    }

    @Override
    public String toString() {
        return "WindowSetting{" +
                "MAX_WIDTH=" + MAX_WIDTH +
                ", MAX_HEIGHT=" + MAX_HEIGHT +
                ", MEDIUM_WIDTH=" + MEDIUM_WIDTH +
                ", MEDIUM_HEIGHT=" + MEDIUM_HEIGHT +
                ", MIN_WIDTH=" + MIN_WIDTH +
                ", MIN_HEIGHT=" + MIN_HEIGHT +
                '}';
    }
}
