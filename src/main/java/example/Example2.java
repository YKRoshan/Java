package example;

public class Example2 {
    int a = 4;
    public static int b = 1;
/*public void fun(){
    System.out.println("MergeOverlappingSubIntervals");
}*/
}

class A extends Example2 {
    int a = 5;
    public static int b = 2;

    public void fun() {
        System.out.println("A");
    }

    public static void main(String[] args) {
        Example2 example2 = new A();
        //example2.fun();

        System.out.println(example2.b);
    }
}