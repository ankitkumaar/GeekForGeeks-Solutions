//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s = in.readLine();

            Solution ob = new Solution();
            out.println(ob.decodeString(s));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends



class Solution {
    static String decodeString(String s) {
        
        /* Stacks to store repeat count and encoded string */
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        
        int num = 0;
        String currString="";
        for(char ch : s.toCharArray())  {
            if(Character.isDigit(ch))  {
                num = num * 10 + (ch - '0');
            }
            else if(ch == '[')   {
                countStack.push(num);
                stringStack.push(currString);
                currString=""; 
                num = 0;
            }
            else if(ch == ']')   {
                int count = countStack.pop();
                String decodedString = stringStack.pop();
                
                for(int i=0; i<count; i++)   {
                    decodedString += currString;
                }
                currString = decodedString;
            }
            else
                currString += ch;
        }
        return currString.toString();
    }
}