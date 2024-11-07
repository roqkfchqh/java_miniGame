import java.util.Scanner;
import java.util.Random;

public class miniGame {
    public static void main(String[] args) {
        Scanner movementKeys = new Scanner(System.in);
        Random randomLocation = new Random();
        // 그리드 크기
        int gridSize = 5;
        // 캐릭터와 bang 초기 위치
        int playerX = randomLocation.nextInt(gridSize);
        int playerY = randomLocation.nextInt(gridSize);
        int bangX = randomLocation.nextInt(gridSize);
        int bangY = randomLocation.nextInt(gridSize);

        // bang이벤트 bool로 생성
        boolean bang = false;

        // 겹칠 경우 do while
        do {
            playerX = randomLocation.nextInt(gridSize);
            playerY = randomLocation.nextInt(gridSize);
            bangX = randomLocation.nextInt(gridSize);
            bangY = randomLocation.nextInt(gridSize);
        } while (playerX == bangX && playerY == bangY);

        System.out.println();
            int score = 0;
            while (true) {

                bangX = randomLocation.nextInt(gridSize);
                bangY = randomLocation.nextInt(gridSize);

                try{
                    // 그리드, 캐릭터, 폭탄 위치 조정
                    for (int i = 0; i < gridSize; i++) {
                        for (int j = 0; j < gridSize; j++) {
                            if (i == playerX && j == playerY && i == bangX && j == bangY) { // 폭탄 터짐
                                System.out.print("\uD83D\uDCA5");
                                java.awt.Toolkit.getDefaultToolkit().beep();
                                bang = true;
                                break;
                            } else if (i == playerX && j == playerY) {  //폭탄이랑 안 겹친 캐릭터 위치
                                System.out.print("\uD83D\uDC25");
                                score++;
                            } else {
                                System.out.print("⬛"); // 빈 공간
                            }
                        }
                        System.out.println();
                    }
                    if(bang){
                        System.out.println("\uD83C\uDF73");
                        System.out.println("맛있는 계란후라이가 되어버렸다!!!! 당신이 움직인 횟수는 " + score);
                        System.out.println("To be Continue...");
                        break;
                    }

                    // 사용자 입력 받기 (WASD)
                    System.out.println("병아리 살리기 게임");
                    System.out.println("한글은 인식되지 않습니다. W: 위, A: 왼쪽, S: 아래, D: 오른쪽");
                    char move = movementKeys.next().toUpperCase().charAt(0);

                    // 이동
                    if (move == 'W' && playerX > 0) playerX--; // 위
                    if (move == 'S' && playerX < gridSize - 1) playerX++; // 아래
                    if (move == 'A' && playerY > 0) playerY--; // 왼
                    if (move == 'D' && playerY < gridSize - 1) playerY++; // 오

                    // 콘솔 화면 지우기
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                } catch (Exception e) {
                    System.out.println("오류가 발생했습니다. :" + e.getMessage());
                }
            }


    }

}

