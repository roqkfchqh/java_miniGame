import java.util.Random;

public class Player {

    private int x, y;
    private Random random = new Random();

    public Player(int gridSize) {
        this.x = random.nextInt(gridSize);
        this.y = random.nextInt(gridSize);
    }

    public void move(char direction, int gridSize) {
        switch (direction) {
            case 'W': if (x > 0) x--; break;
            case 'S': if (x < gridSize - 1) x++; break;
            case 'A': if (y > 0) y--; break;
            case 'D': if (y < gridSize - 1) y++; break;
        }
    }

    public boolean isCollided(Bomb bomb) {
        return this.x == bomb.getX() && this.y == bomb.getY();
    }

    public int getX() { return x; }
    public int getY() { return y; }
}