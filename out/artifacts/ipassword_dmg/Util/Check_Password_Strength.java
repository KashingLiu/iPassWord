package Util;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check_Password_Strength {
    private String password;
    private int length;
    private int uppercase;
    private int lowercase;
    private int num_len;
    private int special_len;

    public Check_Password_Strength(String password) {
        this.password = password.replaceAll("\\s", "");
        length = this.password.length();
    }

    private int Check_Length() {
        return 4*length;
    }

    private int Check_Uppercase() {
        String reg = "[A-Z]";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(password);
        int n = 0;
        while (matcher.find()) {
            n++;
        }
        uppercase = n;
        if (n<=0) {
            return 0;
        } else {
            return (length-uppercase)*2;
        }
    }
    private int Check_Lowercase() {
        String reg = "[a-z]";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(password);
        int n = 0;
        while (matcher.find()) {
            n++;
        }
        lowercase = n;
        if (n<=0) {
            return 0;
        } else {
            return (length-lowercase)*2;
        }
    }
    private int Check_Number() {
        String reg = "[0-9]";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(password);
        int n = 0;
        while (matcher.find()) {
            n++;
        }
        num_len = n;
        if (num_len == length) {
            return 0;
        } else {
            return num_len*4;
        }
    }
    private int Check_Char() {
        special_len = length - lowercase - uppercase - num_len;
        return special_len*6;
    }
    private int Check_mid() {
        if (password.length()>2&&password.substring(0,1).matches("(?=[^a-z])[^A-Z]")&&password.substring(length-1,length).matches("(?=[^a-z])[^A-Z]")) {
            return 2*(num_len+special_len-2);
        } else if (password.length()>2&&password.substring(0,1).matches("[a-z]|[A-Z]")&&password.substring(length-1,length).matches("[a-z]|[A-Z]")) {
            return 2*(num_len+special_len);
        } else if (password.length()<=2) {
            return 0;
        } else return 2*(num_len+special_len-1);
    }
    private int LowestStandard() {
        int j = 0;
        if (this.length>=8) {
            j++;
        }
        if (this.uppercase>0) {
            j++;
        }
        if (this.lowercase > 0) {
            j++;
        }
        if (this.num_len>0) {
            j++;
        }
        if (this.special_len >0 ) {
            j++;
        }
        if (j>=4) {

        }else {
            j = 0;
        }
        return j*2;
    }
    private int Onlycase() {
        if (this.length == uppercase + lowercase ) {
            return -length;
        } else return 0;
    }
    private int Onlynum() {
        if (this.length == num_len) {
            return -length;
        } else return 0;
    }
    private int duplicate() {
        char[] chars = password.toLowerCase().toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i=0; i < chars.length; i++) {
            if (hashMap.containsKey(chars[i])) {
                hashMap.put(chars[i],hashMap.get(chars[i])+1);
            } else {
                hashMap.put(chars[i],1);
            }
        }
        int j;
        int sum = 0;
        for (Character i:hashMap.keySet()) {
            j = hashMap.get(i);
            if (j>0) {
                sum = sum + j*(j-1);
            }
        }
        return -sum;
    }
    private int dup_Upper() {
        int j=0;
        char[] c = this.password.toCharArray();
        for (int i = 0; i < c.length-1; i++) {
            if(Pattern.compile("[A-Z]").matcher(c[i]+"").find()){
                if (Pattern.compile("[A-Z]").matcher(c[i+1]+"").find()) {
                    j++;
                }
            }
        }
        return -2*j;
    }
    private int dup_Lower() {
        int j=0;
        char[] c = this.password.toCharArray();
        for (int i = 0; i < c.length-1; i++) {
            if(Pattern.compile("[a-z]").matcher(c[i]+"").find()){
                if (Pattern.compile("[a-z]").matcher(c[i+1]+"").find()) {
                    j++;
                }
            }
        }
        return -2*j;
    }
    private int dup_Num() {
        int j=0;
        char[] c = this.password.toCharArray();
        for (int i = 0; i < c.length-1; i++) {
            if(Pattern.compile("[0-9]").matcher(c[i]+"").find()){
                if (Pattern.compile("[0-9]").matcher(c[i+1]+"").find()) {
                    j++;
                }
            }
        }
        return -2*j;
    }
    private int conti_Lower() {
        int j = 0;
        char[] c = this.password.toLowerCase().toCharArray();
        for (int i = 0; i < c.length -2; i++) {
            if (Pattern.compile("[a-z]").matcher(c[i]+"").find()) {
                if (c[i+1]==c[i]+1 && c[i+2] == c[i]+2) {
                    j++;
                }
            }
        }
        return -j*3;

    }
    private int conti_Num() {
        int j = 0;
        char[] c = this.password.toLowerCase().toCharArray();
        for (int i = 0; i < c.length -2; i++) {
            if (Pattern.compile("[0-9]").matcher(c[i]+"").find()) {
                if (c[i+1]==c[i]+1 && c[i+2] == c[i]+2) {
                    j++;
                }
            }
        }
        return -j*3;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int judge() {
//        System.out.println("1   "+Check_Length());
//        System.out.println("2   "+Check_Uppercase());
//        System.out.println("3   "+Check_Lowercase());
//        System.out.println("4   "+Check_Number());
//        System.out.println("5   "+Check_Char());
//        System.out.println("6   "+Check_mid());
//        System.out.println("7   "+LowestStandard());
//        System.out.println("8   "+Onlycase());
//        System.out.println("9   "+Onlynum());
//        System.out.println("10   "+duplicate());
//        System.out.println("11   "+dup_Upper());
//        System.out.println("12   "+dup_Lower());
//        System.out.println("13   "+dup_Num());
//        System.out.println("14   "+conti_Lower());
//        System.out.println("15   "+conti_Num());
        int score = Check_Length()+Check_Uppercase()+Check_Lowercase()+Check_Number()+Check_Char()+Check_mid()
                +LowestStandard()+Onlycase()+Onlynum()+duplicate()+dup_Upper()+dup_Lower()+dup_Num()+conti_Lower()+conti_Num();
        return score;
    }
}
