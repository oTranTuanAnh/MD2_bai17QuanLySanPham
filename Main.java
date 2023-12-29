import src.Product;
import src.ProductManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        List<Product> list = new ArrayList<>();
        ProductManager productManagers = new ProductManager();
        while (choice != 0){
            System.out.println("-------------------------------------------");
            System.out.println("MENU");
            System.out.println("1. Them san pham");
            System.out.println("2. Hien thi san pham");
            System.out.println("3. Tim kiem san pham theo id");
            System.out.println("0. Exit");
            System.out.print("Nhap lua chon cua ban:");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    list=productManagers.readData("data.txt");
                    list.add(productManagers.addNewProduct());
                    productManagers.writeData("data.txt",list);
                    break;

                case 2:
                    list=productManagers.readData("data.txt");
                    for (Product p:list){
                        System.out.println(p);
                    }
                    break;
                case 3:
                    System.out.print("Nhap id: ");
                    int id = sc.nextInt();
                    list=productManagers.readData("data.txt");
                    int count = -1;
                    for (Product p:list){
                        if (p.getId() == id){
                            System.out.println(p);
                            count++;
                        }
                    }
                    if (count<0){
                        System.out.println("khong tim thay san pham !!!");
                    }
                    break;
                case 0:
                    System.exit(0);
            }

        }
    }
}
