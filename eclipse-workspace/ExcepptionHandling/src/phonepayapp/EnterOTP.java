package phonepayapp;

import java.util.Scanner;

public class EnterOTP {
static int Otp=1234;
	public static void enterOTP() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter otp");
int otp=sc.nextInt();
if(otp==Otp) {
	System.out.println("you can proceed further");
}else {try {
	throw new IncorrectOTP ("incorrect OTP,please try again");
} catch (IncorrectOTP e) {
	e.printStackTrace();
}

}
	}

}
