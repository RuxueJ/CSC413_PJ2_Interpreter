package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class DumpCode implements ByteCode {

    private boolean isOn;

    public DumpCode(String[] args) {
        if ("ON".equals(args[1])) {
            this.isOn = true;
        } else {
            this.isOn = false;
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        if (this.isOn) {
            vm.setDumpOn();
        } else {
            vm.setDumpOff();
        }
    }
}
