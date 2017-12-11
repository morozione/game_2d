package morozione;

public class LevelManager {
    public static final int MAX_LEVEL = 5;

    private int level = 1;
    private int levelWall = 1;

    private static LevelManager levelManager;

    private OnLevelUpdatedListener listener;

    public interface OnLevelUpdatedListener {
        void levelUpdated();
    }

    private LevelManager() {
    }

    public static LevelManager getInstance() {
        if (levelManager == null) {
            levelManager = new LevelManager();
        }
        return levelManager;
    }

    public void addLevelListener(OnLevelUpdatedListener listener) {
        this.listener = listener;
    }

    public void crashWall() {
        levelWall++;

        if (levelWall > 5) {
            upperLevel();
            levelWall = 1;
        }
    }

    public void upperLevel() {
        level++;
        listener.levelUpdated();
    }

    public int getLevel() {
        return level;
    }

    public int getLevelWall() {
        return levelWall;
    }
}
