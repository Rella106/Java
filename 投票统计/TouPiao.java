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
	
	Button bok=new Button("����");
	Button brs=new Button("����");
	Button bas=new Button("����");
	Button bqw=new Button("����");
	public TouPiao()
	{
		
		this.setLayout(new FlowLayout());
		this.setBounds(200,200,800,800);
		this.setTitle("�ҵ�ͶƱ���棡");
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
			System.out.println("ĿǰƱ��Ϊ������"+i+"Ʊ ����"+a+"Ʊ ����"+x+"Ʊ ����"+y+"Ʊ");}
			
		    if(e.getSource()==brs)
		    {
			  a++;
			  System.out.println("ĿǰƱ��Ϊ������"+i+"Ʊ ����"+a+"Ʊ ����"+x+"Ʊ ����"+y+"Ʊ");}
			
		       if(e.getSource()==bas)
		        {
		        	x++;
			        System.out.println("ĿǰƱ��Ϊ������"+i+"Ʊ ����"+a+"Ʊ ����"+x+"Ʊ ����"+y+"Ʊ");}
			
		            if(e.getSource()==bqw)
		            {
		            	y++;
			            System.out.println("ĿǰƱ��Ϊ������"+i+"Ʊ ����"+a+"Ʊ ����"+x+"Ʊ ����"+y+"Ʊ");
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
		   	s=s+"����";
		   }
		System.out.println("ĿǰƱ�����Ϊ��"+s+t+"Ʊ");
		         
		    
	
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