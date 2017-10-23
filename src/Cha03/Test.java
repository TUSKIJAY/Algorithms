package Cha03;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Test {
    public static void main(String[] args) {
        BinarySearchST<String, Integer> bst = new BinarySearchST<>(12);
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            bst.put(key, i);
        }
        //bst.delete("A");
        bst.pull();
        System.out.println("The key words number is "+ bst.get("P"));
        //System.out.println("The arry size is "+bst.size());
        bst.delete("P");
        bst.pull();
        //System.out.println("The key words number is "+ bst.rank("Z"));
        //System.out.println("The arry size is "+bst.size());

    }
}
