/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int countChar = 0 ;
        for (int i = 0; i < str.length(); i++) {
            if (ch == str.charAt(i)){
                countChar++ ;
            }   
        }
        return countChar ;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        String copyStr2 = str2;
        for (int i=0; i<str1.length(); i++) {
            if (countChar(copyStr2, str1.charAt(i)) == 0) {
                return false;
            } else {
                for 
                (int j=0; j<copyStr2.length(); j++) {
                    if (str1.charAt(i) == copyStr2.charAt(j)) {
                        if (j == 0) {
                            copyStr2 = copyStr2.substring(1);
                        } else if (j == (copyStr2.length()-1)) {
                            copyStr2 = copyStr2.substring(0 , j);
                        } else {
                            copyStr2 = copyStr2.substring(0 , j) + copyStr2.substring(j+1);
                        }
                    }
                }
            }
        }
     return true;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String spacedString = "" ;
        for (int i = 0; i < str.length() ; i++) {
            spacedString = spacedString + str.charAt(i) ;
            if (str.length() - 1 != i){
                spacedString = spacedString + " " ;
            }
        }
        return spacedString ;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String randomString = "" ; 
        
        for (int i = 0 ; i < n ; i++) {
            char ch = (char)(Math.random()*26 + 97) ;
            randomString = randomString + ch ;
        }
        return randomString;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        String newStr = "";
        int l1=str1.length();
        int l2=str2.length();
        if (str2.isEmpty()) {
            return str1;
        }
        if (str2.equals(str1)) {
            return "";
        }
        boolean[] used = new boolean[l2];
        for (int i=0;i<l1;i++) {
            boolean match = false;
            for (int j=0;j<l2;j++) {
                if (!used[j] && str1.charAt(i) == str2.charAt(j)){
                    used[j]=true;
                    match = true;
                    break;
                }
            }
            if (match == false) {
                newStr = newStr + str1.charAt(i);
            }
        }
        return newStr;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index of between 0 and str.lenghth() 
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result.toLowerCase();
    }    
}
