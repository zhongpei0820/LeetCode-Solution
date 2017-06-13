#Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
#
#
#
#postTweet(userId, tweetId): Compose a new tweet.
#getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
#follow(followerId, followeeId): Follower follows a followee.
#unfollow(followerId, followeeId): Follower unfollows a followee.
#
#
#
#Example:
#
#Twitter twitter = new Twitter();
#
#// User 1 posts a new tweet (id = 5).
#twitter.postTweet(1, 5);
#
#// User 1's news feed should return a list with 1 tweet id -> [5].
#twitter.getNewsFeed(1);
#
#// User 1 follows user 2.
#twitter.follow(1, 2);
#
#// User 2 posts a new tweet (id = 6).
#twitter.postTweet(2, 6);
#
#// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
#// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
#twitter.getNewsFeed(1);
#
#// User 1 unfollows user 2.
#twitter.unfollow(1, 2);
#
#// User 1's news feed should return a list with 1 tweet id -> [5],
#// since user 1 is no longer following user 2.
#twitter.getNewsFeed(1);
#
#

class Twitter(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.myTweet = collections.defaultdict(list)
        self.myFollow = collections.defaultdict(set)
        self.time = 0

    def postTweet(self, userId, tweetId):
        """
        Compose a new tweet.
        :type userId: int
        :type tweetId: int
        :rtype: void
        """
        self.myTweet[userId].append((self.time,tweetId))
        self.time += 1
        if len(self.myTweet[userId]) > 10 : self.myTweet[userId] = self.myTweet[userId][1:]

    def getNewsFeed(self, userId):
        """
        Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
        :type userId: int
        :rtype: List[int]
        """
        h = []
        for tweet in self.myTweet[userId] :
            # heapq.heappush(h,tweet)
            if len(h) == 10 : 
                heapq.heappushpop(h,tweet)
            
                # heapq.heapreplace(h,tweet)
            else: heapq.heappush(h,tweet)
        for user in self.myFollow[userId] :
            for tweet in self.myTweet[user] :
                # heapq.heappush(h,tweet)
                if len(h) == 10:
                    heapq.heappushpop(h,tweet)
                else : heapq.heappush(h,tweet)
        ret = []
        while len(h) > 0:
            time,post = heapq.heappop(h)
            ret.append(post)
        ret.reverse()
        return ret
        

    def follow(self, followerId, followeeId):
        """
        Follower follows a followee. If the operation is invalid, it should be a no-op.
        :type followerId: int
        :type followeeId: int
        :rtype: void
        """
        if followerId == followeeId : return
        self.myFollow[followerId].add(followeeId)

    def unfollow(self, followerId, followeeId):
        """
        Follower unfollows a followee. If the operation is invalid, it should be a no-op.
        :type followerId: int
        :type followeeId: int
        :rtype: void
        """
        if followeeId in self.myFollow[followerId] : self.myFollow[followerId].remove(followeeId)
        


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)