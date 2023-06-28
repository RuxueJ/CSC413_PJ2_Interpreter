package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class LabelCode implements ByteCode{
    private String label;
    public LabelCode(String[] args){
        this.label = args[1];
    }

    public String getLabel() {
        return label;
    }

    @Override
    public void execute(VirtualMachine vm) {

    }

    @Override
    public String toString() {
        return "LABEL " + this.label;
    }
}
