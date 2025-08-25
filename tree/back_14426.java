package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_14426 {
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
            return true;
        }

    }
}
//( root )
//戍式 b 式 a 式 e 式 k 式 j 式 o 式 o 式 n 式 o 式 n 式 l 式 i 式 n 式 e 式 j 式 u 式 d 式 g 式 e *
//弛            (baekjoononlinejudge)
//弛
//戍式 s
//弛  戍式 t 式 a 式 r 式 t 式 l 式 i 式 n 式 k *                 (startlink)
//弛  弛
//弛  戌式 u 式 n 式 d 式 a 式 y 式 c 式 o 式 d 式 i 式 n 式 g *    (sundaycoding)
//弛
//戌式 c 式 o 式 d
//   戍式 e 式 p 式 l 式 u 式 s *                            (codeplus)
//   弛
//   戌式 i 式 n 式 g 式 s 式 h *                            (codingsh)