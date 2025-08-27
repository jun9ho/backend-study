package ch13;

public class Practice_1_1 {
    public static void main(String[] args) {

        int[] arr = new int[]{55,25,33,123,40,60};
        System.out.println(minValue(arr));
        System.out.println(maxValue(arr));
    }

    public static int minValue(int[] arr) {
        //for문
        int min = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            min = Math.min(min,arr[i]);
        }
        return min;
    }

    public static int maxValue(int[] arr) {
        //enhanced for문
        int max = arr[0];
        for(int num : arr)
        {
            max = Math.max(num,max);
        }

        return max;
    }
}
