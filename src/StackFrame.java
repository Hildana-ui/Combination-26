import java.util.HashMap;
import java.util.Map;

class StackFrame {
    String functionName;
    Map<String, String> locals;
    int returnAddress;
    StackFrame caller;

    StackFrame(String functionName, int returnAddress, StackFrame caller) {
        this.functionName = functionName;
        this.returnAddress = returnAddress;
        this.caller = caller;
        this.locals = new HashMap<>();
    }
}


