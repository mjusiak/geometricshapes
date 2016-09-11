/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Mati
 */
public class Mouse implements MouseListener {

    public ArrayList<DataForm> forms = new ArrayList<>();
    JPanel panel;
    JFrame mainf;
    PopUpMenu menu;

    public Mouse(JFrame mf, JPanel p) {
        this.panel = p;
        this.mainf = mf;
        menu = new PopUpMenu(mainf, panel, forms);
    }

    public void setPoints(ArrayList<DataForm> f) {
        this.forms = f;
    }

    public void doPop(MouseEvent e) {
        menu = new PopUpMenu(mainf, panel, forms);
/*        JPopupMenu menu = new JPopupMenu();
menu.add(new JMenuItem("remove"));
JMenuItem addItem = new JMenu("add");
menu.add(addItem);

addItem.add(new JMenuItem("pizza"));
addItem.add(new JMenuItem("cake"));
JMenuItem addItem1 = new JMenu("add1");
addItem.add(addItem1);
        */
        menu.show(e.getComponent(), e.getX(), e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            DataForm d = new DataForm(e.getPoint().x, e.getPoint().y);
            forms.add(d);
            panel.repaint();
        } else if (SwingUtilities.isRightMouseButton(e)) {
            doPop(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
