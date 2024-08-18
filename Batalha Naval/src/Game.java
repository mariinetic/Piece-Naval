import java.util.Scanner;

public class Game {
    private Board board;
    private Scanner scanner;

    public Game(int boardSize) {
        board = new Board(boardSize);
        scanner = new Scanner(System.in);
    }

    public void start() {
        placeShips();
        while (!board.isGameOver()) {
            System.out.println("Digite a linha e a coluna para atacar (0 a " + (board.getSize() - 1) + "):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            String shipName = board.attack(row, col);
            if (shipName != null) {
                System.out.println("Acertou o " + shipName + "!");
            } else {
                System.out.println("Água!");
            }
        }
        System.out.println("Parabéns! Você afundou todos os navios.");
    }

    private void placeShips() {
        // Adicionando navios com os nomes solicitados
        Ship ship1 = new Ship("Navio do Luffy", 4);
        board.placeShip(ship1, 1, 1, true); // Horizontal

        Ship ship2 = new Ship("Navio da Nami", 3);
        board.placeShip(ship2, 5, 3, false); // Vertical

        Ship ship3 = new Ship("Navio do Zoro", 2);
        board.placeShip(ship3, 7, 7, true); // Horizontal

        Ship ship4 = new Ship("Navio do Usopp", 3);
        board.placeShip(ship4, 3, 0, true); // Horizontal

        Ship ship5 = new Ship("Navio do Sanji", 4);
        board.placeShip(ship5, 6, 4, false); // Vertical

        Ship ship6 = new Ship("Navio da Robin", 2);
        board.placeShip(ship6, 8, 8, true); // Horizontal
    }

    public static void main(String[] args) {
        Game game = new Game(10); // Tabuleiro 10x10
        game.start();
    }
}
