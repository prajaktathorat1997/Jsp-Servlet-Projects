package SectionOfPlayerUnderNinteen;
import java.util.Scanner;
public class Test {

	public Test() {
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter you age");
		int age=sc.nextInt();
		try {
			Sellection.selection(age);
		} catch (BelowAgeException e) {
			e.printStackTrace();
		}finally {
			System.out.println("better luck!");
		}

	}

}
