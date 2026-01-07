package javaconcepts.exception;
import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// checked exceptions must be explicitly managed with try-catch or throws



public class CheckedExceptions {
    public static void ioExceptionExample(){
        try{
            FileReader file = new FileReader("some_file.txt");
            BufferedReader br = new BufferedReader(file);
            System.out.println(br.readLine());
            br.close();
        }
        catch (IOException e){
            System.out.println("Caught IO javaconcepts.exception : "+ e.getMessage());
        }
    }

    public static void SqlExceptionExample() {
        try {
            System.out.println("hello");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");
            System.out.println("there");
            Statement stmt = conn.createStatement();
            System.out.println("I am ");
            stmt.executeQuery("SELECT * FROM nonexistent_table");
            System.out.println("Vaibhav");
        } catch (SQLException e) {
            System.out.println("Caught SQLException: " + e.getMessage());
        }
    }

    public static void ClassNotFoundExample() throws ClassNotFoundException{
        System.out.println(Class.forName("Exception.CheckedExceptions"));
        System.out.println(Class.forName("Exception.CheckedException"));


    }

    public static void ParseExceptionExample(){
        SimpleDateFormat sdfObj = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date date = sdfObj.parse("2014-12-09");
            System.out.println(date);
            date = sdfObj.parse("awww-ass-asss");
        }
        catch (ParseException e){
            System.out.println("Caught ParseException : " + e.getMessage());
        }
    }

    public static void InterruptedExceptionExample(){
        Thread thread = new Thread(() -> {
            try{
                Thread.sleep(5000);

            }
            catch (InterruptedException e){
                System.out.println("Caught InterruptedException : " + e.getMessage());
            }
        });
        thread.start();
        thread.interrupt(); // interrupting the thread

    }


    public static void main(String[] args) {
        ioExceptionExample();
        SqlExceptionExample();
        ParseExceptionExample();
        InterruptedExceptionExample();

        try{
            ClassNotFoundExample();
        }catch (ClassNotFoundException e){
            System.out.println("Caught ClassNotFoundException : " + e.getMessage());
        }
    }
}
