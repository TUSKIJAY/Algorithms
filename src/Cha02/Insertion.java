package Cha02;

/**
 * 插入排序
 */
public class Insertion {
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean isSorted(Comparable[] a){
        //测试数组是否有序
        for (int i = 1;i < a.length;i++){
            if (less(a[i],a[i--])){return false;}
        }
        return true;
    }

    public static void sort(Comparable[] a){
        //将a[]按升序排列
        int N = a.length;
        for (int i = 0;i < N;i++){
            //将a[i]插入到a[i-1],a[i-2],a[i-3]..当中
            for (int j = i;j > 0 && less(a[j],a[j - 1]);j--){
                exch(a,j,j--);
            }
        }
    }
}
