import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class WuZiQi extends Frame
implements ActionListener
{
	int hl=12;
	int sj[][]=new int[hl+1][hl+1];
	boolean who=true;//黑1白2
	int x=2;
	int y=2;
	int d=35;
	int jsq=0;
	String msg="游戏结束";
	boolean over=false;
	MenuBar mb=new MenuBar();
	Menu myx=new Menu("游戏");
	Menu mbz=new Menu("帮助");
	MenuItem mikj=new MenuItem("开局");
	MenuItem mihq=new MenuItem("悔棋");
	MenuItem mitc=new MenuItem("退出");
	MenuItem migy=new MenuItem("关于");
	Timer t;
	MyT mt;
	int jj=40;
	public WuZiQi()
	{
		
		this.setTitle("我的五子棋，请黑方落子");
		
		this.setMenuBar(mb);
		mb.add(myx);
		mb.add(mbz);
		myx.add(mikj);
		myx.add(mihq);
		myx.addSeparator();
		myx.add(mitc);
		mbz.add(migy);
		mihq.setEnabled(false);
		mikj.setEnabled(false);
	    mikj.addActionListener(this);
	    mihq.addActionListener(this);
	    mitc.addActionListener(this);
	    migy.addActionListener(this);
	    for(int i=4;i<8;i++)
	    {
	    	sj[i][3]=1;
	    }
	    this.addWindowListener(
	    	new WindowAdapter()
	    	{
	    		public void windowClosing(WindowEvent e)
	    		{
	    			System.exit(0);
	    		}
	    	}
	    	);
		this.setBackground(new Color(242,191,64));
		this.setBounds(100,100,hl*jj+60,hl*jj+100);
		this.addMouseListener(
			new MouseAdapter()
			{
				public void mousePressed(MouseEvent e)
				{
					if(over)
					{
						return;
					}
					System.out.println((e.getX()-(30-jj/2)/jj)+":"+(e.getY()-(70-jj/2)/jj));
					int a=(e.getX()-(30-jj/2))/jj;
					int b=(e.getY()-(70-jj/2))/jj;
					
					if(a>=hl||b>=hl||sj[a][b]!=0)
					{
						return;
					}
					if(who)
					{
						sj[a][b]=1;
					}else
					{
						sj[a][b]=2;
					}
					
					WuZiQi.this.x=a;
					WuZiQi.this.y=b;
					pd();
					who=!who;
					WuZiQi.this.mihq.setEnabled(true);
					WuZiQi.this.mikj.setEnabled(true);
					WuZiQi.this.repaint();
				}
			} 
			);
		this.setResizable(true);
		this.setVisible(true);
		
	}
	public void pd()
	{
		int xq=x-4;
		int xz=x+4;
		if(xq<0)
		{
			xq=0;
		}
		if(xz>hl)
		{
			xz=hl;
		}
		int yq=y-4;
		int yz=y+4;
		if(yq<0)
		{
			yq=0;
		}
		if(yz>=hl)
		{
			yz=hl;
		}
		pdh(xq,xz);
		jsq=0;
		pds(yq,yz);
		jsq=0;
		pdfx(xq,xz);
		jsq=0;
		pdzx(xq,xz);
	}
	public void pdzx(int xq,int xz)
	{
		for(int i=xq;i<=xz;i++)
		{
			if(i+y-x<0)
			{
				continue;
			}
			if(i+y-x>hl)
			{
				break;
			}
			if(sj[i][i+y-x]==sj[x][y])
			{
				jsq++;
				isOver();
			}else{
				jsq=0;
			}
			System.out.println("fxjsq="+jsq);
			
		}
	}
	public void pdfx(int xq,int xz)
	{
		for(int i=xq;i<=xz;i++)
		{
			if(x+y-i>hl)
			{
				continue;
			}
			if(x+y-i<0)
			{
				break;
			}
			if(sj[i][x+y-i]==sj[x][y])
			{
				jsq++;
				isOver();
			}else
			{
				jsq=0;
			}
			System.out.println("fxjsp="+jsq);
		}	
	}
	public void pds(int yq,int yz)
	{
		for(int i=yq;i<=yz;i++)
		{
			if(sj[x][i]==sj[x][y])
			{
				jsq++;
				isOver();
				
			}else
			{
				jsq=0;
			}
		}
	}
	public void pdh(int xq,int xz)
	{
	
		for(int i=xq;i<=xz;i++)
		{
			if(sj[i][y]==sj[x][y])
			{
				jsq++;
				isOver();
				
			}else
			{
				jsq=0;
			}
		}
	}
	public void isOver()
	{
		if(jsq>=5)
		{
			over=true;
			
		
		if(t==null)
		{
			t=new Timer();
		}
		if(mt==null)
		{
			mt=new MyT(this);
		}
		t.schedule(mt,0,1000);
		this.repaint();
	    }
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==mitc)
		{
			System.exit(0);
		}else if(e.getSource()==mikj)
		{
			who=true;
			over=false;
			if(t!=null)
			{
				t.cancel();
				t=null;
				mt=null;
			}
			sj=new int[hl+1][hl+1];
			
		}else if(e.getSource()==mihq)
		{
			sj[x][y]=0;
			who=!who;
			mihq.setEnabled(false);
			System.out.println(x+"hq:"+y);
		}else if(e.getSource()==migy)
		{
			new MyD(this);
		}
		this.repaint();
	}
	public static void main(String args[])
   {
   	    new WuZiQi();
   	    //java.util.Timer t=new java.util.Timer();
   	    //MyT my=new MyT();
   	    //t.schedule(my,10000,1000);
   }
   public void paint(Graphics g)
   {
   	if(who)
   	{
   		this.setTitle("我的五子棋，请黑方落子");
   	}else
   	{
   		this.setTitle("我的五子棋，请白方落子");
   	}
   
   	g.drawRect(10,50,hl*jj+40,hl*jj+40);
   	for(int i=0;i<=hl;i++)
   	{
   		g.drawLine(30,70+i*jj,30+hl*jj,70+i*jj);
   		g.drawLine(30+i*jj,70,30+i*jj,70+hl*jj);
   	}
   	//g.fillOval(30+x*jj-20,70+y*jj-20,d,d);
  	for(int i=0;i<sj.length;i++)
   	{
   	aa:	for(int j=0;j<sj[i].length;j++)
   		{
   			switch(sj[i][j])
   			{
   				case 0:continue aa;
   				case 1:g.setColor(Color.black);break;
   				case 2:g.setColor(Color.white);break;
   			}
   			g.fillOval(30+i*jj-d/2,70+j*jj-d/2,d,d);
   		}
   	}
   	if(over)
   	{
   		mihq.setEnabled(false);
   		g.setColor(Color.black);
   		g.setFont(new Font("隶书",1,115));
   		g.drawString(msg,30,300);
   		g.setColor(Color.red);
   		g.setFont(new Font("隶书",1,115));
   		g.drawString(msg,30-5,300-5);
   	
   	}
   }
}
class MyD extends java.awt.Dialog
{
	Image ii=new javax.swing.ImageIcon("about.jpg").getImage();
	Button bok=new Button("确定");
	MyD(WuZiQi wzq)
	{
		super(wzq,"关于我的五子棋",true);
		this.setLayout(null);
		this.addWindowFocusListener(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					MyD.this.dispose();
				}
			}
			);                  
	    this.add(bok);
	    bok.setBounds(260,260,60,20);
	    bok.addActionListener(
	    	new ActionListener()
	    	{
	    		public void actionPerformed(ActionEvent e)
	    		{
	    			MyD.this.dispose();
	    		}
	    	}
	    	);
		this.setBounds(100,100,400,300);
		this.setVisible(true);
	}
	public void paint(Graphics g)
	{
		g.drawImage(ii,0,15,this);
	}
}
class MyT extends java.util.TimerTask
{
	WuZiQi wzq;
	boolean b=true;
	MyT(WuZiQi wzq)
	{
		this.wzq=wzq;
	}
	public void run()
	{
	    if(b)
	    {
	    	wzq.msg="";
	    }else {
	    	wzq.msg="游戏结束";
	    }
	    b=!b;
	    wzq.repaint();
	    System.out.println("aa");
	}
}