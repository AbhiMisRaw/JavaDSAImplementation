package HeapPackage;

public class Demo {
    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(10);
        h.insert(30);
        h.insert(70);
        h.insert(45);
        h.insert(50);
        h.insert(60);
        h.insert(9);
        h.printHeap();
    }
}
