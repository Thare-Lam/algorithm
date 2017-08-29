package lintcode.k_closest_points;

import java.util.PriorityQueue;

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

public class Solution {
    /**
     * @param points a list of points
     * @param origin a point
     * @param k      an integer
     * @return the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        Point[] pList = new Point[k];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (Point p : points) {
            addToQueue(queue, origin, p);
        }
        for (int i = 0; i < k; ++i) {
            pList[i] = queue.poll().p;
        }
        return pList;
    }

    private void addToQueue(PriorityQueue<Node> queue, Point origin, Point p) {
        double d = distance(origin, p);
        Node node = new Node(p, d);
        queue.add(node);
    }

    private double distance(Point a, Point b) {
        return Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2);
    }

    private class Node implements Comparable {
        Point p;
        double distance;

        public Node(Point p, double distance) {
            this.p = p;
            this.distance = distance;
        }

        @Override
        public int compareTo(Object o) {
            Node node = (Node) o;
            if (distance > node.distance) {
                return 1;
            } else if (distance < node.distance) {
                return -1;
            } else {
                return p.x - node.p.x;
            }
        }
    }
}