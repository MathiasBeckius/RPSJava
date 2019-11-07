/*
 * TODO: introduce boundary to state machine => new class that
 * handles States.
 *  class StateRunner
 *  class StateMachine
 */
public class TerminalGame
{
    private State state;

    public TerminalGame(TerminalUI ui)
    {
        this.state = new StartOfGameState(ui);
    }

    public boolean isRunning()
    {
        this.state = this.state.run();
        return !(this.state instanceof TerminateGameState);
    }
}
