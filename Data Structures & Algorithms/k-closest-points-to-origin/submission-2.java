class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int len = points.length;
        PriorityQueue<Point> queue = new PriorityQueue<>((a, b) -> Double.compare(b.dis, a.dis));

        for(int i = 0; i < len; i++) {
            int[] p = points[i];
            double dis = Math.sqrt(p[0] * p[0] + p[1] * p[1]);
            queue.offer(new Point(dis, i));

            if(queue.size() > k) {
                queue.poll();
            }
        }

        int[][] res = new int[k][2];
        int idx = 0;

        while(!queue.isEmpty()) {
            res[idx++] = points[queue.poll().i];
        }

        return res;
    }
}

class Point {
    public double dis;
    public int i;

    public Point(double dis, int i) {
        this.dis = dis;
        this.i = i;
    }
}
