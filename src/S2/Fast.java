package S2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;


public class Fast {


    private static void collinearOutput(Point[] points, int q, int r) {
        StdOut.printf(points[0].toString() + " -> ");
        Arrays.sort(points, q, r);
        for (int n = q; n < r; n++) {
            StdOut.printf(points[n].toString());
            // If not at the end of the array
            if (n != r-1)
                StdOut.printf(" -> ");
            else
                StdOut.printf("\n");
        }
    }

    private static void findPoints(Point[] points, int array_len) {
        // Initialize new point array that is a copy of the inbound array
        Point[] points_clone = points.clone();
        Arrays.sort(points_clone);

        // Use clone array to sort original array
        for (int i = 0; i < array_len; i++) {
            Point p = points_clone[i];
            // Sort the array from p based on SLOPE_ORDER
            Arrays.sort(points, p.SLOPE_ORDER);

            for (int q = 1; q < array_len; q++) {
                boolean check = true;
                if (p.compareTo(points[q]) < 0) {
                    //Avoiding permutations
                    if ((p.compareTo(points[q-1]) < 0) && (points[q].slopeTo(p) == points[q - 1].slopeTo(p))){
                        check = false;
                    }
                    int r;
                    if (check) {
                        for (r = q + 1; r < array_len; r++) {
                            if (points[r].slopeTo(p) == points[q].slopeTo(p) && (points[r].compareTo(p) >= 0)) {
                            }
                            else {
                                if (r - q >= 3) {
                                    check = false;
                                    Fast.collinearOutput(points, q, r);
                                }
                                break;
                            }
                        }
                        // Does the last point in the array have the same slope?
                        if (points[array_len - 1].slopeTo(p) == points[q].slopeTo(p)) {
                            if (check && r - q >= 3) {
                                Fast.collinearOutput(points, q, r);
                            }
                        }
                    }
                }
            }
        }
    }




    public static void main(String[] args) {

        /*In in = new In();
        Out out = new Out();
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt(), y = in.readInt();
            points[i] = new Point(x, y);*/
        String filename = args[0];
        In in = new In(filename);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt(), y = in.readInt();
            points[i] = new Point(x, y);
        }
        Fast.findPoints(points, n);

    }
}

