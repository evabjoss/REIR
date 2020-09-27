package S2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Brute {

    private static boolean checkIfLinear(Point point1, Point point2, Point point3, Point point4) {
        if ((point1.slopeTo(point2)) == (point1.slopeTo(point3))) {
            if ((point1.slopeTo(point2) == (point1.slopeTo(point4)))){
                return true;
            }
        }
        return false;
    }

    public static void GatherPoints(Point[] Point_Collect, int n) {
        Arrays.sort(Point_Collect);
        for (int one = 0; one < n - 3; one++) {
            for (int two = one + 1; two < n - 2; two++) {
                for (int three = two + 1; three < n - 1; three++) {
                    for (int four = three + 1; four < n; four++) {
                        if(checkIfLinear(Point_Collect[one], Point_Collect[two], Point_Collect[three], Point_Collect[four])) {
                            output(Point_Collect[one], Point_Collect[two], Point_Collect[three], Point_Collect[four]);
                        }
                    }
                }
            }
        }
    }

    private static void output(Point one, Point two, Point three, Point four) {
        StdOut.printf(one.toString() + " -> " + two.toString() + " -> " + three.toString()+ " -> " + four.toString() + "\n");
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
        int N = in.readInt();
        Point[] points = new Point[N];
        if (points.length >= 4){
            for (int i = 0; i < N; i++) {
                int x = in.readInt();
                int y = in.readInt();
                Point p = new Point(x, y);
                points[i] = new Point(x, y);
            }*/
        }
        GatherPoints(points, n);


    }

}




