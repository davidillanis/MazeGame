package main;
/*AudioClip s=java.applet.Applet.newAudioClip(getClass().getResource("/main/bailando.wav"));
s.play();//localizacion de la ventana*/
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sonidos extends JFrame implements ActionListener{
    private JButton boton_iniciar, boton_parar;
    private String sonido;
    private Clip clip;
    
    public void IniciarSonido(int i){
        switch (i) {
            case 1:sonido="/musica/mover.wav";break;
            case 2:sonido="/musica/fondo1.wav";break;
            case 3:sonido="/musica/fondo2.wav";break;
            case 4:sonido="/musica/fondo3.wav";break;
            case 5:sonido="/musica/fondo4.wav";break;
            case 6:sonido="/musica/fondo5.wav";break;
            case 7:sonido="/musica/fondo6.wav";break;
            case 8:sonido="/musica/fondo7.wav";break;
            case 9:sonido="/musica/fondo8.wav";break;
            case 10:sonido="/musica/fondo9.wav";break;
            case 11:sonido="/musica/fondo10.wav";break;
            default:System.out.println("Sonido no encontrado");;
        }
        try {
            if(clip==null || !clip.isActive()){
                clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(sonido)));
                clip.start();
            }
        }catch(Exception e){System.out.println("Error en el sonido " + e);}
    }
    public void PararSonido(){
        clip.stop();
    }
    protected boolean IsActive(){
        return clip.isActive();
    }
    private void Interfas(){
        this.setSize(500,400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel panel=new JPanel();
        this.getContentPane().add(panel);
        panel.setLayout(null);
        
        boton_iniciar=new JButton("iniciar");
        boton_iniciar.setBounds((getSize().width-100)/2,50,100,30);
        boton_iniciar.addActionListener(this);
        panel.add(boton_iniciar);
        
        boton_parar=new JButton("parar");
        boton_parar.setBounds((getSize().width-100)/2,100,100,30);
        boton_parar.addActionListener(this);
        panel.add(boton_parar);
    }
    @Override public void actionPerformed(ActionEvent e){
        int n=(int)(Math.random()*9+2);
        System.out.println(n);
        if(e.getSource()==boton_iniciar){IniciarSonido(n);}
        if(e.getSource()==boton_parar){PararSonido();}
    }
//    public static void main(String[] args){
//        Sonidos sn=new Sonidos();
//        sn.Interfas();
//    }
}
