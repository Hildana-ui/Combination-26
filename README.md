Call Stack Debugger Simulator (Java)

This project is a Java-based simulation of a function call stack, similar to what exists inside a real programming language runtime or debugger.

It models:

Function calls and returns

Local variable scopes

Scope chain variable lookup

Stack trace visualization

Stack overflow detection

The simulator is controlled entirely through method calls or CLI-style commands, making it ideal for learning and debugging data structure behavior.

🎯 Purpose of the Project

The goal of this project is to demonstrate:

How a call stack works internally

How stack frames store function state

How variable scope resolution occurs

How stack overflow errors are detected

Practical use of core data structures in Java

This project is especially useful for:

Data Structures students

Debugger and runtime system learners

Interview preparation

🧱 System Design

Each function call creates a stack frame that stores its execution context.

Stack Frame Contains:

Function name

Local variables

Return address (simulated)

Reference to the caller frame (scope chain)

🧩 Data Structures Used
Data Structure	Purpose
Stack<StackFrame>	Represents the call stack
HashMap<String, String>	Stores local variables per function
Linked frame reference	Enables scope chain traversal
⚙️ Supported Operations
Command	Description
CALL <function>	Push a new function frame onto the stack
RETURN	Pop the current function frame
SET <var> <value>	Set a local variable in the current frame
GET <var>	Retrieve a variable using scope chain lookup
TRACE	Print the full stack trace
SET_MAX_DEPTH <d>	Set maximum stack depth
