package space.harbour.l151.agent;


import java.lang.instrument.Instrumentation;

/**
 * Created by tully.
 */
public class Agent {
    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("Classes loaded: " + instrumentation.getAllLoadedClasses().length);

        instrumentation.addTransformer(new MyClassTransformer());

    }
}
