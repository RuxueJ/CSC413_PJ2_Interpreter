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

    }

    @Override
    public String getLable() {
        return this.label;
    }

    @Override
    public void setAddress(int address) {
        this.resolvedAddress = address;
    }
}
