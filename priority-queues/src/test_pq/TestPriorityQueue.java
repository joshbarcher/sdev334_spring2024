package test_pq;

import pojo.Festival;
import pojo.LocationComparator;
import pojo.NameComparator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.PriorityQueue;

public class TestPriorityQueue
{
    public static void main(String[] args)
    {
        Festival[] festivalsArray = {
            new Festival("Festival of Lights", LocalDate.now(), 2, "Seattle"),
            new Festival("Music Madness", LocalDate.now().plusDays(5), 3, "Chicago"),
            new Festival("Peanut Festival", LocalDate.now().plusDays(15), 4, "Chicago"),
            new Festival("Art in the Park", LocalDate.now().plusWeeks(1), 2, "New York"),
            new Festival("Food Fiesta", LocalDate.now().plusDays(10), 4, "Austin"),
            new Festival("Tech Innovate", LocalDate.now().plusMonths(1), 2, "San Francisco")
        };

        //plan out my visits to different festivals
        PriorityQueue<Festival> festivalPQ = new PriorityQueue<>(
            new NameComparator()
        );

        //loop over all of our festivals and add them to the pq
        for (Festival fest : festivalsArray) {
            festivalPQ.add(fest);
        }

        //after adding a festival, make a change to the festival
        festivalsArray[3].setName("Zoo Festival");

        //loop over the pq and remove each element
        while (!festivalPQ.isEmpty()) {
            Festival fest = festivalPQ.remove();

            System.out.println("Visited the " + fest.getName() + " (" + fest.getLocation() + ") for "
                + fest.getDurationHours() + " hours!");
        }
    }
}
