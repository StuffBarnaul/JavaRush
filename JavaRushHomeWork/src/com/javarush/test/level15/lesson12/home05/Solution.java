package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    public Solution(Character f) {}
    public Solution(Object i) {}
    public Solution(String i) {}
    protected Solution(Integer i) {}
    protected Solution(Double i) {}
    protected Solution(Float i) {}
    Solution(char i) {}
    Solution(int i) {}
    Solution(double i) {}
    private Solution(float i) {}
    private Solution(byte i) {}
    private Solution(short i) {}
}

