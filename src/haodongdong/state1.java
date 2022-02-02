package haodongdong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.geom.Rectangle2D;// import

public class state1 extends JPanel implements ActionListener{
    private ImageIcon wallpaper = new ImageIcon(this.getClass().getResource("bg.png"));
    private ImageIcon stone = new ImageIcon(this.getClass().getResource("stone.png"));
    private ImageIcon stone2 = new ImageIcon(this.getClass().getResource("stone2.png"));
    private ImageIcon aa = new ImageIcon(this.getClass().getResource("aa.png"));
    private ImageIcon nextstagebutton = new ImageIcon(this.getClass().getResource("nextstage.png"));
    private ImageIcon againbutton = new ImageIcon(this.getClass().getResource("click to play again.png"));
    private ImageIcon closebutton = new ImageIcon(this.getClass().getResource("closebt.gif"));
    HaoChar haochar = new HaoChar(1);
    MonsterStone MS = new MonsterStone();
    lever lever = new lever(1);
    door door = new door(1);
    stair1 stair1 = new stair1(1);
    stair2 stair2 = new stair2(1);
    stair3 stair3 = new stair3(1);
    int checkbacktofront = 0;
    boolean hit = false;
    public int checkdoor = 0;
    public int checklever = 0;
    public int checknear = 0;
    public int times;
    public int checkattack;
    boolean timestart = true;
    boolean nextstage = false;
    //////////////////////////////////////////////////////////////////////////////
    public int xx = haochar.x;
    public int yy = haochar.y;
    public int hpp = haochar.hp;
    public int floors = haochar.floor;
    public boolean doors = haochar.door;
    /////////////////////////////////////////////////////////////////////////////////
    private Timer timer = new Timer(100, new Listener());
    private Timer timercount = new Timer(1000, new Listener());
    public JButton nextstagebt = new JButton(nextstagebutton);
    public JButton closebt = new JButton(closebutton);
    Thread time = new Thread(new Runnable(){
        public void run(){
            int check=0;
            while(true){
                try{
                    
                    if(Intersect(MS.getbound(),haochar.getbound())){
                        MS.count=1; 
                    }
                    else{
                        if(MS.alive == true){
                            if(MS.x==400){
                                check = 0;
                                MS.x+=5;
                            }
                            else if(MS.x==500){
                                check = 1; 
                                MS.x-=5;
                            }
                            else{
                                if(check==0){
                                  MS.x+=5;  
                                }
                                else{
                                    MS.x-=5;
                                }
                            }
                    }
                 }                   
                    Thread.sleep(100);
                    
                }catch(Exception e){
                 
                }
                
                if(timestart == false){
                    repaint();
                }
            }
        }
    });
    
    state1(){
        timer.start();
        time.start();
        timercount.start();
        this.setFocusable(true);
        this.setLayout(null);
        
        this.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                int a = e.getKeyCode();
                if(a==KeyEvent.VK_RIGHT){
                    checkbacktofront = 0;
                    if(checkbacktofront==0){
                        if(haochar.floor == 0){
                            if(haochar.x>=1100){
                                haochar.x = 1100;
                            }
                            else if(Intersect(stair1.getbound(),haochar.getbound())){   
                                if(haochar.y>=565){
                                    haochar.x+=10;
                                }
                            }
                             else if(Intersect(stair3.getbound(),haochar.getbound())){   
                                if(haochar.y>=565){
                                    haochar.x+=10;
                                }
                            }
                            else{
                                haochar.x+=10;
                                haochar.count++;
                            }
                        }
                        else if(haochar.floor == 1){
                            if(haochar.x>=290){
                                haochar.x = 290;
                            }
                            else if(Intersect(stair1.getbound(),haochar.getbound())){   
                                if(haochar.y<=355){
                                    haochar.x+=10;
                                }
                            }
                            else if(Intersect(stair2.getbound(),haochar.getbound())){
                                if(haochar.y>=355){
                                    haochar.x+=10;
                                }
                            }
                            else{
                                haochar.x+=10;
                                haochar.count++;
                            }
                        }
                        else if(haochar.floor == 3){
                            if(haochar.x>=580){
                                haochar.x = 580;
                            }                          
                            else if(Intersect(stair2.getbound(),haochar.getbound())){
                                if(haochar.y>=130){
                                    haochar.x+=10;
                                }
                            }
                            else{
                                haochar.x+=10;
                                haochar.count++;
                            }
                        }
                        else if(haochar.floor == 2){
                            if(haochar.x>=1100){
                                haochar.x = 1100;
                            }                          
                            else if(Intersect(stair3.getbound(),haochar.getbound())){
                                if(haochar.y<=310){
                                    haochar.x+=10;
                                }
                            }
                            else{
                                haochar.x+=10;
                                haochar.count++;
                            }
                        }
                    }
                    if(haochar.count >= 2){
                        haochar.count = 0;
                    }}
                else if(a==KeyEvent.VK_LEFT){
                    checkbacktofront = 1;
                    if(haochar.floor==0){
                        if(haochar.x <= 0){
                            haochar.x = 0;
                        }
                        else if(Intersect(stair1.getbound(),haochar.getbound())){
                            if(haochar.y >= 565){
                                haochar.x-=10;
                            }
                        }
                        else if(Intersect(stair3.getbound(),haochar.getbound())){
                            if(haochar.y >= 565){
                                haochar.x-=10;
                            }
                        }
                        else{
                            haochar.x-=10;
                            haochar.count++;
                        }
                    }
                    else if(haochar.floor==1){
                        if(haochar.x <= 0){
                            haochar.x = 0;
                        }
                        else if(Intersect(stair1.getbound(),haochar.getbound())){
                            if(haochar.y <= 355){
                                haochar.x-=10;
                            }
                        }
                        else if(Intersect(stair2.getbound(),haochar.getbound())){
                             if(haochar.y >= 355){
                                haochar.x-=10;
                            }
                        }
                        else{
                            haochar.x-=10;
                            haochar.count++;
                        }
                    }
                    else if(haochar.floor==3){
                        if(haochar.x <= 0){
                            haochar.x = 0;
                        }
                        else if(Intersect(stair2.getbound(),haochar.getbound())){
                             if(haochar.y <= 130){
                                haochar.x-=10;
                            }
                        }
                        else{
                            haochar.x-=10;
                            haochar.count++;
                        }
                    }
                    else if(haochar.floor==2){
                        if(haochar.x <= 850){
                            haochar.x = 850;
                        }
                        else if(Intersect(stair3.getbound(),haochar.getbound())){
                             if(haochar.y <= 310){
                                haochar.x-=10;
                            }
                        }
                        else{
                            haochar.x-=10;
                            haochar.count++;
                        }
                    }
                    if(haochar.count >= 2){
                        haochar.count = 0;
                    }  
                }
                else if(a == KeyEvent.VK_SPACE){
                    if(checkattack == 0){
                        checkattack = 1;
                    }
                    if(Intersect(MS.getbound(),haochar.getbound())){
                        if(MS.hp==0){
                            MS.hp=0;
                        }
                        MS.hp-=haochar.damage;
                    }
                }
                else if(a == KeyEvent.VK_F){
                    
                    if(Intersect(lever.getbound(),haochar.getbound())){
                        checklever = 1;
                        checkdoor = 1;
                    }
                    if(Intersect(door.getbound(),haochar.getbound())){
                        if(checkdoor == 1){
                            nextstage = true;
                        }
                        else nextstage = false;
                        
                    }
                    else nextstage = false;
                }

                else if(a==KeyEvent.VK_UP){
                    if(haochar.floor==0){
                        if(Intersect(stair1.getbound(),haochar.getbound())){
                            if(haochar.y<=355){
                                haochar.y=355;
                                haochar.floor=1;
                            }
                            else{
                                haochar.y-=10;
                            }
                        }
                        else if(Intersect(stair3.getbound(),haochar.getbound())){
                            if(haochar.y<=315){
                                haochar.y=310;
                                haochar.floor=2;
                            }
                            else{
                                haochar.y-=10;
                            }
                        }
                    }
                    else if(haochar.floor==1){
                        if(Intersect(stair2.getbound(),haochar.getbound())){
                            if(haochar.y<=135){
                                haochar.y = 130;
                                haochar.floor=3;
                            }
                            else{
                                haochar.y-=10;
                            }
                        }
                    }
                }
                else if(a==KeyEvent.VK_DOWN){
                    if(haochar.floor==1){
                        if(Intersect(stair1.getbound(),haochar.getbound())){
                            if(haochar.y>=565){
                                haochar.y=565;
                                haochar.floor=0;
                            }
                            else{
                                haochar.y+=10;
                            }
                        }
                    }
                    else if(haochar.floor==3){
                        if(Intersect(stair2.getbound(),haochar.getbound())){
                            if(haochar.y>=355){
                                haochar.y=355;
                                haochar.floor=1;
                            }
                            else{
                                haochar.y+=10;
                            }
                        }
                    }
                    else if(haochar.floor==2){
                        if(Intersect(stair3.getbound(),haochar.getbound())){
                            if(haochar.y>=565){
                                haochar.y=565;
                                haochar.floor=0;
                            }
                            else{
                                haochar.y+=10;
                            }
                        }
                    }
                }      
            }
            public void keyReleased(KeyEvent e){
                haochar.count=0;
            }
        });
    }
    
    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == timercount){
                times--;
            }
            
            repaint();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {       
        repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(wallpaper.getImage(), 0, 0, 1200, 665, this);
        g.drawImage(stone.getImage(), 0, 425, 350, 45, this);
        g.drawImage(stone.getImage(), 850, 380, 350, 45, this);
        g.drawImage(stone2.getImage(), 0, 200, 700, 45, this);
        g.drawImage(stair1.stair.getImage(), stair1.x, stair1.y, 40, 215, this);
        g.drawImage(stair2.stair.getImage(), stair2.x, stair2.y, 40, 240, this);
        g.drawImage(stair3.stair.getImage(), stair3.x, stair3.y, 40, 260, this);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Fixedsys Regular",Font.HANGING_BASELINE,30));
        g.drawString("Score : "+ haochar.score,900, 60);
         
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE, 20));
    
        
        if(checklever==1){
            g.drawImage(lever.leverb.getImage(), lever.x, lever.y, 40, 45, this);
            g.drawImage(door.dooropen.getImage(), door.x+2, door.y, 82, 80, this);
        }
        else if(checklever==0){
            g.drawImage(lever.lever.getImage(), lever.x, lever.y, 40, 45, this);           
            g.drawImage(door.doorclose.getImage(), door.x, door.y, 86, 80, this);
        }
        
        
        if(checkbacktofront==0){           
            if(haochar.count==0){
                if(checkattack == 1){
                    g.drawImage(haochar.atkf.getImage(), haochar.x+16, haochar.y, 90, 70, this);
                    g.drawString("HP : "+haochar.hp, haochar.x, haochar.y-15);
                    checkattack = 0;
                   
                        if(MS.hp==0){
                            MS.alive = false;
                            haochar.score+=100;
                            if(haochar.score==100){
                                haochar.score=100;
                            }
                        }
                }
                else {
                    g.drawImage(haochar.im.getImage(), haochar.x, haochar.y, 65, 70, this);
                    g.drawString("HP : "+haochar.hp, haochar.x, haochar.y-15);
                }            
            }
            else {
                g.drawImage(haochar.imk.getImage(), haochar.x, haochar.y, 65, 70, this);
                g.drawString("HP : "+haochar.hp, haochar.x, haochar.y-15);
            }
            
        }
        else if(checkbacktofront==1){
            if(haochar.count==0){
                if(checkattack == 1){
                    g.drawImage(haochar.atkb.getImage(), haochar.x-41, haochar.y, 90, 70, this);
                    g.drawString("HP : "+haochar.hp, haochar.x, haochar.y-15);
                    checkattack = 0;
                        if(MS.hp==0){
                            MS.alive = false; 
                            haochar.score+=100;
                            if(haochar.score==100){
                                haochar.score=100;
                            }
                        }        
                }
                else {
                    g.drawImage(haochar.imb.getImage(), haochar.x, haochar.y, 65, 70, this);
                    g.drawString("HP : "+haochar.hp, haochar.x, haochar.y-15);
                }         
            }
            else{
                g.drawImage(haochar.imbk.getImage(), haochar.x, haochar.y, 65, 70, this);
                g.drawString("HP : "+haochar.hp, haochar.x, haochar.y-15);
            }
        }
        else if(checkbacktofront==2){
            g.drawImage(haochar.imb.getImage(), haochar.x, haochar.y, 65, 70, this);
            g.drawString("HP : "+haochar.hp, haochar.x, haochar.y-15);
        }
        if(MS.count == 1){ 
            if(MS.alive == true){
               g.drawImage(MS.Monsterat.getImage(), MS.x, MS.y, 75, 70, this); 
               g.drawString("HPM : "+MS.hp, MS.x-10, MS.y-15);
               MS.count = 0;
               hit = true;
            }           
        }
        else {
            if(MS.alive == true){
                g.drawImage(MS.MonsterSt.getImage(), MS.x, MS.y, 75, 70, this);
                g.drawString("HPM : "+MS.hp, MS.x-10, MS.y-15);
            }
            
            
        }
        if(hit==true){
            haochar.hp-=MS.damage;
            hit=false;
        }
        
        if(haochar.hp <= 0){
            this.setLayout(null);
            g.setColor(Color.RED);
            g.drawImage(wallpaper.getImage(), 0, 0, 1200, 800, this);   
            g.setFont(new Font("Fixedsys Regular",Font.HANGING_BASELINE,100));
            g.drawString("You Died!",350, 150);
            setLayout(null);
            closebt.setBounds(450, 570, 200, 40);
            closebt.setBorderPainted(false);
            closebt.setBorder(null);
            closebt.setOpaque(false);
            closebt.setContentAreaFilled(false);
            add(closebt);
            timer.stop();
            timercount.stop();
        }
        if(nextstage == true){
            this.setLayout(null);
            g.setColor(Color.YELLOW);
            g.drawImage(wallpaper.getImage(), 0, 0, 1200, 800, this);
            g.setFont(new Font("Fixedsys Regular",Font.HANGING_BASELINE,70));
            g.drawString("Success!",400, 150);
            haochar.x = xx;
            haochar.y = yy;
            haochar.hp = hpp;
            haochar.floor = floors;
            haochar.door = doors;
            setLayout(null);
            nextstagebt.setBounds(375, 400, 352, 68);
            nextstagebt.setBorderPainted(false);
            nextstagebt.setBorder(null);
            nextstagebt.setOpaque(false);
            nextstagebt.setContentAreaFilled(false);
            add(nextstagebt);
            
            timer.stop();
            timercount.stop();
        }
        
    } //drawscreen  
    public boolean Intersect(Rectangle2D a, Rectangle2D b){
	return (a.intersects(b));
    }
}