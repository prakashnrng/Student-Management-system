import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncryption {

	public static void main(String[] args) {
		 
//	    String pas= BCrypt.hashpw("1234", BCrypt.gensalt());
		String pas=BCrypt.hashpw("12JCC#12", BCrypt.gensalt());
	    System.out.println(pas);
	    

	}

}
