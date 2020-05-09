import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("enter command");
        String str = null;
        try {
            str = br.readLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        execCommand(str);
    }

    public static void execCommand(String str) {
        if (str.charAt(1) == 'Q'){
            commandQ();
        }
        else if (str.charAt(1) == 'P'){
            commandP();
        }
        else if (str.charAt(1) == 'C'){
            commandC();
        }
        else{
            System.out.println("Invalid command.");
        }
    }
    
    public static void commandQ() {
        System.exit(0);
    }

    public static void commandP() {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream("roster.csv");
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String line;
            int i = 0;
            String[] arr = null;

            while ((line = br.readLine()) != null) {
              if (i == 0) {
                arr = line.split(",");
              } else {
                System.out.println("-------------------------------");
                System.out.println("Data: " + i);
                String[] data = line.split(",");
                int colno = 0;
                for (String column : arr) {
                  System.out.println(column + ":" + data[colno]);
                  colno++;
                }
              }
              i++;
            }
          } catch (IOException e) {
            e.printStackTrace();
          } finally {
            try {
              br.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
    }

    public static void commandC() {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        int i = 0;
        try {
            fis = new FileInputStream("roster.csv");
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
              i++;
            }
          } catch (IOException e) {
            e.printStackTrace();
          } finally {
            try {
              br.close();
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        System.out.println((i-1)+"data(s) registered");
    }
}