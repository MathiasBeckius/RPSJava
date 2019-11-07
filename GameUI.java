public class GameUI implements TerminalUI
{
    private TerminalIO io;

    public GameUI(TerminalIO io)
    {
        this.io = io;
    }

    public void clear()
    {
        this.io.clearScreen();
    }

    public void show(String message)
    {
        this.io.write(message);
    }

    public String read(String message)
    {
        this.io.write(message);
        return this.io.readLine();
    }
}

