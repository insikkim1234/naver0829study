package bit701.day0904;

public class Ex9_String {

	public static void main(String[] args) {
		String str1="apple";
		String str2="Apple";
		String str3="Have a Good Day";
		String str4="    Happy    ";
		
		
		System.out.println(str3.length());//str3의 총길이:15(공백포함)
		System.out.println(str2.toLowerCase());//str2을 모두 소문자로 변환하여 출력
		System.out.println(str2.toUpperCase());//str2을 모두 대문자로 변환하여 출력
		System.out.println(str3.substring(5));//5번부터 끝까지 출력
		System.out.println(str3.substring(7,11));//7부터 10까지 출력
		
		System.out.println(str3.charAt(0));//str3에서 0번문자 출력
		System.out.println(str3.charAt(7));//str3에서 7번문자 출력
		System.out.println(str1.indexOf('a'));//str1에서 첫번째 a의 인덱스값
		System.out.println(str3.lastIndexOf('a'));//str3에서 마지막 a의 위치
		System.out.println(str4.length());//앞뒤 공백을 포함한 전체의 길이
		System.out.println(str4.trim().length());//앞뒤 공백 제거후 길이구하기(중간은 못없앰)
		System.out.println(str3.startsWith("Have"));//str3가 have로 시작하면 true아니면 false
		System.out.println(str3.endsWith("day"));//str3이 day로 끝나면 true(대소문자 맞아야함)
		System.out.println(str1.equals(str2));//str1이 str2와 완벽하게 같을경우 true(대소문자 맞아야함)
		System.out.println(str1.equalsIgnoreCase(str2));//대소문자 상관없이 철자만 같으면 true
		
		System.out.println(str1.compareTo(str2));//str1과 str2의 차이가 양수값이 나오면 str1>str2음수값이 나오면<(값자체는 상관없다)(97-65=32)
		System.out.println(str1.compareTo("apple"));//완전히 같을경우 0
		
		

	}

}
