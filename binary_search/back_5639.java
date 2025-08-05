package binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class back_5639 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Node node = new Node(Integer.parseInt(br.readLine()));
		String read;
		while (true)
		{
			read = br.readLine();
			if (read == null || read.equals("")) break;
			int input = Integer.parseInt(read);
			node.insert(input);

		}
		postOrder(node);
		System.out.println(sb);

	}
	static class Node{
		int num;
		Node left, right;
		Node(int num) {
			this.num = num;
		}
		Node(int num, Node left, Node right) {
			this.num = num;
			this.left = left;
			this.right = right;
		}
		void insert(int input)
		{
			if(this.num > input) {
				if (this.left == null) {
					this.left = new Node(input);
				} else {
					this.left.insert(input);
				}
			}else{
				if (this.right == null) {
					this.right = new Node(input);
				} else {
					this.right.insert(input);
				}
			}
		}

	}

	public static void postOrder(Node node) {
		if (node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.num);
	}

}
