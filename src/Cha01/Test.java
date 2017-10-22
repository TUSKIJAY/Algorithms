package Cha01;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

/**
 * 队列的用例
 */
public class Test {
    public static int[] readInts(String name){
        In in = new In(name);
        Queue<Integer> q = new Queue<Integer>();
        while (!in.isEmpty()){
            q.enqueue(in.readInt());
        }
        int N = q.size();
        int[] a = new int[N];
        for (int i = 0;i < N;i++){
            a[i] = q.dequeue();
        }
        return a;
    }
    public static void main(String[] args){
        System.out.println(readInts("Cha01/Text.txt"));
    }
}
