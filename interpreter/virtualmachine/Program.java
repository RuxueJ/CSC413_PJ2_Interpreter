package interpreter.virtualmachine;

import interpreter.bytecodes.*;
import interpreter.loaders.ByteCodeLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

    private List<ByteCode> program;

    /**
     * Instantiates a program object using an
     * ArrayList
     */
    public Program() {
        program = new ArrayList<>();

    }

    /**
     * Gets the size of the current program.
     * @return size of program
     */
    public int getSize() {
        return this.program.size();
    }

    /**
     * Grabs an instance of a bytecode at an index.
     * @param programCounter index of bytecode to get.
     * @return a bytecode.
     */
    public ByteCode getCode(int programCounter) {

        return this.program.get(programCounter);
    }

    /**
     * Adds a bytecode instance to the Program List.
     * @param c bytecode to be added
     */
    public void addByteCode(ByteCode c) {
        this.program.add(c);
    }

    /**
     * Makes multiple passes through the program ArrayList resolving
     * address for Goto,Call and FalseBranch bytecodes. These bytecodes
     * can only jump to Label codes that have a matching label value.
     * HINT: make note of what type of data-structure ByteCodes are stored in.
     * **** METHOD SIGNATURE CANNOT BE CHANGED *****
     */
    public void resolveAddress() {
        HashMap<String, Integer> labelHM = new HashMap<>();
        for(int i = 0; i < this.program.size(); i++){
            ByteCode bc = this.program.get(i);

            if(bc instanceof LabelCode byteCode){
                labelHM.put(byteCode.getLabel(),i);
            }
        }

        // print out the resolved address map
//        for (Map.Entry<String, Integer> entry : labelHM.entrySet()) {
//            String key = entry.getKey();
//            Integer value = entry.getValue();
//            System.out.println(key + ": " + value);
//        }




        for (ByteCode bc : this.program) {
            if (bc instanceof GotoCode || bc instanceof FalseBranchCode || bc instanceof CallCode) {
                JumpCode jc = (JumpCode) bc;
                String label = jc.getLable();
                int address = labelHM.get(label);
                jc.setAddress(address);
            }
        }

    }
}