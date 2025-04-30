package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class back_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String s = br.readLine();
            if(s.equals("."))
                break;
            Stack<String> stack = new Stack<String>();
            int flag =0;
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(c=='('){
                    stack.push("(");
                }else if(c==')'){
                    if(!stack.isEmpty() && stack.peek().equals("(")){
                        stack.pop();
                    } else {
                        sb.append("no\n");
                        flag++;
                        break;
                    }
                }else if(c=='['){
                    stack.push("[");
                }else if(c==']'){
                    if(!stack.isEmpty() && stack.peek().equals("[")){
                        stack.pop();
                    }else{
                        sb.append("no\n");
                        flag++;
                        break;
                    }
                }

            }
            if(flag==0 && stack.isEmpty()){
                sb.append("yes\n");
            }else if(flag==0 && !stack.isEmpty())
                sb.append("no\n");

        }
        System.out.print(sb);

    }
}
