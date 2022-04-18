package Java_Basic.Scanner;

import java.util.Scanner;

public class Scanner_Syntax {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in); // создание нового сканера читающего с консоли

        scan.nextInt(); // считывает следующее число
        scan.nextLine(); // считывает строку целиком
        // !!!важно если был опрос - scan.nextInt() с консоли, то следующим считается остаток этой строки,
        // так как scan.nextInt() берет только число,
        // поэтому для сканирования следующей строки считайте сначала остаток

//        пример:
        int a = scan.nextInt(); // сканируем число
        scan.nextLine();  // сканируем остаток с этой строки
        String b = scan.nextLine(); // сканируем новую строку



        scan.useDelimiter(";"); // заменяем знак отделяющий по умолчанию на знак ";"

        while (scan.hasNext()){  // пробежаться по скану при наличии следующего элемента

        }




    }




}
