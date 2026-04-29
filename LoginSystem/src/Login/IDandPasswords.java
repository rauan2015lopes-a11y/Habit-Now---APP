package Login;

import java.util.HashMap;

public class IDandPasswords {
	
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	IDandPasswords(){
		
		logininfo.put("Rauan","123415");
		logininfo.put("João","676767");
		logininfo.put("Jesus","77777");
	}
	protected HashMap<String, String> getLogininfo(){
		return logininfo;
		
	}

}
