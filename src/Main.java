public class Main {
    public static void main(String[] args) {

        CallStackDebugger dbg = new CallStackDebugger();

        dbg.setMaxDepth(5);

        dbg.call("main");
        dbg.setVar("x", "10");

        dbg.call("helper");
        dbg.setVar("y", "20");

        dbg.getVar("x");
        dbg.getVar("z");

        dbg.trace();

        dbg.returnFunc();

        dbg.call("foo");
        dbg.call("bar");
        dbg.call("baz");
        dbg.call("qux");

        dbg.call("overflow");
    }
}
