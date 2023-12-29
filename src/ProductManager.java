package src;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    public Product addNewProduct(){

        System.out.print("Nhap ma san pham: ");
        int id = intInput();
        System.out.print("Nhap ten san pham: ");
        String name = stringInput();
        System.out.print("Nhap gia san pham: ");
        double price = doubleInput();
        System.out.print("Nhap hang san xuat: ");
        String brand = stringInput();
        System.out.print("Nhap mo ta san pham:");
        String script = stringInput();
        Product p = new Product(id, name, price, brand, script);
        return p;
    }
    public static int intInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static String stringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static double doubleInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
    public void writeData(String path, List<Product> list){
        try {
            FileOutputStream file = new FileOutputStream(path);
            ObjectOutputStream os = new ObjectOutputStream(file);
            os.writeObject(list);
            os.close();
            file.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Product> readData(String path){
        List<Product> list = new ArrayList<>();
        try {
            FileInputStream fi = new FileInputStream(path);
            ObjectInputStream oi = new ObjectInputStream(fi);
            list = (List<Product>) oi.readObject();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
