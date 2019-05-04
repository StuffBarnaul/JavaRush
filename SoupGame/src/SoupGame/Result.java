package SoupGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Result extends javax.swing.JPanel {
    final Font font = new Font("Verdana", Font.PLAIN, 18);
    DefaultListModel<String> model1;
    DefaultListModel<String> model2;

    public Result() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(800,600));
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);

        // Добавляем верхнее поле
        JTextField topField = new JTextField("Результаты");
        topField.setBounds(0,0,800,50);
        topField.setHorizontalAlignment(SwingConstants.CENTER);
        topField.setFont(font);
        panel.add(topField);

        // Получаем результаты
        Main.getResults();

        if (Main.userComponents.size() == 0 && Main.result.size() == 0){
            final Font winFont = new Font("Verdana", Font.PLAIN, 120);
            JTextField win = new JTextField("Все Верно");
            win.setBounds(50,75,700,450);
            win.setHorizontalAlignment(SwingConstants.CENTER);
            win.setFont(winFont);
            panel.add(win);
        } else {

            // Чего не хватает в супе
            JTextField r1 = new JTextField("Не хватает:");
            r1.setBounds(50, 75, 300, 50);
            r1.setHorizontalAlignment(SwingConstants.CENTER);
            r1.setFont(font);
            panel.add(r1);
            model1 = new DefaultListModel<>();
            for (int i = 0; i < Main.result.size(); i++) {
                model1.addElement(Main.result.get(i));
            }
            JList res1 = new JList(model1);
            res1.setLayoutOrientation(JList.VERTICAL);
            res1.setVisibleRowCount(0);
            res1.setFont(font);
            JScrollPane resScroll1 = new JScrollPane(res1);
            resScroll1.setBounds(50, 125, 300, 400);
            panel.add(resScroll1);

            // Чего лишнего положили
            JTextField r2 = new JTextField("Лишнего:");
            r2.setBounds(450, 75, 300, 50);
            r2.setHorizontalAlignment(SwingConstants.CENTER);
            r2.setFont(font);
            panel.add(r2);
            model2 = new DefaultListModel<>();
            for (int i = 0; i < Main.userComponents.size(); i++) {
                model2.addElement(Main.userComponents.get(i));
            }
            JList res2 = new JList(model2);
            res2.setLayoutOrientation(JList.VERTICAL);
            res2.setVisibleRowCount(0);
            res2.setFont(font);
            res2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JScrollPane resScroll2 = new JScrollPane(res2);
            resScroll2.setBounds(450, 125, 300, 400);
            panel.add(resScroll2);
        }

        // Кнопка перехода на следующий экран
        JButton choice = new JButton("Еще раз");
        choice.setFont(font);
        choice.setBounds(0,550,800,50);
        choice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.soup = new File("");
                Main.composition.clear();
                Main.userComponents.clear();
                Main.result.clear();
                Main.changeState(State.SOUP);
            }
        });
        panel.add(choice);

        this.add(panel);
    }
}