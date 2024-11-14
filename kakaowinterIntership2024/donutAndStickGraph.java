package kakaowinterIntership2024;

import java.util.ArrayList;

import kakaoblind2023.emoticon;

public class donutAndStickGraph {
//https://school.programmers.co.kr/learn/courses/30/lessons/258711


        static boolean visited[];
        static ArrayList<Integer> A[];
        public int[] solution(int[][] edges) {
               A= new ArrayList[edges.length+1];

                for(int i=1;i<=A.length;i++)
                {
                     A[i]=new ArrayList<>();
                }
               for(int[] edge: edges)
               {
                    A[edge[0]].add(edge[1]);
               }
               for(int i=1;i<=A.length;i++)
               {
                 DFS(i,1,0);
               }





            visited = new boolean[edges.length+1];
            int[] answer = {};
            return answer;
        }

        static void DFS(int v,int point,int line)
        {
            if(visited[v])
                return;
            visited[v]=true;

            for(int i : A[v])
            {
                line++;
                if(visited[i]==false)
                {
                    DFS(i,point,line);
                }
                else{
                    if(point==line)
                    {
                        point++;
                    }
                }
            }
            if(point==line)
            {
                System.out.println("point: "+point+" line: "+line+" donut");
            }
            else if(point-1==line){
                System.out.println("point: "+point+" line: "+line+ "stick");
            }
        }

        static class Edge{
            int start;
            int end;
            Edge(int start, int end)
            {
                this.start=start;
                this.end=end;
            }
        }
    public static void main(String[] args) {
        donutAndStickGraph d = new donutAndStickGraph();
        int[][] edges = {{2, 3}, {4, 3}, {1, 1}, {2, 1}};

        int []answer = d.solution(edges);
        System.out.println(answer);


    }
}


