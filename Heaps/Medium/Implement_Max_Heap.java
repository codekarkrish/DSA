import java.util.*;

public class Implement_Max_Heap {

    ArrayList<Integer> heap;

    public void initializeHeap() {
        heap = new ArrayList<>();
    }

    public void insert(int key) {
        heap.add(key);
        int i = heap.size() - 1;

        while (i > 0) {
            int parent = (i - 1) / 2;

            if (heap.get(parent) >= heap.get(i))
                break;

            swap(i, parent);
            i = parent;
        }
    }

    public int getMax() {
        return heap.get(0);
    }

    public void extractMax() {
        if (heap.isEmpty()) return;

        int n = heap.size();
        swap(0, n - 1);
        heap.remove(n - 1);

        if (!heap.isEmpty())
            heapify(0);
    }

    public int heapSize() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void changeKey(int index, int newVal) {

        int oldVal = heap.get(index);
        heap.set(index, newVal);

        if (newVal > oldVal) {
            while (index > 0) {
                int parent = (index - 1) / 2;

                if (heap.get(parent) >= heap.get(index))
                    break;

                swap(index, parent);
                index = parent;
            }
        } else {
            heapify(index);
        }
    }

    private void heapify(int i) {
        int n = heap.size();

        while (true) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && heap.get(left) > heap.get(largest))
                largest = left;

            if (right < n && heap.get(right) > heap.get(largest))
                largest = right;

            if (largest == i)
                break;

            swap(i, largest);
            i = largest;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // ✅ MAIN METHOD (ADD THIS)
    public static void main(String[] args) {

        Implement_Max_Heap h = new Implement_Max_Heap();

        h.initializeHeap();

        h.insert(4);
        h.insert(1);
        h.insert(10);

        System.out.println("Max: " + h.getMax());   // 10
        System.out.println("Size: " + h.heapSize()); // 3

        h.extractMax();
        System.out.println("After extractMax: " + h.getMax()); // 4

        h.changeKey(0, 16);
        System.out.println("After changeKey: " + h.getMax()); // 16
    }
}