package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class back_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        Stack<Double> stack  =new Stack<Double>();
        double []alpha =new double[26];
        for(int i=0;i<N;i++)
        {
            alpha[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0;i<=s.length()-1;i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                stack.push(alpha[s.charAt(i)-'A']);
            else {
                double a = stack.pop();
                double b = stack.pop();
                if (s.charAt(i) == '*')
                    stack.push(a * b);
                else if (s.charAt(i) == '/')
                    stack.push(b / a);
                else if (s.charAt(i) == '+')
                    stack.push(a + b);
                else if(s.charAt(i) == '-')
                    stack.push(b - a);
            }
        }
        //소수 둘째 자리까지 출력
        System.out.printf("%.2f\n", stack.pop());



    }
}
