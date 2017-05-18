package space.harbour.l151.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by tully.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AddLog {
    String message();
}
