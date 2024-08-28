package com.greatech.server.common.dynamic.sql.where.condition;

import org.mybatis.dynamic.sql.AbstractSingleValueCondition;

import java.util.function.Predicate;

public class Cast<T> extends AbstractSingleValueCondition<T> {

    protected Cast(T value) {
        super(value);
    }

    @Override
    public AbstractSingleValueCondition<T> filter(Predicate<? super T> predicate) {
        return null;
    }

    @Override
    public String operator() {
        return null;
    }
}
