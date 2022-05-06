package com.example.tdd;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) //  Essa anotação faz intermédio entre os recursos do spring boot e o JUNiT
public class BookingServiceTest {

    /*CICLO DO TDD
    * - ESCREVER OS TESTES QIE IRÃO FALHAR;
    * - ARRUMAR OS TESTES
    * - FAZ O REFACTORY*/

    @Autowired
    BookingService bookingService;

    @Test //  vai calcular os dias da reserva
    public void bookingTesteServiceDaysCalculator () {
        String name = "Daiane";
        int days = bookingService.daysCalculatorWithDataBase(name);
    }


}
