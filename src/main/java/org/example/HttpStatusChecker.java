package org.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class HttpStatusChecker {

    public String getStatusImage(int code) {

        String BASE_URL = "https://http.cat/";
        String url = BASE_URL + code + ".jpg";

        try {
            Connection connection = Jsoup.connect(url).ignoreContentType(true);
            Connection.Response response = connection.execute();
            int statusCode = response.statusCode();
            if (statusCode == 200){
                return url;
            }
            else  return "Помилка при запиті на " + url;

        } catch (IOException e) {
            return "Помилка при запиті на " + url;
        }
    }
}
