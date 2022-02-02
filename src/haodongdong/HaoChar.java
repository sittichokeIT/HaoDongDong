package haodongdong;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
public class HaoChar {
    public ImageIcon im = new ImageIcon(this.getClass().getResource("haochar.png"));
    public ImageIcon imk = new ImageIcon(this.getClass().getResource("haocharkao.png"));
    public ImageIcon imb = new ImageIcon(this.getClass().getResource("haocharback.png"));
    public ImageIcon imbk = new ImageIcon(this.getClass().getResource("haocharbackkao.png"));
    public ImageIcon atkf = new ImageIcon(this.getClass().getResource("atkf.png"));
    public ImageIcon atkb = new ImageIcon(this.getClass().getResource("atkb.png"));
    public int x = 5;
    public int y = 565;
    public int hp = 300;
    public int damage = 20;
    public int count = 0;
    public int floor = 0;
    public int score = 0;
    public boolean door = false;
    int distanceP;
    int hit;
    
    HaoChar(int m){
        if(m==1){
            x=5;
            y=565;
        }
        else if(m==2){
            x=5;
            y=475;
        }
        else if(m==3){
            x=5;
            y=315;
        }
    }
     public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,75,70));
	}
}
