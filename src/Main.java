import skypro.WrongPasswordException;
import skypro.WrongLoginException;

public class Main {
    public static void main(String[] args) {
        validateCredentials("qwe", "pass", "pass");
        validateCredentials("!qwe", "pass", "pass");
        validateCredentials("qwe", "pass!", "pass");
        validateCredentials("ashdkjahskjdhaksjdhkjashdjkashdkjhkaskjdh", "pass", "pass");
        validateCredentials("login", "pass", "passs");

    }

    private static void checkLogin(String login) {
        if (hasLengthMoreThan(login, 20) || isNonAlphaNumeric(login)) {
            throw new WrongLoginException("Login is wrong");
        }

    }

    private static void checkPassword(String password, String repeatPassword) {
        if (hasLengthMoreThan(password, 20) || isNonAlphaNumeric(password) || stringNotEquals(password, repeatPassword)) {
            throw new WrongPasswordException("Password is wrong");
        }
    }

    private static boolean validateCredentials(String login, String password, String repeatPassword) {
        try {
            checkLogin(login);
            checkPassword(password, repeatPassword);
            return true;
        } catch (WrongLoginException e) {
            System.out.println("Invalid login: " + e.getMessage());
            return false;
        } catch (WrongPasswordException e) {
            System.out.println("Invalid password: " + e.getMessage());
            return false;
        }
    }

    private static boolean stringNotEquals(String value, String value2) {
        return value.equals(value2);
    }

    private static boolean isNonAlphaNumeric(String string) {
        final String alphabet = "qwertyuiopasdfghjklzxcvbnm1234567890_";
        for (int i = 0; i < string.length(); i++) {
            if (!alphabet.contains(String.valueOf(string.charAt(i)).toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasLengthMoreThan(String string, int length) {
        return string.length() > length;
    }
}