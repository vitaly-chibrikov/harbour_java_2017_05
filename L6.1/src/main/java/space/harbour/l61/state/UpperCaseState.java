package space.harbour.l61.state;

/**
 * Created by tully.
 */
public class UpperCaseState implements State {
    @Override
    public void print(StateContext context, char letter) {
        System.out.print(String.valueOf(letter).toUpperCase());
        if (letter != ' ') {
            context.setState(new LowerCaseState());
        }
    }
}
