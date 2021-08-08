package org.example;

import com.google.gson.Gson;

import java.io.*;
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
    StringBuilder getData = httpsConn.getHttpGET("fish895623");
    httpsConn.saveFile(getData);

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

  private StringBuilder getHttpGET(String username) throws Exception {
    String apiAddress = "https://api.github.com/users/" + username + "/repos";

    URL obj = new URL(apiAddress);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    // 전송방식
    con.setRequestMethod("GET");
    // Request Header 정의
    con.setRequestProperty("User-Agent", USER_AGENT);
    con.setConnectTimeout(10000); // 컨텍션타임아웃 10초
    con.setReadTimeout(5000); // 컨텐츠조회 타임아웃 5총

    int responseCode = con.getResponseCode();

    Charset charset = StandardCharsets.UTF_8;
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
    java.lang.String inputLine;
    StringBuilder response = new StringBuilder();
    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    in.close();

    return response;
  }

  private void saveFile(StringBuilder stringBuilder) {
    File file = new File("json_github.json");

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
      writer.write(stringBuilder.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
