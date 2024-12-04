package pro.dadadaa.dadadaa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CalculatorControler {
    private final CalculatorService calculatorService;
    public CalculatorControler(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }
    @GetMapping
    public String hello(){
        return calculatorService.hello();
    }
    @GetMapping(path = "/calculator")
    public String calculator(){
        return calculatorService.helloCalculator();
    }
    @GetMapping(path = "/calculator/plus")
    public String calculatorPlus(@RequestParam("num1") int firstNum, @RequestParam("num2") int secondNum){
        return calculatorService.plus(firstNum,secondNum);
    }
    @GetMapping(path = "/calculator/minus")
    public String calculatorMinus(@RequestParam("num1") int firstNum, @RequestParam("num2") int secondNum){
        return calculatorService.minus(firstNum,secondNum);
    }
    @GetMapping(path = "/calculator/multiply")
    public String calculatorMultiply(@RequestParam("num1") int firstNum, @RequestParam("num2") int secondNum){
        return calculatorService.multiply(firstNum,secondNum);
    }
    @GetMapping(path = "/calculator/divide")
    public String calculatorDivide(@RequestParam("num1") int firstNum, @RequestParam("num2") int secondNum){
        return calculatorService.divide(firstNum,secondNum);
    }


}
