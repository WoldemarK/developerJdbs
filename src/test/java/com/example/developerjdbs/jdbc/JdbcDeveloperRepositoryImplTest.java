package com.example.developerjdbs.jdbc;


import com.example.developerjdbs.repository.jdbc.JdbcDeveloperRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class JdbcDeveloperRepositoryImplTest {
    @Test
    public void testMethod() {
        @SuppressWarnings("unchecked")
        List<String> mockedList = Mockito.mock(List.class);

        mockedList.add("first-element");
        mockedList.add("second-element");
        mockedList.add("third-element");
        mockedList.add("third-element");
        mockedList.clear();

        verify(mockedList).add("first-element");
        verify(mockedList).add("second-element");
        verify(mockedList, VerificationModeFactory.times(2)).add("third-element");

        verify(mockedList).clear();
    }
    @ExtendWith(MockitoExtension.class)

        @Test
        public void whenNotUseMockAnnotation_thenCorrect() {
            List mockList = Mockito.mock(ArrayList.class);
            //эти методы не будут ничего делать – это заглушки
            mockList.add("one");
            mockList.add("two");
        }

}