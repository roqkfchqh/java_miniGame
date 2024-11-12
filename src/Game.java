import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    private Grid grid;
    private Player player;
    private Bomb bomb;
    private int score;
    private boolean gameOver;

    public Game(int gridSize) {
        this.grid = new Grid(gridSize);
        this.player = new Player(gridSize);
        this.bomb = new Bomb(gridSize);
        this.score = 0;
        this.gameOver = false;
    }

    public void start()   {
        System.out.println("보이지 않는 폭탄을 피해 최대한 오래 살아남으세요!");
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            grid.display(player, bomb);
            System.out.println("점수: " + score);
            System.out.print("이동(WASD, 한글 불가능): ");
            char move = scanner.next().toUpperCase().charAt(0);

            player.move(move, grid.getSize());
            bomb.moveRandom(grid.getSize());

                if (player.isCollided(bomb)) {
                    grid.display(player, bomb);
                    System.out.println("\uD83C\uDF73 앗! 계란후라이가 되었다..");
                    gameOver = true;
                } else {
                    score++;
                }

            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        System.out.println("최종 점수: " + score);
        System.out.println("게임 종료");
    }
}
