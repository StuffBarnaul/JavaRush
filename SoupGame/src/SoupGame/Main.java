package SoupGame;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Main {

    private static State state;
    private static JPanel mpanel;
    private static JPanel workpanel;
    private static JFrame frame;

    public static File soup;
    public static ArrayList<String> composition = new ArrayList(); // Правильный состав
    public static ArrayList<String> userComponents = new ArrayList(); // Выбранный состав
    public static ArrayList<String> result = new ArrayList<>(); //

    public Main() {

        frame = new JFrame();
        mpanel = new JPanel();

        // Sets default state
        changeState(State.SOUP);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(810, 640);
        frame.setResizable(false);
        frame.add(mpanel);
        frame.setVisible(true);
    }

    public static void changeState(State st) {
        state = st;
        switch (state) {
            case SOUP:
                mpanel.removeAll();
                workpanel = new Soup();
                mpanel.add(workpanel);
                mpanel.revalidate();
                mpanel.repaint();
                break;
            case COMPONENT:
                mpanel.removeAll();
                workpanel = new Components();
                mpanel.add(workpanel);
                mpanel.revalidate();
                mpanel.repaint();
                break;
            case RESULT:
                mpanel.removeAll();
                workpanel = new Result();
                mpanel.add(workpanel);
                mpanel.revalidate();
                mpanel.repaint();
                break;
            default:
                System.out.println("UNKNOWN STATE!");
                break;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
    }


    public static void getResults() {
        for (int i=0;i<composition.size();i++){
            String[] variations = composition.get(i).split("#");
            boolean is = true;
            for (String s:variations){
                if (userComponents.contains(s)) {
                    userComponents.remove(s);
                    is = false;
                    break;
                }
            }
            if (is) result.add(variations[0]);
        }
    }
}
