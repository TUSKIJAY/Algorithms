package Cha01;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * 背包 （链表实现）
 * @param <Item>
 */
public class Bag<Item> implements Iterable<Item> {
    private Node first;//链表的首结点
    private class Node{
        Node next;
        Item item;
    }

    public void add(Item item){
        //与stack的push方法一样
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
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
        public void remove() {}
    }
}
