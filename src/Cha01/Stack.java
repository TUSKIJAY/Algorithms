package Cha01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * 栈的链表实现
 */
public class Stack<Item>implements Iterable<Item> {
    private Node first;
    private int N;
    private class Node{
        //定义结点的嵌套类
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
        //或者return N == 0;
    }

    public int size(){return N;}
    public void push(Item item){
        //向栈顶添加元素
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    /*public Item peek(){
        return first.item;
    }*/
    private Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @NotNull
    public Iterator<Item>iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){return current != null;}
        public void remove(){}

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args){
        Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if (!item.equals("-")){
                stack.push(item);
            }else if (!stack.isEmpty()){
                StdOut.print(stack.pop()+" ");
            }
        }
        StdOut.println("("+stack.size()+" left on stack)");
    }
}
