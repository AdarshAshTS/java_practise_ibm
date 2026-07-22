import java.util.Queue;
import java.util.LinkedList;

class QueueTest{
    public static void main(String[] args) {
        Queue<Integer> newQueue = new LinkedList<>();
        newQueue.add(5);
        newQueue.add(7);
        newQueue.add(8);
        newQueue.remove();
        System.out.print(newQueue);
    }
}