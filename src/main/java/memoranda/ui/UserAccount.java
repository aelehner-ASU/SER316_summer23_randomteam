/**
 * UserAccount.java
 * Creates new user account
 *
 * @author Anna Lehner
 * @version 6/24/23 Sprint 2
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
	private enum BeltRank {WHITE, YELLOW, ORANGE, PURPLE, BLUE, BLUESTRIPE, GREEN, GREENSTRIPE,
		BROWN1, BROWN2, BLACK1, BLACK2, BLACK3};
	private BeltRank beltRank;
	private static String file = "UserAccounts.txt";
	
	/**
	 * Constructor
	 * @param inUsername
	 * @param inPassword
	 * @param inAcctType
	 * @param beltType
	 */
	public UserAccount(String inUsername, String inPassword, int inAcctType, int beltType) throws IOException {
		username = inUsername;
		password = inPassword;
		if (inAcctType == 0) {acctType = AcctType.TRAINER;}
		if (inAcctType == 1) {acctType = AcctType.STUDENT;}	
		if (beltType == 0) {beltRank = BeltRank.WHITE;}
		if (beltType == 1) {beltRank = BeltRank.YELLOW;}
		if (beltType == 2) {beltRank = BeltRank.ORANGE;}
		if (beltType == 3) {beltRank = BeltRank.PURPLE;}
		if (beltType == 4) {beltRank = BeltRank.BLUE;}
		if (beltType == 5) {beltRank = BeltRank.BLUESTRIPE;}
		if (beltType == 6) {beltRank = BeltRank.GREEN;}
		if (beltType == 7) {beltRank = BeltRank.GREENSTRIPE;}
		if (beltType == 8) {beltRank = BeltRank.BROWN1;}
		if (beltType == 9) {beltRank = BeltRank.BROWN2;}
		if (beltType == 10) {beltRank = BeltRank.BLACK1;}
		if (beltType == 11) {beltRank = BeltRank.BLACK2;}
		if (beltType == 12) {beltRank = BeltRank.BLACK3;}
	}
	
	/**
	 * Writes account info to UserAccounts.txt
	 */
	public void write() {
		String[] arr = {username, password, String.valueOf(acctType.toString()),
				String.valueOf(beltRank.toString())};
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
