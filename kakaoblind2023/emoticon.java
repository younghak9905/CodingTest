package kakaoblind2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class emoticon {

	static int []w;
	static int []sales={10,20,30,40};
	static int depth=0;
	static int maxService=0;
	static int maxMoney=0;

	static int [][]usersBoard;
	static int []emoticonsBoard;
	public int[] solution(int[][] users, int[] emoticons) {
		int[] answer = {};
		usersBoard = users;
		emoticonsBoard = emoticons;
		depth = emoticons.length;
		int max=0;
		w = new int[4];
		backtracking(0);

		return new int[]{maxService,maxMoney};
	}
	static void backtracking(int cnt)
	{
			if(cnt == depth) {
				calculate();
				return;
			}
			for(int i=0;i<sales.length;i++)
			{
				w[cnt]=sales[i];
				backtracking(cnt+1);
			}
	}
	static void calculate()
	{
		int service = 0;
		int money = 0;

		for (int i = 0; i < usersBoard.length; i++) {
			int sum = 0;
			for (int j = 0; j < emoticonsBoard.length; j++) {
				if (usersBoard[i][0] <= w[j]) {
					sum += emoticonsBoard[j] * (100 - w[j]) / 100;
				}
			}
			if (sum >= usersBoard[i][1])
				service++;
			else money += sum;

		}
		if(maxService>service) {
			return;
		}
		if(maxService<service) {
			maxService = service;
			maxMoney = money;
		}else if(maxMoney<money) //maxService==service && maxMoney<money
		{
			maxMoney = money;
		}
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