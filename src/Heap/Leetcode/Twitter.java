package Heap.Leetcode;


import java.util.*;

public class Twitter {

    HashMap<Integer, Set<Integer>> follows = new HashMap<>();
    int time = 0;
    HashMap<Integer, PriorityQueue<int[]>> tweets = new HashMap<>();


    public Twitter() {
    }

    public void postTweet(int userId, int tweetId) {
        int[] arr = {tweetId, time};
        if(!tweets.containsKey(userId)){
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
            queue.offer(arr);
            tweets.put(userId, queue);
        }else{
            PriorityQueue<int[]> queue = tweets.get(userId);
            queue.offer(arr);
        }
        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        if (tweets.containsKey(userId))
            queue.addAll(tweets.get(userId));

        Set<Integer> follow = follows.get(userId);
        List<Integer> feed = new ArrayList<>();
        if (follow != null) {
            for (Integer i : follow) {
                if (tweets.containsKey(i))
                    queue.addAll(tweets.get(i));
            }
        }
        int count = 1;
        while (count <= 10 && !queue.isEmpty()) {
            feed.add(queue.remove()[0]);
            count++;
        }

        return feed;
    }

    public void copyQueue(PriorityQueue<int[]> q1, PriorityQueue<int[]> q2){
        PriorityQueue<int []> temp = new PriorityQueue<>(q2);
        while(!temp.isEmpty()){
            int[] arr = temp.remove();
            q1.offer(arr);
        }
    }

    public void follow(int followerId, int followeeId) {
        if(follows.containsKey(followerId)){
            Set<Integer> follow = follows.get(followerId);
            if(follow == null){
                follow = new HashSet<>();
            }
            follow.add(followeeId);
        }else{
            Set<Integer> follow = new HashSet<>();
            follow.add(followeeId);
            follows.put(followerId, follow);
        }

    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> follow = follows.get(followerId);
        if(follow == null){
            follow = new HashSet<>();
            return;
        }
        follow.remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        twitter.getNewsFeed(1);
        twitter.follow(2, 1);
        twitter.getNewsFeed(2);
        twitter.unfollow(2, 1);
        twitter.getNewsFeed(2);

        System.out.println();
    }

}
