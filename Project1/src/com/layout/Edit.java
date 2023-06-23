package com.layout;

import java.util.Scanner;
import com.controllers.DbController;
import com.models.Produk;

public class Edit {
    public static void showEditData(String nama) {
        Scanner input = new Scanner(System.in);

        System.out.println("=".repeat(40));
        System.out.println("Silahkan Pilih Data yang Ingin Diedit");
        System.out.println("=".repeat(40));
        DbController.getDatabase();
        System.out.println("=".repeat(40));
        System.out.println("**Note: Input nama produk dengan benar!!!");
        System.out.print("Pilih Nama Produk: ");
        nama = input.nextLine();

        System.out.println("=".repeat(40));
        System.out.println("Silahkan Pilih Menu Update Data");
        System.out.println("=".repeat(40));
        System.out.println("1. Update Nama");
        System.out.println("2. Update Harga");
        System.out.println("3. Update Jumlah");
        System.out.println("4. Back to Menu");

        System.out.println("=".repeat(40));
        System.out.print("Pilihan: ");
        try {
            int selectMenu = input.nextInt();
            switch (selectMenu) {
                case 1:
                    showEditNama(nama);
                    break;
                case 2:
                    showEditHarga(nama);
                    break;
                case 3:
                    showEditJumlah(nama);
                    break;
                case 4:
                    Menu.showMenu();
                    break;
                default:
                    System.out.println("=".repeat(40));
                    System.out.println("Maaf Nama Produk atau Menu yang Dipilih Tidak Ada");
                    System.out.println("-".repeat(40));
                    Menu.showMenu();
            }
        } catch (Exception e) {
            System.out.println("=".repeat(40));
            System.out.println("Maaf Nama Produk atau Menu yang Dipilih Tidak Ada");
            System.out.println("-".repeat(40));
            Menu.showMenu();
        }
        System.out.println("-".repeat(40));
        Menu.showMenu();
        input.close();
    }

    public static void showEditNama(String nama) {
        Scanner input = new Scanner(System.in);
        Produk produk = DbController.getProdukByNama(nama);

        System.out.println("=".repeat(40));
        System.out.println("Edit Nama");
        System.out.println("=".repeat(40));
        System.out.println("Nama Awal: " + produk.getNama());
        System.out.println("-".repeat(40));
        System.out.print("Nama Baru: ");
        String namaBaru = input.nextLine();
        DbController.updateNama(produk.getId(), namaBaru);

        System.out.println("=".repeat(40));
        System.out.println("Berhasil Update Data Nama");
        System.out.println("-".repeat(40));
        Menu.showMenu();
        input.close();
    }

    public static void showEditHarga(String nama) {
        Scanner input = new Scanner(System.in);
        Produk produk = DbController.getProdukByNama(nama);

        System.out.println("=".repeat(40));
        System.out.println("Edit Nama");
        System.out.println("=".repeat(40));
        System.out.println("Harga Awal: " + produk.getHarga());
        System.out.println("-".repeat(40));
        System.out.print("Harga Baru: ");
        long hargaBaru = input.nextLong();
        DbController.updateHarga(produk.getId(), hargaBaru);

        System.out.println("=".repeat(40));
        System.out.println("Berhasil Update Data Harga");
        System.out.println("-".repeat(40));
        Menu.showMenu();
        input.close();
    }

    public static void showEditJumlah(String nama) {
        Scanner input = new Scanner(System.in);
        Produk produk = DbController.getProdukByNama(nama);

        System.out.println("=".repeat(40));
        System.out.println("Edit Nama");
        System.out.println("=".repeat(40));
        System.out.println("Jumlah Awal: " + produk.getJumlah());
        System.out.println("-".repeat(40));
        System.out.print("Jumlah Baru: ");
        int jumlahBaru = input.nextInt();
        DbController.updateStok(produk.getId(), jumlahBaru);

        System.out.println("=".repeat(40));
        System.out.println("Berhasil Update Data Stok");
        System.out.println("-".repeat(40));
        Menu.showMenu();
        input.close();
    }
}