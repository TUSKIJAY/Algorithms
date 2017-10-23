package Cha01;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    private Node first;//链表的首结点
    private class Node{
        Node next;
        Item item;
    }
    public void add(Item item){
        //与stac的push方法一样
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }
    @NotNull
    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
