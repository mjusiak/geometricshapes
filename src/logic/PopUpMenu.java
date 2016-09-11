/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;

/**
 *
 * @author Mati
 */
public class PopUpMenu extends JPopupMenu {

    JPanel panel;
    JFrame mainf;
    public ArrayList<DataForm> forms = new ArrayList<>();

    JMenuItem form;
    JMenuItem color;
    JMenuItem size;
    JMenuItem background;
    JMenuItem fullscreen;
    JMenuItem exit;
    Color c;

    public PopUpMenu(JFrame mf, JPanel p, ArrayList<DataForm> f) {

        this.mainf = mf;
        this.panel = p;
        this.forms = f;
        form = new JMenuItem("Figura");
        color = new JMenuItem("Kolor");
        size = new JMenuItem("Wielkość");
        background = new JMenuItem("Tło");
        fullscreen = new JMenuItem("Pełny ekran");
        exit = new JMenuItem("Wyjście");

        Action();

        add(form);
        add(color);
        add(size);
        add(background);
        //add(fullscreen);
        add(exit);
    }

    private void Action() {

        form.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String f = GetForm();

                switch (f) {
                    case "koło":
                        for (int i = 0; i < forms.size(); i++) {
                            forms.get(i).form = 0;
                        }
                        break;
                    case "kwadrat":
                        for (int i = 0; i < forms.size(); i++) {
                            forms.get(i).form = 1;
                        }
                        break;
                    case "zaokrąglony kwadrat":
                        for (int i = 0; i < forms.size(); i++) {
                            forms.get(i).form = 2;
                        }
                        break;
                    case "3D kwadrat":
                        for (int i = 0; i < forms.size(); i++) {
                            forms.get(i).form = 3;
                        }
                        break;
                    default:
                }
                panel.repaint();
            }
        });

        color.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                c = JColorChooser.showDialog(null, "Wybierz kolor figur", Color.WHITE);
                for (int i = 0; i < forms.size(); i++) {
                    forms.get(i).color = c;;
                }
                panel.repaint();
            }
        });

        size.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int value = GetSize();
                for (int i = 0; i < forms.size(); i++) {
                    forms.get(i).size = value;
                }
                panel.repaint();
            }
        });

        background.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                c = JColorChooser.showDialog(null, "Wybierz kolor tła", Color.WHITE);
                panel.setBackground(c);
            }
        });

        fullscreen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private String GetForm() {
        String[] choices = {"koło", "kwadrat", "zaokrąglony kwadrat", "3D kwadrat"};
        String input = (String) JOptionPane.showInputDialog(null, "Wybierz figurę:",
                "Ustaw figury", JOptionPane.QUESTION_MESSAGE, null, // Use
                // default
                // icon
                choices, // Array of choices
                choices[0]); // Initial choice
        return input;
    }

    private int GetSize() {

        JOptionPane optionPane = new JOptionPane();
        JSlider slider = new JSlider(1, 100);
        optionPane.setMessage(new Object[]{"Wybierz wielkość: ", slider});
        optionPane.setMessageType(JOptionPane.QUESTION_MESSAGE);
        optionPane.setOptionType(JOptionPane.OK_CANCEL_OPTION);
        JDialog dialog = optionPane.createDialog(null, "Suwak wielkości");
        dialog.setVisible(true);
        //System.out.println("Input: " + optionPane.getInputValue());

        return slider.getValue();

    }

}
