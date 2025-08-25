package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_14425 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Trie trie = new Trie();
        for(int i=0;i<N;i++)
        {
            trie.insert(br.readLine());
        }
        int result =0;
        for(int i=0;i<M;i++)
        {
            if(trie.contains(br.readLine()))
                result++;
        }
        System.out.println(result);
    }

    static class TrieNode{
        TrieNode[] next = new TrieNode[26];
        boolean isEnd;
    }
    static class Trie{
        private final TrieNode root = new TrieNode();

        void insert(String s){
            TrieNode cur = root;
            for(int i=0;i<s.length();i++)
            {
                int idx = s.charAt(i)-'a';
                if(cur.next[idx]==null) cur.next[idx] = new TrieNode();
                cur = cur.next[idx];
            }
            cur.isEnd = true;
        }
        boolean contains(String s)
        {
            TrieNode cur = root;
            for(int i=0;i<s.length();i++)
            {
                int idx  = s.charAt(i)-'a';
                if(idx<0 || idx>=26 || cur.next[idx]==null) return false;
                cur = cur.next[idx];
            }
            return cur.isEnd;
        }

    }
}
