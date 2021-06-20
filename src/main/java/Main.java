import com.google.gson.Gson;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        final int time_zone_difference = 7 * 60 * 60 * 1000; //разница в часовых посяах
        Gson gson = new Gson();
        BufferedReader inputFile = new BufferedReader(new FileReader("tickets.json"));
        FileWriter outputFile = new FileWriter("output.txt");
        TicketList ticketList = gson.fromJson(inputFile, TicketList.class);
        ArrayList<Integer> percentile = new ArrayList<Integer>();
        int average_time_fly = 0;
        int max_fly_time = 0;
        int count_flight = 0;

        for (int i = 0; i < ticketList.getTickets().size(); i++) {
            if (ticketList.getTickets().get(i).getOrigin_name().equals("Владивосток") && ticketList.getTickets().get(i).getDestination_name().equals("Тель-Авив")) {
                String departure_date = ticketList.getTickets().get(i).getDeparture_date();
                String departure_time = ticketList.getTickets().get(i).getDeparture_time();
                String arrival_date = ticketList.getTickets().get(i).getArrival_date();
                String arrival_time = ticketList.getTickets().get(i).getArrival_time();

                DateFormat df1 = new SimpleDateFormat("dd.MM.yy HH:mm");
                Date dateFrom = df1.parse(departure_date + " " + departure_time);
                Date dateTo = df1.parse(arrival_date + " " + arrival_time);
                long timeFly = (dateTo.getTime() - dateFrom.getTime() + time_zone_difference) / 1000 / 60;
                average_time_fly += timeFly;
                percentile.add(i, (int) (timeFly));

                if ((average_time_fly) > max_fly_time) {
                    max_fly_time = (int) timeFly;
                }

                count_flight++;
            }
        }
        average_time_fly /= (count_flight);
        outputFile.write(String.format("Среднее время полета = %d:%02d\n", (average_time_fly / 60), (average_time_fly % 60)));

        /*System.out.println("Среднее время полета = " + (average_time_fly / 60) + ":" + (average_time_fly % 60));
        System.out.println(String.format("\nМаксимальное время полета %d:%02d \n", max_fly_time / 60, max_fly_time % 60));*/

        outputFile.write(String.format("90-й перцентиль %d:%02d\n", (int) (max_fly_time * 0.9 / 60), (int) (max_fly_time * 0.9 % 60)));
        outputFile.write("\nТикеты входящие в 90-й перцентиль:");

        /*System.out.println(String.format("90-й перцентиль %d:%02d", (int) (max_fly_time * 0.9 / 60), (int) (max_fly_time * 0.9 % 60)));
        System.out.println("\nТикеты входящие в 90-й перцентиль:");*/

        int count = 0;
        for (int i = 0; i < percentile.size(); i++) {
            if (percentile.get(i) <= max_fly_time * 0.9) {
                count++;
                outputFile.write(String.format("\n\n%d-й тикет\n", count));
                outputFile.write(String.format("Время полета = %d:%02d\n", (percentile.get(i) / 60), (percentile.get(i) % 60)));
                outputFile.write(ticketList.getTickets().get(i).toString());
            }
        }
        outputFile.close();
    }
}
