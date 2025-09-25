### Group 4: Java Swing Event Handling Demo

This repository contains the class project for Group 4, focusing on the Foundational Concepts of Java Swing. The application serves as a live demo for our presentation on **Event Handling and User Interactions** as outlined in our assignment.

-----

### Key Features 🚀

This project is a modular demo that showcases key event handling concepts in Java Swing. It includes individual demos for each presenter's topic, as well as a combined application that integrates all the concepts.

The following concepts are demonstrated:

  * **Presenter 1: Event Handling Architecture** - The core Event-Listener model and the role of the Event Dispatch Thread (EDT).
  * **Presenter 2: Action-Based Events** - Handling user actions using the `ActionListener` interface, specifically for button clicks and text field submissions.
  * **Presenter 3: Mouse & Keyboard Events** - Responding to user input from a mouse and keyboard with `MouseAdapter` and `KeyAdapter`.
  * **Presenter 4: Advanced Listeners** - Utilizing more specific listeners like `FocusListener` and `WindowListener` to manage component states and window behavior.

-----

### Getting Started 🛠️

To run this project, you'll need a Java Development Kit (JDK) installed on your system.

1.  **Clone the repository:**

    ```bash
    git clone [Your Repository URL Here]
    ```

2.  **Navigate to the project directory:**

    ```bash
    cd [Your Project Folder]
    ```

3.  **Compile the Java files:**

    ```bash
    javac *.java
    ```

4.  **Run the application:**

    ```bash
    java Main
    ```

-----

### Project Structure 📂

  * `Main.java`: The main class with the `main` method. It creates the primary menu for the application, allowing the user to select which presenter's demo to run.
  * `Presenter1Demo.java`: Demonstrates the core event-listener model and the use of adapter classes.
  * `Presenter2Demo.java`: Showcases the `ActionListener` for buttons and text fields. It also includes a deliberate example of a long-running task to demonstrate EDT blocking.
  * `Presenter3Demo.java`: A demo for handling mouse and keyboard events.
  * `Presenter4Demo.java`: Highlights the use of `FocusListener` and `WindowListener`.
  * `CombinedDemo.java`: A "best case scenario" application that integrates all the concepts from the four presenters into a single, cohesive GUI.

-----

### Usage Guide 🖥️

When you run `Main.java`, a menu window will appear with six buttons:

  * **Presenter 1-4:** Click these buttons to see a focused demo on each presenter's topic. A new window will appear with a simple application showcasing their concepts.
  * **Best Case Scenario:** This option launches a single, more complex application that combines all the event handling concepts into one project.
  * **Exit:** Closes the application.

-----

### Contributors [Groupmates] ✨

This project was created by the members of Group 4.

  * [David Mohale Kananelo](https://github.com/Significant-Hacks)
  * [Sechaba Jeremiah Seabata](https://github.com/hitman1c)
  * [Nkopane John Mats'aba](https://github.com/johnmilliato)
  * Rorisang Eric Ntsane
  * Lecturer: [Dr. Pii Tumelo](https://github.com/PiiTumelo)
  
