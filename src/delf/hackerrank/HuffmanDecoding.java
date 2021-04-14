package hackerrank;

import java.util.Objects;

/**
 * Huffman Decoding
 * https://www.hackerrank.com/challenges/tree-huffman-decoding/problem
 */
public class HuffmanDecoding {
    static void decode(String s, Node root) {
        String answer = "";
        Node base = Objects.requireNonNull(root);
        while (!s.isEmpty()) {
            base = s.charAt(0) == '1' ? Objects.requireNonNull(base.right) : Objects.requireNonNull(base.left);
            s = s.substring(1);

            if (Objects.isNull(base.left) && Objects.isNull(base.right)) {
                answer += base.data;
                base = root;
            }
        }
        System.out.println(answer);
    }

    class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;
    }
}
