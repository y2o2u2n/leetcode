package me.y2o2u2n.p392;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int ss = 0;
        int tt = 0;

        while(ss < s.length() && tt < t.length()) {
            if (s.charAt(ss) == t.charAt(tt)) {
                ss++;
                tt++;
            } else {
                tt++;
            }
        }

        return s.length() == ss;
    }
}
