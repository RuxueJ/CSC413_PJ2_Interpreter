package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.Scanner;

public class ReadCode implements ByteCode {
    public ReadCode(String[] args) {
    }

    @Override
    public void execute(VirtualMachine vm) {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        int numberToPush = -1;   //??????
        System.out.print("Please enter an integer:");
        while(flag) {

            String userInput = scan.nextLine();
            try {
                numberToPush = Integer.parseInt(userInput);
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("The value is not valid. Please enter again:");

                flag = true;
            }
        }
        vm.push(numberToPush);


    }
    @Override
    public String toString() {
        return "READ";
    }
}
