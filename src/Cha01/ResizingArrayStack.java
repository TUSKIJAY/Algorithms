package Cha01;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];//栈元素
    private int N = 0;
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void resize(int max){
        //将大小为N < = max的栈移动到一个大小为max的数组中
        Item[] temp = (Item[])new Object[max];
        for (int i = 0;i < N;i++){
            temp[i] = a[i];
        }
        a = temp;
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
    @NotNull
    @Override
    /**
     * 迭代器
     */
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item>{
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() { }
    }
}
