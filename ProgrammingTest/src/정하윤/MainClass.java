package 정하윤;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Enumeration;

public class MainClass extends JFrame implements ActionListener{
	ProgTest1 pt1 = new ProgTest1();
	ProgTest2 pt2 = new ProgTest2();
	
	JLabel id,name,tel,gender;
	JTextField mbid,mbname,mbtel;
	JButton bt1,bt2,bt3,gugu;
	ButtonGroup gen;
	JTextArea ta;
	JPanel plgender,pl1,pl2,pla,plb,plc;
	JRadioButton male,female;
	
	MainClass(){
		super("프로그래밍언어활용평가");
		id = new JLabel("회원ID:");
		name = new JLabel("회원이름:");
		tel = new JLabel("전화번호:");
		gender = new JLabel("성별");
		mbid = new JTextField(10);
		mbname = new JTextField(10);
		mbtel = new JTextField(10);
		male = new JRadioButton("남",true);
		female = new JRadioButton("여",false);
		gen = new ButtonGroup();
		gen.add(male);
		gen.add(female);
		bt1 = new JButton("회원등록");
		bt2 = new JButton("회원삭제");
		bt3 = new JButton("전체회원조회");
		gugu = new JButton("구구단보기");
		ta = new JTextArea(10,20);
		
		pl1 = new JPanel();
		pl2 = new JPanel();
		pla = new JPanel(new BorderLayout());
		plb = new JPanel(new BorderLayout());
		plc = new JPanel(new BorderLayout());
		plgender = new JPanel();
		plgender.add(male);
		plgender.add(female);
		
		Box box1 = Box.createVerticalBox();
		pl1.add(id);
		pl1.add(mbid);
		pl1.add(name);
		pl1.add(mbname);
		pl1.add(tel);
		pl1.add(mbtel);
		pl1.add(gender);
		pl1.add(plgender);
		pl2.add(bt1);
		pl2.add(bt2);
		pl2.add(bt3);
		box1.add(pl1);
		box1.add(pl2);
		pla.setBorder(new TitledBorder(new EtchedBorder(),"회원등록,삭제,조회"));
		pla.add(box1,BorderLayout.CENTER);
		
		Box box2 = Box.createVerticalBox();
		box2.add(Box.createHorizontalStrut(150));
		box2.add(gugu);
		plb.setBorder(new TitledBorder(new EtchedBorder(),"구구단"));
		plb.add(box2,BorderLayout.CENTER);
		
		Box box3 = Box.createVerticalBox();
		box3.add(ta);
		plc.setBorder(new TitledBorder(new EtchedBorder(),"결과"));
		plc.add(box3,BorderLayout.CENTER);
		
		Box boxall = Box.createVerticalBox();
		boxall.add(pla);
		boxall.add(plb);
		boxall.add(plc);
		
		add(boxall,BorderLayout.CENTER);
		
		setSize(800,400);
		setVisible(true);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		gugu.addActionListener(this);
	}
	
	public static void main(String[] args) {
		MainClass mc = new MainClass();
		mc.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bt1) {
			String gender="";
			Enumeration<AbstractButton> em = gen.getElements();
			while(em.hasMoreElements()) {
				AbstractButton emi =em.nextElement();
				JRadioButton jb = (JRadioButton)emi;
				if(jb.isSelected())
					gender=jb.getText();
			}
			int con = JOptionPane.showConfirmDialog(this, "회원을 등록하시겠습니까?","회원등록", JOptionPane.YES_NO_OPTION);
			if(con==JOptionPane.YES_OPTION) {
				pt2.mapListAdd(mbid.getText(), mbname.getText(),mbtel.getText(),gender);
			}
			
		}
		
		if(e.getSource()==bt2) {
			int con=JOptionPane.showConfirmDialog(this, "회원을 삭제하시겠습니까?", "회원삭제", JOptionPane.YES_NO_OPTION);
			if(con==JOptionPane.YES_OPTION) {
				pt2.mapListRemove(mbid.getText());
			}
		}
		
		if(e.getSource()==bt3) {
			ArrayList<MemberData> list = pt2.getMapList();
			String str="회원ID \t 회원이름 \t 전화번호 \t 성별 \n";
			for(int i=0;i<list.size();i++) {
				str+=list.get(i).getMemberID()+"\t"+list.get(i).getName()+"\t"+list.get(i).getTel()
						+"\t"+list.get(i).getGender()+"\n";
			}
			ta.setText(str);
		}
		
		if(e.getSource()==gugu) {
			int dan=(Integer.parseInt(JOptionPane.showInputDialog("몇단을 보시겠습니까?",JOptionPane.YES_OPTION)));
			ta.setText(pt1.getGugudan(dan));
		}
	}
}
