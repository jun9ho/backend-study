package ch21;

class Box<T> {
    private T ob;

    public void set(T o) {
        ob = o;
    }

    public T get() {
        return ob;
    }
    
}



public class Practice_2_1 {
    public static <T extends Number> void swapBox(Box<T> a, Box<T> b) {
        Box<T> box = new Box<>();
        box.set(a.get());
        a.set(b.get());
        b.set(box.get());
    }

    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>();
        box1.set(99);
        Box<Integer> box2 = new Box<>();
        box2.set(55);
        System.out.println(box1.get() + " & " + box2.get());
        swapBox(box1,box2);
        System.out.println(box1.get() + " & " + box2.get());
        
    }
}
