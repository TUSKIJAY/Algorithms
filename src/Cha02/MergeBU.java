package Cha02;

/**
 * 自底向上的归并排序
 */
public class MergeBU {
    private static Comparable[] aux;
    public static void sort(Comparable[] a){
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1;sz < N;sz = sz * 2){//sz子数组大小
            for (int lo = 0;lo < N - sz;lo += sz * 2){//lo子数组索引
                merge(a,lo,lo + sz - 1,Math.min(lo + sz * 2 - 1,N - 1));
            }
        }
    }
    public static void merge(Comparable[] a,int lo,int mid,int hi){
        int i = lo,j = mid + 1;
        for (int k = lo;k <= hi;k++){
            aux[k] = a[k];
        }
        for (int k = lo;k <= hi;k++)
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j],aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
    }
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }
    public static void main(String[] args) {
        String[] a = {"M","E","R","G","E","S","O","R","T","E","X","A","M","P","L","E"};

        for (int i = 0; i < 16; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
        System.out.println();
        sort(a);
        for (int i = 0; i < 16; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
    }
}
