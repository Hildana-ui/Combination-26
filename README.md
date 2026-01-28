# Combination 26
___________________________________________________________________________________________
This repository contains implementations of multiple data-structure-driven system simulators, each designed to model a real-world problem while enforcing strict performance and structural constraints.

The goal of these projects is to demonstrate:
- Correct data structure selection
 - Efficient algorithmic design
- Practical CLI-based interaction
- Clear state visualization and debugging

📁 Problems Included

🔹 Problem 21: Real-Time Median Monitor 
______________________________________________________________________________________
Tracks the median of a real-time stream of integer values with optimal performance.

Key Concepts
- Streaming data
- Online median calculation
- Heap balancing

Data Structures Used
- Max-Heap (lower half of numbers)
- Min-Heap (upper half of numbers)

Performance Guarantees
- Insertion: O(log N)
- Median retrieval: O(1)

🔹 Problem 31: VIP Restaurant Manager 
___________________________________________________________________________________________

Manages a waiting line where VIPs, walk-ins, and cancellations must be handled efficiently.

Planned Data Structures

Doubly Linked List

Hash Map for O(1) removals

🔹 Problem 54: Call Stack Debugger Simulator 
____________________________________________________________________________________________

Simulates a function call stack with variable scopes and stack overflow detection.

Planned Data Structures

Stack of frames

Hash Map per frame

Optional Linked List for scope traversal

🚀 How to Run 
______________________________________________________________________________
(Problem 21: Real-Time Median Monitor)

In the terminal:
▶️ Compile

  javac MedianMonitor.java

▶️ Run

  java MedianMonitor

💬 CLI Commands
Command	Description
ADD <value>	- Inserts a number into the data stream
MEDIAN	- Prints the current median
DEBUG	- Shows contents of both heaps
EXIT	- Terminates the program
