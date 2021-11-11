import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Car> cars = new ArrayList<Car>();

        readFile("a.txt", cars);
        writeFile("b.txt", cars);
        System.out.println("Hello, World!");
    }

    static void readFile(String fileName, ArrayList<Car> cars) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            String str = bufferReader.readLine();
            cars.add(toCar(str));
            while (str != null) {
                str = bufferReader.readLine();
                cars.add(toCar(str));
            }
            bufferReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static String toString(Car car) {
        String str = null;
        str = car.number + ";" + car.age + ";";
        return str;

    }

    static Car toCar(String str) {

        Car car = null;
        if (str == null) {
            return car;
        }
        try {

            String[] strs = str.split(";");
            String number = strs[0];
            int age = Integer.parseInt(strs[1]);
            car = new Car(number, age);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return car;

    }

    static void writeFile(String fileName, ArrayList<Car> cars) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            for (int i = 0; i < cars.size(); i++) {
                String str = null;
                Car car = cars.get(i);
                if (car != null) {
                    str = toString(cars.get(i));
                    str = str + System.lineSeparator();

                    fileWriter.write(str);
                }

            }
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
