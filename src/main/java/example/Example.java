package example;

import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int input=sc.nextInt();
        int [] numbers=new int[input];
        for(int i=0;i<input;i++){
            numbers[i]=sc.nextInt();
        }

       // int[] num = new int[]{1, 2, 3, 4, 5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
        System.out.println(per(numbers, numbers.length, numbers.length));
    }

    /*
    1 1 1
    1 2
    3

    n 5
    1 1 1 1 1
    1 1 1 2
    1 1 3
    1 4
    2 1 2
    2 3
    5
    q1) take a positive input n. and print the number of combinations using 1 to n which will give a
     sum equal to n.
    note: you can use a number as many number of times
    num 1 2 3
    n 3
    sum 3
    1> 1
    num 1 2 3
    n 3
    sum 0

    num 1 2
    n 2
    sum 3

    num 1 2
    n 3
    sum 1

1, 2, 3, 4, 5
     */
    private static int per(int[] num, int n, int sum) {
        if (n <= 0) {
            return 0;
        }
        if (sum == 0) {
            return 1;
        }
        if (sum - num[n - 1] >= 0) {
            return per(num, n, sum - num[n - 1]) + per(num, n - 1, sum);
        } else {
            return per(num, n - 1, sum);
        }
    }
}
