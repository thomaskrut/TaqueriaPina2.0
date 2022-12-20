package Taqueria;

import Taqueria.Order.Order;
import Taqueria.TacoInterface.Taco;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Properties;

public class TacoLogger {

    private static TacoLogger instance;

    private HashMap<String, Integer> log = new HashMap<>();

    boolean logging = false;

    private TacoLogger() {

    }

    public static TacoLogger getInstance() {
        if (instance == null) {
            instance = new TacoLogger();
        }
        return instance;
    }

    public void addLogEntry(Order order) {

        if (!logging) return;

        String filename = "resources/" + LocalDate.now() + ".txt";

        Path path = Path.of(filename);

        String[] tempString;

        for (Taco t : order.getTacoList()) {

            System.out.println(t.getName());

            tempString = t.getName().split(" ");

            int temp;

            if (log.get("Servetter") == null) {
                temp = 1;
            } else {
                temp = log.get("Servetter") + t.getNapkins();
            }

            log.put("Servetter", temp);

            for (String s : tempString) {

                int i;

                if (log.get(s) == null) {
                    i = 1;
                } else {
                    i = log.get(s) + 1;
                }

                log.put(s, i);

                System.out.println(i);

            }

        }



        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))){

            for (String s : log.keySet()) {

                writer.write(s + ": " + log.get(s));
                writer.write("\n");

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void setLoggingOnOrOff() {

        Properties p = new Properties();

        try{
            p.load(new FileInputStream("resources/Logging.properties"));
        }catch(Exception e){
            System.out.println("filen kunde ej hittas");
        }

        if (p.getProperty("logging").equals("on")) {
            logging = true;
            System.out.println("Loggar");
        } else {
            logging = false;
            System.out.println("Loggar inte");
        }

    }


}