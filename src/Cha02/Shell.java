package Cha02;

import edu.princeton.cs.algs4.StdOut;

/**
 * 希尔排序
 */
public class Shell{
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];a[i] = a[j];a[j] = t;
    }

    public static void sort(Comparable[] a){
        int N = a.length;
        int h =1;
        while (h < N/3) h = 3*h+1;
        while (h >= 1){
            //将数组变得有序
            for (int i = h;i < N;i++){
                //将a[i]插入到a[i-1],a[i-2*h],a[i-3*h]之中
                for (int j = i;j >= h && less(a[j],a[j-h]);j -= h)
                    exch(a,j,j-h);
            }
            h = h/3;
        }
    }

    public static void main(String[] args){
        String[] a = {"S","H","E","L","L","S","O","R","T","E",
                      "X","A","M","P","L","E"};
        for (int i = 0;i < 16;i++){
            System.out.print(a[i]);
            System.out.print(" ");
        }
        System.out.println();
        sort(a);
        for (int i = 0;i < 16;i++){
            System.out.print(a[i]);
            System.out.print(" ");
        }
    }
}
