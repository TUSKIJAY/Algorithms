package Cha04;

import Cha01.Stack;
import edu.princeton.cs.algs4.In;

public class DepthFirstDirectedPaths {
    private boolean[] marked;//这个顶点上调用过dfs()了吗？
    private int[] edgeTo;//从起点到一个顶点的已知路径上的最后一个顶点
    private final int s;//起点

    /**
     *找出所有起点为s的路径
     */
    public DepthFirstDirectedPaths(Digraph G,int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G,s);
    }
    private void dfs(Digraph G,int v){
        marked[v] = true;
        for (int w:G.adj(v)){//将每一个G.adj(v)赋值给w，然后对每个w执行以下操作
            if (!marked[w]){
                edgeTo[w] = v;//表示v-w是第一次访问w时经过的边
                dfs(G,w);
            }
        }
    }
    /**
     *s到v的路径，如果不存在则返回null
     */
    public Iterable<Integer>pathTo(int v){
        if (!hasPathTo(v))return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v;x != s;x = edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        //System.out.print(path.peek() + " ");
        return path;
    }
    /**
     *是否存在从s到v的路径
     */
    public boolean hasPathTo(int v){
        return marked[v];
    }

    public static void main(String[] args){
        Digraph G = new Digraph(new In(args[0]));
        In in = new In();
        int s = in.readInt();
        DepthFirstDirectedPaths search = new DepthFirstDirectedPaths(G,s);
        for (int v = 0;v < G.V();v++){
            System.out.print(s + " to " + v + ":");
            if (search.hasPathTo(v)) {
                for (int x : search.pathTo(v)) {
                    if (x == s) System.out.print(x);
                    else System.out.print("-" + x);
                }
            }
            System.out.println();
        }
    }
}
