import org.junit.Test;

public class test {

    @Test
    public void arr(){
        long[][] arr;


        long sum = 0;
        arr = new long[1024 * 1024][8];
        // 横向遍历
        long marked = System.currentTimeMillis();
        for (int i = 0; i < 1024 * 1024; i += 1) {
            for (int j = 0; j < 8; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println("Loop times:" + (System.currentTimeMillis() - marked)+ "ms");

        marked = System.currentTimeMillis();
        // 纵向遍历
        for (int i = 0; i < 8; i += 1) {
            for (int j = 0; j < 1024 * 1024; j++) {
                sum += arr[j][i];
            }
        }
        System.out.println("Loop times:" + (System.currentTimeMillis() - marked)+ "ms");
    }

    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }
        int n = s.length();
        int maxLen = 1;
        String res = s.substring(0,1);

        int curlen = 2;
        while (curlen <= n) {
            int start = 0;
            while (start + curlen <= n) {
                String subStr = s.substring(start, curlen);
                if (isPalindrome(subStr)) {
                    res = subStr;
                    maxLen = curlen;
                    break;
                }
                start++;
            }
            curlen++;
        }

        return res;
    }

    public boolean isPalindrome(String str) {
        int len = str.length();
        int left = 0, right = len - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(this.longestPalindrome("babad"));
    }
}
