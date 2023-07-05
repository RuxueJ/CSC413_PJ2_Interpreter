package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class ReturnCode implements ByteCode {
    private String id;
    private String base_id;
    private int value;

    public ReturnCode(String[] args) {
        if (args.length > 1) {
            this.id = args[1];
            int index = id.indexOf("<<");
            this.base_id = id.substring(0, index);


        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        int retVal = vm.pop();
        this.value = retVal;
        vm.popFrame();
        vm.push(retVal);
        vm.popReturnAddress();
    }

    @Override
    public String toString() {
        String base = "RETURN ";
        if(this.id != null){
            base += " " + this.id + "\tEXIT: " + this.base_id + " : " + this.value;
        }
        return base;
    }
}
