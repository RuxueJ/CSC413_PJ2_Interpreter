package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class PopCode implements ByteCode {
    private int numbersToPop;
    public PopCode(String[] args) {
        this.numbersToPop = Integer.parseInt(args[1]);
    }

    @Override
    public void execute(VirtualMachine vm) {
        for(int i = 0; i < this.numbersToPop; i++){
            vm.pop();
        }
    }

    @Override
    public String toString() {
        return "POP " + numbersToPop;
    }

//    public static void main(String[] args) {
//        String[] x = {"POP","1"};
//        PopCode c = new PopCode(x);
//        System.out.println(c);
//    }
}
