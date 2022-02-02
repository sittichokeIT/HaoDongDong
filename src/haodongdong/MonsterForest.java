package haodongdong;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
public class MonsterForest {
    public ImageIcon MonsterW = new ImageIcon(this.getClass().getResource("monsterwood.png"));
    public int x,y;
    public int count=0;
    public int hp = 180;
    public int damage = 10;
    public boolean alive = true;
    MonsterForest(int m){
        if(m==1){
            x=700;
            y=55;
        }
        else if(m==2){           
            x=220;
            y=245;
        }
    }
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,90,70));
    }
}
