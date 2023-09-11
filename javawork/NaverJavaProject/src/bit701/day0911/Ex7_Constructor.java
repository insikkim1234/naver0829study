package bit701.day0911;

public class Ex7_Constructor {

	public static void main(String[] args) {
		/*방법1메모리 할당 후 생성
		Student []stu=new Student[3];//배열을 5개로 할당했지만 저장값은 bnull
		stu[0]=new Student();
		stu[1]=new Student("이효리");
		stu[2]=new Student("이진",1989,99);*/
		
		//방법2
		
		Student []stu= {
				new Student(),
				new Student("강호동"),
				new Student("홍길동",1989,90)
				
		};
		
		/*for(int i=0;i<stu.length;i++)
			stu[i].studentInfo();*/
		
		for(Student s:stu)
			s.studentInfo();

	}

}
