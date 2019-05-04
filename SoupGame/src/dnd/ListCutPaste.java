package dnd;

/**
 * ListCutPaste.java requires the following files:
 *     ListTransferHandler.java
 *     TransferActionListener.java
 */
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import javax.swing.*;

/**
 * The ListCutPaste example illustrates cut, copy, paste
 * and drag and drop using three instances of JList.
 * The TransferActionListener class listens for one of
 * the CCP actions and, when one occurs, forwards the
 * action to the component which currently has the focus.
 */
public class ListCutPaste extends JPanel {
    ListTransferHandler lh;

    public ListCutPaste() {
        super(new BorderLayout());
        lh = new ListTransferHandler();

        JPanel panel = new JPanel(new GridLayout(1, 3));
        DefaultListModel list1Model = new DefaultListModel();
        list1Model.addElement("alpha");
        list1Model.addElement("beta");
        list1Model.addElement("gamma");
        list1Model.addElement("delta");
        list1Model.addElement("epsilon");
        list1Model.addElement("zeta");
        JList list1 = new JList(list1Model);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane sp1 = new JScrollPane(list1);
        sp1.setPreferredSize(new Dimension(400,100));        list1.setDragEnabled(true);
        list1.setTransferHandler(lh);
        list1.setDropMode(DropMode.INSERT);
        setMappings(list1);
        JPanel pan1 = new JPanel(new BorderLayout());
        pan1.add(sp1, BorderLayout.CENTER);
        pan1.setBorder(BorderFactory.createTitledBorder("Greek Alphabet"));
        panel.add(pan1);

        DefaultListModel list2Model = new DefaultListModel();
        list2Model.addElement("uma");
        list2Model.addElement("dois");
        list2Model.addElement("tres");
        list2Model.addElement("quatro");
        list2Model.addElement("cinco");
        list2Model.addElement("seis");
        JList list2 = new JList(list2Model);
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);        list2.setDragEnabled(true);
        JScrollPane sp2 = new JScrollPane(list2);
        sp2.setPreferredSize(new Dimension(400,100));
        list2.setTransferHandler(lh);
        list2.setDropMode(DropMode.INSERT);
        setMappings(list2);
        JPanel pan2 = new JPanel(new BorderLayout());
        pan2.add(sp2, BorderLayout.CENTER);
        pan2.setBorder(BorderFactory.createTitledBorder("Portuguese Numbers"));
        panel.add(pan2);

        setPreferredSize(new Dimension(500, 200));
        add(panel, BorderLayout.CENTER);
    }

    /**
     * Add the cut/copy/paste actions to the action map.
     */
    private void setMappings(JList list) {
        ActionMap map = list.getActionMap();
        map.put(TransferHandler.getCutAction().getValue(Action.NAME),
                TransferHandler.getCutAction());
        map.put(TransferHandler.getCopyAction().getValue(Action.NAME),
                TransferHandler.getCopyAction());
        map.put(TransferHandler.getPasteAction().getValue(Action.NAME),
                TransferHandler.getPasteAction());

    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ListCutPaste");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the menu bar and content pane.
        ListCutPaste demo = new ListCutPaste();
        demo.setOpaque(true); //content panes must be opaque
        frame.setContentPane(demo);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }
}
