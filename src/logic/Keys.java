/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Mati
 */
public class Keys implements KeyListener {

    JPanel panel;
    ArrayList<DataForm> forms = new ArrayList<>();
    DataForm d;
    Socket socket;

    Keys(JPanel p, ArrayList<DataForm> f) {
        panel = p;
        forms = f;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!forms.isEmpty()) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_UP:  // handle up
                    d = forms.get(forms.size() - 1);
                    d.y -= 1;
                    break;
                case KeyEvent.VK_DOWN:  // handle down 
                    d = forms.get(forms.size() - 1);
                    d.y += 1;
                    break;
                case KeyEvent.VK_LEFT:  // handle left
                    d = forms.get(forms.size() - 1);
                    d.x -= 1;
                    break;
                case KeyEvent.VK_RIGHT:  // handle right
                    d = forms.get(forms.size() - 1);
                    d.x += 1;
                    break;
                case KeyEvent.VK_D:
                    forms.remove(forms.size() - 1);
                    break;
                case KeyEvent.VK_W:
                    for (int i = 0; i < forms.size(); i++) {
                        if (i % 2 == 0) {
                            forms.get(i).x += 1;
                            forms.get(i).y -= 1;
                        } else {
                            forms.get(i).x -= 1;
                            forms.get(i).y += 1;
                        }
                    }
                    break;
                case KeyEvent.VK_E:
                    for (int i = 0; i < forms.size(); i++) {
                        forms.get(i).size = 10;
                    }
                    break;
                case KeyEvent.VK_R:
                    for (int i = 0; i < forms.size(); i++) {
                        forms.get(i).size = 150;
                    }
                    break;
                case KeyEvent.VK_Q:
                    for (int i = 0; i < forms.size(); i++) {
                        if (i % 2 == 0) {
                            forms.get(i).x -= 1;
                            forms.get(i).y += 1;
                        } else {
                            forms.get(i).x += 1;
                            forms.get(i).y -= 1;
                        }
                    }
                    break;
                case KeyEvent.VK_S:
                    for (int j = forms.size() - 1; j >= 0; j--) {
                        forms.remove(j);
                    }
                    break;
                default:

            }
            panel.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
