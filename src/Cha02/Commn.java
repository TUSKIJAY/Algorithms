package Cha02;

public class Commn {
    protected static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    protected static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];a[i] = a[j];a[j] = t;
    }
    protected static void show(Comparable[] a){
        for (int i = 0;i < 16;i++){
            System.out.print(a[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}
