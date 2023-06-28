package interpreter.virtualmachine;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;

    public VirtualMachine(Program program) {
        this.program = program;
        this.runTimeStack = new RunTimeStack();
        this.returnAddress = new Stack<>();
        this.programCounter = 0;
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

    // a list of functions that is going to expose to the ByteCode


}
