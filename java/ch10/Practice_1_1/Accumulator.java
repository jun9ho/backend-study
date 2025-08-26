package ch10.Practice_1_1;

public class Accumulator {

    private static int sum;
    public static void main(String[] args) {
        for(int i=0;i<10;i++)
            Accumulator.add(i);
        Accumulator.showResult();
    }

    public static void add(int n){
        sum+=n;
    }

    public static void showResult(){
        System.err.println(sum);
    }

}
