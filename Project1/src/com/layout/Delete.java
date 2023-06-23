package com.layout;

import java.util.Scanner;
import com.controllers.DbController;

public class Delete {
    public static void showDeleteData() {
        Scanner input = new Scanner(System.in);

        System.out.println("=".repeat(40));
        System.out.println("Silahkan Pilih Data yang Ingin Dihapus");
        System.out.println("-".repeat(40));
        DbController.getDatabase();
        System.out.println("-".repeat(40));
        System.out.println("Input nama produk dengan benar!");
        System.out.print("Pilih Nama Produk: ");
        String nama = input.nextLine();
        System.out.println("=".repeat(40));

        if (DbController.deleteData(nama)) {
            System.out.println("Berhasil Delete Data");
        } else {
            System.out.println("Maaf, Gagal untuk Delete Data");
        }

        System.out.println("-".repeat(40));
        Menu.showMenu();
        input.close();
    }
}
