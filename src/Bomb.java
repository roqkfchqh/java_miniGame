import java.util.Random;

public class Bomb {
    private int x, y;
    private Random random = new Random();

    public Bomb(int gridSize) {
        relocate(gridSize);
    }

    public void moveRandom(int gridSize) {
        relocate(gridSize);
    }

    public void relocate(int gridSize) {
        this.x = random.nextInt(gridSize);
        this.y = random.nextInt(gridSize);
    }

    public int getX() { return x; }
    public int getY() { return y; }
}
