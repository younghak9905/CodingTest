package data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class back_10799 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char[] arr = s.toCharArray();
		Stack<Integer> stack = new Stack<>();
		String temp="";
		int result =0;
		for(int i=0;i<arr.length;i++)
		{

			if(arr[i]=='(') {
				stack.push(i);
			}
			else
			{
				if(!stack.isEmpty() && temp.equals("(") && stack.size()>1)
				{
					result += stack.size()-1;
					stack.pop();
				}
				else if(!stack.isEmpty() && temp.equals(")"))
				{
					result += 1;
					stack.pop();
				}
				else{
					if(!stack.isEmpty())
					{
						stack.pop();
					}
				}
			}

			temp = arr[i]+"";
		}
		System.out.println(result);
	}
}
