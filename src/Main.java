import chapter8.Leetcode1306;
import chapter9.Leetcode215;
import chapter9.MedianFinder;

public class Main {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        double re = medianFinder.findMedian();
        System.out.println(re);
        medianFinder.addNum(-2);
        re = medianFinder.findMedian();
        System.out.println(re);
        medianFinder.addNum(-3);
        re = medianFinder.findMedian();
        System.out.println(re);
        medianFinder.addNum(-4);
        re = medianFinder.findMedian();
        System.out.println(re);
        medianFinder.addNum(-5);
        re = medianFinder.findMedian();
        System.out.println(re);
    }
}
