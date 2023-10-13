package algorithmic.total.solution.leetcode;

import algorithmic.base.TrieTree;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2023-02-08
 **/
public class Question1233 {

    public static class DicTree {

        private Node root;

        public DicTree() {
            this.root = new Node();
        }

        public static class Node {
            private int pass;
            private int end;
            private Map<String, Node> map;

            public Node() {
                this.pass = 0;
                this.end = 0;
                this.map = new HashMap<>();
            }
        }

        public void insert(String str) {
            if (str == null || "".equals(str) || "/".equals(str)) {
                return;
            }
            String[] path = str.split("/");
            Node current = root;
            root.pass++;
            for (int i = 1; i < path.length; i++) {
                String key = path[i];
                Node node = current.map.get(key);
                if (node == null) {
                    node = new Node();
                    current.map.put(key, node);
                }
                node.pass++;
                current = node;
            }
            current.end++;
        }

        void getAllPath(Node node, List<String> allPath, String preString) {
            Map<String, Node> map = node.map;
            for (Map.Entry<String, Node> entry : map.entrySet()) {
                String key = entry.getKey();
                Node value = entry.getValue();
                if (value.end > 0) {
                    allPath.add(preString + "/" + key);
                    if (value.pass > 1) {
                        continue;
                    }
                }
                getAllPath(value, allPath, preString + "/" + key);
            }
        }

    }


    public static List<String> removeSubfolders(String[] folder) {

        List<String> result = new ArrayList<>();
        DicTree dicTree = new DicTree();
        for (String s : folder) {
            dicTree.insert(s);
        }
        dicTree.getAllPath(dicTree.root, result, "");
        return result;
    }

    public static void main(String[] args) {
        String str = "/s/d/w/q";
        String[] folder = new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        System.out.println(removeSubfolders(folder));
    }
}

