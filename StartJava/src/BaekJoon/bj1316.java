package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1316 {
	static int N;
	static String[] str;

	public static void main(String[] args) throws IOException {
		bj1316 b = new bj1316();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		str = new String[N];

		for (int i = 0; i < str.length; i++) {
			str[i] = br.readLine();
		}

		b.strCh(str);

	}

	public void strCh(String[] s) {
		int cnt = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i].length() == 1 || s[i].length() == 2) {
				cnt++;
				continue;
			}

			String st = String.valueOf(s[i].charAt(0));
			char tmp = s[i].charAt(0);

			for (int j = 1; j < s[i].length(); j++) {

				if (tmp == s[i].charAt(j)) {
					if (j == s[i].length() - 1) {
						cnt++;
						break;
					}
					continue;
				} else if (tmp != s[i].charAt(j)) {
					if (st.contains(String.valueOf(s[i].charAt(j)))) {
						break;
					} else {
						if (j == s[i].length() - 1) {
							cnt++;
							break;
						}

						st = st.concat(String.valueOf(s[i].charAt(j)));
						tmp = s[i].charAt(j);
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
