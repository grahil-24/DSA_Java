package Trie;

import java.util.TreeMap;

class Node{
    Node[] links = new Node[26];
    boolean flag = false;

    public Node(){

    }

    boolean containsKey(char ch){
        return (links[ch - 'a'] != null);
    }

    Node get(char ch){
        return links[ch-'a'];
    }

    void put(char ch, Node node){
        links[ch-'a'] = node;
    }

    void setEnd(){
        flag = true;
    }

    boolean isEnd(){
        return flag;
    }
}

public class Trie {

    private static Node root;

    Trie(){
        root = new Node();
    }

    public static void insert(String word){
        Node node = root;
        for(int i = 0; i<word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public static boolean search(String word){
        Node node = root;
        for(int i =0; i< word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        if(node.isEnd()){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        insert("hello");
        System.out.println(search("helloo"));
    }
}
