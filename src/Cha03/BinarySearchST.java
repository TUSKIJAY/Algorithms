package Cha03;

import Cha01.Queue;

public class BinarySearchST<Key extends Comparable<Key>,Value> {
    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchST(int capacity){
        //调节数组容量
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Comparable[capacity];
    }
    public int size(){return N;}

    public boolean isEmpty(){return N == 0;}

    public Value get(Key k){
        if (isEmpty()){return null;}
        int i = rank(k);
        if (i < N && keys[i].compareTo(k) == 0){return values[i];}
        else return null;
    }

    private int rank(Key k){//基于有序数组二分查找（迭代）
        int lo = 0,hi = N - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            int cmp = k.compareTo(keys[mid]);
            if (cmp < 0){hi = mid - 1;}
            else if (cmp > 0){lo = mid + 1;}
            else return mid;
        }
        return lo;//不存在该键时，返回表中小于它的键的数量
    }

    public void put(Key k,Value val){
        //查找键，找到则更新值，否则创建新的元素
        int i = rank(k);
        if (i < N && keys[i].compareTo(k) == 0){
            values[i] = val;
            return;
        }
        for (int j = N;j > i;j--){
            keys[i] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = k;//填充键数组
        values[i] = val;//填充值数组
        N++;
    }

    //调整数组大小
    private void resize(int capacity) {
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        values = tempv;
        keys = tempk;
    }

    public void delete(Key k){
        if (k == null){throw new IllegalArgumentException("被删除的键为空");}
        if (isEmpty())return;
        int i = rank(k);
        if (i == N || keys[i].compareTo(k) != 0){ return;}
        for (int j = i;j < N - 1;j++){//删除之后，后续键值跟上
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        N--;
        keys[N] = null;//防止游离
        values[N] = null;
        //if (N > 0 && N == keys.length/4){resize(keys.length/2);}
    }
    public Key min(){
        return keys[0];
    }
    public Key max(){
        return keys[N-1];
    }
    public Key select(int n){return keys[n];}

    public Key ceiling(Key k){
        int i = rank(k);
        return keys[i];
    }
    /*public Iterable<Key>keys(Key lo,Key hi){
        Queue<Key> q = new Queue<>();
        for (int i = rank(lo);i < rank(hi);i++){
            q.enqueue(keys[i]);
        }
        if (contanis(hi)){
        q.enqueue(keys[rank[hi]]);
        }
        return q;
    }*/

    /**
     * 递归版
     */
    /*public int rank(Key k,int lo,int hi){//
        if (hi < lo){
            return lo;
        }
        int mid = lo + (hi -lo)/2;
        int cmp = k.compareTo(keys[mid]);
        if (cmp > 0){
            rank(k,mid+1,hi);
        }else if (cmp < 0) {
            rank(k, lo, mid - 1);
        }else return mid;
        return lo;
    }*/

    public void pull(){
        for (int i = 0;i < N;i++){
            System.out.print(keys[i]+" ");
        }
        System.out.println();
    }
}
