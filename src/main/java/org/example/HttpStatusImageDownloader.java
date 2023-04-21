package org.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code){
        String url = new HttpStatusChecker().getStatusImage(code);

        if (!url.contains("Помилка при запиті на")){

            String imagePath = "C:\\goit\\dev\\dev-mod-7\\src\\main\\java\\org\\example\\downloadedPictures\\"+code+".jpg";

            try {
                Connection connection = Jsoup.connect(url).ignoreContentType(true);
                Connection.Response response = connection.execute();
                int statusCode = response.statusCode();

                if (statusCode == 200) {
                    InputStream inputStream = response.bodyStream();
                    OutputStream outputStream = new FileOutputStream(imagePath);

                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                    outputStream.close();
                    inputStream.close();

                    System.out.println("Зображення з кодом 200 успішно завантажено в файл " + imagePath);
                } else {
                    System.out.println("Помилка при запиті на " + url + ", статус-код: " + statusCode);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else System.out.println("Завантаження картинки не відбулося: невірний url");
    }

}
