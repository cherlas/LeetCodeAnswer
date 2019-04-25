package cn.istarx.java;

import java.util.*;
import java.util.regex.Pattern;

public class NO93_RestoreIpAddresses {
	public static void main(String[] args) {
		String s = "25525511135";
		System.out.println(restoreIpAddresses(s));
	}
	private static List<String> restoreIpAddresses(String s) {
		if (s.length() > 12 || s.length() < 4 || Pattern.matches("^0-9", s)) {
			return new ArrayList<String>();
		}
		
		String p = "^(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
		System.out.println(Pattern.compile(p).matcher(s).matches());
		return new ArrayList<>();
	}
}