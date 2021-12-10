package test;

public class PowerSet {
    public static void main(String []args){
        String str="abc";

        printPowerSet(str,"");
    }

    private static void printPowerSet(String question, String answer) {
        if(question.isEmpty()){
            System.out.println(answer);
            return;
        }
        char ch=question.charAt(0);
        printPowerSet(question.substring(1),answer+ch);
        printPowerSet(question.substring(1),answer);
    }
}
