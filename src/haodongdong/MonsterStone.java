package haodongdong;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;


public class MonsterStone {
    public ImageIcon MonsterSt = new ImageIcon(this.getClass().getResource("monsterstone.png"));
    public ImageIcon Monsterat = new ImageIcon(this.getClass().getResource("monsterstoneat.png"));
    public int x = 400;
    public int y = 130;
    public int hp = 100;
    public int damage = 10;
    public boolean alive = true;
    public int count = 0;
    int distanceP;
    int hit;

    MonsterStone(){
        
    }
    public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,90,70));
	}
}
