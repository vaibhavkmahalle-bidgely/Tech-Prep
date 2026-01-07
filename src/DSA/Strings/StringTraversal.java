package dsa.strings;

//import static java.lang.StringUTF16.charAt;

import java.util.HashMap;

public class StringTraversal {
    public static void vowelsAndConsonantsCount(String str){
        String str1 = str.toLowerCase();
        int vowels = 0, consonants = 0;
        for(int i=0; i<str.length(); i++){
            if(str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z'){
                if(str1.charAt(i) == 'a' || str1.charAt(i) == 'e' || str1.charAt(i) == 'i' || str1.charAt(i) == 'o' || str1.charAt(i) == 'u'){
                    vowels++;
                }else{
                    consonants++;
                }
            }
        }

        System.out.println("Count of vowels : "+vowels+", consonants : "+ consonants);
    }
    public static StringBuffer stringReversal(String str){
       StringBuffer st = new StringBuffer();
        for(int i=str.length()-1, j=0; i >= 0; i--,j++){
            st.append(str.charAt(i));
        }
        return st;
    }
    public static Character nonRepeatingCharacter(String str){
        // Approach : Traverse once and store the characters in hashmap
        // traverse second time and if the count = 1 return that character.
        // else return null
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0 ; i<str.length(); i++){
           map.merge(str.charAt(i),1,Integer::sum);
        }
        for(int i=0; i<str.length(); i++){
            if(map.get(str.charAt(i)) == 1){
                return str.charAt(i);
            }
        }
        return null;
    }

    public static void main(String[] args) {

        //Problem:
        //Write a function that takes a string and counts the number of vowels (a, e, i, o, u) and consonants in it. Ignore spaces and special characters.
        //Input: "hello world"
        //Output: Vowels: 3, Consonants: 7

        vowelsAndConsonantsCount("hello world");


        /*
        Problem :
        Write a function that reverses a given string without using built-in functions like StringBuilder.reverse().
        Input: "java"
        Output: "avaj"
        */

        System.out.println("Reversed string "+stringReversal("hello"));

        /*
        Problem :
        Given a string, find the first character that does not repeat. If all characters repeat, return None.
        Input:  "swiss"
        Output: "w"
        */

        System.out.println("Non repeating character of the given word : "+ nonRepeatingCharacter("swiss"));



    }
}
