package appMain;

import java.io.*;
import java.util.Scanner;

public class FileInputOutputUserData {
	public static boolean check(String login, String password) {
		Scanner in;
		try {
		in = new Scanner(new File("UserLoginDetails.txt"));
		while (in.hasNext()) {
			if (in.next().equals(login)) {
				if (in.next().equals(password)) {
					in.close();
					return true;
				}
			}
			System.out.println(in.next());
		}
		in.close();
		return false;
	}
		catch (Exception ex) {
			return false;
		}
	}
}
