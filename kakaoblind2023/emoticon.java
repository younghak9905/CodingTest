package kakaoblind2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class emoticon {
	public int[] solution(int[][] users, int[] emoticons) {
		int[] answer = {};
		ArrayList<Integer> list = new ArrayList<>();
		answer = new int[list.size()];
		int max=0;
		Map<Integer, User> termap = new HashMap<>();
		for (int i = 0; i < users.length; i++) {
			termap.put(i, new User(users[i][0], users[i][1],0));
			if(users[i][0]>max)
			{
				max = users[i][0];
			}
		}

		ArrayList<Emoticon> pay = new ArrayList<>();
		for(int i=0;i<emoticons.length;i++)
		{
			pay.add(new Emoticon(0, emoticons[i]));
		}

		int result=0;


		int resultMax=0;
		int maxIndex=40;

		int total=0;

		int []bag= new int[users.length];

	for(int k=10;k<=40;k+=10)
	{	total=0;
		for(int i=0;i< users.length;i++)
		{
			User user = termap.get(i);

			for(int j=0;j<emoticons.length;j++)
			{
				Emoticon emoticon = pay.get(j);
				int price = emoticon.price;
				price=price*(100-k)/100;
				if(user.b<=k)
				{
					user.bag+=price;

					if(user.bag>=user.e)
					{
						result++;
						user.bag=0;

					}
					total+=user.bag;
				}

			}

		}
		if(resultMax<result)
		{
			resultMax = result;
			maxIndex = total;

		}else if(resultMax==result)
		{
			maxIndex=Math.max(maxIndex, total);
		}

	}





	list.add(result);
	list.add(maxIndex);










		answer = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

	class User{
		int b;
		int e;
		int bag;
		public User(int b, int e, int bag) {
			this.b = b;
			this.e = e;
			this.bag = bag;
		}
	}

	class Emoticon{
		int b;
		int price;
		public Emoticon(int b, int price) {
			this.b = b;
			this.price = price;
		}
		public void update(int b)
		{
			this.b = b;
			this.price =price*(100-b)/100;
		}
	}

	public static void main(String[] args) {
		emoticon s = new emoticon();
		int[][] users = {{40, 10000}, {25, 10000}};
		int[] emoticons = {7000,9000};
		int[] result = s.solution(users, emoticons);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}