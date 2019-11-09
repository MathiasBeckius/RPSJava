import terminalgame.TerminalGame;
import terminalgame.platform.LinuxTerminal;
import terminalgame.ui.TerminalUI;

public class RockPaperScissors
{
    public static void main(String[] args)
    {
        LinuxTerminal io = new LinuxTerminal();
        TerminalUI ui = new TerminalUI(io);
        TerminalGame game = new TerminalGame(ui);
        while (game.isRunning());
    }
}
