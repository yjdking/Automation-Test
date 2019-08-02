package com.cmb.cashregister;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CashRegisterTest {

    @Mock
    Printer printer;

    @Test
    public void should_get_print_message_correct() {
        Purchase purchase = new Purchase(new Item[]{
                new Item("Apple", 2.5)
        });

        CashRegister cashRegister = new CashRegister(printer);

        cashRegister.process(purchase);

        verify(printer).print("Apple\t2.5\ndiscount:0.8");
    }

    @Test
    public void should_get_discount_0_7_when_price_gt_10() {
        Purchase purchase = new Purchase(new Item[]{
                new Item("Apple", 12.5)
        });

        CashRegister cashRegister = new CashRegister(printer);

        cashRegister.process(purchase);

        verify(printer).print("Apple\t12.5\ndiscount:0.7");
    }

    @Spy
    @InjectMocks
    CashRegister register;

    @Test
    public void should_jump_calculate_discount() {
        Purchase purchase = new Purchase(new Item[]{
                new Item("Apple", 12.5)
        });

        doReturn(0.5).when(register).calculateDiscount(any());

        register.process(purchase);

        verify(printer).print("Apple\t12.5\ndiscount:0.5");
    }
}