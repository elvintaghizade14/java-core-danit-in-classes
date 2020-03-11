package Step_Project_1.gen;

import Step_Project_1.base_classes.Flight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class FlightGenerator {
  static Random gen = new Random();
  static GregorianCalendar gc = new GregorianCalendar();

  public static String cityGen() {
    List<String> cities = Arrays.asList("Baku", "Moscow", "Ankara", "Tbilisi", "Berlin");
    return cities.get(gen.nextInt(cities.size()));
  }

  public static LocalDate genDate() {
    LocalDate start = LocalDate.of(1970, Month.JANUARY, 1);
    long days = ChronoUnit.DAYS.between(start, LocalDate.now());
    return start.plusDays(gen.nextInt((int) days + 1));
  }

  public static LocalTime genTime() {
    LocalTime time1 = LocalTime.of(8, 0);
    LocalTime time2 = LocalTime.of(15, 0);
    int secondOfDayTime1 = time1.toSecondOfDay();
    int secondOfDayTime2 = time2.toSecondOfDay();
    Random random = new Random();
    int randomSecondOfDay = secondOfDayTime1 + random.nextInt(secondOfDayTime2 - secondOfDayTime1 + 1);
    return LocalTime.ofSecondOfDay(randomSecondOfDay);
  }

  public static Flight genFlight() {
    return new Flight(cityGen(), genDate(), genTime(), gen.nextInt(10) * 10 + 10);
  }

  public static void main(String[] args) {
    System.out.println(genTime());
    System.out.println(genDate());
  }
}