package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enun.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date: ");
		Date dateBirth = sdf.parse(sc.next());
		Client client = new Client(name, email, dateBirth);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.next();
		Date atualDate = new Date();
		Order order = new Order(atualDate, OrderStatus.valueOf(status), client);
		
		System.out.print("How many items to this order? ");
		int a = sc.nextInt();
				
		for(int n=1; n <= a; n++) {
			sc.nextLine();
			System.out.println("Enter #" + n + " item data:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity:");
			int quantity = sc.nextInt();
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			order.addOrderItem(orderItem);		
		}
		
		System.out.println(order);		
		sc.close();
	}

}
