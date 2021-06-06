package org.cg.apps.calcydemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorUnitTest2 {

    @Mock
    Adder adder;

    @InjectMocks
    @Spy
    Calculator calculator;

   @Test
    public void testAdd_1(){
       when(adder.add(1,2)).thenReturn(3);
       Calculator calculator=new  Calculator(adder);
         int result=calculator.add(1,2);
        assertEquals(3,result);
   }


    @Test
    public void testAddBy10_1(){
        doReturn(13).when(calculator).add(3,10);
        int result=calculator.addBy10(3);
        assertEquals(13,result);
    }




}
