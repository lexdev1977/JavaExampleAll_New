package Java_Extend.Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LookAndFeelInfo_Syntax {
    public static void main(String[] args) {

        // Код для вывода списка стилей прописанных в системе

        UIManager.LookAndFeelInfo[] uiInfo = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info: uiInfo){

            System.out.println(info.getName());
            System.out.println(info.getClassName());

        }



        JFrame win01 = newWin();
        JPanel panel01 = new JPanel();
        win01.add(panel01);

        JButton button01 = new JButton("MetalL");
        JButton button02 = new JButton("Motif");
        JButton button03 = new JButton("Nimbus");
        JButton button04 = new JButton("Windows");


        panel01.add(button01);
        panel01.add(button02);
        panel01.add(button03);
        panel01.add(button04);

        // Блок кода при нажатии которого мы меняем стили

        button01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (Exception el) {
                    el.printStackTrace();

                }
            }
        });

        button02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (Exception el) {
                    el.printStackTrace();

                }
            }
        });

        button03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception el) {
                    el.printStackTrace();

                }
            }
        });

        button04.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (Exception el) {
                    el.printStackTrace();

                }
            }
        });


    }

    static JFrame newWin(){
        JFrame win01 = new JFrame();
        win01.setVisible(true);
        win01.setBounds(600, 300,400, 300);
        win01.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return win01;
    }



}
