package S2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Fast2 {


    private static void collinearOutput2(Point[] points, int q, int r) {
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

    private static void findPoints2(Point[] points, int array_len) {
        // Initialize new point array that is a copy of the inbound array
        Point[] points_clone = points.clone();
        Arrays.sort(points_clone);

        // Use clone array to sort original array
        for (int i = 0; i < array_len; i++) {
            Point p = points_clone[i];
            // Sort the array from p based on SLOPE_ORDER
            Arrays.sort(points, p.SLOPE_ORDER);

            // Set points q and r to p+1 and p+2
            int q = 1; // Next point
            int r = 2; // Second next point

            boolean check = p.compareTo(points[q]) < 0; // Make sure p is lower than q

            while (r < array_len) {

                if (points[r].slopeTo(p) == points[q].slopeTo(p)) {
                    if (points[r].compareTo(p) < 0) {
                        check = false;
                    }
                }
                else {
                    // If we have at least 4 points to draw
                    if (check && r - q >= 3) {
                        Fast2.collinearOutput2(points, q, r);
                    }
                    // Move q point to same value as r held
                    q = r;
                    // Reset check
                    check = p.compareTo(points[q]) < 0;
                }
                r++;
            }
            // Does the last point in the array have the same slope?
            if (points[array_len-1].slopeTo(p) == points[q].slopeTo(p)) {
                if (check && r -q >= 3) {
                    Fast2.collinearOutput2(points, q, r);
                }
            }
        }
    }


    public static void main(String[] args) {

        In in = new In();
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt(), y = in.readInt();
            points[i] = new Point(x, y);
        /*String filename = args[0];
        In in = new In(filename);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt(), y = in.readInt();
            points[i] = new Point(x, y);*/

        }
        Fast2.findPoints2(points, n);

    }


}