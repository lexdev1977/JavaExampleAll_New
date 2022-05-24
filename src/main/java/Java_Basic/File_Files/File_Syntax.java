package Java_Basic.File_Files;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class File_Syntax {




public static void main(String[] args) {


//  Сканирование и вывод всех файлов в директории по указанному пути
    File folder = new File("c:/windows/");
    for (File file : folder.listFiles())
    {
        System.out.println(file.getName());
    }

    System.out.println("........................................................");



//  Создание фильтра по имени для помещения в метод - folder.listFiles()
    FilenameFilter filter = new FilenameFilter() {

        public boolean accept(File f, String name)       // переопределяем метод accept
        {
            return name.startsWith("win");               // возвращаем поиск файлов начинающихся с - "win"

//      метод возвращает boolean сравнивая со значением, которое передаем в один из методов переменной name
//       (например .startsWith, .equals .endsWith)
//
        }
    };


//  Сканирование и вывод всех файлов в директории по указанному пути с учетом фильтра

    for (File file : folder.listFiles(filter))
    {
        System.out.println(file.getName());
    }

    System.out.println("........................................................");


//  Создание фильтра по имени и расширению для помещения в метод - folder.listFiles()

    FileFilter filter02 = new FileFilter() {

        public boolean accept(File f)
        {
            return f.getName().endsWith("log");
        }

    };
//  Сканирование и вывод всех файлов в директории по указанному пути с учетом фильтра
    for (File file : folder.listFiles(filter02))
    {
        System.out.println(file.getName());
    }




}




}
