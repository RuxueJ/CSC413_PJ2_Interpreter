package interpreter.bytecodes;

public interface JumpCode extends ByteCode {
    String getLable();
    void setAddress(int address);
}
