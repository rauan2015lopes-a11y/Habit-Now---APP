package Login;

public class Main {

	public static void main(String[] args) {
		
		IDandPasswords idandPasswords = new IDandPasswords();
		
		
		@SuppressWarnings("unused")
		LoginPage loginPage = new LoginPage(idandPasswords.getLogininfo());
	}

}
