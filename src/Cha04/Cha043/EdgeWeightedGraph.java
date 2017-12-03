package Cha04.Cha043;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * 加权无向图的数据类型
 */
public class EdgeWeightedGraph {
    private final int V;//顶点的数目
    private int E;//边的数目
    private Bag<Edge>[] adj;//邻接表

    /**
     * 创建一个含有V 个顶点但不含边的图
     */
    public EdgeWeightedGraph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];//创建领接表
        for (int v = 0;v < V;v++){//将所有链表初始化为空
            adj[v] = new Bag<>();
        }
    }

    /**
     * 从标准输入流in读入一幅图
     */
    public EdgeWeightedGraph(In in){
        this(in.readInt());//读取V并将图初始化
        int E = in.readInt();//读取E(边数)
        for (int i = 0;i < E;i++){
            //添加一条边
            int v = in.readInt();//读取一个顶点
            int w = in.readInt();//读取另一个顶点
            double weight = in.readDouble();//读取权重
            addEdge(new Edge(v,w,weight));//添加一条连接它们的边
        }
    }
    /**
     * 向图中添加一条边v-w
     */
    private void addEdge(Edge e){
        int v = e.either(),w = e.other(v);
        adj[w].add(e);//将v添加到w的链表中
        adj[v].add(e);//将w添加到v的链表中
        E++;
    }

    public int V(){return V;}
    public int E(){return E;}

    /**
     * 和v相邻的所有顶点
     */
    public Iterable<Edge>adj(int v){return adj[v];}

    /**
     * 该无向图中所有的边
     */
    public Iterable<Edge> edges(){
        Bag<Edge> b = new Bag<>();
        for (int v = 0;v < V;v++){
            for (Edge e : adj[v])
                if (e.other(v) > v) b.add(e);
        }
        return b;
    }

    /**
     * 图的邻接表的字符串表示
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + "\n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args){
        In in = new In(args[0]);
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        System.out.println(G.toString());
    }
}
