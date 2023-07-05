package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class BopCode implements ByteCode {

    private String operator;
    public BopCode(String[] args) {
        this.operator = args[1];
    }

    @Override
    public void execute(VirtualMachine vm) {
        int secondOperand = vm.pop();
        int firstOperand = vm.pop();
        int retVal;
        switch (this.operator){
            case "+":
                retVal = firstOperand + secondOperand;
                break;
            case "-":
                retVal = firstOperand - secondOperand;
                break;
            case "*":
                retVal = firstOperand * secondOperand;
                break;
            case "/":
                retVal = firstOperand / secondOperand;
                break;
            case "==":
                if(firstOperand == secondOperand){
                    retVal = 1;
                }else {
                    retVal = 0;
                }
                break;
            case "!=":
                if(firstOperand == secondOperand){
                    retVal = 0;
                }else {
                    retVal = 1;
                }
                break;
            case "<=":
                if(firstOperand <= secondOperand){
                    retVal = 1;
                }else {
                    retVal = 0;
                }
                break;
            case "<":
                if(firstOperand < secondOperand){
                    retVal = 1;
                }else {
                    retVal = 0;
                }
                break;
            case ">=":
                if(firstOperand >= secondOperand){
                    retVal = 1;
                }else {
                    retVal = 0;
                }
                break;
            case ">":
                if(firstOperand > secondOperand){
                    retVal = 1;
                }else {
                    retVal = 0;
                }
                break;
            case "&":
                if(firstOperand!=0 && secondOperand!=0){
                    retVal = 1;
                }else {
                    retVal = 0;
                }
                break;
            case "|":
                if(firstOperand==0 || secondOperand==0){
                    retVal = 1;
                }else {
                    retVal = 0;
                }
                break;
            default:retVal = 0;
        }
        vm.push(retVal);

    }

    @Override
    public String toString() {
        return "BOP" + this.operator;
    }
}
