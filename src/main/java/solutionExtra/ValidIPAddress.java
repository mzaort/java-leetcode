package solutionExtra;

public class ValidIPAddress {

	public static void main(String[] args) {
		ValidIPAddress va = new ValidIPAddress();
		System.out.println(va.transform("54.34.24.32"));
	}

	/**
	 * @param IP
	 * @return ����һ�����IP��ַ��ʾ��д���������ת������Ӧ��32λ���޷��������������������벻�ǺϷ����ݣ��ͷ���0.
	 */
	public int transform(String IP) {
		int ilen = IP.length();
		if (ilen < 7) return 0;

		for (int i = 0; i < ilen; i++) {
			char ch = IP.charAt(i);
			if (!(ch == '.' || (ch >= '0' && ch <= '9'))) return 0;
		}

		String[] str = IP.split("\\.");
		int len = str.length;
		if (len != 4) return 0;

		int res = 0;
		for (int i = len - 1; i >= 0; i--) {
			res = res << 8;
			if (str[i].length() > 3) return 0;
			int tmp = Integer.parseInt(str[i]);
			if (str[i].equals("" + tmp) && tmp >= 0 && tmp <= 255) {
				res += tmp;
			} else {
				return 0;
			}
		}
		return res;
	}
}
