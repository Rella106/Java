import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BreakBricks extends JFrame{
	Image ii; //双缓冲
	boolean ExecutionProcess=true; //while循环条件
	boolean DirectionControl = true;//方向控制
	boolean SleepControl = true;//睡眠控制
	int map[][]=new int[600][400];//全图标志位
	int stone[][]=new int[5][9];
	MyRepaint mrp = new MyRepaint(this);//重新绘制主类PaintBuffer方法的线程的对象
	MyPath mp = new MyPath(this);//计算路径线程对象
	MyBoardMove mbm = new MyBoardMove(this);//模板移动线程对象
	int boardx=160;//板子初始坐标
	int ballx=190,bally=520;//小球初始坐标
	
	public BreakBricks() {
		this.setBounds(500,200,400,600);
		for(int i=0;i<400;i++) {  //顶部标志位设定
			for(int j=28;j<48;j++) {
				map[j][i]=1;
			}
		}
		for(int i=382;i<392;i++) {  //右墙标志位设定
			for(int j=48;j<600;j++) {
				map[j][i]=1;
			}
		}
		for(int i=8;i<18;i++) {  //左墙标志位设定
			for(int j=48;j<600;j++) {
				map[j][i]=1;
			}
		}
		for(int i=0;i<5;i++)   //石块标志位初定义
		{
			for(int j=0;j<9;j++)
			{
				stone[i][j]=2;
			}
		}
		this.addKeyListener(
				new KeyListener() {
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode()==37) {//按左
							DirectionControl=true;
							SleepControl = false;
						}
						else if(e.getKeyCode()==39) {//按右
							DirectionControl=false;
							SleepControl = false;
						}else if(e.getKeyCode()==KeyEvent.VK_SPACE){
							mbm.start();
							mp.start();
							mrp.start();
						}
					}
					@Override
					public void keyReleased(KeyEvent e) {
						if(e.getKeyCode()==37) {//松左
							SleepControl = true;
						}
						else if(e.getKeyCode()==39) {//送右
							SleepControl = true;
						}
					}
					@Override
					public void keyTyped(KeyEvent e) {
					}
				}
				);
		this.setLayout(null);
		this.setVisible(true);
	}
	public static void main(String args[])
	{
		new BreakBricks();
	}
	
	@Override
	public void update(Graphics g) {
	    paint(g);
	}
	
	@Override
	public void paint(Graphics g) {
		ii = this.createImage(400,600);
		Graphics gg = ii.getGraphics();
		paintBuffer(gg);
		g.drawImage(ii,0,0,this);
	}
	public void paintBuffer(Graphics g) {
		Graphics2D g2d=(Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.black);
		g.fillRect(0,38,400,10);
		g.fillRect(8,48,10,550);
		g.fillRect(382,48,10,550);
		g.fillRect(boardx,550,80,10);
		g.fillOval(ballx, bally, 20, 20);
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<9;j++)
			{
				if(stone[i][j]==2) {
					g.fillRect(20+j*40,50+i*40,35,35);
					for(int m=20+j*40;m<60+j*40;m++) {
						for(int n=50+i*40;n<90+i*40;n++) {
							map[n][m]=2;
						}
					}
				}
				else {
					for(int m=20+j*40;m<60+j*40;m++) {
						for(int n=50+i*40;n<90+i*40;n++) {
							map[n][m]=0;
						}
					}
				}
			}
		}
	}
}
class MyRepaint extends Thread  //执行重新绘制主类PaintBuffer方法的线程
{
	BreakBricks bb;
	MyRepaint(BreakBricks bb){
		this.bb=bb;
	}
	
	@Override
	public void run() {
		while(bb.ExecutionProcess) {
			bb.repaint();
			try{Thread.sleep(10);}catch(Exception e) {e.printStackTrace();}
			if(bb.bally>570)     //如果掉落，new新的Dialog
			{
				bb.ExecutionProcess=false;
				new GameOver(bb);
			}
		}		
	}
}
class MyPath extends Thread  //计算小球路径的线程
{	
	BreakBricks bb;
	boolean direction=true;//控制小球方向
	double slope=Math.tan(Math.toRadians(Math.random()*20+45));//斜率
	double interecpty =520,interecptx=190;//截距
	MyPath(BreakBricks bb){
		this.bb=bb;
	}
	
	@Override
	public void run() {
		while(bb.ExecutionProcess) {
						
			if(bb.map[bb.bally+10][bb.ballx+20]!=0||     //左右墙壁检测
					bb.map[bb.bally+10][bb.ballx]!=0)
			{
				interecpty=bb.bally;
				interecptx=bb.ballx;
				slope=-slope;	
				direction=!direction;
			}else
				if(bb.map[bb.bally][bb.ballx+10]!=0||        //上下墙壁检测
					bb.map[bb.bally+20][bb.ballx+10]!=0)			
					{
				interecpty=bb.bally;
				interecptx=bb.ballx;
				slope=-slope;
			}
			
			if(bb.map[bb.bally+10][bb.ballx+20]==2){       //石块检测  右
				bb.stone[(bb.bally-50)/40][(bb.ballx)/40]=0;
			}else if(bb.map[bb.bally+10][bb.ballx]==2) {   //左
				bb.stone[(bb.bally-50)/40][(bb.ballx-20)/40]=0;
			}else if(bb.map[bb.bally][bb.ballx+10]==2) { //上
				bb.stone[(bb.bally-50)/40][(bb.ballx-20)/40]=0;
			}else if(bb.map[bb.bally+20][bb.ballx+10]==2) {//下
				bb.stone[(bb.bally-30)/40][(bb.ballx-20)/40]=0;
			}
			
			if(direction)   //向左移动
			{
				bb.ballx++;
			}
			else           //向右移动
				bb.ballx--;
		    bb.bally=(int)(slope*(bb.ballx-interecptx)+interecpty);
		    try{Thread.sleep(10);}catch(Exception e) {e.printStackTrace();}
		}	
	}
}
class MyBoardMove extends Thread //控制下端板子移动
{
	BreakBricks bb;//BreakBricks类引用
	public MyBoardMove(BreakBricks bb) {
		this.bb=bb;
	}
	
	@Override
	public void run() {
		while(bb.ExecutionProcess) {
			if(!bb.SleepControl) {	//板子坐标计算			
				if(bb.DirectionControl) {
					bb.boardx-=2;
					if(bb.boardx<20) {
						bb.boardx=20;
					}
				}else {
					bb.boardx+=2;
					if(bb.boardx>300) {
						bb.boardx=300;
					}
				}				
			}
			for(int i=550;i<560;i++)//板子标识位设定
			{
				for(int j=20;j<380;j++) {
					bb.map[i][j]=0;
				}
			}
			for(int i=550;i<560;i++)
			{
				for(int j=bb.boardx;j<bb.boardx+80;j++) {
					bb.map[i][j]=1;
				}
			}
			try{Thread.sleep(5);}catch(Exception e) {e.printStackTrace();}
		}
	}
}
class GameOver extends java.awt.Dialog{   //游戏结束
	Label l = new Label("  游戏结束");
	GameOver(BreakBricks bb){
		super(bb,"",true);
		this.setBounds(500,200,280,300);
		this.add(l);
		l.setFont(new Font("",1,50));
		this.addWindowListener(
				new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
		this.setAlwaysOnTop(true);
		this.setVisible(true);
	}
}