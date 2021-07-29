package graph.base;

import java.util.LinkedList;
import java.util.Queue;

//无向图
public class Graph {

    //顶点的个数
    private int v;
    //邻接表
    private LinkedList<Integer> adj[];
    //标记DFS是否找到顶点
    boolean found = false;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    //无向图一条边存两次
    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先搜索(BFS)
     * 先查找起始顶点最近的，然后是次近的，依次往外搜索
     * 跟树的广度优先遍历类似，先将顶点相邻的所有顶点放入队列中，然后再依次访问这些顶点的相邻顶点
     *
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
        //1、s表示起始顶点，t表示终止顶点，搜索一条从s到t的最短路径
        if (s == t) {
            return;
        }
        //2、visited用来记录已经被访问的顶点，用来避免顶点被重复访问。如果顶点q被访问，那相应的visited[q]会被设置为true
        boolean[] visited = new boolean[v];
        visited[s] = true;
        //3、queue用来存储已经被访问、但相连的顶点还没有被访问的顶点。
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        //4、prev用来记录搜索路径，当我们从顶点s开始，广度优先搜索到顶点t后，prev数组中存储的就是搜索的路径。
        //这个路径是反向存储的，prev[w]存储的是，顶点w是从哪个前驱顶点遍历过来的。比如：通过顶点2的邻接表访问到顶点3，那prev[3]就等于2，
        //为了正向打印出路径，我们需要递归地来打印
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        while (!queue.isEmpty()) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                //获取已访问顶点的相邻顶点
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    /**
     * 深度优先遍历(DFS)
     * 运用了回溯思想，每次下潜遇到分岔口，先进入，不行就返回到上一顶点
     * 与树的深度优先遍历类似
     *
     * @param s
     * @param t
     */
    public void dfs(int s, int t) {
        //记录是否找到目标顶点t，递归出口
        found = false;
        //visited保存访问过的顶点
        boolean[] visited = new boolean[v];
        //prev记录搜索路径，与BFS一样
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        //遍历分岔口
        for (int i = 0; i < adj[w].size(); i++) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }

    //递归打印s->t的路径
    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.println(t + " ");
    }
}
