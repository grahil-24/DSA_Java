package Graphs;

import java.util.*;

class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res =0;
        if(!wordList.contains(endWord)){
            return res;
        }
        HashMap<String, String> visited = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while(!queue.isEmpty()){
            String current_node = queue.poll();
            if(current_node.equals(endWord)){
                break;
            }
            List<String> neighbors = get_neighbors(current_node, wordList);
            for(String str: neighbors){
                if(visited.containsKey(str)){
                    continue;
                }else{
                    queue.offer(str);
                    visited.put(str, current_node);
                }

            }
        }
        if(!visited.containsKey(endWord)){
            return 0;
        }
        String current = endWord;
        while(true){
            String parent = visited.get(current);
            res++;
            if(parent.equals(beginWord)){
                break;
            }
            current = parent;
        }
        return res+1;
    }

    public List<String> get_neighbors(String beginWord, List<String>wordList){
        List<String> neighbors = new ArrayList<>();

        for(String str: wordList){
            if(beginWord.equals(str)){
                continue;
            }
            int diff = 0;
            for(int i = 0; i<str.length(); i++){
                if(beginWord.charAt(i) != str.charAt(i)){
                    diff++;
                }
                if(diff == 1 && i == str.length()-1){
                    neighbors.add(str);
                }
            }
        }
        return neighbors;
    }

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        String beginWord = "hit";
        String endWord = "cog";
        System.out.println(wl.ladderLength(beginWord,  endWord, wordList));
    }
}