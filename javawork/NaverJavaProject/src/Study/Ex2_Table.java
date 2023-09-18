package Study;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ex2_Table extends JFrame{
	JTable table1;
	JTable table2;

	public Ex2_Table(String title)
	{
		super(title);
		this.setBounds(1000,100,300,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);

	}



	private void setDesign() {
		this.setLayout(new GridLayout(2,1));
		DefaultTableModel model=new DefaultTableModel(new String[] {"이름","나이","주소"},3);
		table1=new JTable(model);
		
		this.add(table1);
		this.add(new JScrollPane(table1));
		
		String [][]data= {
				{"강부자","56","강남구"},
				{"이순재","67","여의도"},
				{"신구","56","제주도"}
		};
		
		table2=new JTable(data,new String[] {"이름","나이","주소"});
		this.add(new JScrollPane(table2));
		

	}
	public static void main(String[] args)
	{
		Ex2_Table ex=new Ex2_Table("JTable");
	}

}
