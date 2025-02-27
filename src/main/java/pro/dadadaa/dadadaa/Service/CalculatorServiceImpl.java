package pro.dadadaa.dadadaa.Service;

public class CalculatorServiceImpl {

    public String helloCalculator() {
        return "<h1>Добро пожаловать в калькулятор</h1>";
    }

    public String plus(int firstNum, int secondNum) {
        int total = firstNum + secondNum;
        return firstNum + " + " + secondNum + " = " + total;
    }

    public String minus(int firstNum, int secondNum) {
        int total = firstNum - secondNum;
        return firstNum + " - " + secondNum + " = " + total;
    }

    public String multiply(int firstNum, int secondNum) {
        int total = firstNum * secondNum;
        return firstNum + " * " + secondNum + " = " + total;
    }

    public String divide(int firstNum, int secondNum) {
        if (secondNum != 0) {
            int total = firstNum / secondNum;
            return firstNum + " / " + secondNum + " = " + total;
        } else {
            return "<h1>На ноль делить нельзя</h1>";
        }

    }
}