/**
 * UserAccount.java
 * Creates new user account
 *
 * @author Anna Lehner
 * @version 6/15/23 Sprint 2
 */
package main.java.memoranda.ui;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class UserAccount {
	private String username, password;
	private enum AcctType {TRAINER, STUDENT};
	private AcctType acctType;
	private static String file = "UserAccounts.txt";
	
	/**
	 * Constructor
	 * @param inUsername
	 * @param inPassword
	 * @param inType
	 */
	public UserAccount(String inUsername, String inPassword, int inType) throws IOException {
		username = inUsername;
		password = inPassword;
		if (inType == 0) {acctType = AcctType.TRAINER;}
		if (inType == 1) {acctType = AcctType.STUDENT;}	
	}
	
	/**
	 * Writes account info to UserAccounts.txt
	 */
	public void write() {
		String[] arr = {username, password, String.valueOf(acctType.toString())};
		try {
			FileWriter fw = new FileWriter(file, true);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter out = new PrintWriter(bw);
		for(String str: arr) {
		  out.print(str + ",");
		}
		out.print("\n");
		out.close();
		}
		catch (IOException ex) {}
	}

}
