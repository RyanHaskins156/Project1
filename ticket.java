import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ticket {
    public static void main(String[] args)
    {
        int numberOfTickets = 100;
           for (int i = 0; i < 3; i++)
           {
            System.out.println("Ticket Counter " + (i + 1));
            ticketCounter(numberOfTickets);
            numberOfTickets = (i == 0) ? 100 : 1000;
           }

    }
    public static void ticketCounter(int numberOfTickets)
    {
        Queue<Integer> ticketQueue = new LinkedList<>();
        Random rand = new Random();

        for (int customer = 1; customer <= numberOfTickets; customer++)
        {
            int ticketsAdded = rand.nextInt(4) + 1;
            ticketQueue.offer(ticketsAdded);
        }

        int totalTicketsSold = 0;
        while (!ticketQueue.isEmpty() && totalTicketsSold < numberOfTickets)
        {
            int ticketsToSell = ticketQueue.poll();
            if (totalTicketsSold + ticketsToSell > numberOfTickets) {
                ticketsToSell = numberOfTickets - totalTicketsSold;
            }
            totalTicketsSold += ticketsToSell;
            System.out.println("Sold " + ticketsToSell + " tickets. Total sold: " + totalTicketsSold);
            int ticketsRemaining = numberOfTickets - totalTicketsSold;
            if (ticketsRemaining > 0) {
                System.out.println(ticketsRemaining + " tickets remaining.");
            } else {
                System.out.println("All tickets sold out!");
            }
        }
        System.out.println("Tickets sold: " + totalTicketsSold);
        System.out.println("Remaining tickets: " + (numberOfTickets - totalTicketsSold));
        System.out.println("Customers left in queue: " + ticketQueue.size());
        
    }
}