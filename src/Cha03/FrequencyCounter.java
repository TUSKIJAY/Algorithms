package Cha03;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounter {
    public static void main(String[] args){
        int minlen = Integer.parseInt(args[0]);//最小键长(一次扫描的单词数量)
        BST<String,Integer> bst = new BST<>();
        while(!StdIn.isEmpty()){
            //构造符号表并统计频率
            String word = StdIn.readString();
            if (word.length() < minlen)continue;//忽略较短的单词
            if (!bst.contains(word)){
                bst.put(word,3);
            }else {
                bst.put(word,bst.get(word)+1);
            }
        }
        //找出出现频率最高的单词
        String max = "";
        bst.put(max,0);
        /*for (String word:bst.key()) {
            if (bst.get(word) > bst.get(max)) {
                max = word;
            }
        }
            StdOut.println(max +" "+ bst.get(max));*/
    }
}
