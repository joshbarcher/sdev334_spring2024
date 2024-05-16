package pojo;

import java.time.LocalDate;

public class Festival /*implements Comparable<Festival>*/ {
    private String name;
    private LocalDate date;
    private int durationHours;
    private String location;

    public Festival(String name, LocalDate date, int durationHours, String location) {
        this.name = name;
        this.date = date;
        this.durationHours = durationHours;
        this.location = location;
    }

    /*@Override
    public int compareTo(Festival other)
    {
        //return durationHours - other.durationHours;
        return -location.compareTo(other.location);
    }*/

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public int getDurationHours() {
        return durationHours;
    }
    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString()
    {
        return "Festival{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", durationHours=" + durationHours +
                ", location='" + location + '\'' +
                '}';
    }
}
