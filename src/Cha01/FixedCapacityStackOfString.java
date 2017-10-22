package Cha01;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfString<Item> {
    private Item[] a;
    private int N;
    public FixedCapacityStackOfString(int cap){
        a = (Item[]) new Object[cap];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void push(Item item){
        if (N == a.length)resize(2*a.length);
        a[N++] = item;
    }
    public Item pop(){
        Item item = a[--N];
        a[N] = null;//避免对象游离
        if (N > 0 && N == a.length/4)resize(a.length/2);
        return item;
    }
    public void resize(int max){
        //将大小为N < = max的栈移动到一个大小为max的数组中
        Item[] temp = (Item[])new Object[max];
        for (int i = 0;i < N;i++){
            temp[i] = a[i];
        }
        a = temp;
    }
    public static void main(String[] args){
        //FixedCapacityStackOfString<String> s = new FixedCapacityStackOfString<>(100);
        Stack<String> s = new Stack<String>();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-")){
                s.push(item);
            }else if (!s.isEmpty()){
                StdOut.print(s.pop()+" ");
            }
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
