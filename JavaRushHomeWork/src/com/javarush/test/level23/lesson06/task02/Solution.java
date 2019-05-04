package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.CONSTANT_A);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.CONSTANT_A, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.CONSTANT_B);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.CONSTANT_B, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.CONSTANT_C);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.CONSTANT_C, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.CONSTANT_D);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.CONSTANT_D, cause);
        }
    }

    public static final class Constants {
        static String CONSTANT_A = "Server is not accessible for now.";
        static String CONSTANT_B = "User is not authorized.";
        static String CONSTANT_C = "User is banned.";
        static String CONSTANT_D = "Access is denied.";
    }
}
