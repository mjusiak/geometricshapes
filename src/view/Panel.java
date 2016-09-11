/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import logic.DataForm;

/**
 *
 * @author Mati
 */
public class Panel extends JPanel {

    public ArrayList<DataForm> forms = new ArrayList<>();
    Dimension dim;

    public void setPoints(ArrayList<DataForm> f) {
        this.forms = f;
        dim= new Dimension();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        dim = this.getSize();
        for (int i = 0; i < forms.size(); i++) {
            if (init(i)) {
                g.setColor(forms.get(i).color);
                switch (forms.get(i).form) {
                    case 0: // koło
                        g.fillOval(forms.get(i).x - forms.get(i).size, forms.get(i).y - forms.get(i).size, 2 * forms.get(i).size, 2 * forms.get(i).size);
                        break;
                    case 1: // kwadrat
                        g.fillRect(forms.get(i).x - forms.get(i).size, forms.get(i).y - forms.get(i).size, 2 * forms.get(i).size, 2 * forms.get(i).size);
                        break;
                    case 2: // prostokąt 
                        g.fillRect(forms.get(i).x - forms.get(i).xrectangle, forms.get(i).y - forms.get(i).yrectangle, 2 * forms.get(i).xrectangle, 2 * forms.get(i).yrectangle);
                        break;
                    case 3: // zaokrąglony kwadrat
                        g.fillRoundRect(forms.get(i).x - forms.get(i).size, forms.get(i).y - forms.get(i).size, 2 * forms.get(i).size, 2 * forms.get(i).size, 60, 60);
                        break;
                    case 4: // zaokrąglony prostokąt
                        g.fillRoundRect(forms.get(i).x - (forms.get(i).xrectangle/2), forms.get(i).y - (forms.get(i).yrectangle/2), forms.get(i).xrectangle, forms.get(i).yrectangle, 60, 60);
                        break;
                    case 5: // kwadrat 3D
                        g.fill3DRect(forms.get(i).x - forms.get(i).size, forms.get(i).y - forms.get(i).size, 2 * forms.get(i).size, 2 * forms.get(i).size, false);
                        break;
                    case 6: // koło-trójkąt
                        g.fillArc(forms.get(i).x - forms.get(i).size, forms.get(i).y - forms.get(i).size, 2 * forms.get(i).size, 2 * forms.get(i).size, ABORT, ABORT);
                        break;
                    default:

                }
            }
        }
    }

    public boolean init(int tmp) {

        if (check(tmp)) {
            return true;
        } else {
            forms.remove(tmp);
            return false;
        }
    }

    public boolean check(int tmp) {
        if (forms.get(tmp).x < 50) {
            return false;
        } else if (forms.get(tmp).y < 50) {
            return false;
        } else if (forms.get(tmp).x > dim.getWidth()-50) {
            return false;
        } else if (forms.get(tmp).y > dim.getHeight()-50) {
            return false;
        } else {
            return true;
        }
    }

}
