package Cha02;

public class Heapsort {
    //private int N = 0;
    public  void sort(Comparable[] a){
        int N = a.length - 1;
        //创建堆
        for (int k = N/2;k >= 1;k--){
            sink(a,k,N);
        }
        //将最大元素a[1]与a[N]交换并修复堆，直到堆变空
        while (N > 1){
            exch(a,1,N--);
            sink(a,1,N);
        }
    }
    private  void sink(Comparable[] a,int k,int N){
        while(2*k <= N){
            int j = 2*k;
            if (j < N && less(a,j,j+1)){
                ++j;
            }
            if (!less(a,k,j))break;
            exch(a,k,j);
            k = j;
        }
    }
    private  boolean less(Comparable [] a,int i,int j){
        return a[i].compareTo(a[j]) < 0;
    }
    private  void exch(Comparable[] a,int i,int j){
        a[0] = a[i];
        a[i] = a[j];
        a[j] = a[0];
        a[0] = null;
    }
    public static void main(String[] args){
        String[] a = new String[12];
        //a[0] = null;
        a[1] = ("S");
        a[2] = ("O");
        a[3] = ("R");
        a[4] = ("T");
        a[5] = ("E");
        a[6] = ("X");
        a[7] = ("A");
        a[8] = ("M");
        a[9] = ("P");
        a[10] = ("L");
        a[11] = ("E");
        Heapsort heapsort = new Heapsort();
        for (int i = 1; i < 12; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
        System.out.println();
        heapsort.sort(a);
        for (int i = 1; i < 12; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
    }
}
