package ch13;

public class Practice_2_2 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4},{4,5,6,7},{7,8,9,10},{12,13,14,15}};
        changeArr(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }

    }

    public static void changeArr(int[][] arr)
    {
        int[] tmp = new int[arr[0].length];
        int [] last = new int[arr[0].length];
        System.arraycopy(arr[arr.length-1],0,last,0,arr[0].length);
        for(int i=0;i<arr.length;i++)
        {
            System.arraycopy(arr[i],0,tmp,0,arr[0].length);
            System.arraycopy(last,0,arr[i],0,arr[0].length);
            System.arraycopy(tmp,0,last,0,arr[0].length);
        }
    }
}
