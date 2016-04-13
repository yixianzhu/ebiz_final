package Servlet;

public class Meal {
	
	public Meal(String id,String name,String category,int price)
    {      
        this.setId(id);
        this.setName(name);
       // this.setContinent(continent);
      //  this.setRegion(region);
        this.setCategory(category);
        this.setPrice(price);
            }
	
	public Meal() {
		
	}

    private String id;
    private String name;
    private String category;
  //  private String region;
    private int price;   
  //  private String capital;
    
      
    public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	

	
	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	
	


}

