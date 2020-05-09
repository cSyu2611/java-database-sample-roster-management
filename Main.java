import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;

public class Main {
    public static void main(String[] args){
        
        while(true){
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.println("コマンドを入力してください");
            String str = null;
            try {
                str = br.readLine();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            execCommand(str);
        }
    }

    public static void execCommand(String str) {
        if (str.charAt(1) == 'Q'){
            System.out.println("終了コマンドが実行されました");
            commandQ();
        }
        else if (str.charAt(1) == 'P'){
            System.out.println("名簿表示コマンドが実行されました");
            commandP();
        }
        else if (str.charAt(1) == 'C'){
            System.out.println("名簿件数表示コマンドが実行されました");
            commandC();
        }
        else{
            System.out.println("有効なコマンドは %Q %P %C です");
        }
    }
    
    public static void commandQ() {
        System.out.println("名簿管理を終了します");
        System.exit(0);
    }

    public static void commandP() {
        System.out.println("名簿を表示します");
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
                System.out.println("データ" + i + "件目");
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
        System.out.println("名簿件数を表示します");
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
          } catch (Exception e) {
            e.printStackTrace();
          } finally {
            try {
              br.close();
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
        System.out.println((i-1)+"件のデータが登録されています");
    }
}