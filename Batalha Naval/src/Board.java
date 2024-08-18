public class Board {
    private Ship[][] grid;
    private int size;

    public Board(int size) {
        this.size = size;
        this.grid = new Ship[size][size];
    }

    public int getSize() {
        return size;
    }

    public void placeShip(Ship ship, int row, int col, boolean horizontal) {
        for (int i = 0; i < ship.getSize(); i++) {
            if (horizontal) {
                if (col + i >= size) throw new IllegalArgumentException("Ship placement out of bounds.");
                grid[row][col + i] = ship;
            } else {
                if (row + i >= size) throw new IllegalArgumentException("Ship placement out of bounds.");
                grid[row + i][col] = ship;
            }
        }
    }

    public String attack(int row, int col) {
        if (grid[row][col] != null) {
            Ship ship = grid[row][col];
            int index = 0; // Placeholder for accurate indexing
            ship.hit(index);
            return ship.getName();
        }
        return null;
    }

    public boolean isGameOver() {
        for (Ship[] row : grid) {
            for (Ship ship : row) {
                if (ship != null && !ship.isSunk()) return false;
            }
        }
        return true;
    }
}
