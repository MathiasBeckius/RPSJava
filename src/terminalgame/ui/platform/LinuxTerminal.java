package terminalgame.ui.platform;

import terminalgame.ui.TerminalIO;

public class LinuxTerminal implements TerminalIO
{
    public void clearScreen()     { System.out.print("\033\143"); }
    public void write(String str) { System.out.print(str); }
    public String readLine()      { return System.console().readLine(); }
}
