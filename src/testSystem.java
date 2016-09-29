import java.util.InputMismatchException; 
import java.util.Scanner;

public class testSystem {
	public static void main(String[] args) {
		
							//  category, name, price, ID,  manufacturerName,  shipperName, quantityLeft  
		// Product Database
		Product p1=new Product("Lumbers", "Oak", 78.90, 12344, "WoodlandsForest", "Fedex", 1);
		Product p2=new Product("Paints", "Benjamin Moore", 8.90, 1244, "China", "Fedex", 1);
		Product p3=new Product("HouseWare", "PaintBrush", 1.90, 1234400, "China", "Fedex", 1);
		Product p4=new Product("Kitchen", "GlacierBay Sink", 67.90, 124, "China", "Fedex", 1);	
	
		
		
		ProductManager database=new ProductManager();
		database.addProduct(p1);
		database.addProduct(p2);
		database.addProduct(p3);
		database.addProduct(p4);

		
	//----------------------------------------------------------------------------------------------------------------	
		System.out.println("Welcome to the Java Inventory Database System");
		
		int quit=0;
		do 
		{
			try {
			Scanner kb=new Scanner(System.in);
			
			System.out.println();
			
			//Menu
			System.out.println("Press 1 to add or remove a product");
			System.out.println("Press 2 to show Specific quantities of a product");
			System.out.println("Press 3 to show all Products and quanties in the inventory");
			System.out.println("Press 4 to search a product by the price");
			System.out.println("Press 5 to search a product by the name");
			System.out.println("Press 6 to search a product by the ID");
			System.out.println("Press 7 to show details of a product. You have to enter the ID");
			System.out.println("Press 8 to add or remove quantities of a product");
			System.out.println("Press 9 to quit");
			
			int userChoice=kb.nextInt();
			switch(userChoice)
			{
			
			
				case 1: //add/remove a Product
				{
						System.out.println("You chose to add/remove a Product. Press 1 to add or 2 to remove");
						int choice=kb.nextInt();
						if(choice==1)
						{
							System.out.println("You chose to add a prodcut");
							System.out.println("What is the category of the product?");
							String category=kb.next();
							System.out.println("What is the name of the product?");
							String name=kb.next();
							System.out.println("What is the general price of the product?");
							double price=kb.nextDouble();
							System.out.println("What is the ID of the product?");
							int id=kb.nextInt();
							System.out.println("What are some additional details you can mention. Manufacter Name?");
							String ManufactureName=kb.next();
							System.out.println("Shipper Name?");
							String shipperName=kb.next();
							System.out.println("What is the quanitity you have at this time?");
							int quantityLeft=kb.nextInt();
							
							Product product=new Product(category, name, price, id, ManufactureName , shipperName, quantityLeft);
							database.addProduct(product);
							
							System.out.println("Product has been sucessfully added to the inventory. Would you like to add another product? Type y for yes or n for no");
							String ans=kb.next();
							if(ans.equalsIgnoreCase("n"))
							{
								System.out.println("Thank you for adding the product to the inventory.");
								
							}
							
						}
						if(choice==2)
						{
							// Remove product goes here
						}
				}
				//quit=8;
				break;
				
				case 2: // search quantities for a specific product
				{
					System.out.println("You choose to search quantities for a specific product");
					System.out.println("What is the ID of the product?");
					int id=kb.nextInt();
					
					if(database.searchProductbyID(id).getID()==id)
					{
						System.out.println("Quantity left of the Prduct " + id + " is " + database.searchProductbyID(id).getQuantityLeft());
					}
					else
						System.out.println("That id is not valid for our database.");
					
					break;
				}
				case 3:  //show all products and quantities in the database
				{
					System.out.println("You choose to show all products and quantities in the database.");
					for(int i=0;i<database.getProductDatabase().size();i++)
					{
						System.out.println(database.getProductDatabase().get(i).getName() + "\t" +database.getProductDatabase().get(i).getQuantityLeft());
					}
					break;
				}
				case 4: //search a product by the price
				{
					System.out.println("You chose to to search a product by the price");
					System.out.println("Please enter a price to search, and products with that price will appear");
					double price=kb.nextDouble();
					if(database.searchProductbyPrice(price).getPrice()==price)
					{
						System.out.println("We found " +database.searchProductbyPrice(price).getName() + "that matches the price you entered.");
					}
					break;
				}
				
				
				
				case 5:  //search a product by the name
				{
					System.out.println("You chose to to search a product by the name");
					System.out.println("Please enter a name to search, and products with that name will appear");
					String name=kb.next();
					if(database.searchProductbyName(name).getName().equals(name))
					{
						System.out.println("We found " +database.searchProductbyName(name).getName() + "that matches the name you entered.");
					}
					break;
				}
				
				
				
				case 6:  //search a product by the ID
				{
					System.out.println("You chose to to search a product by the ID");
					System.out.println("Please enter a ID to search, and products with that ID will appear");
					int ID=kb.nextInt();
					if(database.searchProductbyID(ID).getID()==ID)
					{
						System.out.println("We found " +database.searchProductbyID(ID).getName() + "that matches the ID you entered.");
					}
					break;
				}
				
				
				
				case 7: //details of a product by the ID
				{
					System.out.println("You chose to to get details of a product by the ID");
					System.out.println("Please enter a ID to search, and products with that ID will appear");
					int ID=kb.nextInt();
					if(database.searchProductbyID(ID).getID()==ID)
					{
						System.out.print("This is what we found " +database.searchProductbyID(ID).getName() + " " +database.searchProductbyID(ID).getCategory()
								+database.searchProductbyID(ID).getID() + " "+database.searchProductbyID(ID).getManufacturerName() +" "
								+database.searchProductbyID(ID).getPrice() + " "+database.searchProductbyID(ID).getShipperName() + " "
								+database.searchProductbyID(ID).getQuantityLeft() );
					}
					break;
				}
				
				
				
				case 8:  //add or remove quantities of a product
				{
					System.out.println("You choose to add or remove quantities of a product");
					System.out.println("IF you want to add quantities, type 'add', otherwise if you want to remove, type 'remove'");
					String choice=kb.next();
					
					if(choice.equalsIgnoreCase("add"))
					{
						
							System.out.println("Enter a product name ");
							String name=kb.next();
							System.out.println("Enter the amount you want to add");
							int quantity=kb.nextInt();
							
							if(database.searchProductbyName(name).getName().equalsIgnoreCase(name))
							{
								database.AddQuantity(database.searchProductbyName(name), quantity);
							}
							System.out.println("Add another quantity to another product? Type 'yes' or 'no'");
							String ans=kb.next();
							if(ans.equalsIgnoreCase("no"))
							{
								System.out.println("Thank you for adding the quantity. Now there is " +database.searchProductbyName(name).getQuantityLeft());
								break;
							}
							
						
					}
					else if(choice.equalsIgnoreCase("remove"))
					{
						
							System.out.println("Enter a product name ");
							String name=kb.next();
							System.out.println("Enter the amount you want to remove");
							int quantity=kb.nextInt();
							
							if(database.searchProductbyName(name).getName().equalsIgnoreCase(name))
							{
								database.removeQuantity(database.searchProductbyName(name), quantity);
								if(database.searchProductbyName(name).getQuantityLeft()<3)
								{
									database.warnUserForLowProductLevels(database.searchProductbyName(name));
								}
								
							}
							System.out.println("Remove another quantity/amount to another product?");
							String ans=kb.next();
							if(ans.equalsIgnoreCase("no"))
							{
								break;
							}
							
						
					}
					else
						System.out.println("Invalid choice");
					break;
				}
				
				
				
				//quit
				case 9:
				{
					System.out.println("Thank you for using the Java Inventory System.");
					quit=9;
					break;
				}
				
				
				default:
				{
					System.out.println("Invalid choice");
				}
				
			}
			
		} // end of try
			
			
			
			// Handles UserInput Errors
			catch(InputMismatchException ie)
			{
				System.out.println("Sorry, we couldnt recoginze that input.Please try again.");
			}
			
			catch(NullPointerException ne)
			{
				System.out.println("Sorry, we couldnt recoginze that name. Please try again");
			}
	}
	
		while(quit!=9);
		
}}

