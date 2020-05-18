import java.awt.*;
import java.awt.event.*;
public class GJXQ extends Frame
{
	Image ii[]=new Image[12];
	int sj[][]={{4,5,3,1,2,3,5,4},
	{0,0,0,0,0,0,0,0},
	{-1,-1,-1,-1,-1,-1,-1,-1},
		{-1,-1,-1,-1,-1,-1,-1,-1},
		{-1,-1,-1,-1,-1,-1,-1,-1},
		{-1,-1,-1,-1,-1,-1,-1,-1},
		{6,6,6,6,6,6,6,6},
		{10,11,9,7,8,9,11,10}
	
	};
	boolean who=true;//黑
	boolean xz=false;
	boolean over=false;
	int ihq=-1;
	int tempx=-1;
	int tempy=-1;
	int mx=2;
	int my=3;
	int xzx=2;
	int xzy=4;
	boolean hq=false;
	public GJXQ()
	{
		this.setTitle("我的国际象棋，请黑方落子！");
		ii[0]=new javax.swing.ImageIcon("img\\b0.png").getImage();
		ii[1]=new javax.swing.ImageIcon("img\\b1.png").getImage();
		ii[2]=new javax.swing.ImageIcon("img\\b2.png").getImage();
		ii[3]=new javax.swing.ImageIcon("img\\b3.png").getImage();
		ii[4]=new javax.swing.ImageIcon("img\\b4.png").getImage();
		ii[5]=new javax.swing.ImageIcon("img\\b5.png").getImage();
		ii[6]=new javax.swing.ImageIcon("img\\w0.png").getImage();
		ii[7]=new javax.swing.ImageIcon("img\\w1.png").getImage();
		ii[8]=new javax.swing.ImageIcon("img\\w2.png").getImage();
		ii[9]=new javax.swing.ImageIcon("img\\w3.png").getImage();
		ii[10]=new javax.swing.ImageIcon("img\\w4.png").getImage();
		ii[11]=new javax.swing.ImageIcon("img\\w5.png").getImage();
	    this.addWindowListener(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			}
			
			);
		this.addMouseListener(
			new MouseAdapter()
			{
				public void mousePressed(MouseEvent e)
				{
					int i=(e.getX()-8)/80;
					int j=(e.getY()-23)/80;
					if(i<0||i>7)
					{
						return;
					}
					if(j<0||j>7)
					{
						return;
					}
					System.out.println(i+":"+j);

					
					if(xz)
					{
						if(!rule()){
						   xz=false;
						   return;	
						}
						hq=true;tempx=mx;tempy=my;
						ihq=sj[my][mx];
						if(sj[my][mx]==1||sj[my][mx]==7)
						{
							over=true;
						}
						sj[j][i]=sj[xzy][xzx];
						sj[xzy][xzx]=-1;
						xz=false;
						who=!who;
					
						
					}else
					{
						 if(sj[j][i]==-1)
			     	     {
			     		     return;
				         }
				          if(who&&sj[j][i]>5)
				          {
				           	return;
				          }
				         if(!who&&sj[j][i]<6)
				         {
				    	   return;
				         }
				        xzx=i;
				       	xzy=j;
				       	xz=true;
					}
					repaint();
				}
			}
			);
		this.addMouseMotionListener(
			new MouseAdapter()
			{
				public void mouseMoved(MouseEvent e)
				{
					int i=(e.getX()-8)/80;
					int j=(e.getY()-23)/80;
					if(i<0&&i>7)
					{
						return;
					}
					if(j<0&&j>7)
					{
						return;
					}
					System.out.println(i+":"+j);
					mx=i;
					my=j;
					repaint();
					
				}
			}
			);
		this.addKeyListener(
			new KeyAdapter()
			{
				public void keyPressed(KeyEvent e)
				{
					if((e.getKeyChar()=='r'||e.getKeyChar()=='R')&&(hq))
					{
						sj[xzy][xzx]=sj[tempy][tempx];
						sj[tempy][tempx]=ihq;
						who=!who;
						hq=false;
						repaint();
					}else if(e.getKeyChar()=='k'||e.getKeyChar()=='K')
					{
						sj=new int[][]{{4,5,3,1,2,3,5,4},
									
										{0,0,0,0,0,0,0,0},
										{-1,-1,-1,-1,-1,-1,-1,-1},
											{-1,-1,-1,-1,-1,-1,-1,-1},
											{-1,-1,-1,-1,-1,-1,-1,-1},
											{-1,-1,-1,-1,-1,-1,-1,-1},
											{6,6,6,6,6,6,6,6},
											{10,11,9,7,8,9,11,10}
										
										};
										over=false;
										xz=false;
										who=true;
										hq=false;
										
					}
					repaint();
				}
			}
			);	
		this.setResizable(false);	
		this.setBounds(200,200,640+16,640+33);
		this.setVisible(true);
	}
	public boolean jus()
	{
				int xq=xzx;
				int xz=mx;
				if(xq>xz)
				{
					xq=mx;
					xz=xzx;
				}
				for(int i=xq+1;i<xz;i++)
				{
					if(sj[my][i]!=-1)
					{
						return false;
					}
				}
				return true;
				
			
	}
	public boolean juh()
	{		
	       	    int yq=xzy;
				int yz=my;
				if(yq>yz)
				{
					yq=my;
					yz=xzy;
				}
				for(int i=yq+1;i<yz;i++)
				{
					if(sj[i][mx]!=-1)
					{
						return false;
					}
				}
				return true;
	}
	public boolean rule()
	{
		if(who&&sj[my][mx]<6&&sj[my][mx]>=0)//黑吃黑
		{
			return false;
		}
		if(!who&&sj[my][mx]>5)//白吃白
		{
			return false;
		}
		switch(sj[xzy][xzx])
		{
			case 0://黑兵
			if((xzx==mx)&&(my-xzy==1)&&(sj[my][mx]==-1))
			{
				return true;
			}
			if((my-xzy==1)&&(Math.abs(mx-xzx)==1)&&(sj[my][mx]!=-1))
			{
				return true;
			}
			if((xzx==mx)&&(my-xzy==2)&&(sj[my][mx]==-1)&&(xzy==1)&&(sj[my-1][mx]==-1))
			{//走两步
				return true;
			}
			break;
			case 6://白兵
			if((xzx==mx)&&(my-xzy==-1)&&(sj[my][mx]==-1))
			{
				return true;
			}
			if((my-xzy==-1)&&(Math.abs(mx-xzx)==1)&&(sj[my][mx]!=-1))
			{
				return true;
			}
			if((xzx==mx)&&(my-xzy==-2)&&(sj[my][mx]==-1)&&(xzy==6)&&(sj[my+1][mx]==-1))
			{//走两步
				return true;
			}
			break;
			case 4:
			case 10://车横竖走
			if(my==xzy)
			{
				if(juh())
				{
					return true;
				}else{
					return false;
				}
			}
			if(mx==xzx)
			{
				if(jus())
				{
					return true;
				}else{
					return false;
				}
			}	
			break;
		    case 5:
		    case 11://马
		    if(Math.abs(xzx-mx)==1&&Math.abs(xzy-my)==2)
		    {
		    	return true;
		    }
		    if(Math.abs(xzx-mx)==2&&Math.abs(xzy-my)==1)
		    {
		    	return true;
		    }break;
		    case 2://后
		    case 8:
		    if(my==xzy)
			{
				if(juh())
				{
					return true;
				}else{
					return false;
				}
			}
			if(mx==xzx)
			{
				if(jus())
				{
					return true;
				}else{
					return false;
				}
			}	
			 
		    case 3:
		    case 9://相
		        int xq=mx;
		    	int xz=xzx;
		    if((xzx-mx)==(xzy-my))//正斜
		    {
		        if(xq>xz)
		    	{
		    		xq=xzx;
		    		xz=mx;
		    	}
		    	for(int i=xq+1;i<xz;i++)
		    	{
		    		if(sj[i-mx+my][i]!=-1)
		    	    {
		    	    	return false;
		    	    }
		    	}
		    	return true;
	        }
	        if((xzx+xzy)==(mx+my))//反斜
	        {
	        	for(int i=xq+1;i<xz;i++)
	        	{
	        		if(sj[mx+my-i][i]!=-1)
	        		{
	        			return false;
	        		}
	        	}
	        	return true;
	        	
	        }break;
	        case 1:
	        case 7:			//王
	        if(Math.abs(xzx-mx)<=1&&Math.abs(xzy-my)<=1)
	        {
	        	return true;
	        }
		    	
		}
		    
		return false;
		
	}
	
	public void update(Graphics g)
	{
			paint(g);
	}//去闪
    public void paint(Graphics g)
	{
        if(who)
		{
							
			setTitle("我的国际象棋，请黑方落子！");
		}else
		{
			setTitle("我的国际象棋，请白方落子！");
		}
		Image ibuffer=this.createImage(640+16,640+33);
		Graphics gg=ibuffer.getGraphics();
		myPaint(gg);
		g.drawImage(ibuffer,0,0,null);
	}//去抖
	public void myPaint(Graphics g)
	{
		g.setColor(new Color(252,160,105));
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if((i+j)%2==0)
				{
					g.setColor(new Color(190,135,80));
				}else{
				    g.setColor(Color.white);
			    }
			    g.fillRect(8+i*80,23+j*80,80,80);
		}
	}
	g.setColor(new Color(190,135,80));
	g.drawRect(8,23,640,640);
	for(int i=0;i<8;i++)
	{
		for(int j=0;j<8;j++)
		{
			if(sj[j][i]==-1)
			{
			   continue;	
			}
			g.drawImage(ii[sj[j][i]],8+23+i*80,23+j*80,null);
		}
	}//移动套移动
	g.setColor(new Color(0,0,255,140));
	g.fillRect(8+mx*80,23+my*80,80,80);
	g.setColor(Color.blue);
	g.drawRect(8+mx*80,23+my*80,80,80);
    g.drawRect(9+mx*80,24+my*80,78,78);
    //选中
    if(xz)
    {
    g.setColor(new Color(0,255,0,140));
	g.fillRect(8+xzx*80,23+xzy*80,80,80);
	g.setColor(Color.green);
	g.drawRect(8+xzx*80,23+xzy*80,80,80);
    g.drawRect(9+xzx*80,24+xzy*80,78,78);
	}
	if(over)
	{
		g.setColor(Color.black);
		g.setFont(new Font("隶书",1,140));
		g.drawString("游戏结束",50,400);
		g.setColor(Color.red);
		g.drawString("游戏结束",54,404);
	}
}
public static void main(String args[])
{
	new GJXQ();
}
}