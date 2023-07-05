package interpreter.bytecodes;

import interpreter.Interpreter;
import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class CallCode implements JumpCode {
    private String id;
    private String base_id;


    private int resolvedAddress;
    private List<Integer> argsList ;

    public CallCode(String[] args) {
        this.id = args[1];
        if(id.contains("<<")){
            int index = id.indexOf("<<");
            base_id = id.substring(0,index);
        }else{
            base_id = id;
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        this.argsList = vm.getArgs();
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

        String arguments = this.argsList.toString().substring(1,this.argsList.toString().length()-1);
        return "CALL " + this.id + "\t" + base_id + "(" +arguments + ")";
    }
}
