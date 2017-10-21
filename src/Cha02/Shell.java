package Cha02;

import edu.princeton.cs.algs4.StdOut;

public class Shell extends Commn{
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
        String[] a =new String[16];
        a[0] = ("S");
        a[1] = ("H");
        a[2] = ("E");
        a[3] = ("L");
        a[4] = ("L");
        a[5] = ("S");
        a[6] = ("O");
        a[7] = ("R");
        a[8] = ("T");
        a[9] = ("E");
        a[10] = ("X");
        a[11] = ("A");
        a[12] = ("M");
        a[13] = ("P");
        a[14] = ("L");
        a[15] = ("E");
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
