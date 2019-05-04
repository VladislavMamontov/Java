package ru.geekbrains.lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XOGame extends JFrame {
    JButton [] buttons;

    public XOGame() {
        setTitle("XO Game");
        setBounds(300,300,400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Main.initMap();
        Main.printMap();

        Font font = new Font("Arial",Font.BOLD,24);
        buttons = new JButton[Main.SIZE* Main.SIZE];
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(Main.SIZE, Main.SIZE));
        for (int i = 0; i < Main.SIZE* Main.SIZE; i++) {
            buttons[i] = new JButton("" + Main.DOT_EMTY);
            buttons[i].setFont(font);
            final int temp = i;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {


                    //Ход игрока
                    buttons[temp].setText("" + Main.DOT_X);
                    int x = temp % Main.SIZE;
                    int y = temp / Main.SIZE;
                    Main.map[y][x] = Main.DOT_X;

                    if (Main.checkWin(Main.DOT_X)){
                        System.out.println("Победил человек");
                        return;
                    }
                    if (Main.isMapFull()) {
                        System.out.println("Ничья");
                        return;
                    }

                    aiTurn();
                    Main.printMap();
                    if (Main.checkWin(Main.DOT_O)){
                        System.out.println("Победил ИИ");
                        return;
                    }
                    if (Main.isMapFull()) {
                        System.out.println("Ничья");
                        return;
                    }





                }
            });
            panel.add(buttons[i]);

        }
        add(panel);



        setVisible(true);
    }
    public void aiTurn() {

        //Цикл для проверки строк
        int numberOfSymb = 0;
        for (int i = 0; i < Main.SIZE; i++) {
            for (int j = 0; j < Main.SIZE; j++) {
                if (Main.map [i] [j] == Main.DOT_X) numberOfSymb ++;
                if (numberOfSymb == Main.DOTS_TO_WIN - 1 && Main.map[i][j] == Main.DOT_EMTY) {
                    Main.map[i][j] = Main.DOT_O;
                    System.out.println("Компьютер походил в точку " + (j + 1) + " " + (i + 1));
                    buttons[i * Main.SIZE + j].setText("" + Main.DOT_O);
                    return;
                }
                if (Main.map [i] [j] != Main.DOT_X) numberOfSymb = 0;
            }

            numberOfSymb = 0;
        }
        //Цикл для проверки столбцов
        for (int i = 0; i < Main.SIZE; i++) {
            for (int j = 0; j < Main.SIZE; j++) {
                if (Main.map [j] [i] == Main.DOT_X) numberOfSymb ++;
                if (numberOfSymb == Main.DOTS_TO_WIN - 1 && Main.map[j][i] == Main.DOT_EMTY) {
                    Main.map[j][i] = Main.DOT_O;
                    System.out.println("Компьютер походил в точку " + (i + 1) + " " + (j + 1));
                    buttons[j * Main.SIZE + i].setText("" + Main.DOT_O);
                    return;
                }
                if (Main.map [j] [i] != Main.DOT_X) numberOfSymb = 0;
            }

            numberOfSymb = 0;
        }

        //Цикл для проверки первой диагонали
        for (int i = 0; i < Main.SIZE; i++) {
            if (Main.map [i] [i] == Main.DOT_X) numberOfSymb++;
            if (numberOfSymb == Main.DOTS_TO_WIN - 1 && Main.map [i] [i] == Main.DOT_EMTY ){
                Main.map [i] [i] = Main.DOT_O;
                System.out.println("Компьютер походил в точку " + (i + 1) + " " + (i + 1));
                buttons[i * Main.SIZE + i].setText("" + Main.DOT_O);
                return;
            }
            if (Main.map [i] [i] != Main.DOT_X) numberOfSymb = 0;
        }
        numberOfSymb = 0;

        //Цикл для проверки второй диагонали
        for (int i = 0; i < Main.SIZE; i++) {
            for (int j = 0; j < Main.SIZE; j++) {
                if (i + j + 1 == Main.SIZE && Main.map [i] [j] == Main.DOT_X) numberOfSymb++;
                if (i + j + 1 == Main.SIZE && numberOfSymb == Main.DOTS_TO_WIN - 1 && Main.map [i] [j] == Main.DOT_EMTY) {
                    Main.map [i] [j] = Main.DOT_O;
                    System.out.println("Компьютер походил в точку " + (j + 1) + " " + (i + 1));
                    buttons[i * Main.SIZE + j].setText("" + Main.DOT_O);
                    return;
                }
                if (i + j + 1 == Main.SIZE && Main.map [i] [j] != Main.DOT_X) numberOfSymb = 0;
            }
        }
        int x, y;
        do {
            x = Main.rand.nextInt(Main.SIZE);
            y = Main.rand.nextInt(Main.SIZE);
        } while (!Main.isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        buttons[y * Main.SIZE + x].setText("" + Main.DOT_O);
        Main.map[y][x] = Main.DOT_O;
        return;
    }
}
