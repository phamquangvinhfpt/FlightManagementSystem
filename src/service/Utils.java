/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author hd
 */
public class Utils {

    public static final int MIN = 1;
    public static final int MAX = 100;

    public static String readFile(String fileName) {
        return File.readFile(fileName);
    }

    public static void saveFile(String fileName, String data) {
        File.writeFile(fileName, data);
    }

//    public static List<Product> loadData(String fileName) {
//        List<Product> list = new ArrayList<>();
//        if(readFile(fileName) != null){
//            String rawData = readFile(fileName);
//            String lineData[] = rawData.split("\n");
//            for (int i = 0; i < lineData.length; i++) {
//                String entity[] = lineData[i].split(",");
//                try {
//                    String code = entity[0].trim();
//                    String name = entity[1].trim();
//                    String manuDate = entity[2].trim();
//                    String expDate = entity[3].trim();
//                    int quantity = Integer.parseInt(entity[4].trim());
//                    double price = Double.parseDouble(entity[5].trim());
//                    Product p = new Product(code, name, manuDate, expDate, quantity, price);
//                    list.add(p);
//                } catch (NumberFormatException e) {
//                    System.out.println("Error: " + e.getMessage());
//                }
//            }
//        } 
//        return list;
//    }

//    public static void saveData(String fileName, List<Product> list) {
//        String data = "";
//        for (Product product : list) {
//            data += product.toString() + "\n";
//        }
//        saveFile(fileName, data);
//    }

    public static String getString(String welcome) {
        boolean check = true;
        String result = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println("Input text!!!");
            } else {
                check = false;
            }
        } while (check);
        return result;
    }
    

    public static String getString(String welcome, String oldData) {
        String result = oldData;
        Scanner sc = new Scanner(System.in);
        System.out.print(welcome);
        String tmp = sc.nextLine();
        if (tmp.isEmpty()) {
            result = oldData;
        } else {
            result = tmp;
        }
        return result;
    }

    public static boolean isNumber(String str) {
        boolean result = false;
        if (str.matches("F\\d{4}")) {
            result = true;
        }
        return result;
    }

    public static int getInt(String welcome, int min, int max) {
        boolean check = true;
        int number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static int getInt(String welcome, int min, int max, int oldData) {
        boolean check = true;
        int number = oldData;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Integer.parseInt(tmp);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static double getDouble(String welcome, double min, double max) {
        boolean check = true;
        double number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                number = Double.parseDouble(sc.nextLine());
                if(number < min || number > max){
                    System.out.println("Input number in range [" + min + ", " + max + "]");
                }else{
                check = false;
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static double getDouble(String welcome, double min, double max, double oldData) {
        boolean check = true;
        double number = oldData;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Double.parseDouble(tmp);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static boolean confirmYesNo(String welcome) {
        boolean result = false;
        String confirm = Utils.getString(welcome);
        if ("Y".equalsIgnoreCase(confirm)) {
            result = true;
        }
        return result;
    }

    public static String readNonBlank(String welcome) {
        boolean check = true;
        String result = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty() && result.length()<5) {
                System.out.println("Please input again!!!");
            } else {
                result = result.trim();
                check = false;
            }
        } while (check);
        return result;
    }
}
