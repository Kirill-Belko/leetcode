import java.math.BigInteger;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger bi1 = new BigInteger(getNumber(l1));
        BigInteger bi2 = new BigInteger(getNumber(l2));
        BigInteger sum = bi1.add(bi2);
        String sumStr = sum.toString();

        int[] sumArr = new int[sumStr.length()];
        char[] charArr = sumStr.toCharArray();
        for (int i = 0; i < sumStr.length(); i++) {
            sumArr[i] = Character.getNumericValue(charArr[i]);
        }

        ListNode res = null;
        return getResult(res, sumArr, sumArr.length-1);
    }

    public static String getNumber(ListNode ln) {
        String valStr = String.valueOf(ln.val);
        if (ln.next != null) {
            valStr = getNumber(ln.next) + valStr;
        }
        return valStr;
    }

    public static ListNode getResult(ListNode ln, int[] sumArr, int idx) {
        if (idx >= 0) {
            ln = new ListNode(sumArr[idx--], getResult(ln, sumArr, idx));
        }

        return ln;
    }
}
