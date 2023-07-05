package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

class RunTimeStack {

    private List<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial frame pointer value, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public String dump() {
        String dumpResult = new String();
        int frameNumber = this.framePointer.size();

        Vector<Integer> vector = new Vector<>(this.framePointer);
        for (int i = 0; i < frameNumber - 1; i++) {
            dumpResult += this.runTimeStack.subList(vector.get(i), vector.get(i + 1));
            dumpResult += " ";
        }

        dumpResult += this.runTimeStack.subList(vector.get(frameNumber - 1), this.runTimeStack.size());
        return dumpResult;

    }

    public int push(int value) {
        this.runTimeStack.add(value);
        return value;
    }

    public List<Integer>getCurrentFrame(){
        List<Integer> args = new ArrayList<>();
       args = runTimeStack.subList(framePointer.peek(), runTimeStack.size());
       return args;
    }

    public int peek() {
        return this.runTimeStack.get(this.runTimeStack.size() - 1);
    }

    public int pop() {

//        assert runTimeStack.size() > framePointer.peek();
//        return this.runTimeStack.remove(this.runTimeStack.size() - 1);

        if(runTimeStack.size() > framePointer.peek()){
            return this.runTimeStack.remove(this.runTimeStack.size() - 1);
        }else {
            return 0;
        }
    }

    public int store(int offsetFromFramePointer) {
        int value = this.runTimeStack.remove(this.runTimeStack.size() - 1);
        int currentFrameIndex = this.framePointer.peek();
        int targetIndex = currentFrameIndex + offsetFromFramePointer;
        this.runTimeStack.set(targetIndex, value);
        return value;
    }

    public int load(int offsetFromFramePointer) {
        int currentFrameIndex = this.framePointer.peek();
        int targetIndex = currentFrameIndex + offsetFromFramePointer;
        int value = this.runTimeStack.get(targetIndex);
        this.runTimeStack.add(value);
        return value;

    }

    public void newFrameAt(int offsetFromTopOfRunStack) {
        int currentFrameIndex = this.runTimeStack.size();
        int targetIndex = currentFrameIndex - offsetFromTopOfRunStack;
        this.framePointer.add(targetIndex);
    }

    public void popFrame() {
        int startIndex = this.framePointer.peek();
        int endIndex = this.runTimeStack.size();
        for (int i = 0; i < endIndex - startIndex; i++) {
            this.runTimeStack.remove(this.runTimeStack.size() - 1);
        }
        this.framePointer.pop();

    }

//    public static void main(String[] args) {
//        RunTimeStack rts = new RunTimeStack();
//        rts.push(1);
//        rts.push(2);
//        rts.push(3);
//        rts.push(4);
//
//        System.out.println(rts.store(2));
//        System.out.println(rts.load(0));
//        System.out.println(rts.load(1));
//        System.out.println(rts.load(2));
//        rts.newFrameAt(3);
//
//        rts.push(5);
//        rts.push(6);
//        rts.push(7);
//        rts.push(8);
//        System.out.println("================");
//        System.out.println(rts.dump());
//        rts.newFrameAt(2);
//        System.out.println(rts.dump());
//
//        System.out.println("runtimestack: ");
//        rts.runTimeStack.forEach(v -> System.out.print(v));
//        System.out.println("\n");
//        System.out.println("framepointer: ");
//        rts.framePointer.forEach(v -> System.out.print(v));
//        System.out.println("\n");
//
//        System.out.println(rts.dump());
//        rts.popFrame();
//
//
//        System.out.println("runtimestack: ");
//        rts.runTimeStack.forEach(v -> System.out.print(v));
//        System.out.println("\n");
//        System.out.println("framepointer: ");
//        rts.framePointer.forEach(v -> System.out.print(v));
//        System.out.println("\n");
//
//        System.out.println(rts.dump());
//
//        rts.popFrame();
//        System.out.println(rts.dump());
//    }
}
