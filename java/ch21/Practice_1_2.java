package ch21;

class DBox<L, R> {
    private L left;
    private R right;

    public void set(L o, R r) {
        left = o;
        right = r;
    }

    @Override
    public String toString() {
        return left + " & " + right;
    }
}

public class Practice_1_2 {
    public static void main(String[] args) {
        DBox<String, Integer> box1 = new DBox<>();
        box1.set("Apple", 25);
        DBox<String, Integer> box2 = new DBox<>();
        box2.set("0range", 33);
        DBox<DBox<String,Integer>,DBox<String,Integer>> ddbox =new DBox<>();
        ddbox.set(box1,box2);
        System.out.println(ddbox);
    }
}
