package ch11;

public class Practice_1_2 {
    public static void main(String[] args) {
        String str = "990925-101299";
        StringBuilder sb = new StringBuilder(str);
        sb.delete(6,7);
        System.out.print(sb.toString());
    }
}
