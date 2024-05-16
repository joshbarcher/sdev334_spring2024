package pojo;

import java.util.Comparator;

public class LocationComparator implements Comparator<Festival>
{
    @Override
    public int compare(Festival fest1, Festival fest2)
    {
        return fest1.getLocation().compareTo(fest2.getLocation());
    }
}
