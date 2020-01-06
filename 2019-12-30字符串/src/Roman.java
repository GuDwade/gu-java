public class Roman {
    private static int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public  static int romanToInt(String s) {
        int num = 0;
        while (!s.isEmpty()) {
            for (int i = 0; i < roman.length; i++) {
                if (s.startsWith(roman[i])) {
                    num += nums[i];
                    s = s.substring(roman[i].length());
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("DXC"));
    }
}
