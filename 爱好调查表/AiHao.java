import java.awt.*;
import java.awt.event.*;
public class AiHao extends Frame
implements ActionListener,ItemListener
{
	String s="张三";
	String s1="男";
	String s2="高小";
	String s3="看书";
	CheckboxGroup cbg=new CheckboxGroup();
	CheckboxGroup cbg1=new CheckboxGroup();
	Button bok=new Button("提交");
	Label l1=new Label("姓名：");
	Label l2=new Label("性别：");
	Label l3=new Label("学历：");
	Label l4=new Label("爱好：");
	Checkbox c1=new Checkbox("男",cbg1,true);
	Checkbox c2=new Checkbox("女",cbg1,false);
	Checkbox c3=new Checkbox("高小",cbg,true);
	Checkbox c4=new Checkbox("大专",cbg,false);
	Checkbox c5=new Checkbox("本科",cbg,false);
	Checkbox c6=new Checkbox("硕士",cbg,false);
	Checkbox x1=new Checkbox("看书");
	Checkbox x2=new Checkbox("听音");
	Checkbox x3=new Checkbox("篮球");
	Checkbox x4=new Checkbox("游泳");
	Choice cc=new Choice();
	TextArea ta=new TextArea();
	public AiHao()
	{
		this.setTitle("爱好");
		this.setLayout(null);
		//this.add(p);
		//this.setBounds(100,100,300,300);
		this.add(l1);
		l1.setBounds(100,100,60,20);
		this.add(l2);
		l2.setBounds(100,130,60,20);
		this.add(l3);
		l3.setBounds(100,160,60,20);
		this.add(l4);
		l4.setBounds(100,190,60,20);
		this.add(cc);
		cc.setBounds(170,100,100,20);
		cc.add("张三");
		cc.add("李四");
		cc.add("王五");
		
		this.add(c1);
		c1.setBounds(170,130,60,20);
		this.add(c2);
		c2.setBounds(240,130,60,20);
		this.add(c3);
		c3.setBounds(170,160,60,20);
		this.add(c4);
		c4.setBounds(240,160,60,20);
		this.add(c5);
		c5.setBounds(310,160,60,20);
		this.add(c6);
		c6.setBounds(380,160,60,20);
		this.add(x1);
		x1.setState(true);
		x1.setBounds(170,190,60,20);
		this.add(x2);
		x2.setState(false);
		x2.setBounds(240,190,60,20);
		this.add(x3);
		x3.setState(false);
		x3.setBounds(310,190,60,20);
		this.add(x4);
		x4.setState(false);
		x4.setBounds(380,190,60,20);
		this.add(ta);
		ta.setBounds(100,220,340,160);
		this.add(bok);
		bok.setBounds(240,400,60,20);
		//this.add(p,BorderLayout.SOUTH);
		this.setBounds(50,50,500,500);
		
		c1.addItemListener(this);
		c2.addItemListener(this);
		c3.addItemListener(this);
		c4.addItemListener(this);
		c5.addItemListener(this);
		c6.addItemListener(this);
		x1.addItemListener(this);
		x2.addItemListener(this);
		x3.addItemListener(this);
		x4.addItemListener(this);
		bok.addActionListener(this);
		cc.addItemListener(this);
		this.addWindowListener(new MyAdp());
		this.setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent e)	
	
	{
		
			
		   if(e.getSource()==cc)
		   {
		    	switch(cc.getSelectedIndex())
		    	{
		    		case 0:s="张三";
		    		       //ta.setText("张三");
			               break;
		    	    case 1:s="李四";
		    	           //ta.setText("李四");
			               break;
			        case 2:s="王五";
			               //ta.setText("王五");
			               break;
			     }
		   }else if(e.getSource()==c1)
		   {
		   	s1="男";
		   }else if(e.getSource()==c2)
		   {
		   	s1="女";
		   }else if(e.getSource()==c3)
		   {
		   	s2="高小";
		   }else if(e.getSource()==c4)
		   {
		   	s2="大专";
		   }else if(e.getSource()==c5)
		   {
		   	s2="本科";
		   }else if(e.getSource()==c6)
		   {
		   	s2="硕士";
		   }else if(e.getSource()==x1)
		   {
		   	s3="";
		   }else if(e.getSource()==x2)
		   {
		   	s3=s3+"听音";
		   }else if(e.getSource()==x3)
		   {
		   	s3=s3+"篮球";
		   }else if(e.getSource()==x4)
		   {
		   	s3=s3+"游泳";
		   }
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bok)
		{
			ta.setText("姓名："+s+"性别："+s1+"学历："+s2+"爱好："+s3+"\n");
		}
	        
    	x1.setState(true);
	
		x2.setState(false);
		
		x3.setState(false);
	
		x4.setState(false);
    }
	public static void main(String args[])
	{
		new AiHao();
	}
}
class MyAdp extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	
}
 