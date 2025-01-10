# CPU Scheduling Simulator

## Overview
The **CPU Scheduling Simulator** is a Java-based graphical application that simulates various CPU scheduling algorithms, including **First-Come-First-Serve (FCFS)**, **Shortest Job First (SJF)**, **Round Robin (RR)**, and **Priority Scheduling**. The application allows users to input processes with specific attributes and visualizes the execution order along with performance metrics, such as average waiting time and turnaround time.

## Features
- **User-Friendly GUI**: Intuitive interface built using Swing components.
- **Dynamic Scheduling**: Supports FCFS, SJF, RR (with quantum time), and Priority scheduling.
- **Process Management**: Add, delete, and clear processes dynamically.
- **Performance Metrics**: Displays average waiting time and turnaround time.
- **Visual Design**: Gradient background for an appealing interface.

## Project Structure
- **`models`**:
    - `Validation`: Handles input validation and error messages.
    - `Services`: Manages processes, performs scheduling, and updates metrics.
    - `CPUSchedule`: Implements scheduling algorithms (FCFS, SJF, RR, Priority).
    - `Process`: Represents a process with burst time, priority, and scheduling results.
- **`gui`**:
    - `MainPage`: Main GUI frame for user interaction.
    - `Panel`: Custom Swing panel with gradient rendering.

## How It Works
1. Enter process details: Process number, burst time, and priority (if applicable).
2. Add the process to the list.
3. Select the scheduling algorithm from the dropdown menu.
4. Click "Run" to execute the scheduling and display the results.
5. View the average waiting time and turnaround time at the bottom.
6. Use the "Clear" or "Reset" buttons to modify or start over.

## Algorithms
### First-Come-First-Serve (FCFS)
- Non-preemptive: Processes execute in the order they arrive.

### Shortest Job First (SJF)
- Non-preemptive: Executes the process with the shortest burst time first.

### Round Robin (RR)
- Preemptive: Processes are executed in time slices based on a quantum.

### Priority Scheduling
- Non-preemptive: Executes processes based on priority (lower value = higher priority).

## Prerequisites
- **Java Development Kit (JDK)**: Version 8 or higher.
- **IDE**: IntelliJ IDEA, Eclipse, or any Java IDE.

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/Som3a-Mo/CPU-Scheduling.git
   ```
2. Open the project in your preferred IDE.
3. Ensure all required libraries are available.
4. Run the MainPage class to launch the application.


## Future Enhancements
- Add support for preemptive scheduling algorithms (e.g., Preemptive SJF, Preemptive Priority).
- Allow dynamic process arrival times.
