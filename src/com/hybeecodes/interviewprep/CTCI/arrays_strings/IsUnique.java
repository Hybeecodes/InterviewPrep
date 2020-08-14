package com.hybeecodes.interviewprep.CTCI.arrays_strings;

// Cracking The Coding Interview > Arrays And Strings//

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//  IS Unique
public class IsUnique {
    public static void main(String[] args) {
        boolean isUnique1 = solution3("Discover");
        boolean isUnique2 = solution3("Relieve");
        System.out.println(isUnique1);
        System.out.println(isUnique2);
    }

    // Each Solution is going to be a static function

    /** This is the Brute Force Solution
     *  T = O(n^2)
     * @param s
     * @return check
     */
    static boolean solution1 (String s) {
        boolean check = true;
        for (int i =0; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    /** A more Optimal solution using HashMap
     * T = O(n), S (space) = O(n)
     * @param s
     * @return check
     */
    static boolean solution2 (String s) {
        boolean check = true;
        Set<Character> set = new HashSet<Character>();
        for (int i =0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                check = false;
                break;
            }else{
                set.add(s.charAt(i));
            }
        }
        return check;
    }

    /** A more Optimal solution by sorting first
     * T = O(n(log n)),
     * @param s
     * @return check
     */
    static boolean solution3 (String s) {
        boolean check = true;
        s = sortString(s);
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                check = false;
                break;
            }
        }
        return check;
    }

    /** A more Optimal solution using bit vector
     * T = O(n)
     * @param s
     * @return check
     */
    static boolean solution4 (String s) { // Not implemented Yet
        return false;
    }

    public static String sortString(String inputString)
    {
        // convert input string to char array
        char[] tempArray = inputString.toCharArray();

        // sort tempArray
        Arrays.sort(tempArray);

        // return new sorted string
        return new String(tempArray);
    }

}
