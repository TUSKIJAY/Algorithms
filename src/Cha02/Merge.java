package Cha02;

public class Merge {
    private static Comparable[] aux;
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }
    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a,int lo,int hi){
        if (hi <= lo){
            return;
        }
        int mid = lo + (hi - lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
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
    public static void main(String[] args) {
        String[] a = new String[10];
        a[0] = ("M");
        a[1] = ("E");
        a[2] = ("R");
        a[3] = ("G");
        a[4] = ("E");
        a[5] = ("S");
        a[6] = ("O");
        a[7] = ("R");
        a[8] = ("T");
        a[9] = ("E");

        for (int i = 0; i < 10; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
        System.out.println();
        sort(a);
        for (int i = 0; i < 10; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
    }
}
