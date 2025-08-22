package ch05;

public class Practice_6_1 {
    public static void main(String[] args) {
        
        int count = 0;

        // while ((num++) < 100) {
        //     if (((num % 5) != 0) || ((num % 7) != 0))
        //         continue;

        //     count++;
        //     System.out.println(num);
        // }
        for ( int num = 1; num <= 100; num++) {
            if (((num % 5) != 0) || ((num % 7) != 0))
                continue;

            count++;
            System.out.println(num);
        }


        System.out.println("count: " + count);
    }
}
