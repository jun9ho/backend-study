package ch06;

public class Practice_2_2 {
    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            if (isPrime(i))
                System.out.println(i);
        }
    }

    public static Boolean isPrime(int number) {
        boolean flag = true;
        if (number == 1)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
