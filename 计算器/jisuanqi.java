import java.awt.*;
import java.awt.event.*;//�����������Ҫʹ�õİ�����
public class jisuanqi extends Frame 
implements ActionListener
{
	int t=0,a=0,b=0,sum=0;
	Button a1=new Button("1");
	Button a2=new Button("2");
	Button a3=new Button("3");
	Button a4=new Button("4");
	Button a5=new Button("5");
	Button a6=new Button("6");
	Button a7=new Button("7");
	Button a8=new Button("8");
	Button a9=new Button("9");
	Button a10=new Button("0");
	Button a11=new Button("-");
	Button a12=new Button("+");
	Button a13=new Button("*");
	Button a14=new Button("=");
	Button a15=new Button("���");//�������������谴ť
	Panel b1=new Panel();
	TextField c1=new TextField();//����text���
	public jisuanqi()
	{
	    this.setLayout(new BorderLayout());
	    this.add(c1,BorderLayout.NORTH);
	    this.add(b1,BorderLayout.CENTER);
	    b1.setLayout(new GridLayout(3,5));//���ò���Ϊ��������
	    b1.add(a1);
	    b1.add(a2);
	    b1.add(a3);
	    b1.add(a4);
	    b1.add(a5);
	    b1.add(a6);
	    b1.add(a7);
	    b1.add(a8);
	    b1.add(a9);
	    b1.add(a10);
	    b1.add(a11);
	    b1.add(a12);
	    b1.add(a13);
	    b1.add(a14);
	    b1.add(a15);//������а�ť
	    c1.addActionListener(this);
	    a1.addActionListener(this);
	    a2.addActionListener(this);
	    a3.addActionListener(this);
	    a4.addActionListener(this);
	    a5.addActionListener(this);
	    a6.addActionListener(this);
	    a7.addActionListener(this);
	    a8.addActionListener(this);
	    a9.addActionListener(this);
	    a10.addActionListener(this);
	    a11.addActionListener(this);
	    a12.addActionListener(this);
	    a13.addActionListener(this);
	    a14.addActionListener(this);
	    a15.addActionListener(this);//�����а�ť���м���
	    this.setBounds(300,300,300,300);//���ô����λ�úͳ���
	    this.setVisible(true);//���ÿɼ�
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==a1)
		{
			c1.setText(c1.getText()+"1");	
		}else if(e.getSource()==a2)
		{
			c1.setText(c1.getText()+"2");
		}else if(e.getSource()==a3)
		{
			c1.setText(c1.getText()+"3");
		}else if(e.getSource()==a4)
		{
			c1.setText(c1.getText()+"4");
		}else if(e.getSource()==a5)
		{
			c1.setText(c1.getText()+"5");
		}else if(e.getSource()==a6)
		{
			c1.setText(c1.getText()+"6");
		}else if(e.getSource()==a7)
		{
			c1.setText(c1.getText()+"7");
		}else if(e.getSource()==a8)
		{
			c1.setText(c1.getText()+"8");
		}else if(e.getSource()==a9)
		{
			c1.setText(c1.getText()+"9");
		}else if(e.getSource()==a10)
		{
			c1.setText(c1.getText()+"0");
		}else if(e.getSource()==a11)//�������ְ�ť���ܴ��������
		{
			t=1;
			a=Integer.parseInt(c1.getText());
			c1.setText("a");c1.setText("");
		}else if(e.getSource()==a12)//����
		{
			t=2;
			a=Integer.parseInt(c1.getText());
			c1.setText("a");c1.setText("");	
		}else if(e.getSource()==a13)//�ӷ�
		{
			t=3;
			a=Integer.parseInt(c1.getText());
		    c1.setText("a");c1.setText(""); 
		}else if(e.getSource()==a14)//�˷�
		{
			b=Integer.parseInt(c1.getText());
			switch(t)
			{
				case 1:sum=a-b;
				       break;
				case 2:sum=a+b;
				       break;
				case 3:sum=a*b;
			       	   break;
			}
			c1.setText(sum+"");
		}else if(e.getSource()==a15)
		{
			c1.setText("a");c1.setText("");//������ ��ֵ��ʧ
		}
	}
	public static void main(String args[])
	{
		new jisuanqi();
	}
}