package Cha04;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class KosarajuSCC {
    private boolean[] marked;//已访问过的顶点
    private int[] id;//强连通分量的标识符
    private int count;//强连通分量的数量

    private KosarajuSCC(Digraph G){
        //将反向图进行深度优先搜索并且将顶点排序（逆后序）
        DepthFirstOrder order = new DepthFirstOrder(G.reverse());

        marked = new boolean[G.V()];
        id = new int[G.V()];
        //将逆后序的顶点迭代给s
        for (int s : order.reversePost()) {
            //按照逆后序的顺序来进行深度优先搜索
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }
    private void dfs(Digraph G,int v){
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }
    public boolean stronglyConnected(int v,int w){
        return id[v] == id[w];
    }
    private int id(int v){
        return id[v];
    }
    private int getCount() {
        return count;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        KosarajuSCC scc = new KosarajuSCC(G);

//      System.out.println(G.toString());
        int m = scc.getCount();
        StdOut.println(m + " strong components");

        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[m];
        for (int i = 0; i < m; i++) {
            components[i] = new Queue<>();
        }
        for (int v = 0; v < G.V(); v++) {
            components[scc.id(v)].enqueue(v);
        }

        for (int i = 0; i < m; i++) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }

    }
}
