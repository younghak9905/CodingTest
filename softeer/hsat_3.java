package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class hsat_3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String password = br.readLine();
		password.replaceAll("J", "I");
		String key = br.readLine(); //j==i
		key.replaceAll("J", "I");
		char [][]map = new char[5][5];
		int []check = new int[26];
		int cnt = 0;
		HashMap<Character,int[]> table = new HashMap<>();
		for(int j=0;cnt<25 && j<key.length();)
		{	char c = key.charAt(j++);
			if(c=='I') check['J'-'A']=1;
			if(check[c-'A']==1) continue;
			check[c-'A']=1;
			map[cnt/5][cnt%5]=c;
			table.put(c,new int[] {cnt/5,cnt%5});
			cnt++;
		}

		for(int i=0;i<=25 && cnt<25;i++)
		{
			char c = (char)(i+'A');
			if(c=='J') c='I';
			if(check[c-'A']==1) continue;
			map[cnt/5][cnt%5]=c;
			table.put(c,new int[] {cnt/5,cnt%5});
			check[c-'A']=1;
			cnt++;
		}
		ArrayList<String> list = new ArrayList<>();
		for(int i=0;i<password.length();i++)
		{
			if(i==password.length()-1)
				list.add(password.charAt(i)+"X");
			else if(password.charAt(i)==password.charAt(i+1))
			{
				if(password.charAt(i)=='X')
					list.add(password.charAt(i)+"Q");
				else
					list.add(password.charAt(i)+"X");
			}
			else
				list.add(password.charAt(i)+""+password.charAt(++i));
		}
		StringBuilder sb = new StringBuilder();
		while (list.size()>0)
		{
			String s = list.remove(0);
			char a = s.charAt(0);
			char b = s.charAt(1);
			int []posA = table.get(a);
			int []posB = table.get(b);
			if(posA[0]==posB[0])
			{
				sb.append(map[posA[0]][(posA[1]+1)%5]);
				sb.append(map[posB[0]][(posB[1]+1)%5]);
			}else if(posA[1]==posB[1]) {
				sb.append(map[(posA[0] + 1) % 5][posA[1]]);
				sb.append(map[(posB[0] + 1) % 5][posB[1]]);
			}
			else {
				sb.append(map[posA[0]][posB[1]]);
				sb.append(map[posB[0]][posA[1]]);
			}
		}
		System.out.println(sb);


	}
}

//HELLOWORLD  password
// PLAYFAIRCIPHERKEY   key