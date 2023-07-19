import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    AviaSouls repo = new AviaSouls();

    Ticket ticket1 = new Ticket("Moscow", "Sochi", 9890, 20, 23);
    Ticket ticket2 = new Ticket("Sochi", "Moscow", 5390, 8, 12);
    Ticket ticket3 = new Ticket("Moscow", "Saint Petersburg", 3746, 1, 2);
    Ticket ticket4 = new Ticket("Moscow", "Yerevan", 28_229, 7, 13);
    Ticket ticket5 = new Ticket("Moscow", "Kaliningrad", 12_751, 9, 12);
    Ticket ticket6 = new Ticket("Moscow", "Yerevan", 17_049, 1, 6);
    Ticket ticket7 = new Ticket("Moscow", "Yerevan", 14_579, 2, 6);
    Ticket ticket8 = new Ticket("Moscow", "Sochi", 15900, 18, 23);
    Ticket ticket9 = new Ticket("Moscow", "Sochi", 9890, 20, 24);

    @Test
    public void shouldCompareTo() {

        repo.add(ticket1);
        repo.add(ticket3);

        Ticket[] tickets = {ticket1, ticket3};
        Arrays.sort(tickets);
    }

    @Test
    public void shouldCompareToEquality() {

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);
        repo.add(ticket9);

        Ticket[] tickets = {ticket1, ticket9};
        Arrays.sort(tickets);
    }

    @Test
    public void shouldSearch() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);

        Ticket[] expected = {ticket7, ticket6, ticket4};
        Ticket[] actual = repo.search("Moscow", "Yerevan");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareTime() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);

        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7};
        Arrays.sort(tickets, timeComparator);
    }

    @Test
    public void shouldSearchAndSortBy() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);

        Ticket[] expected = {ticket7, ticket6, ticket4};
        Ticket[] actual = repo.searchAndSortBy("Moscow", "Yerevan", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortBySochi() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);
        repo.add(ticket9);

        Ticket[] expected = {ticket1, ticket9, ticket8};
        Ticket[] actual = repo.searchAndSortBy("Moscow", "Sochi", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByOne() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);
        repo.add(ticket9);

        Ticket[] expected = {ticket5};
        Ticket[] actual = repo.searchAndSortBy("Moscow", "Kaliningrad", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

}
