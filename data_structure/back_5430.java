package data_structure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
public class back_5430 {
			public static void main(String[] args) throws Exception {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				int T = Integer.parseInt(br.readLine());
				for(int t =0;t<T;t++)
				{
					String query=br.readLine();
					int N=Integer.parseInt(br.readLine());
					String arr=br.readLine();
					Deque<Integer> deque = new LinkedList<>();
					for(String s:arr.substring(1,arr.length()-1).split(","))
					{
						if(!s.equals(""))
							deque.add(Integer.parseInt(s));
					}
					System.out.println(ac(deque, query));
				}
			}
			static String ac(Deque<Integer> deque, String commands) {
				boolean reverse = false;

				for (char command : commands.toCharArray()) {
					if (command == 'R')
						reverse = !reverse;
					else {
						if (deque.size() == 0)
							return "error";

						if (reverse)
							deque.removeLast();
						else
							deque.removeFirst();
					}
				}

				StringBuilder sb = new StringBuilder("[");
				while (!deque.isEmpty()) {
					sb.append(reverse ? deque.removeLast() : deque.removeFirst());
					if (deque.size() != 0)
						sb.append(',');
				}
				sb.append(']');

				return sb.toString();
			}

		}



