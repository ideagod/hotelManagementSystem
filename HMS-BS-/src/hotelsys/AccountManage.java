package hotelsys;
import java.io.*;
import java.util.*;

public class AccountManage {
	ArrayList<Account> users;
	static final String fileName = "SystemAccount.txt";

	AccountManage() {
		users = new ArrayList<Account>(); 
	}

	void LoadUser() throws FileNotFoundException {
		String lineData;
		File file = new File(fileName);
		Scanner fileScan = new Scanner(file);
		Scanner lineScan;
		while (fileScan.hasNext()) {
			lineData = fileScan.nextLine();
			lineScan = new Scanner(lineData);
			lineScan.useDelimiter("/");

			while (lineScan.hasNext()) {
				String name = lineScan.next();
				String passwd = lineScan.next();
				users.add(new Account(name, passwd));
			}
			lineScan.close();
		}
		fileScan.close();
		
	}
	
	public boolean Check(String name, String passwd) {
		boolean bResult = false;
		for (Account user : users) {
			if (0 == user.getName().compareTo(name)) {
				if (0 == user.getPasswd().compareTo(passwd)) {
					bResult = true;
				}
			}
		}
		return bResult;
	}

//	public  static void main(String[] args) {
//		AccountManage manage = new AccountManage();
//		try {
//			manage.LoadUser();
//
//			boolean bPassed = manage.Check("Admin2", "123456");
//			System.out.println(bPassed == true ? "passed" : "user not exist or passwd error");
//		} catch (FileNotFoundException e) {
//			System.out.println("FileNotFoundException");
//		}
//		
//	}
}
