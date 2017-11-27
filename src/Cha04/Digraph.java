package Cha04;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * 有向图
 */
public class Digraph {
    private final int V;//顶点的数目
    private int E;//边的数目
    private Bag<Integer>[] adj;//邻接表

    /**
     * 创建一个含有V 个顶点但不含边的图
     */
    public Digraph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];//创建领接表
        for (int v = 0;v < V;v++){//将所有链表初始化为空
            adj[v] = new Bag<>();
        }
    }
    /**
     * 从标准输入流in读入一幅图
     */
    public Digraph(In in){
        this(in.readInt());//读取V并将图初始化
        int E = in.readInt();//读取E(边数)
        for (int i = 0;i < E;i++){
            //添加一条边
            int v = in.readInt();//读取一个顶点
            int w = in.readInt();//读取另一个顶点
            addEdge(v,w);//添加一条连接它们的边
        }
    }
    /**
     * 向图中添加一条边v-w
     */
    public void addEdge(int v,int w){
        adj[v].add(w);//将w添加到v的链表中
        E++;
    }

    public int V(){return V;}
    public int E(){return E;}

    /**
     * 和v相邻的所有顶点
     */
    public Iterable<Integer>adj(int v){return adj[v];}

    /**
     * @return 该图反向图
     */
    public Digraph reverse(){
        Digraph R = new Digraph(V);
        for (int v = 0;v < V;v++) {
            for (int w : adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }
    /**
     * 图的领接表的字符串表示
     */
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder(V + " vertices," + E + " edges\n");
        for (int v = 0;v < V;v++){
            s.append(v).append(" :");
            for (int w:this.adj(v)){
                s.append(w).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }
    public static void main(String[] args){
        Digraph G = new Digraph(new In(args[0]));
        System.out.println(G.toString());
        System.out.println();
        System.out.println(G.reverse().toString());
    }
}
