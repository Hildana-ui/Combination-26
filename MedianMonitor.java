import java.util.*;

public class MedianMonitor {

    static PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
    static int count = 0;

    public static void addNum (int value) {
        if (leftHeap.isEmpty() || value <= leftHeap.peek()) {
            leftHeap.add(value);
        } else {
            rightHeap.add(value);
        }

        count++;

        if(leftHeap.size() > rightHeap.size()+1) {
            rightHeap.add(leftHeap.poll());
        } else if (rightHeap.size() > leftHeap.size()) {
            leftHeap.add(rightHeap.poll());
        }
    }

    public static double getMedian(){
        if (count % 2 != 0) {
            return leftHeap.peek();
        }
        return (leftHeap.peek() + rightHeap.peek()) / 2.0;
    }

    public static void debug() {
        System.out.println("Left Heap: " + leftHeap);
        System.out.println("Right Heap: " + rightHeap);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter commands: ");

        while (true) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(" ");
            String cmd = parts[0].toUpperCase();

            if (cmd.equals("ADD")) addNum(Integer.parseInt(parts[1]));
            else if (cmd.equals("MEDIAN")) System.out.println("Median: " + getMedian());
            else if (cmd.equals("DEBUG")) debug();
            else if (cmd.equals("EXIT")) { sc.close(); break; }
            else System.out.println("Unknown command");
        }

    }
}