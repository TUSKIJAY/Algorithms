package Cha03;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Test {
    public static void main(String[] args) {
        BinarySearchST<String, Integer> bsst = new BinarySearchST<>(12);
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            bsst.put(key, i);
        }
        //bst.delete("A");
        bsst.pull();
        System.out.println("The key words number is "+ bsst.get("P"));
        //System.out.println("The arry size is "+bst.size());
        bsst.delete("P");
        bsst.pull();
        //System.out.println("The key words number is "+ bst.rank("Z"));
        //System.out.println("The arry size is "+bst.size());

    }
}
