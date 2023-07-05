package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class CallCode implements JumpCode {
    private String id;
    private String base_id;
    private int args_number;

    private int resolvedAddress;
    private List<Integer> argsList;

    public CallCode(String[] args) {
        this.id = args[1];
//        int indexStart = id.indexOf("<<");
//        int indexEnd = id.indexOf(">>");
//        String number = id.substring(indexStart+2,indexEnd);
//        args_number = Integer.parseInt(number);
//        for(int i = 0; i < args_number; i++){
//
//        }


    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.saveReturnAddress();
        vm.gotoAddress(this.resolvedAddress);
    }

    @Override
    public String getLable() {
        return this.id;
    }

    @Override
    public void setAddress(int address) {
        this.resolvedAddress = address;
    }

    @Override
    public String toString() {

        return "CALL " + this.id;
    }
}
