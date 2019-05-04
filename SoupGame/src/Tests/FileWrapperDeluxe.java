package Tests;

import javax.swing.*;
import javax.swing.tree.TreeModel;
import java.io.File;

public class FileWrapperDeluxe {
    public static void main(final String[] args) {
        final JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.setBounds(100, 100, 400, 400);

        final File file = new File("E:\\");
        final MyFile mf = new MyFile(file);
        final TreeModel model = new FileTreeModel(mf);

        final JTree tree = new JTree(model);
        tree.setEditable(true);

        f.add(new JScrollPane(tree));
        f.setVisible(true);
    }
}
