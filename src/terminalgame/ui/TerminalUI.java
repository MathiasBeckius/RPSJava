package terminalgame.ui;

public class TerminalUI
{
    private TerminalIO io;

    public TerminalUI(TerminalIO io)  { this.io = io; }
    public void clearScreen()         { this.io.clearScreen(); }
    public void write(String message) { this.io.write(message); }

    public String readLine(String message)
    {
        this.io.write(message);
        return this.io.readLine();
    }
}
