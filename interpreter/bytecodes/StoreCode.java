package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class StoreCode implements ByteCode {
    private int offset;
    private String id;
    private int valuePopped;
    public StoreCode(String[] args) {
        this.offset = Integer.parseInt(args[1]);
        if(args.length > 2){
            this.id = args[2];
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
       this.valuePopped = vm.store(offset);
    }

    @Override
    public String toString() {
        String base = "STORE " + this.offset;
        if(this.id != null){
            base += " " + this.id +" \t" + this.id + "=" + this.valuePopped;
        }
        return base;
    }

    public static void main(String[] args) {
        String[] x = {"STORE","1", "K"};
        StoreCode c = new StoreCode(x);
        System.out.println(c);
    }
}
