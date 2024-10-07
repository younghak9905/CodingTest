package kakaomobility;

public class task2 {


		// 두 종류 이하의 숫자로 이루어져 있는지 확인하는 함수
		public static boolean isValidTime(String time) {
			int[] digitCount = new int[10]; // 0~9까지의 숫자 카운트 배열
			int uniqueDigits = 0; // 고유한 숫자의 종류 수를 저장할 변수

			// 문자열을 하나씩 확인
			for (char c : time.toCharArray()) {
				if (c != ':') { // ':'는 제외
					int digit = c - '0'; // 문자를 숫자로 변환 (예: '1' -> 1)

					// 해당 숫자가 처음 등장하는 경우
					if (digitCount[digit] == 0) {
						uniqueDigits++; // 고유한 숫자 종류 증가
					}

					digitCount[digit]++; // 해당 숫자 카운트 증가

					// 고유한 숫자가 3종류 이상이면 바로 false 반환
					if (uniqueDigits > 2) {
						return false;
					}
				}
			}

			return true; // 고유한 숫자가 2 이하인 경우 true 반환
		}

		// 시간을 1초 증가시키는 함수
		public static String incrementTime(String time) {
			String[] parts = time.split(":");
			int hh = Integer.parseInt(parts[0]);
			int mm = Integer.parseInt(parts[1]);
			int ss = Integer.parseInt(parts[2]);

			// 1초 증가
			ss++;
			if (ss == 60) {
				ss = 0;
				mm++;
				if (mm == 60) {
					mm = 0;
					hh++;
					if (hh == 24) {
						hh = 0; // 24시가 되면 00시로
					}
				}
			}

			// HH:MM:SS 형식으로 다시 변환
			return String.format("%02d:%02d:%02d", hh, mm, ss);
		}

		// 시작 시간과 끝 시간 사이에 두 종류 이하의 숫자로만 이루어진 시간을 찾는 함수
		public static int solution(String startTime, String endTime) {
			int count = 0; // 두 종류 이하 숫자로 이루어진 시간 카운트

			// 시작 시간부터 끝 시간까지 반복
			String currentTime = startTime;
			while (!currentTime.equals(endTime)) {
				if (isValidTime(currentTime)) { // 두 종류 이하 숫자로 이루어진 시간이면 카운트 증가
					count++;
				}
				currentTime = incrementTime(currentTime); // 시간 1초 증가
			}

			// 끝 시간도 검사
			if (isValidTime(endTime)) {
				count++;
			}

			return count;
		}

		public static void main(String[] args) {
			// 테스트 케이스
			String startTime = "22:22:21";
			String endTime = "22:22:23";
			task2 solution = new task2();
			int result = solution(startTime, endTime);
			System.out.println(result); // 출력: 1 (15:15:11만 두 종류 이하 숫자로 이루어져 있음)
		}


}
