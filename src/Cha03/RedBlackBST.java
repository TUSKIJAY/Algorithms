package Cha03;


import com.sun.org.apache.regexp.internal.RE;

public class RedBlackBST<Key extends Comparable<Key>,Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node{
        Key key;
        Value value;
        Node left,right;
        int N;//以它为根结点的结点总数
        boolean color;//其父节点指向它的链接颜色
        Node(Key key,Value value,int N,boolean color){
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }
    private boolean isRed(Node x){
        if (x == null){return false;}
        return x.color == RED;
    }
    public int size(){return size(root);}
    private int size(Node x){
        if (x == null){return 0;}
        else return x.N;
    }
    private Node rotalLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;//将被连的链接设为红色
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }
    private Node rotalRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }
    private void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    public void put(Key key,Value value){
        //查找key，找到则更新其值，否则为它新建一个结点
        root = put(root,key,value);
        root.color = BLACK;
    }
    private Node put(Node h,Key key,Value value){
            if (h == null){//标准的插入操作，和父节点用红链接相连
            return new Node(key,value,1,RED);
        }

            int cmp = key.compareTo(h.key);
            if      (cmp < 0){h.left = put(h.left,key,value);}
            else if (cmp > 0){h.right = put(h.right,key,value);}
            else     h.value = value;

            if (isRed(h.right) && !isRed(h.left)){     h = rotalLeft(h);}
            if (isRed(h.left)  && isRed(h.left.left)){ h = rotalRight(h);}
            if (isRed(h.left)  && isRed(h.right)){     flipColors(h);}

            h.N = size(h.left) + size(h.right) + 1;
            return h;
    }
    public Value get(Key key){
        return get(root,key);
    }
    private Value get(Node x,Key key){
        while (x != null){
            int cmp = key.compareTo(x.key);
            if (cmp > 0){
                x = x.right;
            }else if (cmp < 0){
                x = x.left;
            }else { return x.value;}
        }
        return null;
    }
}
