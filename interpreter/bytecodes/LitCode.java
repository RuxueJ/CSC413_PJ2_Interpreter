package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class LitCode implements ByteCode {
    private int valueToPush;
    private String id;
    public LitCode(String[] args){
        this.valueToPush = Integer.parseInt(args[1]);
        if(args.length > 2){
            this.id = args[2];
        }
    }


    @Override
    public void execute(VirtualMachine vm) {
        vm.push(this.valueToPush);
    }

    @Override
    public String toString() {
        String base = "LIT " + this.valueToPush;
        if(this.id != null){
            base += " " + this.id + "\tint " + this.id;
        }
        return base;
    }

    public static void main(String[] args) {
        String[] x = {"LIT","1", "J"};
        LitCode c = new LitCode(x);
        System.out.println(c);
    }
}
