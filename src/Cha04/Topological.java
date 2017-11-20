package Cha04;


public class Topological {
    private Iterable<Integer> order;
    public Topological(Digraph G){
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if (!cyclefinder.hasCycle()){
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    /**
     *
     * @return 拓扑有序的所有顶点
     */
    public Iterable<Integer> getOrder() {
        return order;
    }

    /**
     *
     * @return G有无环图吗
     */
    public boolean isDAG(){
        return order != null;
    }

    public static void main(String[] args){
        String filename = args[0];
        String separator = args[1];
        SymbolDigraph sg = new SymbolDigraph(filename,separator);

        Topological top = new Topological(sg.G());

        for (int v : top.getOrder())
            System.out.println(sg.name(v));
    }
}
