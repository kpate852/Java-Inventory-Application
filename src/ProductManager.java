import java.util.ArrayList;
public class ProductManager {

	/*
	 * Stores Products in a arrayList
	 */
	private ArrayList<Product> ProductDatabase=new ArrayList<Product>();
	
	
	public void addProduct(Product p)
	{
		ProductDatabase.add(p);
		//p.setQuantityLeft(1);

	}
	
	public void removeProduct(Product p)
	{
		ProductDatabase.remove(p);
		//p.setQuantityLeft(0);
	}
	
	public void AddQuantity(Product p, int quantity)
	{
		p.setQuantityLeft((p.getQuantityLeft()+quantity));
		
	}
	
	public void removeQuantity(Product p, int quantity)
	{
		if(quantity>p.getQuantityLeft())
		{
			System.out.println("Invalid, you can't remove more that what you have");
		}
		else
		p.setQuantityLeft((p.getQuantityLeft()-quantity));
		
		
	}
	
	public Product searchProductbyName(String name)
	{
		// returns a products that matches the search criteria
		for(int i=0;i<ProductDatabase.size(); i++)
		{
			//ProductDatabase.get(i);
			if(ProductDatabase.get(i).getName().equalsIgnoreCase(name))
			{
				return ProductDatabase.get(i);
			}
		}
		return null;
		
	}
	
	public Product searchProductbyID(int ID)
	{
		// returns a products that matches the search criteria which is ID
		for(int i=0;i<ProductDatabase.size(); i++)
		{
			//ProductDatabase.get(i);
			if(ProductDatabase.get(i).getID()==ID)
			{
				return ProductDatabase.get(i);
			}
		}
		return null;	
	}
	
	public Product searchProductbyPrice(double price)
	{
		// returns a products that matches the search criteria which is price
		for(int i=0;i<ProductDatabase.size(); i++)
		{
			//ProductDatabase.get(i);
			if(ProductDatabase.get(i).getPrice()==price)
			{
				return ProductDatabase.get(i);
			}
		}
		return null;	
	}
	
	public void warnUserForLowProductLevels(Product p)
	{
		if(p.getQuantityLeft()<3)
		{		
			System.out.println("Hey bro, add some of this: " +p.getName());
			System.out.println("Quantites of this product are only " +p.getQuantityLeft());
		}

	}
	
	
	public ArrayList<Product> getProductDatabase() {
		return ProductDatabase;
	}

	public void setProductDatabase(ArrayList<Product> productDatabase) {
		ProductDatabase = productDatabase;
	}
	
}
