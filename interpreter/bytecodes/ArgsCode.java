package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class ArgsCode implements ByteCode {
    private int numberOfArgs;
    public ArgsCode(String[] args) {
        this.numberOfArgs = Integer.parseInt(args[1]);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.newFrameAt(this.numberOfArgs);
    }

    @Override
    public String toString() {
        return "ARGS " + this.numberOfArgs;
    }

    public static void main(String[] args) {
        String[] x = {"ARGS","2"};
        ArgsCode c = new ArgsCode(x);
        System.out.println(c);
    }
}
