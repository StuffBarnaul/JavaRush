package SoupGame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

public class Components extends JPanel {
    final String ROOT = "Компоненты";
    final Font font = new Font("Verdana", Font.PLAIN, 18);
    DefaultListModel<String> model =  new DefaultListModel();
    private String componentToAdd;
    private int indexToRemove;

    public Components() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(800,600));
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        Main.composition = readcomposition(Main.soup);

        // Добавляем верхнее поле
        JTextField topField = new JTextField("Выберите компоненты для "+Main.soup.getName());
        topField.setBounds(0,0,800,50);
        topField.setHorizontalAlignment(SwingConstants.CENTER);
        topField.setFont(font);
        panel.add(topField);

        //Добавляем панель со списом компонентов
        JTree components = new JTree(getMyComponents());
        components.setFont(font);
        components.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        components.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) components.getLastSelectedPathComponent();
                boolean isInModel = true;
                for (int i=0;i<model.size();i++){
                    if (model.get(i) == components.getLastSelectedPathComponent().toString()) isInModel=false;
                }
                if (selectedNode.isLeaf() && isInModel){
                    componentToAdd = components.getLastSelectedPathComponent().toString();
                } else componentToAdd = null;
            }
        });
        components.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) components.getLastSelectedPathComponent();
                    if (selectedNode == null) return;
                    boolean isInModel = true;
                    for (int i=0;i<model.size();i++){
                        if (model.get(i) == components.getLastSelectedPathComponent().toString()) isInModel=false;
                    }
                    if (selectedNode.isLeaf() && isInModel){
                        componentToAdd = components.getLastSelectedPathComponent().toString();
                        model.addElement(componentToAdd);
                        panel.revalidate();
                    } else componentToAdd = null;
                }
            }
        });
        JScrollPane soupComponentScroll = new JScrollPane(components);
        soupComponentScroll.setBounds(50,75,300,450);
        panel.add(soupComponentScroll);

        // Кнопка добавить компонент
        JButton addComponent = new JButton("->");
        addComponent.setFont(font);
        addComponent.setBounds(360,150,80,80);
        addComponent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (componentToAdd!=null){
                    model.addElement(componentToAdd);
                    panel.revalidate();
                }
            }
        });
        panel.add(addComponent);

        // Кнопка удалить компонент
        JButton removeComponent = new JButton("<-");
        removeComponent.setFont(font);
        removeComponent.setBounds(360,350,80,80);
        removeComponent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indexToRemove>=0) model.remove(indexToRemove);
                panel.revalidate();
            }
        });
        panel.add(removeComponent);

        // Панель выбранных компонентов
        JList userComponents = new JList(model);
        userComponents.setLayoutOrientation(JList.VERTICAL);
        userComponents.setVisibleRowCount(0);
        userComponents.setFont(font);
        userComponents.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        userComponents.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                indexToRemove = userComponents.getSelectedIndex();
            }
        });
        userComponents.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                //JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    indexToRemove = userComponents.getSelectedIndex();
                    if (indexToRemove>=0) model.remove(indexToRemove);
                    panel.revalidate();
                }
            }
        });
        JScrollPane userComponentScroll = new JScrollPane(userComponents);
        userComponentScroll.setBounds(450,75,300,450);
        panel.add(userComponentScroll);

        // Кнопка перехода на следующий экран
        JButton choice = new JButton("Проверить");
        choice.setFont(font);
        choice.setBounds(0,550,800,50);
        choice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<model.size();i++){
                    Main.userComponents.add(model.get(i));
                }
                Main.changeState(State.RESULT);
            }
        });
        panel.add(choice);

        this.add(panel);
    }

    private TreeModel getMyComponents() {
        // Корневой узел дерева
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(ROOT);
        // Добавление ветвей - потомков 1-го уровня
        DefaultMutableTreeNode type1 = new DefaultMutableTreeNode("Мясо,рыба,птица");
        DefaultMutableTreeNode type2 = new DefaultMutableTreeNode("Овощи");
        DefaultMutableTreeNode type3 = new DefaultMutableTreeNode("Бакалея");
        DefaultMutableTreeNode type4 = new DefaultMutableTreeNode("Специи");
        DefaultMutableTreeNode type5 = new DefaultMutableTreeNode("При подаче");
        // Добавление ветвей к корневой записи
        root.add(type1);
        // Добавление листьев - потомков 2-го уровня
        type1.add(new DefaultMutableTreeNode("Баранина"));
        type1.add(new DefaultMutableTreeNode("Баранина(грудинка)"));
        type1.add(new DefaultMutableTreeNode("Белуга"));
        type1.add(new DefaultMutableTreeNode("Вымя"));
        type1.add(new DefaultMutableTreeNode("Говядина"));
        type1.add(new DefaultMutableTreeNode("Говядина(грудинка)"));
        type1.add(new DefaultMutableTreeNode("Головизна"));
        type1.add(new DefaultMutableTreeNode("Жир-сырец свиной"));
        type1.add(new DefaultMutableTreeNode("Зубатка пятнистая(пестрая)"));
        type1.add(new DefaultMutableTreeNode("Конина"));
        type1.add(new DefaultMutableTreeNode("Кости свинокопченостей"));
        type1.add(new DefaultMutableTreeNode("Окорок копчено-вареный"));
        type1.add(new DefaultMutableTreeNode("Окунь морской"));
        type1.add(new DefaultMutableTreeNode("Осетр"));
        type1.add(new DefaultMutableTreeNode("Почки говяжьи"));
        type1.add(new DefaultMutableTreeNode("Сардельки"));
        type1.add(new DefaultMutableTreeNode("Сердце"));
        type1.add(new DefaultMutableTreeNode("Сосиски"));
        type1.add(new DefaultMutableTreeNode("Стерлядь"));
        type1.add(new DefaultMutableTreeNode("Судак"));
        type1.add(new DefaultMutableTreeNode("Телятина"));
        type1.add(new DefaultMutableTreeNode("Треска"));
        type1.add(new DefaultMutableTreeNode("Шпик"));
        type1.add(new DefaultMutableTreeNode("Язык говяжий"));
        root.add(type2);
        type2.add(new DefaultMutableTreeNode("Грибы белые свежие"));
        type2.add(new DefaultMutableTreeNode("Грибы белые сушеные"));
        type2.add(new DefaultMutableTreeNode("Кабачки"));
        type2.add(new DefaultMutableTreeNode("Капуста белокочанная"));
        type2.add(new DefaultMutableTreeNode("Капуста брюссельская"));
        type2.add(new DefaultMutableTreeNode("Капуста квашеная"));
        type2.add(new DefaultMutableTreeNode("Капуста савойская"));
        type2.add(new DefaultMutableTreeNode("Капуста цветная"));
        type2.add(new DefaultMutableTreeNode("Картофель"));
        type2.add(new DefaultMutableTreeNode("Лук порей"));
        type2.add(new DefaultMutableTreeNode("Лук репчатый"));
        type2.add(new DefaultMutableTreeNode("Морковь"));
        type2.add(new DefaultMutableTreeNode("Перец сладкий"));
        type2.add(new DefaultMutableTreeNode("Петрушка (корень)"));
        type2.add(new DefaultMutableTreeNode("Помидоры свежие"));
        type2.add(new DefaultMutableTreeNode("Репа"));
        type2.add(new DefaultMutableTreeNode("Свекла"));
        type2.add(new DefaultMutableTreeNode("Свекла молодая с ботвой"));
        type2.add(new DefaultMutableTreeNode("Сельдерей (корень)"));
        type2.add(new DefaultMutableTreeNode("Фасоль овощная свежая"));
        type2.add(new DefaultMutableTreeNode("Чеснок"));
        type2.add(new DefaultMutableTreeNode("Шампиньоны свежие"));
        type2.add(new DefaultMutableTreeNode("Шпинат"));
        type2.add(new DefaultMutableTreeNode("Щавель"));
        root.add(type3);
        type3.add(new DefaultMutableTreeNode("Вермишель"));
        type3.add(new DefaultMutableTreeNode("Геркулес"));
        type3.add(new DefaultMutableTreeNode("Горох лущеный"));
        type3.add(new DefaultMutableTreeNode("Горошек зеленый консервированный"));
        type3.add(new DefaultMutableTreeNode("Жир для жарки"));
        type3.add(new DefaultMutableTreeNode("Каперсы"));
        type3.add(new DefaultMutableTreeNode("Крупа манная"));
        type3.add(new DefaultMutableTreeNode("Крупа овсяная"));
        type3.add(new DefaultMutableTreeNode("Крупа перловая"));
        type3.add(new DefaultMutableTreeNode("Крупа пшеничная"));
        type3.add(new DefaultMutableTreeNode("Крупа рисовая"));
        type3.add(new DefaultMutableTreeNode("Крупа ячневая"));
        type3.add(new DefaultMutableTreeNode("Лапша"));
        type3.add(new DefaultMutableTreeNode("Лапша домашняя"));
        type3.add(new DefaultMutableTreeNode("Макароны"));
        type3.add(new DefaultMutableTreeNode("Маргарин"));
        type3.add(new DefaultMutableTreeNode("Маслины"));
        type3.add(new DefaultMutableTreeNode("Масло сливочное"));
        type3.add(new DefaultMutableTreeNode("Молоко"));
        type3.add(new DefaultMutableTreeNode("Мука пшеничная"));
        type3.add(new DefaultMutableTreeNode("Огурцы соленые"));
        type3.add(new DefaultMutableTreeNode("Пшено"));
        type3.add(new DefaultMutableTreeNode("Сахар"));
        type3.add(new DefaultMutableTreeNode("Сливки"));
        type3.add(new DefaultMutableTreeNode("Соус ткемали"));
        type3.add(new DefaultMutableTreeNode("Томатное пюре"));
        type3.add(new DefaultMutableTreeNode("Уксус 3%-ный"));
        type3.add(new DefaultMutableTreeNode("Фасоль"));
        type3.add(new DefaultMutableTreeNode("Чернослив"));
        type3.add(new DefaultMutableTreeNode("Чечевица"));
        type3.add(new DefaultMutableTreeNode("Яйцо"));
        root.add(type4);
        type4.add(new DefaultMutableTreeNode("Кориандр(кинза)"));
        type4.add(new DefaultMutableTreeNode("Хмели-сунели(сушеная зелень)"));
        root.add(type5);
        type5.add(new DefaultMutableTreeNode("Клецки готовые"));
        type5.add(new DefaultMutableTreeNode("Лимон"));
        type5.add(new DefaultMutableTreeNode("Лук зеленый"));
        type5.add(new DefaultMutableTreeNode("Пельмени готовые"));
        type5.add(new DefaultMutableTreeNode("Петрушка(зелень)"));
        type5.add(new DefaultMutableTreeNode("Сметана"));
        type5.add(new DefaultMutableTreeNode("Фрикадельки мясные готовые"));
        type5.add(new DefaultMutableTreeNode("Фрикадельки рыбные готовые"));
        // Создание стандартной модели
        TreeModel model = new DefaultTreeModel(root);
        return model;
    }

    private ArrayList readcomposition(File soup) {
        ArrayList composition = new ArrayList();
        try {
            FileInputStream fstream = new FileInputStream(soup);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream,"UTF8"));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                composition.add(strLine);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        }
        return composition;
    }
}
