
class Twitter {
    int tweetUid;
    HashMap<Integer, List<int[]>> tweetMap;
    HashMap<Integer, HashSet<Integer>> followerMap;

    public Twitter() {
        tweetUid = 0;
        tweetMap = new HashMap<>();
        followerMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[] { tweetUid++, tweetId });
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        var tweetsOfOwn = tweetMap.get(userId);
        if (tweetsOfOwn != null) {
            for (var tweet : tweetsOfOwn) {
                heap.offer(new int[] { tweet[0], tweet[1] });
            }
        }

        var followingList = followerMap.get(userId);
        if (followingList != null) {
            for (var following : followingList) {
                var tweetsOfFollowing = tweetMap.get(following);
                if (tweetsOfFollowing != null) {
                    for (var tweet : tweetsOfFollowing) {
                        heap.offer(new int[] { tweet[0], tweet[1] });
                    }
                }
            }
        }

        int i = 0;
        while (result.size() < 10 && !heap.isEmpty()){
            var tweet = heap.poll();
            if (tweet != null) {
                var tweetId = tweet[1];
                result.add(tweetId);
            }
            i++;
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        followerMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        followerMap.computeIfAbsent(followerId, k -> new HashSet<>()).remove(followeeId);
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