package Cha04.Cha043;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;

/**
 * 最小生成树的Prime算法（即时版本）
 */
public class PrimMST {
    private Edge[] edgeTo;//距离树最近的边
    private double[] distTo;//（最近边的权重）disTo[w] = edgeTo[w].getWeight()
    private boolean[] marked;//如果v在树中则为true
    private IndexMinPQ<Double> pq;//有效的横切边

    public PrimMST(EdgeWeightedGraph G){
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0;v < G.V();v++)
            distTo[v] = Double.POSITIVE_INFINITY;//初始化距离为正无穷
        pq = new IndexMinPQ<>(G.V());

        distTo[0] = 0.0;
        pq.insert(0,0.0);//用顶点0和权重0初始化pq
        while(!pq.isEmpty()){
            visit(G,pq.delMin());//将最近的顶点添加到树中
        }
    }
    /**
     * 标记顶点v并将所有连接v和未被标记的顶点的边加入pq
     */
    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)){
            int w  = e.other(v);

            if (marked[w]) continue;//v-w失效
            if (e.getWeight() < distTo[w]){
                //连接w和树的最佳边Edge变成为e
                edgeTo[w] = e;
                distTo[w] = e.getWeight();
                if (pq.contains(w)) pq.changeKey(w,distTo[w]);
                else pq.insert(w,distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges(){
        Queue<Edge> mst = new Queue<>();
        for (Edge e : edgeTo) {
            if (e != null) {
                mst.enqueue(e);
            }
        }
        return mst;
    }

    public double weight(){
        double weight = 0.0;
        for (Edge e : edges()){
            weight += e.getWeight();
        }
        return weight;
    }
    public static void main(String[] args){
        In in = new In(args[0]);
        EdgeWeightedGraph G;
        G = new EdgeWeightedGraph(in);

        PrimMST mst = new PrimMST(G);
        for (Edge e : mst.edges())
            System.out.println(e);
        System.out.printf("%.2f",mst.weight());
    }
}
