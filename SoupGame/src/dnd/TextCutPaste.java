package dnd;

/**
 * TextCutPaste.java requires the following file:
 *     TextTransferHandler.java
 */

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import javax.swing.*;
import javax.swing.text.*;

/**
 * Example code that shows a text component that supports both
 * cut, copy and paste (using the DefaultEditorKit's built-in
 * actions) and drag and drop.
 */
public class TextCutPaste extends JPanel {
    TextTransferHandler th;

    public TextCutPaste() {
        super(new BorderLayout());

        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        //Create the transfer handler.
        TextTransferHandler th = new TextTransferHandler();

        //Create some text fields.
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
        JTextField textField = new JTextField("Cut, copy and paste...", 30);
        textField.setTransferHandler(th);
        textField.setDragEnabled(true);
        buttonPanel.add(textField);
        textField = new JTextField("or drag and drop...", 30);
        textField.setTransferHandler(th);
        textField.setDragEnabled(true);
        buttonPanel.add(textField);
        textField = new JTextField("from any of these text fields.", 30);
        textField.setTransferHandler(th);
        textField.setDragEnabled(true);
        buttonPanel.add(textField);
        add(buttonPanel, BorderLayout.CENTER);
    }

    /**
     * Create an Edit menu to support cut/copy/paste.
     */
    public JMenuBar createMenuBar () {
        JMenuItem menuItem = null;
        JMenuBar menuBar = new JMenuBar();
        JMenu mainMenu = new JMenu("Edit");
        mainMenu.setMnemonic(KeyEvent.VK_E);

        menuItem = new JMenuItem(new DefaultEditorKit.CutAction());
        menuItem.setText("Cut");
        menuItem.setMnemonic(KeyEvent.VK_T);
        mainMenu.add(menuItem);

        menuItem = new JMenuItem(new DefaultEditorKit.CopyAction());
        menuItem.setText("Copy");
        menuItem.setMnemonic(KeyEvent.VK_C);
        mainMenu.add(menuItem);

        menuItem = new JMenuItem(new DefaultEditorKit.PasteAction());
        menuItem.setText("Paste");
        menuItem.setMnemonic(KeyEvent.VK_P);
        mainMenu.add(menuItem);

        menuBar.add(mainMenu);
        return menuBar;
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TextCutPaste");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the menu bar and content pane.
        TextCutPaste demo = new TextCutPaste();
        frame.setJMenuBar(demo.createMenuBar());
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

