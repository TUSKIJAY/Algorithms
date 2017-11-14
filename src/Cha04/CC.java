package Cha04;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * 使用深度优先搜索找出图中的所有连通分量
 */
public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;

    private int getCount() {
        return count;
    }

    private CC(Graph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0;s < G.V();s++)
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
    }
    private void dfs(Graph G,int v){
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)){
            if (!marked[v])
                dfs(G,w);
        }
    }
    public boolean connected(int v,int w){
        return id[v] == id[w];
    }
    private int id(int v){
        return id[v];
    }

    public static void main(String[] args){
        Graph G = new Graph(new In(args[0]));
        CC cc = new CC(G);

        System.out.println(G.toString());
        int M = cc.getCount();
        System.out.println(M + " components");

        Bag<Integer>[] components;
        components = (Bag<Integer>[]) new Bag[M];
        for (int i = 0;i < M;i++)
            components[i] = new Bag<>();
        for (int v = 0;v < G.V();v++)
            components[cc.id(v)].add(v);
        for (int i = 0;i < M;i++){
            for (int v : components[i])
                System.out.print(v + " ");
            System.out.println();
        }
    }
}
