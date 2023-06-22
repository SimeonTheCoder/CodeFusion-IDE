package window;

import keyboard.Keyboard;
import lang.Keywords;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class Window extends JPanel {
    private JFrame frame;

    private JTextArea area;

    public Window(String name, int sizeX, int sizeY) {
        frame = new JFrame(name);
        frame.setSize(sizeX, sizeY);

        frame.setExtendedState(Frame.MAXIMIZED_BOTH);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        area = new JTextArea(100, 170);
        area.addKeyListener(new Keyboard(this));

        area.setFont(new Font("Consolas",Font.PLAIN,20));

        area.setForeground(Color.BLACK);
        area.setBackground(Color.BLACK);

        area.setCaretColor(Color.LIGHT_GRAY);

        this.setBackground(Color.BLACK);

        this.add(area);

        frame.add(this);

        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas",Font.PLAIN,20));

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

                    if(Keywords.keywords.contains(sequence.toString())) {
                        g.setColor(Color.BLUE);

                        for(int j = Math.max(0, i - sequence.length()); j < i; j ++) {
                            g.drawString(String.valueOf(copy.charAt(j)), 25 + 11 * j, 20 + 24 * currRow);
                        }
                    }else if(Keywords.vars.contains(sequence.toString())  || sequence.toString().startsWith("_")) {
                        g.setColor(Color.GREEN);

                        for(int j = Math.max(0, i - sequence.length()); j < i; j ++) {
                            g.drawString(String.valueOf(copy.charAt(j)), 25 + 11 * j, 20 + 24 * currRow);
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

                g.drawString(String.valueOf(copy.charAt(i)), 25 + 11 * i, 20 + 24 * currRow);
            }

            currRow ++;
        }

        repaint();
    }

    public void run() throws IOException {
        FileWriter writer = new FileWriter("test.jpsl");

        writer.write(area.getText());
        writer.close();

        Runtime rt = Runtime.getRuntime();
        //Process pr = rt.exec("explorer");
        Process pr = rt.exec("java -jar JPSL.jar -d -p(test.jpsl) -t8 -o(output.jpg)");
    }
}
