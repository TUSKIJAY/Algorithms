package Cha03;

import Cha01.Queue;

public class BST<Key extends Comparable<Key>,Value> {
    private Node root;//根结点

    private class Node{
        private Key key;//键
        private Value value;//值
        private Node left,right;//指向子树的链接
        private int N;//以该结点为根的子树中的结点总数

        private Node(Key key,Value val,int N){
            this.key = key;
            this.value = val;
            this.N = N;
        }
    }
    public int size(){return size(root);}
    private int size(Node x){
        if (x == null){return 0;}
        else return x.N;
    }
    public Value get(Key key){
        return get(root,key);
    }
    private Value get(Node x,Key key){
        //在以x为根结点的子树中查找并返回key所对应的值；
        //如果找不到则返回null
        if (x == null){return null;}
        int cmp = key.compareTo(x.key);
        if (cmp < 0){return get(x.left,key);}
        else if (cmp > 0){return get(x.right,key);}
        else return x.value;
    }
    public void put(Key key,Value value){ root = put(root,key,value);}
    private Node put(Node x,Key key,Value value){
        //如果key存在于以x为根节点的子树中则更新它的值
        //否则将以key和val为键值对新结点插入到该子树中
        if (x == null){return new Node(key,value,1);}
        int cmp = key.compareTo(x.key);
        if (cmp > 0){
            x.right = put(x.right,key,value);
        }else if (cmp < 0){
            x.left = put(x.left,key,value);
        }else x.value = value;//如果所插入的键在本树中，则更新值即可
        x.N = size(x.left) + size(x.right) + 1;//二叉树中任意结点x的结点总数
        return x;
    }
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }
    public Key min(){
        return min(root).key;
    }
    private Node min(Node x){
        if (x.left == null){
            return x;
        }
        return min(x.left);
    }
    public void deleteMin(){root = deleteMin(root);}
    private Node deleteMin(Node x){
        if (x.left == null){
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key max(){
        return max(root).key;
    }
    private Node max(Node x){
        if (x.right == null){
            return x;
        }
        return max(x.right);
    }
    public void deleteMax(){root = deleteMax(root);}
    private Node deleteMax(Node x){
        if (x.right == null){ return x.left;}
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public Key floor(Key key){//小于key的但最大的结点
        Node x = floor(root,key);
        if (x == null){return null;}
        return x.key;
    }
    private Node floor(Node x,Key key){
        if (x == null){ return null; }
        int cmp = key.compareTo(x.key);
        if (cmp == 0){ return x;}
        if (cmp < 0){
            return floor(x.left,key);
        }
        //如果给定的键key大于二叉树的根结点，
        Node t = floor(x.right,key);
        //那么只有当根结点右子树中存在小于等于key的结点时，小于等于key的最大键才会出现在右子树。
        if (t != null){return t;}
        else return x;
    }
    public Key ceiling(Key key){//大于key但最小的结点
        Node x = ceiling(root,key);
        if (x == null){return null;}
        return x.key;
    }
    private Node ceiling(Node x,Key key){
        if (x == null){return null;}
        int cmp = key.compareTo(x.key);
        if (cmp == 0){return x;}
        if (cmp > 0){
            return x = ceiling(x.right,key);
        }
        Node t = ceiling(x.left,key);
        if (t != null){
            return t;
        }else return x;
    }
    public Key select(int n){
        return select(root,n).key;
    }
    private Node select(Node x,int n){
        //返回排名为k的结点
        if (x == null){return null;}
        int t = size(x.left);
        if (t > n){
            return select(x.left,n);
        }
        else if (t < n){
            return select(x.right,n-t-1);
        }
        else return x;
    }
    public int rank(Key key){
        return rank(key,root);
    }
    private int rank(Key key,Node x){
        if (x == null){return 0;}
        int cmp = key.compareTo(x.key);
        if (cmp < 0){
            return rank(key,x.left);
        }
        else if (cmp > 0){
            return 1 + size(x.left) + rank(key,x.right);
        }
        else return size(x.left);
    }

    public void delete(Key key){ root = delete(root,key);}
    private Node delete(Node x,Key key){
        if (x == null){ return null;}

        int cmp = key.compareTo(x.key);

        if      (cmp < 0){ x.left = delete(x.left,key);}
        else if (cmp > 0){ x.right = delete(x.right,key);}

        else {
            if (x.right == null){ return x.left;}
            if (x.left == null){ return x.right;}
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Iterable<Key>keys(){
        return keys(min(),max());
    }
    public Iterable<Key>keys(Key lo,Key hi){
        Queue<Key> queue= new Queue<>();
        keys(root,queue,lo,hi);
        return queue;
    }
    private void keys(Node x,Queue<Key> queue,Key lo,Key hi){
        if (x == null){return;}
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0){keys(x.left,queue,lo,hi);}
        if (cmplo <= 0 && cmphi >= 0){queue.enqueue(x.key);}
        if (cmphi > 0){keys(x.right,queue,lo,hi);}
    }
}
