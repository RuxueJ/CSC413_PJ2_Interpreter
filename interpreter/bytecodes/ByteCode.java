package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public interface ByteCode {

    void execute(VirtualMachine vm);
    static ByteCode getNewInstance(String type, String[] args) {
        return switch (type) {
            case "LIFT" -> new LitCode(args);
            case "HALT" -> new HaltCode(args);
            case "POP" -> new PopCode(args);
            case "STORE" -> new StoreCode(args);
            case "LOAD" -> new LoadCode(args);
            case "ARGS" -> new ArgsCode(args);
            case "LABEL" -> new LabelCode(args);
            case "GOTO" -> new GotoCode(args);
            case "CALL" -> new CallCode(args);
            case "FALSEBRANCH" -> new FalseBranchCode(args);
            default -> throw new IllegalArgumentException();
        };
    }
}

