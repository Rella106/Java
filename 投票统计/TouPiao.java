import java.awt.*;
import java.awt.event.*;
public class TouPiao extends Frame implements ActionListener
{
		int i=0;
		int a=0;
		int x=0;
		int y=0;
		int max;
		String s;
	
	Button bok=new Button("张三");
	Button brs=new Button("李四");
	Button bas=new Button("王五");
	Button bqw=new Button("赵六");
	public TouPiao()
	{
		
		this.setLayout(new FlowLayout());
		this.setBounds(200,200,800,800);
		this.setTitle("我的投票界面！");
	    this.setBackground(Color.pink);
		this.setAlwaysOnTop(true);
		this.add(bok);
		this.setBounds(300,300,20,10);
		bok.addActionListener(this);
		this.add(brs);
		this.setBounds(330,300,20,10);
		brs.addActionListener(this);
		this.add(bas);
		this.setBounds(360,300,20,10);
		bas.addActionListener(this);
		this.add(bqw);
		this.setBounds(390,300,20,10);
		bqw.addActionListener(this);
		this.addWindowListener(new MyAdp());
		this.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e)
	{
	
		if(e.getSource()==bok)
		   {
			i++;
			System.out.println("目前票数为：张三"+i+"票 李四"+a+"票 王五"+x+"票 赵六"+y+"票");}
			
		    if(e.getSource()==brs)
		    {
			  a++;
			  System.out.println("目前票数为：张三"+i+"票 李四"+a+"票 王五"+x+"票 赵六"+y+"票");}
			
		       if(e.getSource()==bas)
		        {
		        	x++;
			        System.out.println("目前票数为：张三"+i+"票 李四"+a+"票 王五"+x+"票 赵六"+y+"票");}
			
		            if(e.getSource()==bqw)
		            {
		            	y++;
			            System.out.println("目前票数为：张三"+i+"票 李四"+a+"票 王五"+x+"票 赵六"+y+"票");
		            }	
		            
		            if(max<i)
		           {
		 	        max=i;
		 	       
		          }else if(a>max)
		         {
		 	    max=a;
		        }else if(x>max)
		        {
		         max=x;
		       
		        }else if(y>max)
		    {
		       max=y;
		       
		   }
		   if(i==max)
		   {
		   	s=s+"张三";
		   }
		System.out.println("目前票数最高为："+s+t+"票");
		         
		    
	
	}
	
	public static void main(String args[])
	{
		new TouPiao();
	}

class MyAdp extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}
}