class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int len = points.length;
        PriorityQueue<Double[]> queue = new PriorityQueue<>((a, b) -> a[0].compareTo(b[0]));

        for(int i = 0; i < len; i++) {
            int[] p = points[i];
            Double dis = Math.sqrt(p[0] * p[0] + p[1] * p[1]);
            queue.offer(new Double[] { dis, Double.valueOf(i) });
        }

        int[][] res = new int[k][2];
        int idx = 0;

        while(!queue.isEmpty()) {
            Double[] r = queue.poll();

            if(idx < k) {
                res[idx++] = points[r[1].intValue()];
            }
        }

        return res;
    }
}
