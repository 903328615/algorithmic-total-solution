package algorithmic.base;

import com.sun.tools.javac.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: algorithmic-total-solution
 * @description: 字典树
 * @author: wangzibin
 * @create: 2022-11-26
 **/
public class TrieTree {

    private Node root;

    public TrieTree() {
        root = new Node();
    }

    private static class Node {
        int pass;
        int end;
        Map<Integer, Node> next;

        public Node() {
            this.pass = 0;
            this.end = 0;
            this.next = new HashMap<>();
        }
    }

    public void insert(String str) {
        if (str == null || str.length() < 1) {
            return;
        }
        int length = str.length();
        Node current = root;
        root.pass++;
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            int index = c - 'a';
            Node node = current.next.get(index);
            if (node == null) {
                node = new Node();
                current.next.put(index, node);
            }
            node.pass++;
            current = node;
        }
        current.end++;
    }

    public void delete(String str) {
        if (getNum(str) == 0) {
            return;
        }
        int length = str.length();
        Node current = root;
        root.pass--;
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            int index = c - 'a';
            Node node = current.next.get(index);
            node.pass--;
            if (node.pass == 0){
                // 当某个通路 pass 已经是 0 则直接 remove 完成 delete
                current.next.remove(index);
                return;
            }
            current = node;
        }
        current.end--;
    }

    public int getNum(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        int length = str.length();
        Node current = root;
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            int index = c - 'a';
            Node node = current.next.get(index);
            if (node == null) {
                return 0;
            }
            current = node;
        }
        return current.end;
    }

    public int getPrefixNum(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        int length = str.length();
        Node current = root;
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            int index = c - 'a';
            Node node = current.next.get(index);
            if (node == null) {
                return 0;
            }
            current = node;
        }
        return current.pass;
    }

    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();
        trieTree.insert("abccd");
        trieTree.insert("abccd");
        trieTree.insert("abccd");
        trieTree.insert("abccd");
        trieTree.insert("abccd");
        trieTree.insert("abccde1123%^$$8*吧");
        trieTree.insert("abccdf");
        trieTree.insert("abccdq");
        System.out.println(trieTree.getNum("abccde1123%^$$8*吧"));
        System.out.println(trieTree.getPrefixNum("abccde1123%^$$"));
        System.out.println(trieTree.getNum("abccd"));
        System.out.println(trieTree.root.pass);
        trieTree.delete("abccde1123%^$$8*吧");
        trieTree.delete("abccde");
        trieTree.delete("abccd");
        trieTree.delete("abccd");
        trieTree.delete("abccd");
        trieTree.delete("abccd");
        trieTree.delete("abccd");
        trieTree.delete("abccd");
        System.out.println(trieTree.getPrefixNum("abccde1123%^$$8*吧"));
        System.out.println(trieTree.getPrefixNum("abccde1123%^$$"));
        System.out.println(trieTree.getNum("abccd"));
        System.out.println(trieTree.root.pass);

    }

}

