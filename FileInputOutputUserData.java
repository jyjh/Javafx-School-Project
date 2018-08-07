package appMain;

import java.io.*;
import java.util.Scanner;

public class FileInputOutputUserData {
	public static boolean check(String login, String password) {
		Scanner in;
		try {
		// Must fix this line;
		in = new Scanner(new File("C:\\Users\\h1610165\\Documents\\App\\src\\appMain\\UserLoginDetails.txt"));
		while (in.hasNext()) {
			String z = in.next();
			System.out.println(z);
			if (z.equals(login)) {
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
			System.out.println("error");
			return false;
		}
	}
}
