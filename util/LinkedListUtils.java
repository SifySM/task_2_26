package edu.vsu.ru.util;

import edu.vsu.ru.project.MyLinkedList;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LinkedListUtils {
    public static MyLinkedList<Integer> readLListFromJTable(JTable table) {
        StringBuilder sb = new StringBuilder();
        TableModel tableModel = table.getModel();

        int numberOfColumns = tableModel.getColumnCount();

        for (int i = 0; i < numberOfColumns; i++) {
            sb.append(tableModel.getValueAt(0, i).toString());
            sb.append(" ");
        }

        return convertToList(sb.toString());
    }

    private static MyLinkedList<Integer> convertToList(String unsortedList) {
        MyLinkedList<Integer> sortedList = new MyLinkedList<>();

        if (unsortedList != null) {
            Scanner scn = new Scanner(unsortedList);
            scn.useDelimiter("(\\s|,)+");

            while (scn.hasNext())
                if (!scn.hasNextInt()) {
                    return null;
                } else {
                    sortedList.addLast(scn.nextInt());
                }
        } else {
            return null;
        }

        return sortedList;
    }

    public static int[] toIntArray(String str) {
        Scanner scanner = new Scanner(str);
        scanner.useLocale(Locale.ROOT);
        scanner.useDelimiter("(\\s|[,;])+");
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }

        // из List<Integer> можно получить Integer[]
        Integer[] arr = list.toArray(new Integer[0]);
        // Integer[] -> int[]
        return ArrayUtils.toPrimitive(arr);
    }

    public static MyLinkedList<Integer> readLListFromFile(String fileName) throws FileNotFoundException {
        Scanner scn = new Scanner(new File(fileName));
        String unsortedList;
        unsortedList = scn.nextLine();

        return convertToLList(unsortedList);
    }

    private static MyLinkedList<Integer> convertToLList(String unsortedList) {
        MyLinkedList<Integer> sortedList = new MyLinkedList<>();

        if (unsortedList != null) {
            Scanner scn = new Scanner(unsortedList);
            scn.useDelimiter("(\\s|,)+");

            while (scn.hasNext())
                if (!scn.hasNextInt()) {
                    return null;
                } else {
                    sortedList.addLast(scn.nextInt());
                }
        } else {
            return null;
        }

        return sortedList;
    }

    public static int[] convertToIntArray(MyLinkedList<Integer> LList) {
        int[] arr = new int[LList.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = LList.get(i);
        }

        return arr;
    }

    public static void fillArrayRandomNumbers(int[] arr) {
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
    }
}
