package bit701.day0918;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//행과 열로 데이터 출력

public class Ex2_Table extends JFrame{
	JTable table1;
	JTable table2;
	
	 public Ex2_Table(String title) {
		// TODO Auto-generated constructor stub
	
		super(title);
		this.setBounds(1000, 100, 300, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign();//x눌러서 크리에이트
		this.setVisible(true);
	}
	private void setDesign() {
		//테이블 두개를 넣기 위해서 2행1열로 레이아웃 변경
		//그리드레이아웃 컨스페
		this.setLayout(new GridLayout(2,1));
		
		//table1을 생성을 하는데 
		//table1=new JTable(5,4);//5행4열의 빈테이블 생성
		//this.add(table1);
		
		//제목과 세개의 빈 행을 추가하고자 할 경우
		DefaultTableModel model=new DefaultTableModel(new String[] {"이름","나이","주소"},3);//배열 타입으로 주는 방법
		table1=new JTable(model);
		
		//this.add(table1);//이렇게만 하면 제목이 안나옴
		this.add(new JScrollPane(table1));//이렇게 스크롤이 가능하도록 만들어줘야함
		
		//table2에는 데이터를 넣어보자
		String [][]data= {
				{"강부자","56","강남구"},
				{"이순재","67","여의도"},
				{"신구","56","제주도"}
		};
		
		table2=new JTable(data,new String[] {"이름","나이","주소"});
		this.add(new JScrollPane(table2));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2_Table ex=new Ex2_Table("JTable");

	}


}
