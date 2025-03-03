package hw3;

public class Cargo {
    private int distance;
    private boolean isBig;
    private boolean isFragile;

    public Cargo(int distance, boolean isBig, boolean isFragile) {
        this.distance = distance;
        this.isBig = isBig;
        this.isFragile = isFragile;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isBig() {
        return isBig;
    }

    public boolean isFragile() {
        return isFragile;
    }

    @Override
    public String toString() {
        return "Distance=" + distance +
                ", isBig=" + isBig +
                ", isFragile=" + isFragile;
    }
}
