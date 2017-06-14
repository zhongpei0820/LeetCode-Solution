#
#Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
#
#
#Only one letter can be changed at a time
#Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
#
#
#
#For example,
#
#
#Given:
#beginWord = "hit"
#endWord = "cog"
#wordList = ["hot","dot","dog","lot","log","cog"]
#
#
#Return
#
#  [
#    ["hit","hot","dot","dog","cog"],
#    ["hit","hot","lot","log","cog"]
#  ]
#
#
#
#
#Note:
#
#Return an empty list if there is no such transformation sequence.
#All words have the same length.
#All words contain only lowercase alphabetic characters.
#You may assume no duplicates in the word list.
#You may assume beginWord and endWord are non-empty and are not the same.
#
#
#
#
#UPDATE (2017/1/20):
#The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
#

class Solution(object):
    def findLadders(self,beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: List[List[str]]
        """
        isVisited = {beginWord}
        adj = collections.defaultdict(list)
        wordSet = set()
        for word in wordList : wordSet.add(word)
        def nextNeighbor(currWord):
            nextBegin = []
            for i in range(len(currWord)):
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    nextWord = currWord[:i] + c + currWord[i + 1:]
                    if nextWord in wordSet and nextWord not in isVisited:
                        nextBegin.append(nextWord)
            return nextBegin
    
        def bfs(currWord):
            if len(currWord) == 0 : return False
            isFound = False
            nextWord = set()
            for word in currWord:
                currNeighbor = nextNeighbor(word)
                for neighbor in currNeighbor:
                    if neighbor == endWord : isFound = True
                    adj[word].append(neighbor)
                    nextWord.add(neighbor)
            for word in nextWord:
                isVisited.add(word)
            if isFound : return isFound
            else : return bfs(list(nextWord))
    
        def findPath(adj,beginWord,endWord,currList,ret):
            if beginWord == endWord :
                ret.append(currList)
                return
            neighbors = adj[beginWord]
            for word in neighbors:
                findPath(adj,word,endWord,currList + [word], ret)
    
        ret = []
        if bfs([beginWord]) :
            findPath(adj, beginWord, endWord, [beginWord], ret)
            return ret
        else :
            return []
                
                