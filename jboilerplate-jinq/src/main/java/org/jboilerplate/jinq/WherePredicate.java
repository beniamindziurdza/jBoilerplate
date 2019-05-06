package org.jboilerplate.jinq;


import java.util.Objects;
import org.jinq.orm.stream.JinqStream;

/**
 *
 * @author Beniamin.Dziurdza
 * @param <T>
 */
public interface WherePredicate<T extends Object>
        extends JinqStream.Where<T, RuntimeException> {

    default WherePredicate<T> and(WherePredicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> where(t) && other.where(t);
    }
 
    default WherePredicate<T> negate() {
        return (t) -> ! where(t);
    }
 
    default WherePredicate<T> or(WherePredicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> where(t) || other.where(t);
    }
 
    static WherePredicate isEqual(Object targetRef) {
        return (null == targetRef)
                ? Objects::isNull
                : object -> targetRef.equals(object);
    }                   

}


