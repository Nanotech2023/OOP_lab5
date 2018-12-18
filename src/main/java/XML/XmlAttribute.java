package XML;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlAttribute {
    public String tag() default "defaultAttribute";
}
