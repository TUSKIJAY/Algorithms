package Cha04.Cha043;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

/**
 * 最小生成树的Prime算法的延时实现
 */
public class LazyPrimMST {
    private boolean[] marked;//最小生成树的顶点
    private Queue<Edge> mst;//最小生成树的边
    private MinPQ<Edge> pq;//横切边（包括失效的边）

    public LazyPrimMST(EdgeWeightedGraph G){
        pq = new MinPQ<>();
        marked = new boolean[G.V()];
        mst = new Queue<>();

        visit(G,0);//假设G是连通的
        while (!pq.isEmpty()){
            Edge e = pq.delMin();//从pq中得到权重最小的边

            int v = e.either(),w = e.other(v);
            if (marked[v] && marked[w]) continue;//跳过失效的边
            mst.enqueue(e);//将边添加到树中
            if (!marked[v])visit(G,v);//将顶点（v或w）添加到树中
            if (!marked[w])visit(G,w);
        }
    }

    /**
     * 标记顶点v并将所有连接v和未被标记的顶点的边加入pq
     */
    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v))
            if (!marked[e.other(v)])pq.insert(e);
    }
    public Iterable<Edge> edges(){
        return mst;
    }

    /**
     * @return 最小生成树的权重之和
     */
    public double weight(){
        double weight = 0;
        for (Edge e : edges()){
            weight += e.getWeight();
        }
        return weight;
    }
    public static void main(String[] args){
        In in = new In(args[0]);
        EdgeWeightedGraph G;
        G = new EdgeWeightedGraph(in);

        LazyPrimMST mst = new LazyPrimMST(G);
        for (Edge e : mst.edges())
            System.out.println(e);
        System.out.printf("%.2f",mst.weight());
    }
}
