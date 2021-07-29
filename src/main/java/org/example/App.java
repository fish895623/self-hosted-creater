package org.example;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Hello world!
 */
public class App {
  public static final java.lang.String USER_AGENT = "Mozilla/5.0";


  public static void main(String[] args) throws Exception {
    App httpsConn = new App();
    String getData = httpsConn.getHttpGET("https://api.github.com/users/fish895623/repos");

    httpsConn.using_JsonParser2("json_github2.json");
    httpsConn.using_JsonParser2("json_github.json");
  }

  private void using_JsonParser2(String filename) throws FileNotFoundException {
    Gson gson = new Gson();
    JsonGithub[] jsonArray = gson.fromJson(new FileReader(filename), JsonGithub[].class);
    for (JsonGithub json_github : jsonArray) {
      System.out.println(json_github.get_full_name());
    }
  }

  private String getHttpGET(String username) throws Exception {
    String apiAddress = "https://api.github.com/users/" + username + "/repos";

    URL obj = new URL(apiAddress);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    //전송방식
    con.setRequestMethod("GET");
    //Request Header 정의
    con.setRequestProperty("User-Agent", USER_AGENT);
    con.setConnectTimeout(10000);       //컨텍션타임아웃 10초
    con.setReadTimeout(5000);           //컨텐츠조회 타임아웃 5총

    int responseCode = con.getResponseCode();

    Charset charset = StandardCharsets.UTF_8;
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
    java.lang.String inputLine;
    StringBuilder response = new StringBuilder();
    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    in.close();

    return response.toString();
  }
}
