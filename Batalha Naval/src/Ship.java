public class Ship {
    private String name;
    private int size;
    private boolean[] isSunk;

    public Ship(String name, int size) {
        this.name = name;
        this.size = size;
        this.isSunk = new boolean[size];
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public boolean[] getIsSunk() {
        return isSunk;
    }

    public void hit(int index) {
        if (index >= 0 && index < size) {
            isSunk[index] = true;
        }
    }

    public boolean isSunk() {
        for (boolean hit : isSunk) {
            if (!hit) return false;
        }
        return true;
    }
}
