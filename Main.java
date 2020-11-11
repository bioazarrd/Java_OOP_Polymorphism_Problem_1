package D_JavaAdvancedOOP.Lecture5_Polymorphism.ExProblem1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Vehicle> vehicleByType = new HashMap<>();

        String[] input = reader.readLine().split("\\s+");
        vehicleByType.put("Car", new Car(Double.parseDouble(input[1]), Double.parseDouble(input[2])));


        input = reader.readLine().split("\\s+");
        vehicleByType.put("Truck", new Truck(Double.parseDouble(input[1]), Double.parseDouble(input[2])));


        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            double param = Double.parseDouble(tokens[2]);
            String type = tokens[1];

            if (tokens[0].equals("Drive")) {
                System.out.println(vehicleByType.get(tokens[1]).drive(param));
            } else {
                vehicleByType.get(type).refuel(param);
            }
        }



        for (Vehicle vehicle : vehicleByType.values()) {
            System.out.println(vehicle.toString());
        }
    }
}