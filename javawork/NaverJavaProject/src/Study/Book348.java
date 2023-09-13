package Study;

interface RemoteControl
{
	int MAX_VOLUME=10;
	int MIN_VOLUME=0;
	
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	default void setMute(boolean mute)
	{
		if(mute)
		{
			System.out.println("무음 처리합니다");
			setVolume(MIN_VOLUME);
		}
		else
		{
			System.out.println();
		}
	}
}

class Television implements RemoteControl
{
	private int volume;

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("tv를 켭니다");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("tv를 끕니다");
	}

	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		if(volume>RemoteControl.MAX_VOLUME)
		{
			this.volume=RemoteControl.MAX_VOLUME;
		}
		else if(volume<MIN_VOLUME)
		{
			this.volume=MIN_VOLUME;
		}
		else
		{
			this.volume=volume;
		}
		System.out.println("현재 볼륨음"+this.volume+"입니다");
		
	}
	
}

public class Book348 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoteControl rc=null;
		rc=new Television();
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(5);
		
		rc.setMute(false);
		rc.setMute(true);

	}

}
