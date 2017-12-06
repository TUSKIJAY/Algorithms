package Cha02;

import edu.princeton.cs.algs4.StdOut;

/**
 * 选择排序
 */
public class Selection {
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];a[i] = a[j];a[j] = t;
    }

    private static void show(Comparable[] a){
        for (int i = 0;i < a.length;i++){
            StdOut.print(a[i]+" ");
            StdOut.println();
        }
    }

    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0;i < N;i++){
            int min = i;
            for (int j = i+1;j<N;j++){
                if (less(a[j],a[min]))min = j;
            exch(a,i,min);
            }
        }
    }

    public static void main(String[] args){
        String[] a = new String[11];
        a[0] = ("S");
        a[1] = ("D");
        a[2] = ("G");
        a[3] = ("R");
        a[4] = ("Q");
        a[5] = ("O");
        a[6] = ("B");
        a[7] = ("L");
        a[8] = ("F");
        a[9] = ("V");
        a[10] = ("M");
        sort(a);
        show(a);
    }
}
