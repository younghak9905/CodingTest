package pccp;

public class pccp_clock {
	public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {

		int t1 = h1*3600+m1*60+s1;
		int t2 = h2*3600+m2*60+s2;
		int answer = 0;
		if(t1%360==0 || t1%360==12)
			answer++;
		while(t1<t2)
		{
			double h_angle = (t1/(double)120)%360;
			double m_angle = (t1/(double)10)%360;
			double s_angle = (6*t1)%360;

			double h_angle2 = ((t1+1)/(double)120)%360;
			double m_angle2 = ((t1+1)/(double)10)%360;
			double s_angle2 = (6*(t1+1))%360;

			if(h_angle2==0) h_angle2=360;
			if(m_angle2==0) m_angle2=360;
			if(s_angle2==0) s_angle2=360;

			if(s_angle<h_angle && h_angle2<=s_angle2)
				answer++;
			if(s_angle<m_angle && m_angle2<=s_angle2)
				answer++;
			if(h_angle2==m_angle2)
				answer--;
			t1++;
		}

		return answer;
	}

	public static void main(String[] args) {
		pccp_clock sol = new pccp_clock();
		int h1 = 0;
		int m1 = 0;
		int s1 = 0;
		int h2 = 23;
		int m2 = 59;
		int s2 = 59;
		int ret = sol.solution(h1, m1, s1, h2, m2, s2);
		System.out.println(ret);
	}

}
