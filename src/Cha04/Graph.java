package Cha04;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class Graph {
    private final int V;//顶点的数目
    private int E;//边的数目
        private Bag<Integer>[] adj;//邻接表

    /**
     * 创建一个含有V 个顶点但不含边的图
     */
    public Graph(int V){
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];//创建领接表
        for (int v = 0;v < V;v++){//将所有链表初始化为空
            adj[v] = new Bag<>();
        }
    }

    /**
     * 从标准输入流in读入一幅图
     */
    public Graph(In in){
        this(in.readInt());//读取V并将图初始化
        int E = in.readInt();//读取E(边数)
        for (int i = 0;i < E;i++){
            //添加一条边
            int v = in.readInt();//读取一个顶点
            int w = in.readInt();//读取另一个顶点
            addEdge(v,w);//添加一条连接它们的边
        }
    }
    public int V(){return V;}
    public int E(){return E;}

    /**
     * 向图中添加一条边v-w
     */
    public void addEdge(int v,int w){
        adj[v].add(w);//将w添加到v的链表中
        adj[w].add(v);//将v添加到w的链表中
        E++;
    }

    /**
     * 和v相邻的所有顶点
     */
    public Iterable<Integer>adj(int v){return adj[v];}

    /**
     * 计算v的度数
     */
    public static int degree(Graph G,int v){
        int degree = 0;
        for (int w:G.adj(v))degree++;
        return degree;
    }

    /**
     * 计算所有顶点最大度数
     */
    public static int maxDegree(Graph G){
        int max = 0;
        for (int v = 0;v < G.V();v++){
            if (degree(G,v) > max)
                max = degree(G,v);
        }
        return max;
    }

    /**
     * 计算所有顶点的平均度数
     */
    public static double avgDegree(Graph G){ return 2.0*G.E()/G.V();}

    /**
     * 计算自环的个数
     */
    public static int numberofSelfLoops(Graph G){
        int count = 0;
        for (int v = 0;v < G.V();v++){
            for (int w:G.adj(v)){
                if (v == w)count++;
            }
        }
        return count/2;//每条边都被记录过两次
    }

    /**
     * 图的领接表的字符串表示
     * @return
     */
    @Override
    public String toString() {
        String s = V + "vertices," + E + "edges\n";
        for (int v = 0;v < V;v++){
            s += v + " :";
            for (int w:this.adj(v)){
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }
}
