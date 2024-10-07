package SeoulScient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class d_x_xplus1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>();
		Long x = Long.parseLong(st.nextToken());
		for(int i = 1; i<Math.sqrt(x+1); i++)
		{
			if((x+1)%i==0)
			{
				list.add(i);
				if(i!=(x+1)/i)
					list.add((int)(x+1)/i);
			}
		}
		list.sort((Comparator.naturalOrder()));
		for(int i = 0; i < list.size()-1; i++)
		{
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);
	}

}
