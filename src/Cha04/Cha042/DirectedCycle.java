package Cha04.Cha042;

import Cha01.Stack;

public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;//有向环中的所有顶点（如果存在的话）
    private boolean[] onStack;//递归调用的栈上的顶点

    public DirectedCycle(Digraph G){
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0;v < G.V();v++)
            if (!marked[v]) dfs(G,v);
    }

    private void dfs(Digraph G,int v){
        onStack[v] = true;
        marked[v] = true;
        for (int w:G.adj(v)){//将每一个G.adj(v)赋值给w，然后对每个w执行以下操作
            if (this.hasCycle()) return;
            else if (!marked[w]){
                edgeTo[w] = v;//在找到有向环时返回环中的所有顶点
                dfs(G,w);
            }
            else if (onStack[w]){
                cycle = new Stack<>();
                for (int x = v;x != w;x = edgeTo[x])
                    cycle.push(x);

                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    /**
     * G是否含有有向环
     * @return 是否有有向环
     */
    public boolean hasCycle(){ return cycle != null;}

    /**
     *
     * @return 有向环中的所有的顶点（如果存在的话）
     */
    public Iterable<Integer> cycle(){ return cycle;}
}
