package Java_Extend.SimpleProject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class URL_InputStream {
    public static void main(String[] args) throws IOException {


        // код для считывания содержимого страницы и записи его в массив

        URL url = new URL("https://javarush.ru");
        InputStream input = url.openStream();
        byte[] buffer = input.readAllBytes();
        String str = new String(buffer);
        System.out.println(str);


        // код для считывания картинки из интернета и сохранении ее в файл

        String image = "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png";
        URL url1 = new URL(image);
        InputStream input1 = url1.openStream();

        Path path = Path.of("c:\\GoogleLogo.jpg");
        Files.copy(input1, path);

    // еще вариант считывания содержимого по адрессу
        URL url2 = new URL("https://javarush.ru");
        System.out.println(getResponseFromURL(url2));   // вызов метода getResponseFromURL



    }

    // метод который считывает данные по адресу и возвращает в виде строки
    public static String getResponseFromURL(URL url2) throws IOException{
        HttpURLConnection urlConnection = (HttpURLConnection) url2.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scan = new Scanner(in);
            scan.useDelimiter("\\A");   //  здесь в качестве разделителя используется начало строки,
                                        //  что позволяет считать все данные

            Boolean hasInput = scan.hasNext();
            if (hasInput) {
                return scan.next();
            } else return null;

        } finally {
            urlConnection.disconnect();
        }
    }






}
