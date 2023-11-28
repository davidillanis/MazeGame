package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Personaje{
    protected int coor_x=Juego.lado, coor_y=Juego.lado;
    private int l;
    protected int labe[][]=new Laberinto(null).laberi;//Nivel_________________
    private Juego juego;
    private ImageIcon personaje=new ImageIcon("src/main/personaje.png");
    
    
    public Personaje(Juego juego){
        this.juego=juego;
    }
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));
        l=Juego.lado;
        
        personaje=new ImageIcon(personaje.getImage().getScaledInstance(l, l, Image.SCALE_SMOOTH));
        g.drawImage(personaje.getImage(), coor_x, coor_y, juego);
    }
    public void MovPersonaje(KeyEvent e){
        if(e.getKeyCode()==37){//Izquier 
            if(labe[(coor_y/40)][(coor_x/40)-1]!=1){
                coor_x-=l;
            }
        }if(e.getKeyCode()==39){//derecha  
            if(labe[(coor_y/40)][(coor_x/40)+1]!=1){
                coor_x+=l;
            }
        }if(e.getKeyCode()==40){//abajo
            if(labe[(coor_y/40)+1][(coor_x/40)]!=1){
                coor_y+=l;
            }
        }if(e.getKeyCode()==38){//arriba
            if(labe[(coor_y/40)-1][(coor_x/40)]!=1){
                coor_y-=l;
            }
        }
        LaberintoPrimitiivo();
    }
    protected void LaberintoPrimitiivo(){
        System.out.println("\n\n");
        for(int i=0; i<13; i++){
            for(int j=0; j<23; j++){
                if(i==coor_y/40 && j==coor_x/40){
                    System.out.print("x");
                }else{
                    System.out.print(labe[i][j]);
                }
            }
            System.out.println();
        }
    }
    public int getPosicion(){
        return labe[(coor_y/40)][(coor_x/40)];
    }
}
