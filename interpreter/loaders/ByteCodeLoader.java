package interpreter.loaders;

import interpreter.bytecodes.ByteCode;
import interpreter.virtualmachine.Program;

import java.io.*;
import java.util.Arrays;

public final class ByteCodeLoader {
    private String codSourceFileName;

    /**
     * Constructs ByteCodeLoader object given a COD source code
     * file name
     *
     * @param fileName name of .cod File to load.
     */
    public ByteCodeLoader(String fileName) {
        this.codSourceFileName = fileName;
    }

    /**
     * Loads a program from a .cod file.
     *
     * @return a constructed Program Object.
     * @throws InvalidProgramException thrown when
     *                                 loadCodes fails.
     */
    public Program loadCodes() throws InvalidProgramException {
        Program program;
        try (BufferedReader reader = new BufferedReader(new FileReader(this.codSourceFileName))) {
            String line;
            String[] items;
            String bytecodename;
            ByteCode bc;
            program = new Program();
            while (reader.ready()) {
                line = reader.readLine();
                items = line.split("\\s+");
                bytecodename = items[0];
                bc = ByteCode.getNewInstance(bytecodename, items);
                program.addByteCode(bc);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return program;
    }
}
