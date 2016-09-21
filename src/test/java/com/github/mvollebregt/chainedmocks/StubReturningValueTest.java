package com.github.mvollebregt.chainedmocks;

import com.github.mvollebregt.chainedmocks.testhelpers.ClassToBeMocked;
import org.junit.jupiter.api.Test;

import static com.github.mvollebregt.chainedmocks.ChainedMocks.mock;
import static com.github.mvollebregt.chainedmocks.ChainedMocks.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StubReturningValueTest {

    private final ClassToBeMocked mock = mock(ClassToBeMocked.class);

    @Test
    public void testStubReturningValue() {
        // given
        when(() -> mock.provide(String.class)).then(() -> "expected value");
        // when
        String value = mock.provide(String.class);
        // then
        assertEquals("expected value", value);
    }

}
