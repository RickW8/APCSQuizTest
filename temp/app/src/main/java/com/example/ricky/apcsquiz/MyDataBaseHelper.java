package com.example.ricky.apcsquiz;

/**
 * Created by wur3 on 11/20/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;


import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;

public class MyDataBaseHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static String DATABASE_QUESTION = "questionBank.db";
    private static final String TABLE_QUESTION = "QuestionBank";
    private static final String KEY_ID = "id";
    private static final String QUESTION = "question";
    private static final String CHOICE1 = "choice1";
    private static final String CHOICE2 = "choice2";
    private static final String CHOICE3 = "choice3";
    private static final String CHOICE4 = "choice4";
    private static final String ANSWER = "answer";
    private SQLiteDatabase dbase;

    public MyDataBaseHelper(Context context) {
        super(context, DATABASE_QUESTION, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase){
        dbase=sqLiteDatabase;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTION + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + QUESTION
                + " TEXT, " + ANSWER+ " TEXT, "+ CHOICE1 +" TEXT, "
                + CHOICE2 +" TEXT, "+ CHOICE3 +" TEXT, "+ CHOICE4 +" TEXT)";
        sqLiteDatabase.execSQL(sql);
        addQuestions();

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION);
        onCreate(sqLiteDatabase);
    }

    public void addInitialQuestion (Question question){

        ContentValues values = new ContentValues();
        values.put(QUESTION, question.getQuestion());
        values.put(CHOICE1, question.getChoice(0));
        values.put(CHOICE2, question.getChoice(1));
        values.put(CHOICE3, question.getChoice(2));
        values.put(CHOICE4, question.getChoice(3));
        values.put(ANSWER, question.getAnswer());

        //long insert = db.insert(TABLE_QUESTION, null, values);
        //return insert;
        dbase.insert(TABLE_QUESTION, null, values);

    }

    private void addQuestions() {
        //Variables
        addInitialQuestion(new Question("What does the following code print?\n" +
                "System.out.println(2 % 3);",
                new String[] {"2", "0", "3", "1"}, "2"));
        addInitialQuestion(new Question("What does the following code print?\n" +
                "System.out.println(1 / 3);",
                new String[] {"0.3333333333333333", "0", "It will give a run-time error", "0.3"}, "0"));
        addInitialQuestion(new Question("Which of the following would be the correct result from the following expression: 123 (decimal) - 12 (octal) + 111 (binary)?",
                new String[] {"120", "220", "118", "121"}, "120"));
        addInitialQuestion(new Question("What is the hexadecimal equivalent of the following binary number: 110100?",
                new String[] {"B4", "64", "52", "34"}, "34"));
        addInitialQuestion(new Question("What will be printed by System.out.println(Integer.MAX_VALUE + 1);?",
                new String[] {"2147483647", "There will be a run time error", "-2147483648", "There will be a compile time error"}, "-2147483648"));
        addInitialQuestion(new Question("Which of the following would be the correct result from the following expression: 150 (in decimal) - 21 (in octal) + 101 (in binary) - E (in hexadecimal)?",
                new String[] {"124", "168", "186", "123"}, "124"));

        //Conditionals
        addInitialQuestion(new Question("If the operator AND is used, which of the following will make the whole condition true?",
                new String[] {"first operand true, second operand false", "first operand false, second operand true", "both operands true", "both operands false"}, "both operands true"));
        addInitialQuestion(new Question("The condition specified for an if or an if-else statement must be a(n) _________________ expression.",
                new String[] {"Boolean", "Arithmetic", "Relational", "Assignment"}, "Boolean"));
        addInitialQuestion(new Question("For which of the following values of x and y is the expression (x>3) || (y<=5) FALSE?",
                new String[] {"x=3, y=6", "x=5 y=4", "x=7, y=2", "x=1, y=5"}, "x=3, y=6"));
        addInitialQuestion(new Question("Of Java's three logical operators, which comes first in the order of operations?",
                new String[] {"NOT", "AND", "OR", "XOR"}, "NOT"));
        addInitialQuestion(new Question("Which of the following statements contain a syntax error? Assume: int  X, Y, Z; \n" +
                "I.    if X>3 {System.out.println(“Hello”);}\n" +
                "II.   if(Z=Y) System.out.println(“How are you?”);\n" +
                "III.  if(X>3) System.out.println(“Just fine.”)\n" +
                "            else System.out.println(“And yourself?”);\n",
                new String[] {"I and II", "I and III", "II and III", "I, II and III"}, "I, II and III"));
        addInitialQuestion(new Question("What is the value of y after the following if the value of x is 5?\n" +
                "if (x<5){y=2*x+1;} else {y=2*x;}\n" +
                "if (y%2==0) {y=y+3;}\n",
                new String[] {"10", "11", "13", "14"}, "13"));

        //Loops
        addInitialQuestion(new Question("What is the output of the following code segment? \n" +
                "for ( int j = 10;  j >  5; j-- )\n" +
                "{\n" +
                "  System.out.print( j + \" \" );\n" +
                "}\n" +
                "System.out.println();",
                new String[] {"10 11 12 13 14 15", "9 8 7 6 5 4 3 2 1 0", "10 9 8 7 6 5", "10 9 8 7 6"}, "10 9 8 7 6"));
        addInitialQuestion(new Question("What is the number of times that the loop below will display “HELLO”assuming that b>a?\n" +
                "for(x=a; x<=b; x++)\n" +
                "     System.out.println(“HELLO”);\n",
                new String[] {"b-a", "b-a+1", "b", "b+a"}, "b-a+1"));
        addInitialQuestion(new Question("What will be the output of the following while statement?\n" +
                "int x=10;\n" +
                "while(x>0){\n" +
                "     System.out.println(x + “  “);\n" +
                "     x-=3;}",
                new String[] {"10  7  4  1", "10  9  8  7  6  5  4  3  2  1", "10  8  6  4  2  0", "10  8  6  4  2"}, "10  7  4  1"));
        addInitialQuestion(new Question("Consider the following code segment:\n" +
                "int x = 2, y = 0;\n" +
                "while(x>y){\n" +
                "x--;\n" +
                "y++}\n" +
                "System.out.println(x - y);\n" +
                "What is the output of the System.out.println statement?",
                new String[] {"-2", "-1", "0", "1"}, "0"));
        addInitialQuestion(new Question("Consider the following code segment, which will be used to determine the number of years required for a $10,000 investment to grow to $25,000 at a simple interest rate of 3%..\n" +
                "int years = 0;\n" +
                "double balance = 10000, interest;\n" +
                "while(balance<25000){\n" +
                "years++;\n" +
                "interest = balance * .03;\n" +
                "<BLANK> }\n" +
                "System.out.println(“Years = “ + years);\n" +
                "What is the following statements should be placed where <BLANK> is so that the code works as intended?",
                new String[] {"balance = interest;", "balance++;", "balance += interest;", "balance *= interest;"}, "balance += interest;"));
        addInitialQuestion(new Question("Consider the following code segment.\n" +
                "for(int k=0; k<10; k++)\n" +
                "for(int j=0; j<5; j++)\n" +
                "System.out.print(“*”); }\n" +
                "How many asterisks (stars) will be displayed when this code segment is executed?",
                new String[] {"50", "15", "10", "5"}, "50"));

        //Strings and Arrays
        addInitialQuestion(new Question("public static int[] what(int[] A){\n" +
                "      int n = A.length;\n" +
                "      int[] temp = new int[n] ;\n" +
                "      for(int i=0; i<n; i++){\n" +
                "            temp[i] = A[n-i-1]; }\n" +
                "      return temp; }\n" +
                "What is the the purpose of this method?",
                new String[] {"To make an array that is a copy of the array A", "To make an array that is a copy of the array A in reverse order", "To make an array that is a scrambled copy of the array A", "To make an array that is filled with the negatives of the array A"}, "To make an array that is a copy of the array A in reverse order"));
        addInitialQuestion(new Question("Suppose the method int sign(int x) returns 1 if x is positive, -1 if x is negative and 0 if x is 0. Given\n" +
                "int[] nums = {-2, -1, 0, 1, 2};\n" +
                "what are the values of the elements of nums after the following code is executed?\n" +
                "for(int k=0; k<nums.length; k++){\n" +
                "nums[k] -= sign(nums[k]);\n" +
                "nums[k] += sign(nums[k]); }",
                new String[] {"-2, -1, 0, 1, 2", "-1, 0, 0, 0, 1", "-2, 0, 0, 0, 2", "0, 0, 0, 0, 0"}, "-2, 0, 0, 0, 2"));
        addInitialQuestion(new Question("What is the output of the following code segment?\n" +
                "String str1 = “Happy ”;\n" +
                "String str2 = str1;\n" +
                "str2 += “New Year! ”;\n" +
                "str1 = str2.substring(6);\n" +
                "System.out.println(str1 + str2)",
                new String[] {"Happy New Year!", "Happy Happy New Year!", "New Year! New Year!", "New Year! Happy New Year!"}, "New Year! Happy New Year!"));
        addInitialQuestion(new Question("public static String process(String msg, String s){\n" +
                "      int pos = msg.indexOf(s);\n" +
                "      msg = msg.substring(0,pos) + \" \" + s;\n" +
                "      return msg; }\n" +
                "What is the output of the following code segment?\n" +
                "String s1 = \"superstar\";\n" +
                "String s2 = \"star\";\n" +
                "System.out.println(process(s1, s2));",
                new String[] {"superstar", "super star", "superstarstar", "superstar star"}, "super star"));
        addInitialQuestion(new Question("Given the following code segment, what is in the string referenced by s1?\n" +
                "String s1 = \"xy\";\n" +
                "String s2 = s1;\n" +
                "s1 = s1 + s2 + \"z\";",
                new String[] {"xyz", "xyxyz", "xy xy z", "xy z"}, "xyxyz"));
        addInitialQuestion(new Question("What is the value of len after the following executes?\n" +
                "String s1 = \"Hey, buddy!\";\n" +
                "int len = s1.length();",
                new String[] {"11", "8", "10", "9"}, "11"));

        //2D Arrays
        addInitialQuestion(new Question("How many columns does a have if it is created as follows int[][] a = {{2, 4, 6, 8}, {1, 2, 3, 4}};?",
                new String[] {"2", "4", "8", "0"}, "4"));
        addInitialQuestion(new Question("How would you get the value 6 out of the following array int[][] a = {{2, 4, 6, 8}, {1, 2, 3, 4}};?",
                new String[] {"a[2][0]", "a[0][2]", "a[1][3]", "a[0][3]"}, "a[0][2]"));
        addInitialQuestion(new Question("Which of the following statements assigns the letter S to the third row and first column of a two-dimensional array named strGrid (assuming row-major order).",
                new String[] {"strGrid[0][2] = \"S\";", "strGrid[1][3] = \"S\";", "strGrid[3][1] = \"S\";", "strGrid[2][0] = \"S\";"}, "strGrid[2][0] = \"S\";"));
        addInitialQuestion(new Question("Given the following code segment, what is the value of sum after this code executes?\n" +
                "int[][] matrix = {{1,1,2,2},{1,2,2,4},{1,2,3,4},{1,4,1,2}};\n" +
                "int sum = 0;\n" +
                "int col = matrix[0].length - 2;\n" +
                "for (int row = 0; row < 4; row++){\n" +
                "   sum = sum + matrix[row][col]; }",
                new String[] {"8", "9", "12", "10"}, "8"));
        addInitialQuestion(new Question("What are the contents of mat after the following code segment has been executed?\n" +
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
        addInitialQuestion(new Question("What are the contents of arr after the following code has been executed?\n" +
                "int[][] arr = {{3,2,1},{1,2,3}};\n" +
                "int value = 0;\n" +
                "for (int row = 1; row < arr.length; row++) {\n" +
                "   for (int col = 1; col < arr.length; col++) {\n" +
                "      value = arr[row][col];\n" +
                "      if (value % 2 == 1) arr[row][col] = value + 1;\n" +
                "      if (arr[row][col] % 2 == 0) arr[row][col] = value * 2; } }",
                new String[] {"{{6, 4, 2}, {2, 4, 6}}", "{{3, 2, 1}, {1, 4, 6}}", "{{3, 2, 1}, {1, 4, 8}}", "{{4, 4, 2}, {2, 4, 4}}"}, "{{3, 2, 1}, {1, 4, 8}}"));
    }


    public List<Question> getAllQuestionsList() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTION;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        while(quesList.size()!=30){
            if (cursor.moveToFirst()) {
                do {
                    Question quest = new Question();
                    //quest.setID(cursor.getInt(0));
                    quest.setQuestion(cursor.getString(1));
                    quest.setAnswer(cursor.getString(2));
                    quest.setChoice(0,cursor.getString(3));
                    quest.setChoice(1,cursor.getString(4));
                    quest.setChoice(2,cursor.getString(5));
                    quest.setChoice(3,cursor.getString(6));
                    quesList.add(quest);
                } while (cursor.moveToNext());
            }
        }
        // return quest list
        return quesList;
    }




}
