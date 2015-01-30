package home;

import com.google.common.base.Joiner;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ly on 1/30/15.
 */
public class Main {
    public static void main(String[] args) {
        int[][] array;
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Read array from console [0] or from file [1]? ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "0":
                array = readArrayFromConsole(scanner);
                break;
            default:
                array = readArrayFromFile(scanner);
        }

        System.out.println(Joiner.on(" ").join(new ArrayService().toSpiralString(array)));

        scanner.close();
    }

    private static int[][] readArrayFromConsole(Scanner scanner) {
        int n = 0;
        int m = 0;
        List integerRows = new LinkedList();

        while (true) {
            System.out.print("Enter a space-separated row of integers: ");
            int[] integerRow = toIntegerArray(scanner.nextLine().trim().split("[ ]+"));
            n++;
            if (m == 0) {
                m = integerRow.length;
            } else if (m != integerRow.length) {
                throw new RuntimeException("doesn't have the same number of columns as the previous ones do.");
            }
            integerRows.add(integerRow);

            System.out.print("Enter another row? [Y/N] ");
            String choice = scanner.nextLine();
            if ("n".equalsIgnoreCase(choice)) {
                break;
            }
        }

        int[][] result = new int[n][m];
        int i = 0;
        for (Object integerRow : integerRows) {
            result[i++] = (int[]) integerRow;
        }

        return result;
    }

    private static int[][] readArrayFromFile(Scanner scanner) {
        int n = 0;
        int m = 0;
        List integerRows = new LinkedList();

        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();
        try (Scanner scan = new Scanner(Paths.get(filePath), StandardCharsets.US_ASCII.name())) {
            while (scan.hasNextLine()) {
                int[] integerRow = toIntegerArray(scan.nextLine().trim().split("[ ]+"));
                n++;
                if (m == 0) {
                    m = integerRow.length;
                } else if (m != integerRow.length) {
                    throw new RuntimeException("doesn't have the same number of columns as the previous ones do.");
                }
                integerRows.add(integerRow);
            }

            int[][] result = new int[n][m];
            int i = 0;
            for (Object integerRow : integerRows) {
                result[i++] = (int[]) integerRow;
            }

            return result;
        }
        catch (IOException ioex) {
            throw new RuntimeException(ioex);
        }
    }

    private static int[] toIntegerArray(String[] array) {
        final int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = Integer.valueOf(array[i]);
        }

        return result;
    }
}
