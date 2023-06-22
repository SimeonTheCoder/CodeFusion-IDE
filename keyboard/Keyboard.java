package keyboard;


import window.Window;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Keyboard implements KeyListener {
    private Window window;

    public Keyboard(Window window) {
        this.window = window;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 116: //F5
                try {
                    window.run();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
