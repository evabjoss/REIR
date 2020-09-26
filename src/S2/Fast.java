package S2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import javax.naming.PartialResultException;
import java.util.Arrays;
import java.util.Collections;

public class Fast {


    private static void collinearOutput(Point[] points, int q, int r) {
        StdOut.printf("%s -> ", points[0].toString());
        Arrays.sort(points, q, r);
        int difference = r - q;
        for (int n = 0; n < difference; n++) {
            StdOut.printf("%s", points[q+n].toString());
            if (n != difference-1)
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

            // Set points q and r to p+1 and p+2
            int q = 1; // Next point
            int r = 2; // Second next point

            boolean check = p.compareTo(points[q]) < 0; // Make sure p is lower than q
            while (r < array_len) {
                // If the current point has a different slope than the previously found point:
                {
                    if (points[r].slopeTo(p) == points[q].slopeTo(p)) {
                        if (points[r].compareTo(p) < 0) {
                            check = false;
                        }
                    }
                    else {
                        // If we have at least 4 points to draw
                        if (check && r - q >= 3) {
                            Fast.collinearOutput(points, q, r);
                        }
                        // Move q point to same value as r held
                        q = r;
                        // Reset check
                        check = p.compareTo(points[q]) < 0;
                    }
                    r++;
                }
                // Check edge case (if the last point has the same slope as the previously found point

            }
        }
    }



    public static void main(String[] args) {

        In in = new In();
        Out out = new Out();
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
        Fast.findPoints(points, n);

    }


}
