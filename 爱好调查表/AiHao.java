import java.awt.*;
import java.awt.event.*;
public class AiHao extends Frame
implements ActionListener,ItemListener
{
	String s="����";
	String s1="��";
	String s2="��С";
	String s3="����";
	CheckboxGroup cbg=new CheckboxGroup();
	CheckboxGroup cbg1=new CheckboxGroup();
	Button bok=new Button("�ύ");
	Label l1=new Label("������");
	Label l2=new Label("�Ա�");
	Label l3=new Label("ѧ����");
	Label l4=new Label("���ã�");
	Checkbox c1=new Checkbox("��",cbg1,true);
	Checkbox c2=new Checkbox("Ů",cbg1,false);
	Checkbox c3=new Checkbox("��С",cbg,true);
	Checkbox c4=new Checkbox("��ר",cbg,false);
	Checkbox c5=new Checkbox("����",cbg,false);
	Checkbox c6=new Checkbox("˶ʿ",cbg,false);
	Checkbox x1=new Checkbox("����");
	Checkbox x2=new Checkbox("����");
	Checkbox x3=new Checkbox("����");
	Checkbox x4=new Checkbox("��Ӿ");
	Choice cc=new Choice();
	TextArea ta=new TextArea();
	public AiHao()
	{
		this.setTitle("����");
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
		cc.add("����");
		cc.add("����");
		cc.add("����");
		
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
		    		case 0:s="����";
		    		       //ta.setText("����");
			               break;
		    	    case 1:s="����";
		    	           //ta.setText("����");
			               break;
			        case 2:s="����";
			               //ta.setText("����");
			               break;
			     }
		   }else if(e.getSource()==c1)
		   {
		   	s1="��";
		   }else if(e.getSource()==c2)
		   {
		   	s1="Ů";
		   }else if(e.getSource()==c3)
		   {
		   	s2="��С";
		   }else if(e.getSource()==c4)
		   {
		   	s2="��ר";
		   }else if(e.getSource()==c5)
		   {
		   	s2="����";
		   }else if(e.getSource()==c6)
		   {
		   	s2="˶ʿ";
		   }else if(e.getSource()==x1)
		   {
		   	s3="";
		   }else if(e.getSource()==x2)
		   {
		   	s3=s3+"����";
		   }else if(e.getSource()==x3)
		   {
		   	s3=s3+"����";
		   }else if(e.getSource()==x4)
		   {
		   	s3=s3+"��Ӿ";
		   }
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bok)
		{
			ta.setText("������"+s+"�Ա�"+s1+"ѧ����"+s2+"���ã�"+s3+"\n");
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
 