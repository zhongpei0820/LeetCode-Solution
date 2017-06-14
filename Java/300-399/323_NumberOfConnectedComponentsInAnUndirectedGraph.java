// Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

// Example 1:
//      0          3
//      |          |
//      1 --- 2    4
// Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

// Example 2:
//      0           4
//      |           |
//      1 --- 2 --- 3
// Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

// Note:
// You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

// Soluton 1 : Quick Find. Each union, n = n - 1.


public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] id = new int[n];
        int count = n;
        for(int i = 0; i < n; i++) id[i] = i;
        for(int i = 0; i < edges.length; i++){
            int p1 = edges[i][0];
            int p2 = edges[i][1];
            if(id[p1] == id[p2]) continue;
            int temp = id[p2];
            for(int j = 0; j < id.length; j++){
                if(id[j] == temp) id[j] = id[p1];        
            }
            count--;
        }
        return count;
    }
}


// Solution 2 : Quick Union

public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] root = new int[n];
        int count = n;
        for(int i = 0; i < n; i++) root[i] = i;
        for(int i = 0; i < edges.length; i++){
            int p = find(root,edges[i][0]);
            int q = find(root,edges[i][1]);
            if(p != q){
                root[p] = q;
                count--;
            }
        }
        return count;
    }
    
    private int find(int[] root, int id){
        while(root[id] != id){
            id = root[root[id]];
        }
        return id;
    }
}


// Solution 3: Quick Union with Path Compression.

public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] root = new int[n];
        int count = n;
        for(int i = 0; i < n; i++) root[i] = i;
        for(int i = 0; i < edges.length; i++){
            int p = find(root,edges[i][0]);
            int q = find(root,edges[i][1]);
            if(p != q){
                root[p] = q;
                count--;
            }
        }
        return count;
    }
    
    private int find(int[] root, int id){
        while(root[id] != id){
            root[id] = root[root[id]];
            id = root[id];
        }
        return id;
    }
}


