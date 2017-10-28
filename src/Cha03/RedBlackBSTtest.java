package Cha03;

public class RedBlackBSTtest {
    public static void main(String[] args){
        RedBlackBST redBlackBST = new RedBlackBST();
        redBlackBST.put("S",0);
        redBlackBST.put("E",1);
        redBlackBST.put("A",2);
        redBlackBST.put("R",3);
        redBlackBST.put("C",4);
        redBlackBST.put("H",5);
        redBlackBST.put("X",6);
        redBlackBST.put("M",7);
        redBlackBST.put("P",8);
        redBlackBST.put("L",9);

        System.out.println(redBlackBST.get("A"));
        System.out.println(redBlackBST.size());
    }
}
