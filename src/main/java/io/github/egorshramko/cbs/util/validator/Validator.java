package io.github.egorshramko.cbs.util.validator;

public interface Validator<T> {
    Boolean validate(T obj);
}
