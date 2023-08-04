package eapli.base.AGV.modules;

public class Coordinate implements Comparable<Coordinate>{

    private final int row;
    private final int col;
    private final int dist;

    private final Coordinate parent;

    public Coordinate(final int row, final int col, final int dist, final Coordinate parent) {
        this.row = row;
        this.col = col;
        this.dist = dist;
        this.parent = parent;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getDist() {
        return dist;
    }

    public Coordinate getParent() {
        return parent;
    }

    public int compareTo(Coordinate c2){
        return Integer.compare(dist, c2.dist);
    }

    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null || obj.getClass() != Coordinate.class)
            return false;

        return row == ((Coordinate) obj).row && col == ((Coordinate) obj).col && dist == ((Coordinate) obj).dist;
    }

    public String toString(){
        return String.format("x: %d y: %d distance: %d", row, col, dist);
    }
}