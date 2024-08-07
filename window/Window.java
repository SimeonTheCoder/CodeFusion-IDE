package window;

import keyboard.Keyboard;
import lang.Keywords;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Window extends JPanel {
    private JFrame frame;
    private String filename;

    private JTextArea area;

    public Window(String name, int sizeX, int sizeY, String filename) {
        this.filename = filename;

        frame = new JFrame(name);
        frame.setSize(sizeX, sizeY);

        frame.setExtendedState(Frame.MAXIMIZED_BOTH);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        area = new JTextArea(100, 170);
        area.addKeyListener(new Keyboard(this));

        area.setFont(new Font("Cascadia Code",Font.PLAIN,20));

//        area.setForeground(new Color(28, 29, 34));
        area.setBackground(new Color(28, 29, 34));

        area.setCaretColor(Color.LIGHT_GRAY);

        this.setBackground(new Color(28, 29, 34));

        this.add(area);

        frame.add(this);

        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Cascadia Code",Font.PLAIN,20));

        String[] text = area.getText().split("\n");

        int currRow = 0;

        for (String s : text) {
            g.setColor(Color.GRAY);

            g.drawString(String.valueOf(currRow + 1), 0, 20 + 24 * currRow);

            g.setColor(Color.WHITE);

            String copy = s.replace("\t", "        ") + "  ";

            StringBuilder sequence = new StringBuilder();

            for (int i = 0; i < copy.length(); i ++) {
                if(i != copy.length() - 1 && copy.charAt(i) != ' ' && copy.charAt(i) != '\n' && copy.charAt(i) != '\t' && copy.charAt(i) != '(' && copy.charAt(i) != ')') {
                    sequence.append(copy.charAt(i));
                }else{
                    if(i == copy.length() - 1) sequence.append(copy.charAt(i));

                    if(Keywords.keywords.contains(sequence.toString().toLowerCase())) {
                        g.setColor(new Color(118, 150, 255));

                        for(int j = Math.max(0, i - sequence.length()); j < i; j ++) {
                            g.drawString(String.valueOf(copy.charAt(j)), 40 + 11 * j, 20 + 24 * currRow);
                        }
                    }else if(Keywords.vars.contains(sequence.toString())  || sequence.toString().startsWith("_")) {
                        g.setColor(Color.GREEN);

                        for(int j = Math.max(0, i - sequence.length()); j < i; j ++) {
                            g.drawString(String.valueOf(copy.charAt(j)), 40 + 11 * j, 20 + 24 * currRow);
                        }
                    }

                    g.setColor(Color.WHITE);

                    sequence.delete(0, sequence.length());
                }

                if(Keywords.chars.contains(copy.charAt(i))) {
                    g.setColor(Color.ORANGE);
                }else{
                    g.setColor(Color.WHITE);
                }

                g.drawString(String.valueOf(copy.charAt(i)), 40 + 11 * i, 20 + 24 * currRow);
            }

            currRow ++;
        }

        repaint();
    }

    public void run() throws IOException {
        FileWriter writer = new FileWriter(new File(filename));

        writer.write(area.getText());
        writer.close();

//        Runtime rt = Runtime.getRuntime();
//        //Process pr = rt.exec("explorer");
//        Process pr = rt.exec("./nlang test");
    }
}
