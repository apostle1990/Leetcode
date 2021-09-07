package LinkedList;

import java.util.*;

public class Twitter {
    private class Tweet {
        private int timestamp;
        private int id;
        private Tweet next;
        public Tweet(int id, int timestamp){
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    HashMap<Integer, Tweet> twitter;
    HashMap<Integer,Set<Integer>> followings;
    private static int timestamp =0;
    private static PriorityQueue<Tweet> maxheap;

    /** Initialize your data structure here. */
    public Twitter() {
        followings = new HashMap<>();
        twitter = new HashMap<>();
        maxheap = new PriorityQueue<>((o1, o2) -> o1.timestamp + o2.timestamp);
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        if (twitter.containsKey(userId)){
            Tweet oldhead = twitter.get(userId);
            Tweet newhead = new Tweet(userId,timestamp);
            newhead.next = oldhead;
            twitter.put(userId, newhead);
        }else {
            twitter.put(userId,new Tweet(tweetId,timestamp));
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        maxheap.clear();
        if (twitter.containsKey(userId)){
            maxheap.offer(twitter.get(userId));
        }
        Set<Integer> followinglist = followings.get(userId);
        if (followinglist !=null && followinglist.size() >0){
            for (Integer followingid : followinglist){
                Tweet tweet = twitter.get(followingid);
                if (tweet != null) {
                    maxheap.offer(tweet);
                }
            }
        }
        List<Integer> res = new ArrayList<>(10);
        int count =0;
        while (!maxheap.isEmpty() && count<10){
            Tweet head = maxheap.poll();
            res.add(head.id);

            if (head.next !=null){
                maxheap.offer(head.next);
            }
            count++;
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId){
            return;
        }
        Set<Integer> followinglist = followings.get(followeeId);
        if (followinglist == null){
            Set<Integer> init = new HashSet<>();
            init.add(followeeId);
            followings.put(followeeId, init);
        }else {
            if (followinglist.contains(followeeId)){
                return;
            }
            followinglist.add(followeeId);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId){
            return;
        }
        Set<Integer> followingList = followings.get(followerId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
