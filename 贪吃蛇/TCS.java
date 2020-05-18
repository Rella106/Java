import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class TCS extends Frame
{
	int jj=30;//间距
	int hl=12;//行列
	int r=jj;//球
	int x=0;
	int y=0;
	int sd=1000;
	int a;
	byte fx=0;//方向

	MyTimer mt;
	DD dd[]=new DD[20];//{new DD(2,2),new DD(2,3),new DD(2,4)};
	DD dd2;
	byte cd=3;
	boolean zt=false;
	boolean over=false;
//	byte tempx=0;//记录暂停前的状态
	Timer t=new Timer();
	public static void main(String args[])
	{
		new TCS();
	}
	public int getXY()
	{
		
		return (int )Math.round(Math.random()*8);//产生随机DD2
		
	}
	public TCS()
	{
		for(int i=0;i<cd;i++)
		{
			dd[i]=new DD(2,2+i);
		}
		dd2=new DD(5,5);
		this.setTitle("贪吃蛇");
		this.setBounds(100,100,hl*jj+30,hl*jj+50);
		this.addWindowListener(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			}
			);
		this.addKeyListener(
			new KeyAdapter()
			{
				public void keyPressed(KeyEvent e)
				{
					if(mt==null)
					{
						mt=new MyTimer(TCS.this);
						t.schedule(mt,0,sd);
					}
					
					if(e.getKeyCode()==37)
					{
						if((fx==3)||(mt.tempfx==3))
						{
							return;
						}
						fx=1;
						
						zt=false;
					}
					else if(e.getKeyCode()==38)
					{
						if((fx==4)||(mt.tempfx==4))
						{
							return;
						}
						fx=2;
					
						zt=false;
					}
					else if(e.getKeyCode()==39)
					{
						if((fx==1)||(mt.tempfx==1))
						{
							return;
						}
						fx=3;
						
						zt=false;
					}
					else if(e.getKeyCode()==40)
					{
						if((fx==2)||(mt.tempfx==2))
						{
							return;
						}
						fx=4;
						
						zt=false;
					}
					else if(e.getKeyCode()==32)
					{
						
						zt=!zt;
					  /*if(tcs.zt)
	    	            {
							tempx=fx;
							fx=0;//暂停
						}else
						{
							fx=tempx;
						} */
						
					}
				}
			}
			);
		this.setVisible(true);
		
	}
	public void bs()
	{
		mt.cancel();
		mt=new MyTimer(TCS.this);
		t.schedule(mt,sd,sd=(int)(sd*0.7));
				//tcs.t=new Timer();
				//tcs.t.schedule(tcs.mt,0,sd=(int)(tcs.sd*0.5));
		    	
	}
	public boolean pz(DD dd1,DD dd2)
	{
		if((dd1.x==dd2.x)&&(dd1.y==dd2.y))
		{
			return true;
		}else{
			return false;
		}
	}
	public void update(Graphics g)
	{
		paint(g);
	}
	public void paint(Graphics g)
	{
		Image ii=this.createImage(hl*jj+30,hl*jj+50);
		Graphics gg=ii.getGraphics();
		paintBu(gg);
		g.drawImage(ii,0,0,null);
	} 
	public void paintBu(Graphics g)
	{
		for(int i=0;i<hl;i++)
		{
			g.drawLine(30,50+i*jj,30+(hl-1)*jj,50+i*jj);
			g.drawLine(30+i*jj,50,30+i*jj,50+(hl-1)*jj);
		}
		for(int i=0;i<cd;i++)
		{
			g.setColor(Color.pink);
			g.fillOval(30+jj*dd[i].x,50+jj*dd[i].y,r,r);
		}
		g.setColor(Color.yellow);
		g.fillOval(30+jj*dd2.x,50+jj*dd2.y,r,r);
		if(over)
		{
			g.setColor(Color.red);
			g.setFont(new Font("隶书",1,100));
			g.drawString("游戏结束",30,300);
		}
	}
    class MyTimer extends java.util.TimerTask
	{
		TCS tcs;
		byte tempfx;
		MyTimer(TCS tcs)
		{
			this.tcs=tcs;
		}
		public void run()
		{
			 
            if(tcs.zt)
            {
            	return;
            }	     
			if(tcs.fx==0)
			{
				return;
			}
			for(int i=tcs.cd-1;i>=1;i--)
			{
				tcs.dd[i].x=tcs.dd[i-1].x;
				tcs.dd[i].y=tcs.dd[i-1].y;
			}
			switch(tcs.fx)
			{
				case 1:if(tcs.dd[0].x<=0)
				       {
				       		tcs.over=true;
				       		tcs.mt.cancel();
				       		tcs.repaint();
				       		return;
				       }
				       
				       tempfx=1;
				       tcs.dd[0].x--;
						break;
				case 2:if(tcs.dd[0].y<=0)
					   {
				       		tcs.over=true;
				       		tcs.mt.cancel();
				       		tcs.repaint();
				       		return;
				       }
				       
				       tempfx=2;
				       tcs.dd[0].y--;
						break;
				case 3:if((tcs.dd[0].x)>=(tcs.hl-2))
				       {
				       		tcs.over=true;
				       		tcs.mt.cancel();
				       		tcs.repaint();
				       		return;
				       }
				       tempfx=3;
				       tcs.dd[0].x++;
						break;
				case 4:if((tcs.dd[0].y)>=(tcs.hl-2))
			           {
				       		tcs.over=true;
				       		tcs.mt.cancel();
				       		tcs.repaint();
				       		return;
				       }
				      tempfx=4;
				       tcs.dd[0].y++;
						break;
			}
			System.out.println("sd="+sd);
		/*	if((tcs.dd[0].x<0)||(tcs.dd[0].y<0))
			{
				tcs.over=true;
				tcs.mt.cancel();
				tcs.repaint();
				return;
			}
			if(((tcs.dd[0].x)>=(tcs.hl-1))||((tcs.dd[0].y)>=(tcs.hl-1)))
			{
				tcs.over=true;
				tcs.mt.cancel();
				tcs.repaint();
				return;
			}*/
			for(int i=0;i<tcs.cd;i++)
			{
				System.out.println("dd:"+tcs.dd[i].x+":"+tcs.dd[i].y);
			}
			if(tcs.pz(tcs.dd[0],tcs.dd2))
			{
				tcs.cd++;
				tcs.dd2.x=tcs.getXY();
				tcs.dd2.y=tcs.getXY();
				tcs.dd[tcs.cd-1]=new DD();
				tcs.dd[tcs.cd-1].x=tcs.dd[tcs.cd-2].x;
				tcs.dd[tcs.cd-1].y=tcs.dd[tcs.cd-2].y;
				tcs.bs();
				for(int i=0;i<tcs.cd;i++)
				{
					if(tcs.pz(tcs.dd[i],tcs.dd2))
					{
						tcs.dd2.x=tcs.getXY();
						tcs.dd2.y=tcs.getXY();
						i=0;
					}
				}
			}
			for(int i=4;i<tcs.cd;i++)
			{
				if(tcs.pz(tcs.dd[i],tcs.dd[0]))
				{
					tcs.over=true;
					tcs.mt.cancel();
					tcs.repaint();
					return;
				}
				
			}
			tcs.repaint();
			System.out.println("abc");
		}
		
	}

}
class DD
{
	int x;
	int y;
	DD(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	DD()
	{
	}
	
}