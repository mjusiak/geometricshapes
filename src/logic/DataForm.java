/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Mati
 */
public class DataForm {

    public int form;                   // kształt
    public int x;                      // x
    public int y;                      // y
    public Color color;                // kolor
    public int size;                   // wielkosc
    
    public int xrectangle;
    public int yrectangle;        

    public DataForm(int x, int y) {

        this.x = x;
        this.y = y;
        form = generator(7);        // od 0 do 6
        color = new Color((int) (Math.random() * 0x1000000));
        size = generator(100);      // od 0 do 99
        xrectangle = generator(100);
        yrectangle = generator(100);

    }

    public int generator(int g) {
        
        Random rand = new Random(); 
        return rand.nextInt(g);

    }

}
