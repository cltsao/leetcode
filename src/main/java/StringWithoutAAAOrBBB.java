public class StringWithoutAAAOrBBB {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        boolean nextA = a > b;
        while(a > 0 || b > 0) {
            if(nextA) {
                if (a > b && a > 1) {
                    sb.append("aa");
                    a -= 2;
                } else {
                    sb.append('a');
                    --a;
                }
            } else {
                if (b > a && b > 1) {
                    sb.append("bb");
                    b -= 2;
                } else {
                    sb.append('b');
                    --b;
                }
            }
            nextA = !nextA;
        }
        return sb.toString();
    }
}
