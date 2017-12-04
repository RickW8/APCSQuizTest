package com.example.ricky.apcsquiz;

/**
 * Created by wur3 on 11/20/2017.
 */

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import java.lang.reflect.Array;
import android.content.ContentValues;


public class QuestionBank{


    List<Question> list = new ArrayList<>();
    MyDataBaseHelper myDataBaseHelper;

    public int getLength() { return list.size(); }

    public String getQuestion(int a) { return list.get(a).getQuestion(); }

    public String getChoice(int index, int num){ return list.get(index).getChoice(num-1);}

    public String getCorrectAnswer(int a){ return list.get(a).getAnswer(); }

    public void initQuestions(Context context){
        myDataBaseHelper = new MyDataBaseHelper(context);
        list = myDataBaseHelper.getAllQuestionsList();

        if(list.isEmpty()){


            //Variables
            myDataBaseHelper.addInitialQuestion(new Question("What does the following code print?\n" +
                    "System.out.println(2 % 3);",
                    new String[] {"2", "0", "3", "1"}, "2"));
            myDataBaseHelper.addInitialQuestion(new Question("What does the following code print?\n" +
                    "System.out.println(1 / 3);",
                    new String[] {"0.3333333333333333", "0", "It will give a run-time error", "0.3"}, "0"));
            myDataBaseHelper.addInitialQuestion(new Question("Which of the following would be the correct result from the following expression: 123 (decimal) - 12 (octal) + 111 (binary)?",
                    new String[] {"120", "220", "118", "121"}, "120"));
            myDataBaseHelper.addInitialQuestion(new Question("What is the hexadecimal equivalent of the following binary number: 110100?",
                    new String[] {"B4", "64", "52", "34"}, "34"));
            myDataBaseHelper.addInitialQuestion(new Question("What will be printed by System.out.println(Integer.MAX_VALUE + 1);?",
                    new String[] {"2147483647", "There will be a run time error", "-2147483648", "There will be a compile time error"}, "-2147483648"));
            myDataBaseHelper.addInitialQuestion(new Question("Which of the following would be the correct result from the following expression: 150 (in decimal) - 21 (in octal) + 101 (in binary) - E (in hexadecimal)?",
                    new String[] {"124", "168", "186", "123"}, "124"));

            //Conditionals
            myDataBaseHelper.addInitialQuestion(new Question("If the operator AND is used, which of the following will make the whole condition true?",
                    new String[] {"first operand true, second operand false", "first operand false, second operand true", "both operands true", "both operands false"}, "both operands true"));
            myDataBaseHelper.addInitialQuestion(new Question("The condition specified for an if or an if-else statement must be a(n) _________________ expression.",
                    new String[] {"Boolean", "Arithmetic", "Relational", "Assignment"}, "Boolean"));
            myDataBaseHelper.addInitialQuestion(new Question("For which of the following values of x and y is the expression (x>3) || (y<=5) FALSE?",
                    new String[] {"x=3, y=6", "x=5 y=4", "x=7, y=2", "x=1, y=5"}, "x=3, y=6"));
            myDataBaseHelper.addInitialQuestion(new Question("Of Java's three logical operators, which comes first in the order of operations?",
                    new String[] {"NOT", "AND", "OR", "XOR"}, "NOT"));
            myDataBaseHelper.addInitialQuestion(new Question("Which of the following statements contain a syntax error? Assume: int  X, Y, Z; \n" +
                    "I.    if X>3 {System.out.println(“Hello”);}\n" +
                    "II.   if(Z=Y) System.out.println(“How are you?”);\n" +
                    "III.  if(X>3) System.out.println(“Just fine.”)\n" +
                    "            else System.out.println(“And yourself?”);\n",
                    new String[] {"I and II", "I and III", "II and III", "I, II and III"}, "I, II and III"));
            myDataBaseHelper.addInitialQuestion(new Question("What is the value of y after the following if the value of x is 5?\n" +
                    "if (x<5){y=2*x+1;} else {y=2*x;}\n" +
                    "if (y%2==0) {y=y+3;}\n",
                    new String[] {"10", "11", "13", "14"}, "13"));

            //Loops
            myDataBaseHelper.addInitialQuestion(new Question("What is the output of the following code segment? \n" +
                    "for ( int j = 10;  j >  5; j-- )\n" +
                    "{\n" +
                    "  System.out.print( j + \" \" );\n" +
                    "}\n" +
                    "System.out.println();",
                    new String[] {"10 11 12 13 14 15", "9 8 7 6 5 4 3 2 1 0", "10 9 8 7 6 5", "10 9 8 7 6"}, "10 9 8 7 6"));
            myDataBaseHelper.addInitialQuestion(new Question("What is the number of times that the loop below will display “HELLO”assuming that b>a?\n" +
                    "for(x=a; x<=b; x++)\n" +
                    "     System.out.println(“HELLO”);\n",
                    new String[] {"b-a", "b-a+1", "b", "b+a"}, "b-a+1"));
            myDataBaseHelper.addInitialQuestion(new Question("What will be the output of the following while statement?\n" +
                    "int x=10;\n" +
                    "while(x>0){\n" +
                    "     System.out.println(x + “  “);\n" +
                    "     x-=3;}",
                    new String[] {"10  7  4  1", "10  9  8  7  6  5  4  3  2  1", "10  8  6  4  2  0", "10  8  6  4  2"}, "10  7  4  1"));
            myDataBaseHelper.addInitialQuestion(new Question("Consider the following code segment:\n" +
                    "int x = 2, y = 0;\n" +
                    "while(x>y){\n" +
                    "x--;\n" +
                    "y++}\n" +
                    "System.out.println(x - y);\n" +
                    "What is the output of the System.out.println statement?",
                    new String[] {"-2", "-1", "0", "1"}, "0"));
            myDataBaseHelper.addInitialQuestion(new Question("Consider the following code segment, which will be used to determine the number of years required for a $10,000 investment to grow to $25,000 at a simple interest rate of 3%..\n" +
                    "int years = 0;\n" +
                    "double balance = 10000, interest;\n" +
                    "while(balance<25000){\n" +
                    "years++;\n" +
                    "interest = balance * .03;\n" +
                    "<BLANK> }\n" +
                    "System.out.println(“Years = “ + years);\n" +
                    "What is the following statements should be placed where <BLANK> is so that the code works as intended?",
                    new String[] {"balance = interest;", "balance++;", "balance += interest;", "balance *= interest;"}, "balance += interest;"));
            myDataBaseHelper.addInitialQuestion(new Question("Consider the following code segment.\n" +
                    "for(int k=0; k<10; k++)\n" +
                    "for(int j=0; j<5; j++)\n" +
                    "System.out.print(“*”); }\n" +
                    "How many asterisks (stars) will be displayed when this code segment is executed?",
                    new String[] {"50", "15", "10", "5"}, "50"));

            //Strings and Arrays
            myDataBaseHelper.addInitialQuestion(new Question("public static int[] what(int[] A){\n" +
                    "      int n = A.length;\n" +
                    "      int[] temp = new int[n] ;\n" +
                    "      for(int i=0; i<n; i++){\n" +
                    "            temp[i] = A[n-i-1]; }\n" +
                    "      return temp; }\n" +
                    "What is the the purpose of this method?",
                    new String[] {"To make an array that is a copy of the array A", "To make an array that is a copy of the array A in reverse order", "To make an array that is a scrambled copy of the array A", "To make an array that is filled with the negatives of the array A"}, "To make an array that is a copy of the array A in reverse order"));
            myDataBaseHelper.addInitialQuestion(new Question("Suppose the method int sign(int x) returns 1 if x is positive, -1 if x is negative and 0 if x is 0. Given\n" +
                    "int[] nums = {-2, -1, 0, 1, 2};\n" +
                    "what are the values of the elements of nums after the following code is executed?\n" +
                    "for(int k=0; k<nums.length; k++){\n" +
                    "nums[k] -= sign(nums[k]);\n" +
                    "nums[k] += sign(nums[k]); }",
                    new String[] {"-2, -1, 0, 1, 2", "-1, 0, 0, 0, 1", "-2, 0, 0, 0, 2", "0, 0, 0, 0, 0"}, "-2, 0, 0, 0, 2"));
            myDataBaseHelper.addInitialQuestion(new Question("What is the output of the following code segment?\n" +
                    "String str1 = “Happy ”;\n" +
                    "String str2 = str1;\n" +
                    "str2 += “New Year! ”;\n" +
                    "str1 = str2.substring(6);\n" +
                    "System.out.println(str1 + str2)",
                    new String[] {"Happy New Year!", "Happy Happy New Year!", "New Year! New Year!", "New Year! Happy New Year!"}, "New Year! Happy New Year!"));
            myDataBaseHelper.addInitialQuestion(new Question("public static String process(String msg, String s){\n" +
                    "      int pos = msg.indexOf(s);\n" +
                    "      msg = msg.substring(0,pos) + \" \" + s;\n" +
                    "      return msg; }\n" +
                    "What is the output of the following code segment?\n" +
                    "String s1 = \"superstar\";\n" +
                    "String s2 = \"star\";\n" +
                    "System.out.println(process(s1, s2));",
                    new String[] {"superstar", "super star", "superstarstar", "superstar star"}, "super star"));
            myDataBaseHelper.addInitialQuestion(new Question("Given the following code segment, what is in the string referenced by s1?\n" +
                    "String s1 = \"xy\";\n" +
                    "String s2 = s1;\n" +
                    "s1 = s1 + s2 + \"z\";",
                    new String[] {"xyz", "xyxyz", "xy xy z", "xy z"}, "xyxyz"));
            myDataBaseHelper.addInitialQuestion(new Question("What is the value of len after the following executes?\n" +
                    "String s1 = \"Hey, buddy!\";\n" +
                    "int len = s1.length();",
                    new String[] {"11", "8", "10", "9"}, "11"));

            //2D Arrays
            myDataBaseHelper.addInitialQuestion(new Question("How many columns does a have if it is created as follows int[][] a = {{2, 4, 6, 8}, {1, 2, 3, 4}};?",
                    new String[] {"2", "4", "8", "0"}, "4"));
            myDataBaseHelper.addInitialQuestion(new Question("How would you get the value 6 out of the following array int[][] a = {{2, 4, 6, 8}, {1, 2, 3, 4}};?",
                    new String[] {"a[2][0]", "a[0][2]", "a[1][3]", "a[0][3]"}, "a[0][2]"));
            myDataBaseHelper.addInitialQuestion(new Question("Which of the following statements assigns the letter S to the third row and first column of a two-dimensional array named strGrid (assuming row-major order).",
                    new String[] {"strGrid[0][2] = \"S\";", "strGrid[1][3] = \"S\";", "strGrid[3][1] = \"S\";", "strGrid[2][0] = \"S\";"}, "strGrid[2][0] = \"S\";"));
            myDataBaseHelper.addInitialQuestion(new Question("Given the following code segment, what is the value of sum after this code executes?\n" +
                    "int[][] matrix = {{1,1,2,2},{1,2,2,4},{1,2,3,4},{1,4,1,2}};\n" +
                    "int sum = 0;\n" +
                    "int col = matrix[0].length - 2;\n" +
                    "for (int row = 0; row < 4; row++){\n" +
                    "   sum = sum + matrix[row][col]; }",
                    new String[] {"8", "9", "12", "10"}, "8"));
            myDataBaseHelper.addInitialQuestion(new Question("What are the contents of mat after the following code segment has been executed?\n" +
                    "int [][] mat = new int [4][3];\n" +
                    "for (int row = 0; row < mat.length; row++) {\n" +
                    "   for (int col = 0; col < mat[0].length; col++) {\n" +
                    "      if (row < col)\n" +
                    "         mat[row][col] = 1;\n" +
                    "      else if (row == col)\n" +
                    "         mat[row][col] = 2;\n" +
                    "      else\n" +
                    "         mat[row][col] = 3; } }",
                    new String[] {"{{2 3 3}, {1 2 3}, {1 1 2}, {1 1 1}}", "{{2 1 1}, {3 2 1}, {3 3 2}, {3 3 3}}", "{{2 1 1 1}, {3 2 1 1}, {3 3 2 1}}", "{{1 1 1 1}, {2 2 2 2}, {3 3 3 3}}"}, "{{2 1 1}, {3 2 1}, {3 3 2}, {3 3 3}}"));
            myDataBaseHelper.addInitialQuestion(new Question("What are the contents of arr after the following code has been executed?\n" +
                    "int[][] arr = {{3,2,1},{1,2,3}};\n" +
                    "int value = 0;\n" +
                    "for (int row = 1; row < arr.length; row++) {\n" +
                    "   for (int col = 1; col < arr.length; col++) {\n" +
                    "      value = arr[row][col];\n" +
                    "      if (value % 2 == 1) arr[row][col] = value + 1;\n" +
                    "      if (arr[row][col] % 2 == 0) arr[row][col] = value * 2; } }",
                    new String[] {"{{6, 4, 2}, {2, 4, 6}}", "{{3, 2, 1}, {1, 4, 6}}", "{{3, 2, 1}, {1, 4, 8}}", "{{4, 4, 2}, {2, 4, 4}}"}, "{{3, 2, 1}, {1, 4, 8}}"));

            list = myDataBaseHelper.getAllQuestionsList();
        }
    }

}