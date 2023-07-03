package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class CallCode implements JumpCode {
    private String label;
    private int resolvedAddress;

    public CallCode(String[] args) {
        this.label = args[1];
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.gotoAddress(this.resolvedAddress);
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
