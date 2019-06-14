package ex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Ex2Main extends JFrame implements ActionListener{
	JButton jbt1,jbt2;
	JTable jtb;
	JPanel jp1, jp2, jp3,p1;
	JTextField jt1,jt2;
	JTextArea ja;
	JLabel jl1,jl2;
	Ex2 ex = new Ex2();
	
	
	Ex2Main(){
		super();
		
		jl1 = new JLabel("이       름:");
		jt1 = new JTextField(20);
		jl2 = new JLabel("전화번호:");
		jt2 = new JTextField(20);
		jbt1 = new JButton("전화번호 추가");
		jbt2 = new JButton("전화번호 보기");
		ja = new JTextArea(20,25);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		p1 = new JPanel();
		
		jp1.add(jl1);
		jp1.add(jt1);
		jp2.add(jl2);
		jp2.add(jt2);
		jp3.add(jbt1);
		jp3.add(jbt2);
		
		p1.add(jp1);
		p1.add(jp2);
		p1.add(jp3);
		p1.add(ja);
		
		add(p1);
		
		jbt1.addActionListener(this);
		jbt2.addActionListener(this);
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Ex2Main ex2m = new Ex2Main();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==jbt1) {
			ex.insertPhoneNumber(jt1.getText(), jt2.getText());
			
		}
		String str = "이름"+"\t"+"전화번호"+"\n";
		if(e.getSource()==jbt2) {
			ArrayList<PhoneValue> listt = ex.getPhoneNumberList();
			for(int i=0; i<listt.size(); i++) {
				str+=(listt.get(i).getName()+"\t"+listt.get(i).getPhoneNumber()+"\n");
			}
			ja.setText(str);
		}
	}
}
