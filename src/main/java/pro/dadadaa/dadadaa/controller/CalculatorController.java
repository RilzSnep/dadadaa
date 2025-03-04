package pro.dadadaa.dadadaa.controller;

import org.springframework.web.bind.annotation.*;
import pro.dadadaa.dadadaa.Service.CalculatorServiceImpl;
import pro.dadadaa.dadadaa.exeption.DivisionByZeroException;


@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorServiceImpl calculatorService;

    public CalculatorController(CalculatorServiceImpl calculatorService) {
        this.calculatorService = calculatorService;
    }


    @GetMapping
    public String hello() {
        return calculatorService.helloCalculator();
    }

    @GetMapping(path = "/calculator/plus")
    public String calculatorPlus(@RequestParam Integer num1, @RequestParam Integer num2) {
        return calculatorService.plus(num1, num2);
    }

    @GetMapping(path = "/calculator/minus")
    public String calculatorMinus(@RequestParam Integer num1, @RequestParam Integer num2){
        return calculatorService.minus(num1, num2);
    }

    @GetMapping(path = "/calculator/multiply")
    public String calculatorMultiply(@RequestParam Integer num1, @RequestParam Integer num2) {
        return calculatorService.multiply(num1, num2);
    }

    @GetMapping(path = "/calculator/divide")
    public String calculatorDivide(@RequestParam Integer num1, @RequestParam Integer num2) {
        return calculatorService.divide(num1, num2);
    }
    @ExceptionHandler(DivisionByZeroException.class)
    public String handleDivisionByZero(DivisionByZeroException e) {
        return e.getMessage();
    }
}



