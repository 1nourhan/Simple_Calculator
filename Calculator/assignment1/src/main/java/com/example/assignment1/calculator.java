package com.example.assignment1;

import org.springframework.web.bind.annotation.*;

import java.util.logging.SocketHandler;
@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/print")
public class calculator<calculate> {



    String exp;
     double operand1;
     double operand2;
    String operator;

    String[] ops ;

    @GetMapping("/result")
//    public String name(@RequestParam String first){
//
//        System.out.println(first);
//        return "i will calculate expression"+""+first;
//    }
     public String convert_exp(@RequestParam String exp) {
        System.out.println(exp);
         if (exp.contains(" ")) {
             ops = exp.split(" ");
             operator = "+";
            // return "true" + exp + operator;
         } else if (exp.contains("-")) {
             ops = exp.split("-");
             operator = "-";
             //return "true" + exp + operator;
         } else if (exp.contains("×")) {
             ops = exp.split("×");
             operator = "*";
         } else if (exp.contains("÷")) {
             ops = exp.split("÷");
             operator = "/";
         }
//         else if (exp.contains("%")) {
//             ops = exp.split("%");
//             operator = "%";
//         }

         operand1 = Double.parseDouble(ops[0]);
         operand2 = Double.parseDouble(ops[1]);
       switch (operator){
             case "+":
                 operand1+=operand2;

                 break;

             case "-":
                 operand1-=operand2;
                 break;

             case "*":
                 operand1*=operand2;
                 break;

             case "/":
                 if(operand2 == 0){
                     System.out.println("E");
                     return "E";
                 }
                 else{
                     operand1/=operand2;
                     break;
                 }

//             case "%":
//                 operand1%=operand2;
//                 break;
             default: break;
         }

        String s=String.valueOf(operand1);
        System.out.println(s);
         return s;
    }


//    double x1 = Double.parseDouble(ops[0]);
//     double x2 = Double.parseDouble(ops[1]);

//  public double calculate(double x1,double x2, String oper){
//
//      System.out.println(x1);
//        return x1;
//    }
//
//    public double result(double x1){
//        System.out.println(x1);
//        return x1;
//    }



     }