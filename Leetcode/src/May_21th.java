public class May_21th {
	//翻转字符串
    public static String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
			//确定边界
            int i = start, j = Math.min(start + k - 1, a.length - 1);
			//交换完成翻转
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }

    public static void main(String[] args) {
        System.out.println(May_21th.reverseStr("abcdefg", 3));
    }
}
