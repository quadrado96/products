package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> productList = new ArrayList<>(); 
		
		System.out.print("Enter the number of products: ");
		int quantity = sc.nextInt();
		
		for (int i = 1; i <= quantity; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, Used or Imported (c/u/i)? ");
			char productType = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if ( productType == 'c') {
				productList.add(new Product(name, price));
			}
			
			if ( productType == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				productList.add(new ImportedProduct(name, price, customsFee));
			}
			
			if ( productType == 'u') {
				System.out.print("Manufacture date: ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				productList.add(new UsedProduct(name, price, date));
			}
			
		}
		
		System.out.println("\nPRICE TAGS: ");
		for ( Product product : productList) {
			System.out.println(product.priceTag());
		}
		
		
	}

}
