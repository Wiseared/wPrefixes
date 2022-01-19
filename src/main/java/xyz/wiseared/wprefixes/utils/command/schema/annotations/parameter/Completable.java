package xyz.wiseared.wprefixes.utils.command.schema.annotations.parameter;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface Completable {

    /**
     * Things to add to the tab complete.
     */
    @NotNull String[] value();

}
