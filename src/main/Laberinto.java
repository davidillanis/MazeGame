package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Laberinto{
    private Niveles nivel=new Niveles();
    Juego juego;
    
    public Laberinto(Juego juego){
        this.juego=juego;
    }
    protected int [][]laberi=nivel.Nivel(Niveles.nivel);
    public void paint(Graphics g){
        int fila, colunma, n_fila, n_colunma, l;
        
        n_fila=13; n_colunma=23;  l=Juego.lado;
        ImageIcon pared=new ImageIcon("src/main/muro.png");
        ImageIcon camino=new ImageIcon("src/main/camino.png");
        pared=new ImageIcon(pared.getImage().getScaledInstance(l, l, Image.SCALE_SMOOTH));
        camino=new ImageIcon(camino.getImage().getScaledInstance(l, l, Image.SCALE_SMOOTH));
        
        for(fila=0; fila<n_fila; fila++){
            for(colunma=0; colunma<n_colunma; colunma++){
                if(laberi[fila][colunma]==0){
                    g.drawImage(camino.getImage(), colunma*l, fila*l, null);
                }if(laberi[fila][colunma]==1){
                    g.drawImage(pared.getImage(), colunma*l, fila*l, null);
                    g.setColor(Color.LIGHT_GRAY);
                    g.drawRect(colunma*l, fila*l, l, l);
                }if(laberi[fila][colunma]==2){
                    g.setColor(Color.GREEN);
                    g.fillRect(colunma*l, fila*l+1, l-1, l-1);
                    g.setColor(Color.MAGENTA);
                    g.setFont(new Font("Bell MT",1,20));
                    g.drawString("FIN", colunma*l, fila*l+25);
                }
            }
        }
    }
}
