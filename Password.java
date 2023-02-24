package PasswordGenerator;

public class Password {
    int passwordLength;
    private String password;
    public Password(int passwordLength) {
        this.passwordLength = passwordLength;
        createPassword(passwordLength);

    }

    public String getPassword() {
        return password;
    }
    public void createPassword(int passwordLength){
        do{
            password = "";
            for (int i = 0; i < passwordLength; i++) {
                password += getRandomChar();
            }
        }while(!this.checkPassword());

    }

    public char getRandomChar() {
        return (char) ((Math.random() * 94) + 33);
    }

    public boolean checkPassword() {
        boolean isSpecial = false;
        boolean isNumber = false;
        boolean isUpper = false;
        boolean isLower = false;
        for (int i = 0; i < this.passwordLength; i++) {
            char currChar = this.getPassword().charAt(i);
            if ((currChar > 32 && currChar < 48) || (currChar > 57 && currChar < 65) || (currChar > 90 && currChar < 97) || (currChar > 122 && currChar < 127)) isSpecial = true;
            if (currChar > 47 && currChar < 58) isNumber = true;
            if (currChar > 64 && currChar < 91) isUpper = true;
            if (currChar > 96 && currChar < 123) isLower = true;
        }
        return isSpecial && isNumber && isUpper && isLower;

    }
}
