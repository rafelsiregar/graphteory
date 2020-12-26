import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
        public static void fill(boolean[][] graph){
                for(int i=0;i<graph.length;i++){
                        for(int j=0;j<graph[0].length;j++){
                                graph[i][j]=false;
                        }
                }
        }
        
        
        public static void optimize(int[] array, int startNode){
                for(int i=0;i<array.length;i++){
                        if(i!=startNode-1 && array[i]==0)
                                array[i]=-1;
                }
        }
        
          public static void print(boolean[][] graph){
                for(int i=0;i<graph.length;i++){
                        System.out.println();
                        for(int j=0;j<graph[0].length;j++){
                                System.out.print(graph[i][j]+" ");
                        }
                }
        }
        public static void main(String[] args){
                Scanner s = new Scanner(System.in);
                int q = s.nextInt();
                while(q-->0){
                        //Number of vertex
                        int n = s.nextInt();
                        //Number of edge
                        int m = s.nextInt();
                        //Adjacency graph
                        boolean graph[][]=new boolean[n][n]; 
                        for(int i=0;i<m;i++){
                                int u = s.nextInt();
                                int v = s.nextInt();
                                //Make an edge of two graph
                                graph[u-1][v-1]=true;
                                graph[v-1][u-1]=true;
                        }
                        
                        int startNode = s.nextInt();
                        //Visited node
                        boolean visited[]=new boolean[n];
                        int level[] = new int[n];
                        int dist[] = new int[n];
                        //Perform BFS Using Queue
                        Queue<Integer> queue = new LinkedList<>();
                        //Mark as visited and add the start Node
                        visited[startNode-1]=true;
                        level[startNode-1] = 0;
                        queue.add(startNode);
                        while(!queue.isEmpty()){
                                //Show front element in the array
                                int current = queue.poll();
                                for(int i=0;i<n;i++){
                                        if(graph[current-1][i]==true){
                                                if(!visited[i]){
                                                        level[i]=level[current-1]+1;
                                                        visited[i]=true;
                                                        queue.add(i+1);
                                                        dist[i]=6*level[i];
                                                }
                                        }
                                }
                        }
                        optimize(dist, startNode);
                       for(int i=0;i<dist.length;i++){
                               if(i==startNode-1) continue;
                               else System.out.print(dist[i]+" ");
                       } 
                       System.out.println();
                }
        }
}
