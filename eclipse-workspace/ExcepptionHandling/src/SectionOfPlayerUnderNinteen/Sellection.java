package SectionOfPlayerUnderNinteen;

public class Sellection {

	public Sellection() {
		
	}
public static void selection(int age) throws BelowAgeException {

	if(age<16) {
		throw new BelowAgeException("You are not applicable");
	}if(age>19) {
		throw new AboveAgeException("You are not applicable");
	}else {
		System.out.println("you are applicable");
	}
}
}
