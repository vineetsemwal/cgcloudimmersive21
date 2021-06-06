package org.cg.apps.calcydemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;


public class CalculatorUnitTest {


    @Test
    public void testAdd_1(){
        Adder adder=mock(Adder.class);
        when(adder.add(1,2)).thenReturn(3);
        Calculator calculator=new  Calculator(adder);

        int result=calculator.add(1,2);
        assertEquals(3,result);
    }


    @Test
    public void testList_experiment(){
        List<Integer>list=mock(List.class);
        when(list.get(0)).thenReturn(10);
        when(list.get(1)).thenReturn(20);

        int e1=list.get(0);
        int e2=list.get(1);

        System.out.println("e1="+e1+" e2="+e2);
        verify(list).get(0);
        verify(list).get(10);
    }



    @Test
    public void testAddBy10_1(){
      Calculator calculator=spy(Calculator.class);
     // when(calculator.add(3,10)).thenReturn(13);
      doReturn(13).when(calculator).add(3,10);
      int result=calculator.addBy10(3);
      assertEquals(13,result);
    }

}
