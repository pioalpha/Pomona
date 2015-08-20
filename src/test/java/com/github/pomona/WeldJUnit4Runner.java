package com.github.pomona;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

import com.github.common.util.WeldContext;

public class WeldJUnit4Runner extends BlockJUnit4ClassRunner {

    public WeldJUnit4Runner(Class<Object> clazz) throws InitializationError {
        super(clazz);
    }

    @Override
    protected Object createTest() {
        final Class<?> test = getTestClass().getJavaClass();
        return WeldContext.INSTANCE.getBean(test);
    }
}
