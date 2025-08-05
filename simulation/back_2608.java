package simulation;

import java.io.*;
import java.util.*;

import javax.swing.text.html.parser.Entity;

public class back_2608 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String q1 = br.readLine();
		String q2 = br.readLine();
		String q3="";
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("I", 1);
		map.put("IV", 4);
		map.put("V", 5);
		map.put("IX", 9);
		map.put("X", 10);
		map.put("XL", 40);
		map.put("L", 50);
		map.put("XC", 90);
		map.put("C", 100);
		map.put("CD", 400);
		map.put("D", 500);
		map.put("M", 1000);
		map.put("CM", 900);

		int res1 = 0;
		for(int i=0;i<q1.length();i++)
		{
			char c = q1.charAt(i);

			if(i<q1.length()-1 && (c=='I' || c=='X' || c=='C'))
			{
				String temp = q1.substring(i,i+2);
				if(map.containsKey(temp)) {
					res1 += map.get(temp);
					i++;
					continue;
				}
			}
			res1 += map.get(q1.charAt(i)+"");
		}
		for(int i=0;i<q2.length();i++)
		{
			char c = q2.charAt(i);

			if(i<q2.length()-1 && (c=='I' || c=='X' || c=='C'))
			{
				String temp = q2.substring(i,i+2);
				if(map.containsKey(temp)) {
					res1 += map.get(temp);
					i++;
					continue;
				}
			}
			res1 += map.get(q2.charAt(i)+"");
		}

		System.out.println(res1);

		List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
		list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
		while(res1!=0)
		{

			int res2 =0;
			for(Map.Entry<String,Integer> entry : list)
			{
					res2 = res1/entry.getValue();
					if(res2!=0)
					{
						for(int i=0;i<res2;i++)
						{
							q3+= entry.getKey();
						}
						res1 = res1%entry.getValue();
						break;
					}

			}

		}
		System.out.print(q3);
	}
}
