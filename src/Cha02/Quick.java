package Cha02;

import edu.princeton.cs.algs4.StdRandom;

public class Quick {
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];a[i] = a[j];a[j] = t;
    }
    private static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length - 1);
    }
    private static void sort(Comparable[] a,int lo,int hi){
        if (hi <= lo){
            return;
        }
        int j = partition(a,lo,hi);//切分,找到切分元素
        sort(a,lo,j-1);//将小于切分元素的左半部分a[lo..j-1]排序
        sort(a,j+1,hi);//将大于切分元素的右半部分a[j+1..hi]排序
    }
    private static int partition(Comparable[] a,int lo,int hi){
        int i = lo,j = hi + 1;//左右扫描指针
        Comparable v = a[lo];//切分元素
        while (true){
            //扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i],v)){
                if (i == hi)
                    break;//i加至最大时跳出
            }
            while (less(v,a[--j])){
                if (j == lo)
                    break;//j减至最小时跳出
            }
            if (i >= j)//i大于等于j时跳出
                break;

            exch(a,i,j);
        }
        exch(a,lo,j);//将v == a[j]放入正确的位置
        return j;//a[lo..j-1] <= a[j] <= a[j+1..hi]达成
    }
    public static void main(String[] args){
        String[] a =new String[16];
        a[0] = ("Q");
        a[1] = ("U");
        a[2] = ("I");
        a[3] = ("C");
        a[4] = ("K");
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
