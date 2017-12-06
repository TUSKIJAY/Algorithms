package Cha02;

/**
 * 基于堆的优先队列
 * @param <Key>
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN){
        pq = (Key[]) new Comparable[maxN];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key delMax(){
        Key max = pq[1];//从根结点得到最大元素
        exch(1,N--);//将其和最后一个结点交换
        pq[N+1] = null;//防止对象游离
        sink(1);//恢复堆得有序性(只有下沉没有上浮，最大元素交换后被覆盖)
        return max;
    }

    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i,int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    /**
     * 上浮
     * @param k 需要上浮的数
     */
    private void swim(int k){
        while (k > 1 && less(k/2,k)){
            exch(k/2,k);
            k = k/2;
        }
    }

    /**
     * 下沉
     * @param k 需要下沉的数
     */
    private void sink(int k){
        while(2*k <= N){
            int j = 2*k;
            if (j < N && less(j,j+1)){
                ++j;
            }
            if (!less(k,j))break;
            exch(k,j);
            k = j;
        }
    }

    public Key PQ(int i){
        return pq[i];
    }

    public static void main(String[] args){
        MaxPQ mq = new MaxPQ(13);
//        edu.princeton.cs.algs4.MaxPQ mq = new edu.princeton.cs.algs4.MaxPQ();
        mq.insert("T");
        mq.insert("S");
        mq.insert("R");
        mq.insert("P");
        mq.insert("N");
        mq.insert("O");
        mq.insert("A");
        mq.insert("E");
        mq.insert("I");
        mq.insert("H");
        mq.insert("G");

        //System.out.print("");
        for (int i = 1;i < mq.pq.length && mq.pq[i] != null;i++){
            System.out.print(mq.PQ(i) + " ");
        }
        System.out.println();
        //mq.delMax();
        mq.insert("Z");
        for (int i = 1;i < mq.pq.length && mq.pq[i] != null;i++){
            System.out.print(mq.PQ(i) + " ");
        }
    }
}
