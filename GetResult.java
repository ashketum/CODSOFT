import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GetResult {

    public GetResult() {
    }

    public String URLWork(String url) throws IOException{

          URL urlObject = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            Scanner sc = new Scanner(connection.getInputStream());
            StringBuilder sb = new StringBuilder();

            while (sc.hasNext()) {
                sb.append(sc.nextLine());
            }
            sc.close();
        
          return sb.toString();
        }
        return "";
    }
    
     public double getResult(String from, String to, double amt) throws IOException {

        String url = "https://api.frankfurter.dev/v1/latest?base=" + from + "&symbols=" + to;

            String str = URLWork(url);
            
            if(!str.equals("")){
                return formatResult(str)*amt;
            }
            
            return -1;
    }

    public double formatResult(String result){

        result = result.replaceAll("[\\{\\}]", "");
         String[] arr = result.split(",");
        String[][] arr2 = new String[4][2];

        int i = 0;
        for (String str : arr) {
            arr2[i++] = str.split(":");
        }

        String rate = arr2[3][2];
        rate = rate.replace("}", "");
  
        return Double.parseDouble(rate);
    }

    public String getCountryCode() throws IOException{
        String url = "https://api.frankfurter.dev/v1/currencies";

         String result = URLWork(url);
        result = result.replaceAll("[\\{\\}]", "");

        if(result.isEmpty()) return "";
      
       StringBuilder sb = new StringBuilder();

        for(String s : result.split(",")){
            sb
            .append(s.replace(":", " : "))
            .append("\n");
        }
         System.out.println(sb);
        return sb.toString();
    }
}
