package Study;

abstract class Animal
{
	public void breathe()
	{
		System.out.println("숨을 숩니다");
	}
	
	public abstract void sound();
}

class Dog extends Animal
{

	@Override
	public void sound() {
		System.out.println("멍멍");
		
	}
	
}

class Cat extends Animal
{

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("야옹");
	}
	
}

public class Study328 {
	public static void animalSound(Animal animal)
	{
		animal.sound();
	}

	public static void main(String[] args) {
		
		animalSound(new Cat());
		Dog dog=new Dog();
		animalSound(dog);
		

	}

}
