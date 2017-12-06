package Cha01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * 队列 （链表实现）
 * @param <Item>
 */
public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;
    private class Node{
        //定义了结点的嵌套类
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
        //return N == 0;
    }

    public int size(){
        return N;
    }

    public void enqueue(Item item){
        //向表尾添加元素
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()){
            first = last;
        }else {oldlast.next = last;}
        N++;
    }

    public Item dequeue(){
        //从表头删除元素
        Item item = first.item;
        first = first.next;
        if (isEmpty()){last = null;}
        N--;
        return item;
    }

    @NotNull
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() { }
    }

    public static void main(String[] args){
        Queue<String> queue = new Queue<>();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-")){
                queue.enqueue(item);
            }else if (!queue.isEmpty()){
                StdOut.print(queue.dequeue()+" ");
            }
        }
        StdOut.println("("+queue.size()+" left on stack)");
    }
}
