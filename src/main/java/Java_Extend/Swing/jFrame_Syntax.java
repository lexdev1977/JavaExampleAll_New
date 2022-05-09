package Java_Extend.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class jFrame_Syntax {

    // создаем статический метод который возвращает объект класса JFrame и производим в нем настройки окна


    static JFrame getFrame(){

//                                   *** JFrame (Окно) ***

        JFrame jFrame = new JFrame();    // создание объекта класса JFrame

        jFrame.setVisible(true);        // сделать окно видимым


        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Задает операции, которая будет по умолчанию,
        // когда пользователь инициирует «закрыть» в текущем окне.

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();          // возвращает разрешение экрана
//        double width = screenSize.getWidth();
//        double height = screenSize.getHeight();


//        jFrame.setSize(500, 400);                             // размер окна
//        jFrame.setLocation(700,300);                          // позиция на экране

        jFrame.setBounds(dimension.width/+2-200, 300,400, 300); // позиция и размер окна


        jFrame.setTitle("приложение супер ЕЖ!");         // название окна

        jFrame.setResizable(false);         // запрет изменения окна

        return jFrame;


    }



    public static void main(String[] args) {

        JFrame windows01 = getFrame();   // создаем объект JFrame (окна) вызывая метод с настройками окна getFrame
        JPanel panel01 = new JPanel();   // создаем объект панели
        windows01.add(panel01);          // добавляем панель к окну


//        Создаем кнопку и добавляем сценарий при нажатии
        JButton button01 = new JButton("Любимый цвет?");        // создаем кнопку и добавляем addActionListener
        button01.addActionListener(new ActionListener() {            // передаем анонимный класс имплиментирующий
            @Override                                                // интерфейс ActionListener
            public void actionPerformed(ActionEvent e) {             // и переопределяем метод actionPerformed
                                                                     // записывая в него любой наш код

                panel01.setBackground(Color.YELLOW);                 // задает цвет фона
            }
        });

        panel01.add(button01);                                      // добавляем кнопку на панель










//                                        блок настройки шрифта

        Font font = new Font("Arial",Font.ITALIC,20);   // задаем шрифт


//                          блок выводящий на экран все шрифты установленный в системе

//        String[] fontsInWindows = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
//
//        for (String fontWin: fontsInWindows){
//            System.out.println(fontWin);
//        }




    }




}
