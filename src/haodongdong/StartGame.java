package haodongdong;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class StartGame extends JPanel {
    private ImageIcon wallpaper = new ImageIcon(this.getClass().getResource("bg.png"));
    private ImageIcon starts = new ImageIcon(this.getClass().getResource("start.png"));
    private ImageIcon namegame = new ImageIcon(this.getClass().getResource("1.png"));
    private ImageIcon character = new ImageIcon(this.getClass().getResource("character1.png"));
    public JButton StartGame = new JButton(starts);
    StartGame(){
        setLayout(null);
        StartGame.setBounds(430, 325, 300, 100);
        StartGame.setBorderPainted(false);
        StartGame.setBorder(null);
        StartGame.setOpaque(false);
        StartGame.setContentAreaFilled(false);
        add(StartGame);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(wallpaper.getImage(), 0, 0, 1200, 665, this);
        g.drawImage(namegame.getImage(), 160, 0, 800, 700, this);
        g.drawImage(character.getImage(), -50, 435, 350, 300, this);
        /*g.drawImage(imageunder.getImage(), 0, -30, 1200, 710, this);
        g.drawImage(imagelogo.getImage(), 0, 0, 1200, 665, this);*/
    }
}
