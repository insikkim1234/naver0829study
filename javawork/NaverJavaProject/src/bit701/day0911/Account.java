package bit701.day0911;

public class Account {
	private String accountNo;//계좌번호
	private String accountName;//계좌주
	private int money;//잔액
	
	//3개의 값을 전달받는 생성자
	
	public Account(String accountNo,String accountName,int money)
	{
		this.accountNo=accountNo;
		this.accountName=accountName;
		this.money=money;
	}
	//계좌번호가 맞을경우 true반환해주는 메서ㄷㅡisAccount(String accountNo):맞을경우 true 틀릴경우 false
	public boolean isAccount(String accountNo)
	{
		if(accountNo.equals(this.accountNo))
			return true;
		else
			return false;
	}
	//외부에서 입금시 money에 추가하는 메서드addMoney
	public void addMoney(int money) 
	{
		this.money+=money;
		
	}
	
	//외부에서 출금시 money에서 빼는 메서드subMoney
	public void subMoney(int money) 
	{
		this.money-=money;
		
	}
	
	//출력해주는 메서드 계좌번호 예금주 잔액accountWrite함수
	public void accountWrite()
	{
		System.out.println(accountNo+"\t"+accountName+"\t"+money);
	}
	
	//getter method 자동생성
	public String getAccountNo() {
		return accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public int getMoney() {
		return money;
	}
	
	
	

}
