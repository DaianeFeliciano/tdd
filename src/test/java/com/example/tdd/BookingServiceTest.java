package com.example.tdd;
import com.example.tdd.model.BookingModel;
import com.example.tdd.repository.BookingRepository;
import com.example.tdd.service.BookingService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@SpringBootTest//  Essa anotação faz intermédio entre os recursos do spring boot e o JUNiT
@RunWith(SpringRunner.class)
public class BookingServiceTest {

    /*CICLO DO TDD
    * - ESCREVER OS TESTES QIE IRÃO FALHAR;
    * - AJUSTES
    * - FAZ O REFACTORY*/

    @TestConfiguration
    static class BookingServiceTesteConfiguration {
        @Bean
        public BookingService bookingService() {
            return new BookingService(); //Cria um Bean de BookingService/ p/ simular a instancia de booking service
        }
    }

    @Autowired
    BookingService bookingService;

    @MockBean
    BookingRepository bookingRepository;

    @Test //  vai calcular os dias da reserva
    public void bookingTesteServiceDaysCalculator () {
        String name = "Daiane";
        int days = bookingService.daysCalculatorWithDataBase(name); // retorna os dias da reversa

        Assertions.assertEquals(days,10); // os dias e o esperado
    }

    @Before
    public void setup() {

        LocalDate checkIn = LocalDate.parse("2022-05-06");
        LocalDate checkOut = LocalDate.parse("2022-05-16");
        BookingModel bookingModel= new BookingModel("1", "Daiane", checkIn, checkOut, 2);

        Mockito.when(bookingRepository.findByReserveName(bookingModel.getReserveName()))
                .thenReturn(java.util.Optional.of(bookingModel));
    }


}
