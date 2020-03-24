import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex_문제5 {

	public static void main(String[] args) {
		int[] vote = input();
		output(vote);

	}

	static int[] input() {
		Scanner input = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.println("후보 수를 입력: ");
		int huboNum = input.nextInt();// 후보 숫자를 입력
		int vote[] = new int[huboNum];

		System.out.println("투표하세요(ex. 3,4,2,1,3):");
		String line = sc.nextLine();// 투표값을 입력
		StringTokenizer st = new StringTokenizer(line, ",");

		for (int i = 0; st.hasMoreTokens(); i++) {
			int su = Integer.parseInt(st.nextToken());
			switch (su) {// 입력받은 수가 나올 때 마다 후보가 받은 투표수를 증가시킴
			case 1:
				vote[0] += 1;
				continue;
			case 2:
				vote[1] += 1;
				continue;
			case 3:
				vote[2] += 1;
				continue;
			case 4:
				vote[3] += 1;
				continue;
			case 5:
				vote[4] += 1;
				continue;
			case 6:
				vote[5] += 1;
				continue;
			case 7:
				vote[6] += 1;
				continue;
			case 8:
				vote[7] += 1;
				continue;
			case 9:
				vote[8] += 1;
				continue;
			case 10:
				vote[9] += 1;
				continue;

			}

		}
		int[] result = solution(vote);
		return result;// 가장 많이 받은 후보들을 다시 리턴
	}

	static int[] solution(int[] vote) {
		int maxPluse = 0;// max[] 의 자리수를 변경하는 변수
		int realMax = 0;// 가장 많은 득표를 받은 수를 넣음
		int cnt = 0;
//		int[] max = new int[vote.length];// 5명의 후보가 1표씩 받을 수도 있으니 후보 수 만큼 만듦
		int[] max = new int[] {};// 5명의 후보가 1표씩 받을 수도 있으니 후보 수 만큼 만듦

		for (int i = 0; i < vote.length; i++) {
			if (realMax < vote[i]) {
				realMax = vote[i];// 가장 득표를 많이 받은 사람의 득표수를 넣어줌
			}

		}

		for (int i = 0; i < vote.length; i++) {
			if (realMax == vote[i]) {// 처음으로 저장된 득표수 많은 사람을 제외하고 그중에 그 값과 동일한 사람
				
				max[maxPluse++] = i + 1;
			}
		}

		return max;// 가장 많이 받은 후보들의 목록을 리턴하면

	}

	static void output(int[] max) {
		for (int i = 0; i < max.length; i++) {

			System.out.print((max[i]) + " ");
		}

	}

}
