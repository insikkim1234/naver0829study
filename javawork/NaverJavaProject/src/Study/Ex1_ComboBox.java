package Study;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Ex1_ComboBox extends JFrame{
	JPanel p=new JPanel();
	JComboBox<String> combo;
	JRadioButton rbYellow,rbMagenta,rbGray,rbBlue;
	JLabel lblMessage;


	public Ex1_ComboBox(String title) {
		super(title);
		this.setBounds(1000, 100, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}
	private void setDesign() {
		// TODO Auto-generated method stub
		Vector<String> list=new Vector<String>();
		list.add("빨강");
		list.add("초록");
		list.add("분홍");
		list.add("오렌지");

		combo=new JComboBox<String>(list);

		JPanel pTop=new JPanel();
		pTop.add(combo);
		this.add("North", pTop);

		lblMessage=new JLabel("have a nice day");
		lblMessage.setFont(new Font("Comic sans MS",Font.BOLD,30));
		p.add(lblMessage);

		p.setBackground(Color.red);
		this.add("Center",p);

		combo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String selectColor=(String)combo.getSelectedItem();
				System.out.println(selectColor);

				switch(selectColor)
				{
				case "빨강":
					p.setBackground(Color.red);
					break;
				case "분홍":
					p.setBackground(Color.pink);
					break;
				case "오렌지":
					p.setBackground(Color.orange);
					break;
				case "초록":
					p.setBackground(Color.green);
					break;

				}
			}
		});

		ButtonGroup bg=new ButtonGroup();
		rbYellow=new JRadioButton("노랑");
		rbBlue=new JRadioButton("파랑");
		rbMagenta=new JRadioButton("핫핑크");
		rbGray=new JRadioButton("회색");

		bg.add(rbYellow);
		bg.add(rbBlue);
		bg.add(rbMagenta);
		bg.add(rbGray);

		JPanel pBottom=new JPanel();
		pBottom.add(rbYellow);
		pBottom.add(rbBlue);
		pBottom.add(rbGray);
		pBottom.add(rbMagenta);

		this.add("South",pBottom);

		rbYellow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setForeground(Color.yellow);
			}
		});
		rbBlue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setForeground(Color.blue);
			}
		});
		rbGray.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setForeground(Color.gray);
			}
		});
		rbMagenta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMessage.setForeground(Color.magenta);
			}
		});


	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1_ComboBox ex=new Ex1_ComboBox("ComboBox");

	}

}
