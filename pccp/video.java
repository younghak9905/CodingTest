package pccp;

import kakaoblind2022.queue;

public class video {
}
class Solution {
	public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
		Time vedio = split(video_len);
		Time position = split(pos);
		Time start = split(op_start);
		Time end = split(op_end);

		int total = vedio.mm*60+vedio.ss;
		int now = position.mm*60+position.ss;
		int s = start.mm*60+start.ss;
		int e = end.mm*60+end.ss;

		for (int i = 0; i < commands.length; i++) {
			String cmd = commands[i];
			switch (cmd) {
				case "next":
					if(now<=e && now>=s)
					{
						now=e+10;
					}
					else
					{
						if(now+10<total)
						{
							now+=10;
						}
						else
						{
							now = total;
						}
					}
				break;
				case "prev":
					if(now<10)
					{
						now=0;
					}
					else
					{
						now-=10;
					}
			}
		}


		String answer = String.format("%02d:%02d", now/60, now%60);

		return answer;
	}

	static Time split(String time) {
		String[] t = time.split(":");
		return new Time(Integer.parseInt(t[0]), Integer.parseInt(t[1]));

	}

	static class Time {

		int mm;
		int ss;

		public Time(int mm, int ss) {
			this.mm = mm;
			this.ss = ss;
		}
	}
	public static void main(String[] args) {

		//"34:33"	"13:00"	"00:55"	"02:55"	["next", "prev"]	"13:00"
		Solution s = new Solution();
		String video_len = "34:33";
		String pos = "13:00";
		String op_start = "00:55";
		String op_end = "02:55";
		String[] commands = {"next", "prev"};

		System.out.println(s.solution(video_len, pos, op_start, op_end, commands));
	}
}
