package Cha02;

public class Test {
    public static void com(){
        int count = 0;
        int j;
        for (int i = 0;i < 10;i++){
           count = ++count;
        }
        System.out.println(count);
    }
    public static void main(String[] args){
        com();
    }
}
