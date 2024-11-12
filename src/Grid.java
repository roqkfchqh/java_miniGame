public class Grid {
    private int size;

    public Grid(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void display(Player player, Bomb bomb) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!player.isCollided(bomb)) {
                    if (i == bomb.getX() && j == bomb.getY()) {
                        System.out.print("⬛");
                    } else if (i == player.getX() && j == player.getY()) {
                        System.out.print("🐥");
                    } else {
                        System.out.print("⬛");
                    }
                } else {
                    if (i == player.getX() && j == player.getY()) {
                        System.out.print("\uD83D\uDCA5");
                    } else if (i == bomb.getX() && j == bomb.getY()) {
                        System.out.print("\uD83D\uDCA5");
                    } else {
                        System.out.print("⬛");
                    }

                }
            }System.out.println();
        }
    }
}


