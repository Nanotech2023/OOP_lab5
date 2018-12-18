package XML;

import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlObject {
   String message() default "defaultObject";
}