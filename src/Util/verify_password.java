package Util;

public class verify_password {
    private int AllEnglish (String password) {
        String reg = "[a-zA-Z]+";
        if (password.matches(reg)) {
            return 1;
        } else return -1;
    }

    private int Number (String password) {
        String reg = "[0-9]";
        if (password.matches(reg)) {
            return 1;
        } else return -1;
    }

    private int Eng_Num (String password) {
        String reg = "(?![0-9a-zA-Z]+)(?![0-9A-Za-z]+)(?![A-Z0-9a-z]+)(?![A-Za-z0-9]+)(?![a-zA-Z0-9]+)(?![a-z0-9A-Z]+)";
        if (password.matches(reg)) {
            return 1;
        } else return -1;
    }

    public int verify (String password) {
        // 太短，提示少于10个字符
        if (password.length() < 10) {
            return 0;
        } else if (AllEnglish(password) == 1) { //全是英语
            return 1;
        } else if (Number(password) == 1) { //全是数字
            return 2;
        } else if (Eng_Num(password) == 1) { //字母和数字的组合
            return 3;
        } else return -1;
    }
}
