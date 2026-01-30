import java.util.Stack;

public class CallStackDebugger {

    private Stack<StackFrame> stack = new Stack<>();
    private int maxDepth = 0;
    private int currentLine = 1; // simulated return address

    // ---------- CONFIG ----------
    public void setMaxDepth(int d) {
        maxDepth = d;
        System.out.println("Max stack depth set to " + d + ".");
    }

    // ---------- STACK OPERATIONS ----------
    public void call(String functionName) {
        if (stack.size() >= maxDepth) {
            System.out.println(
                    "Error: Stack Overflow! Max depth (" + maxDepth + ") exceeded."
            );
            return;
        }

        StackFrame caller = stack.isEmpty() ? null : stack.peek();
        StackFrame frame = new StackFrame(functionName, currentLine++, caller);
        stack.push(frame);

        System.out.println(
                "Entered: " + functionName + ". Depth: " + stack.size() + "."
        );
    }

    public void returnFunc() {
        if (stack.isEmpty()) {
            System.out.println("Error: No function to return from.");
            return;
        }

        StackFrame exited = stack.pop();
        String current =
                stack.isEmpty() ? "None" : stack.peek().functionName;

        System.out.println(
                "Returned from " + exited.functionName +
                        ". Depth: " + stack.size() +
                        ". Current: " + current + "."
        );
    }

    // ---------- VARIABLE OPERATIONS ----------
    public void setVar(String var, String value) {
        if (stack.isEmpty()) {
            System.out.println("Error: No active function.");
            return;
        }

        stack.peek().locals.put(var, value);
        System.out.println(
                var + " = " + value + " in " + stack.peek().functionName + "."
        );
    }

    public void getVar(String var) {
        if (stack.isEmpty()) {
            System.out.println("Error: No active function.");
            return;
        }

        StackFrame frame = stack.peek();

        while (frame != null) {
            if (frame.locals.containsKey(var)) {
                System.out.println(
                        var + " = " + frame.locals.get(var) +
                                " (found in " + frame.functionName + ")."
                );
                return;
            }
            frame = frame.caller;
        }

        System.out.println(
                "Error: Variable '" + var + "' not found in scope chain."
        );
    }

    // ---------- DEBUG ----------
    public void trace() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Stack Trace:");
        for (int i = stack.size() - 1; i >= 0; i--) {
            StackFrame frame = stack.get(i);
            String current = (i == stack.size() - 1) ? " (current)" : "";

            System.out.println(
                    "  [" + (i + 1) + "] " + frame.functionName + current
            );

            for (String key : frame.locals.keySet()) {
                System.out.println(
                        "      " + key + " = " + frame.locals.get(key)
                );
            }
        }
    }
}
