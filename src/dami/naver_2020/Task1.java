package dami.naver_2020;

public class Task1 {

	public String task1(String m, String k) {
		StringBuilder decode = new StringBuilder();
		StringBuilder encode = new StringBuilder(m);
		char[] kChars = k.toCharArray();

		for (int i = 0; i < k.length(); i++) {
			int index = encode.indexOf(String.valueOf(kChars[i]));
			if (index != 0) {
				decode.append(encode.substring(0, index));
			}
			encode.replace(0, encode.length(), encode.substring(index+1));
		}

		decode.append(encode);
		return decode.toString();
	}

}
