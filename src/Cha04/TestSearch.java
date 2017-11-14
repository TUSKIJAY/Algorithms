package Cha04;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TestSearch {
    public static void main(String[] args){
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(G,s);
        System.out.println(G.toString());
        for (int v = 0;v < G.V();v++) {
            if (depthFirstSearch.marked(v))
                StdOut.print(v + " ");
        }
        System.out.println(depthFirstSearch.count());

        if (depthFirstSearch.count() != G.V()) {
            StdOut.print("NOT");
        }
        System.out.println(" connected");
    }
}
