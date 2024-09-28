package kakaowinterIntership2024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class manyGift
{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    }



    static class Solution {
        public int solution(String[] friends, String[] gifts) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < friends.length; i++) {
                map.put(friends[i], i);
            }



            int []giftsCount = new int[friends.length];

           int [][]giftBox = new int[friends.length][friends.length];
           int []result=new int[friends.length];
            for(String gift : gifts)
            {
                String send = gift.split(" ")[0];
                String receive = gift.split(" ")[1];
                giftBox[map.get(send)][map.get(receive)]++;
                giftsCount[map.get(send)]++;
                giftsCount[map.get(receive)]--;
            }
            for(String friend : friends)
            {
                int index=map.get(friend);
                for(int i=index+1;i<friends.length;i++) {
                    if(giftBox[index][i]>giftBox[i][index])
                    {
                        result[index]++;
                    }
                    else if(giftBox[index][i]==giftBox[i][index])
                    {
                        if(giftsCount[index]>giftsCount[i])
                        {
                            result[index]++;
                        }
                        else if(giftsCount[index]<giftsCount[i]){
                            result[i]++;
                        }
                    }
                    else{
                        result[i]++;
                    }
                }

            }

            int answer = 0;
            for(int i : result)
            {
               if(answer<i)
                {
                     answer=i;
                }
            }
            return answer;
        }



    }
}
