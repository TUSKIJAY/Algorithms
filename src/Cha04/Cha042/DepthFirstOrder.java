package Cha04.Cha042;

import Cha01.Stack;
import edu.princeton.cs.algs4.Queue;

/**
 * 有向图中基于深度优先搜索的顶点排序
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;//所有顶点前序遍历
    private Queue<Integer> post;//所有顶点后序遍历
    private Stack<Integer> reversePost;//所有顶点逆后序遍历

    public DepthFirstOrder(Digraph G){
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        marked = new boolean[G.V()];

        for (int v = 0;v < G.V();v++)
            if (!marked[v]) dfs(G,v);
    }
    private void dfs(Digraph G,int v){
        pre.enqueue(v);

        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w])
                dfs(G,w);

        post.enqueue(v);
        reversePost.push(v);
    }
    public Iterable<Integer> pre(){ return pre;}
    public Iterable<Integer> post(){ return post;}
    public Iterable<Integer> reversePost(){ return reversePost;}

}
