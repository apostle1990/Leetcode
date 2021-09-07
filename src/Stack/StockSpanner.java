package Stack;
import java.util.Deque;
import java.util.LinkedList;

//901.股票价格跨度
public class StockSpanner {
    Deque<Integer> prices;
    Deque<Integer> weights;

    public StockSpanner() {
        prices = new LinkedList<>();
        weights = new LinkedList<>();
    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peekLast() <= price){
            prices.pollLast();
            w += weights.pollLast();
        }
        prices.addLast(price);
        weights.addLast(w);
        return w;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}
