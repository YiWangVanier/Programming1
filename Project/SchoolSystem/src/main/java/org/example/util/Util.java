package org.example.util;

public class Util {
    /**
     * converts a string to title case.
     * @param strIn input string
     * @return string with each word in title case
     */
    public static String toTitleCase(String strIn) {
        String[] strs = strIn.split(" ");

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            strs[i] = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        }

        String strOut = "";
        for (String name : strs)
            strOut += name + " ";

        return strOut.substring(0, strOut.length() - 1);
    }
}
