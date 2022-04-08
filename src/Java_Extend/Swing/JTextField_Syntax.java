package Java_Extend.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class JTextField_Syntax {
    public static void main(String[] args) throws InterruptedException {

        JFrame win01 = newWin();
        JPanel panel01 = new JPanel();
        win01.add(panel01);

        JTextField textField = new JTextField("Введите какой либо текст", 30);

        JTextArea textArea = new JTextArea("Проба текста", 20, 60);


        panel01.add(textField);
        panel01.add(textArea);
        panel01.revalidate();

//        Thread.sleep(10000);

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(textField.getText());
            }
        });






    }


    static JFrame newWin(){
        JFrame win01 = new JFrame();
        win01.setVisible(true);
        win01.setBounds(500, 300,800, 500);
        win01.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return win01;

    }
}

