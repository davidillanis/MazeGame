package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Juego extends JPanel implements KeyListener{
    public static int x=10, y=40, lado=40;
    private Personaje perso=new Personaje(this);
    private Laberinto laber=new Laberinto(this);
    private Sonidos sonid=new Sonidos();
    private JFrame ventana;
    
    public Juego(){
        ventana=new JFrame();
        ventana.add(Juego.this);
        ventana.setSize(940,570);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setTitle("Juego del laberinto: Nivel-"+Niveles.nivel);
        ventana.setIconImage(new ImageIcon("src/main/personaje.png").getImage());
        ventana.addKeyListener(Juego.this);
        this.setBackground(new Color(190,255,200));
        sonid.IniciarSonido((int)(Math.random()*9+2));
        //System.setProperty("sun.awt.noerasebackground", "true");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override public void keyTyped(KeyEvent e){} @Override public void keyReleased(KeyEvent e){}
    @Override public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==37||e.getKeyCode()==38||e.getKeyCode()==39||e.getKeyCode()==40){
            perso.MovPersonaje(e);
            sonid.IniciarSonido(1);
            repaint();
            if(perso.getPosicion()==2){
                SiguienteNivel();
            }
        }
    }
    @Override public void paint(Graphics g){
        super.paint(g);
        laber.paint(g);
        perso.paint(g);
    }
   
    private void SiguienteNivel(){
        JOptionPane.showMessageDialog(null, "Ganaste");
        Niveles.nivel++;
        if(Niveles.nivel>5){
            Niveles.nivel=1;
        }
        ventana.setTitle("Juego del laberinto: Nivel-"+Niveles.nivel);
        perso.coor_x=40;
        perso.coor_y=40;
        laber.laberi=new Niveles().Nivel(Niveles.nivel);
        perso.labe=laber.laberi;
        repaint();
        if(!sonid.IsActive()){
            sonid.IniciarSonido((int)(Math.random()*9+2));
        }
    }
    
    public static void main(String[] args) {
        Juego game=new Juego();
        game.setVisible(true);
    }
}
