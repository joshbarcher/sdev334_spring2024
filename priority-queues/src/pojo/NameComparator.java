package pojo;

import java.util.Comparator;

public class NameComparator implements Comparator<Festival>
{
    @Override
    public int compare(Festival fest1, Festival fest2)
    {
        return fest1.getName().compareTo(fest2.getName());
    }
}
