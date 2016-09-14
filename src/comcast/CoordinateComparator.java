package comcast;

import java.util.Comparator;

public class CoordinateComparator implements Comparator<Coordinate> {
    public int compare(Coordinate a, Coordinate b) {
        double dista = a.getDist();
        double distb = b.getDist();

        if (dista > distb) {
            return 1;

        } else if (dista == distb) {
            return 0;

        } else {
            return -1;

        }
    }
}

