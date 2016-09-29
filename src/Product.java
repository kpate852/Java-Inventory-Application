
public class Product {

	private int quantityLeft;
	private String category;
	private String name;
	private double price;
	private int ID;
	private String manufacturerName;
	private String shipperName;
	
	public Product(String category, String name,double price, int ID, String manufacturerName, String shipperName, int quantityLeft ) 
	{
	
		this.quantityLeft = quantityLeft;
		this.category = category;
		this.name = name;
		this.price = price;
		this.ID=ID;
		this.manufacturerName = manufacturerName;
		this.shipperName = shipperName;
		
		//quantityLeft=1;
	}

	
	public Product(String name, int ID) {
		this.name=name;
		this.ID=ID;
	}
	
	
	public int getQuantityLeft() {
		return quantityLeft;
	}

	public void setQuantityLeft(int quantityLeft) {
		this.quantityLeft = quantityLeft;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getShipperName() {
		return shipperName;
	}

	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	
	
}
