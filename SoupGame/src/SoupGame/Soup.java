package SoupGame;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class Soup extends JPanel {
    final Font font = new Font("Verdana", Font.PLAIN, 18);
    private DefaultMutableTreeNode root;
    private DefaultTreeModel souplist;
    private JTree soupTree;

    public Soup() {

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(800, 600));
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);

        // Добавляем верхнее поле
        JTextField topField = new JTextField("Выберите суп");
        topField.setBounds(0, 0, 800, 50);
        topField.setHorizontalAlignment(SwingConstants.CENTER);
        topField.setFont(font);
        panel.add(topField);

        // Собираем данные об имеющихся супах и слушаем выбор
        File dir = new File(System.getProperty("user.dir"));
        File fileRoot = new File(System.getProperty("user.dir")+"\\Resources");
        root = new DefaultMutableTreeNode(new FileNode(fileRoot));
        readSoupList(fileRoot,root);
        souplist = new DefaultTreeModel(root);
        soupTree = new JTree(souplist);
        soupTree.setRootVisible(false);
        soupTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        soupTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                JTree tree = (JTree)e.getSource();
                TreePath selected = tree.getSelectionPath();
                Object[] nodes = selected.getPath();
                String path = fileRoot.getPath();
                for (int i=1;i<nodes.length;i++){
                    path+="\\"+nodes[i];
                }
                Main.soup = new File(path);
            }
        });
        soupTree.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    TreePath selected = soupTree.getClosestPathForLocation(e.getX(), e.getY());
                    if (selected == null) return;
                    Object[] nodes = selected.getPath();
                    String path = fileRoot.getPath();
                    for (int i=1;i<nodes.length;i++){
                        path+="\\"+nodes[i];
                    }
                    Main.soup = new File(path);
                    if (!Main.soup.isDirectory()) Main.changeState(State.COMPONENT);
                }
            }
        });
        soupTree.setVisibleRowCount(0);
        soupTree.setFont(font);
        JScrollPane soupScroll = new JScrollPane(soupTree);
        soupScroll.setBounds(100, 75, 600, 450);
        panel.add(soupScroll);

        // Кнопка перехода на следующий экран
        JButton choice = new JButton("Подобрать ингредиенты");
        choice.setFont(font);
        choice.setBounds(0, 550, 800, 50);
        choice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Main.soup.isDirectory()) {
                    Main.changeState(State.COMPONENT);
                }
            }
        });
        panel.add(choice);

        this.add(panel);
    }

    private void readSoupList(File fileRoot,
                              DefaultMutableTreeNode node) {
        File[] files = fileRoot.listFiles();
        if (files == null) return;
        for (File file : files) {
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(new FileNode(file));
            node.add(childNode);
            if (file.isDirectory()) {
                readSoupList(file, childNode);
            }
        }
    }

}