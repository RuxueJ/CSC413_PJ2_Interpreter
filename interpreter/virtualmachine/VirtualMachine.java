package interpreter.virtualmachine;

import interpreter.bytecodes.ByteCode;
import interpreter.bytecodes.DumpCode;
import interpreter.bytecodes.HaltCode;

import java.util.List;
import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runTimeStack;
    private Stack<Integer> returnAddress;
    private Program program;
    private int programCounter;
    private boolean isRunning;

    private boolean isDumpOn;

    public VirtualMachine(Program program) {
        this.program = program;
        this.runTimeStack = new RunTimeStack();
        this.returnAddress = new Stack<>();
        this.programCounter = 0;
    }

    public void setDumpOn() {
        this.isDumpOn = true;
    }

    public void setDumpOff() {
        this.isDumpOn = false;
    }

    public void saveReturnAddress() {
        this.returnAddress.add(this.programCounter);
    }

    public void popReturnAddress() {
        this.programCounter = this.returnAddress.pop();
    }

    public void halt() {
        this.isRunning = false;
    }


    public int push(int valueToPush) {
        this.runTimeStack.push(valueToPush);
        return valueToPush;
    }

    public int pop() {
        return this.runTimeStack.pop();
    }

    public int store(int offset) {
        return this.runTimeStack.store(offset);
    }

    public int load(int offset) {
        return this.runTimeStack.load(offset);
    }

    public void newFrameAt(int numberOfArgs) {
        this.runTimeStack.newFrameAt(numberOfArgs);
    }

    public void executeProgram() {
        isRunning = true;
        while (isRunning) {
            ByteCode code = program.getCode(programCounter);
            code.execute(this);

            if (!(code instanceof HaltCode) && !(code instanceof DumpCode) && this.isDumpOn) {
                System.out.println(code);
                System.out.println(this.runTimeStack.dump());
            }

            programCounter++;
        }
    }

    public void gotoAddress(int resolvedAddress) {
        this.programCounter = resolvedAddress;
    }

    public int peek() {
        return this.runTimeStack.peek();
    }

    public void popFrame() {
        this.runTimeStack.popFrame();
    }

    public List<Integer> getArgs() {
        return this.runTimeStack.getCurrentFrame();

    }


    // a list of functions that is going to expose to the ByteCode


}
