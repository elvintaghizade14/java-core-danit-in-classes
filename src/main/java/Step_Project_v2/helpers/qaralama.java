package Step_Project_v2.helpers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class qaralama {
  public static void main(String[] args) {
    LocalTime time1 = LocalTime.of(8, 0);
    LocalTime time2 = LocalTime.of(15, 0);
    int secondOfDayTime1 = time1.toSecondOfDay();
    int secondOfDayTime2 = time2.toSecondOfDay();
    Random random = new Random();
    int randomSecondOfDay = secondOfDayTime1 + random.nextInt(secondOfDayTime2 - secondOfDayTime1 + 1);
    System.out.println(LocalTime.ofSecondOfDay(randomSecondOfDay));
  }
}
