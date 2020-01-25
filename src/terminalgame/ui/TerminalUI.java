package terminalgame.ui;

/**
 * Terminal-based user interface.
 */
public class TerminalUI
{
    private TerminalIO io;

    /**
     * Create an instance of the user interface.
     * @param terminalIO Terminal I/O instance.
     * @throws NullPointerException If null is passed as argument.
     */
    public TerminalUI(TerminalIO terminalIO)
    {
        if (terminalIO == null)
            throw new NullPointerException();
        io = terminalIO;
    }

    /**
     * Clears the terminal screen (buffer).
     */
    public void clearScreen() { io.clearScreen(); }

    /**
     * Write a message on the current line of the terminal.
     * @param message Message
     */
    public void write(String message) { io.write(message); }

    /**
     * Lets the user write a line (finish by pressing Enter/Return).
     * @param message Message
     * @return The line that the user wrote.
     */
    public String readLine(String message)
    {
        io.write(message);
        return io.readLine();
    }
}
