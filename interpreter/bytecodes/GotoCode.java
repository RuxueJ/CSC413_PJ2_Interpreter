package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class GotoCode implements JumpCode {
    private String label;
    private int resolvedAddress;
    public GotoCode(String[] args) {
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
    @Override
    public String toString() {
        return "GOTO " + this.label;
    }
}
