package kakaoblind2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//https://school.programmers.co.kr/learn/courses/30/lessons/150370?language=java
public class programers_150370 {

	public static class Solution {
	public int[] solution(String today, String[] terms, String[] privacies) {
		int[] answer = {};
		ArrayList<Integer> list = new ArrayList<>();

		Map<String, Integer> termap = new HashMap<>();
		for (String term : terms) {
			String[] temp = term.split(" ");
			termap.put(temp[0], Integer.parseInt(temp[1]));
		}
		for (int i = 0; i <privacies.length; i++) {

			String[] temp = privacies[i].split(" ");
			int term = termap.get(temp[1]);
			String plusday = getDay(temp[0], term);
			if (today.compareTo(plusday) >=0) {
				list.add(i+1);
			}

		}
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		//list to array
		return answer;

	}

		public String getDay(String date, int term) {
			// 날짜 포맷이 "년.월.일" 형식이므로 "."으로 분리
			String[] splitDate = date.split("\\.");
			int year = Integer.parseInt(splitDate[0]);
			int month = Integer.parseInt(splitDate[1]);
			int day = Integer.parseInt(splitDate[2]);

			// 달에 기간(term)을 더함
			month += term;
			while (month > 12) {
				year++;
				month -= 12;
			}

			// 날짜를 "년.월.일" 형식으로 반환
			return String.format("%04d.%02d.%02d", year, month, day);
		}

		public static void main(String[] args) {
			Solution solution = new Solution();

			String today = "2022.05.19";
			String[] terms = {"A 6", "B 12", "C 3"};
			String[] privacies = {
				"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"
			};

			// 결과 호출 및 출력
			int[] result = solution.solution(today, terms, privacies);

			// 결과 출력
			for (int idx : result) {
				System.out.println("만료된 개인정보 번호: " + idx);
			}
		}

}
}


