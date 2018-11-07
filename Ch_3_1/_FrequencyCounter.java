package Ch_3_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by HuGuodong on 2018/11/5.
 */

public class _FrequencyCounter {


//  java Ch_3_1._FrequencyCounter 8 < E:\gitspace\x1c\Alg4\algs4\src\main\java\Ch_3_1\tale.txt
//  java Ch_3_1._FrequencyCounter 10 < E:\gitspace\x1c\Alg4\algs4\src\main\java\Ch_3_1\leipzig1M.txt

  public static void main(String[] args) {

    Stopwatch stopwatch = new Stopwatch();

    int minlen = Integer.parseInt(args[0]); // key-length cutoff
    _SequentialSearchST<String, Integer> st = new _SequentialSearchST<>();
    while (!StdIn.isEmpty()){
      String word = StdIn.readString();
      if(word.length() < minlen){
        continue;
      }

      if(!st.contains(word)){ // put W
        st.put(word, 1);
      }else{
        st.put(word, st.get(word) + 1); // get W-D
      }
    }

    // find the key with the highest frequency count
    String max = "";
    st.put(max, 0); // put 1次
    for(String word : st.keys()){
      if(st.get(word) > st.get(max)){ // get 2D 次
        max = word;
      }
    }

    StdOut.println(max + " " + st.get(max)); // get 1 次
    StdOut.println(stopwatch.elapsedTime());

  }

}
