package com.javarush.test.level21.lesson02.task02;

/* Сравниваем модификаторы
Реализовать логику метода isAllModifiersContainSpecificModifier, который проверяет,
содержит ли переданный параметр allModifiers значение конкретного модификатора specificModifier
*/

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Solution {
    public static void main(String[] args) {
        int modifiersOfThisClass = Solution.class.getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.PUBLIC));   //true
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.STATIC));   //false

        int modifiersOfMethod = getMainMethod().getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfMethod, Modifier.STATIC));      //true
    }

    public static boolean isAllModifiersContainSpecificModifier(int allModifiers, int specificModifier) {
        if ((allModifiers & specificModifier) > 0) return true;
        return false;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }
        return null;
    }
}
