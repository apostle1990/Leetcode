package PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

//973. 最接近原点的 K 个点
public class Leetcode973 {
    private class Node{
        private int x;
        private int y;
        private int area;
        public Node(){}
        public Node(int x, int y){
            this.x = x;
            this.y = y;
            this.area = x*x + y*y;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((node1,node2) -> (node1.area -node2.area));
        for (int[] point : points){
            Node node = new Node(point[0], point[1]);
            priorityQueue.add(node);
        }
        int[][] re = new int[k][2];
        for (int i=0; i<k; i++){
           Node node = priorityQueue.poll();
           re[i][0] = node.x;
           re[i][1] = node.y;
        }
        return re;
    }

    public static void main(String[] args) {
        Leetcode973 leetcode973 = new Leetcode973();
        int[][] points = {{1,3},{-2,2}};
        int k =1;
        int[][] re = leetcode973.kClosest(points, k);
        for (int[] i : re){
            System.out.println(Arrays.toString(i));
        }
    }
}
