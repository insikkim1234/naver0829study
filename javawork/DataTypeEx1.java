public class DataTypeEx1{
	public static void main(String []args)//
	{
		//�̶����� ����๮�Դϴ�
		/*
			2023.08.30 ����Ÿ Ÿ�� ����
		*/
		//byte�� 1������ ũ���� ������ Ÿ���Դϴ�
		//ũ��� -128 127������ ���� �����մϴ�
		byte a=127;
		System.out.println("a="+a);

		byte b=(byte)200;//200���� ����� ���� �߻� ��������ȯ
		System.out.println("b="+b);//����ȯ ������� ���ս� �߻�
		//-56�� ������ ������ ��Ʈ�� ����

		//����� ���ڷ� �Ѿ���� ���ڿ��� Ȯ���غ���
		System.out.println(args[0]);//�迭�� ù���ڿ� ���
		//�̰� �����ϸ� ArrayIndexOutOfBoundsException���� ����

		//java DataTypeEx1 apple �� cmdâ�� �Է��ؼ� ���� �ϳ��� �־ args[0]�� 
		//ä�� �� �ְ� �Ǿ���.

		//java DataTypeEx1 20�� �Է��ϸ� 20�� ���ڰ� �ƴ� ��Ʈ������ �Է�
	}
}

