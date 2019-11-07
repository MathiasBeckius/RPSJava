public class RockPaperScissors
{
    public static void main(String[] args)
    {
        LinuxTerminal terminal = new LinuxTerminal();
        GameUI ui = new GameUI(terminal);
        TerminalGame game = new TerminalGame(ui);
        while (game.isRunning());
    }
}
