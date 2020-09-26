package S2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

import static edu.princeton.cs.algs4.StdOut.print;

/*************************************************************************
 * Compilation: javac Point.java Execution: Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 * @author Magnus M. Halldorsson, email: mmh@ru.is
 *************************************************************************/
public class Point implements Comparable<Point> {

    public final int x, y;

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new SlopeOrder();

    private class SlopeOrder implements Comparator<Point> {
        public int compare(Point point1, Point point2) {
            double line1 = point1.slopeTo(Point.this);
            double line2 = point2.slopeTo(Point.this);
            if ((line1 - line2) > 0) return 1;
            else if ((line1 - line2) < 0) return -1;
            else return 0;
        }
    }


    // create the point (x, y)
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        float diff_x = that.x - this.x;
        float diff_y = that.y - this.y;
        if ((diff_y == 0) && (diff_x == 0)) return Double.NEGATIVE_INFINITY;
        if(diff_y == 0.0) return 0.0;
        if((diff_x) == 0.0) return Double.POSITIVE_INFINITY;
        else return (diff_y/diff_x);
    }

    /**
     * Is this point lexicographically smaller than that one? comparing
     * y-coordinates and breaking ties by x-coordinates
     */
    public int compareTo(Point that) {
        if (this.y < that.y) return -1;
        if (this.y > that.y) return +1;
        else{
            if (this.x < that.x) return -1;
            if (this.x > that.x) return +1;
        }
        return 0;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {

        // TODO: CHANGE BACK!
        /*
         * Do not modify
         */
        String filename = args[0];
        In in = new In(filename);
        Out out = new Out();
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt(), y = in.readInt();
            points[i] = new Point(x, y);
            StdOut.println(points[i]);
        }
        out.printf("Testing slopeTo method...\n");
        for (int i = 1; i < points.length; i++) {
            out.println(points[i].slopeTo(points[i - 1]));
        }
        out.printf("Testing compareTo method...\n");
        for (int i = 1; i < points.length; i++) {
            out.println(points[i].compareTo(points[i - 1]));
        }
        out.printf("Testing SLOPE_ORDER comparator...\n");
        for (int i = 2; i < points.length; i++) {
            out.println(points[i].SLOPE_ORDER.compare(points[i - 1],
                    points[i - 2]));
        }
    }

}
