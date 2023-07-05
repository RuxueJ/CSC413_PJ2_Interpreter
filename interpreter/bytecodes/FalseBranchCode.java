package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class FalseBranchCode implements JumpCode {

    private String label;
    private int resolvedAddress;

    public FalseBranchCode(String[] args) {
        this.label = args[1];
    }

    @Override
    public void execute(VirtualMachine vm) {
        int topValue = vm.pop();
        if(topValue == 0){
            vm.gotoAddress(this.resolvedAddress);
        }

    }

    @Override
    public String getLable() {
        return this.label;
    }

    @Override
    public void setAddress(int address) {
        this.resolvedAddress = address;
    }

    @Override
    public String toString() {
        return "FALSEBRANCH " + this.label;
    }
}
