package rf.store;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {

	private Customer customer;
	private Salesman salesman;
	private Date orderedOn;
	private String deliveryStreet;
	private String deliveryCity;
	private String deliveryCountry;
	private Set<OrderItem> items;

	public Order(Customer customer, Salesman salesman, String deliveryStreet, String deliveryCity, String deliveryCountry, Date orderedOn) {
		this.customer = customer;
		this.salesman = salesman;
		this.deliveryStreet = deliveryStreet;
		this.deliveryCity = deliveryCity;
		this.deliveryCountry = deliveryCountry;
		this.orderedOn = orderedOn;
		this.items = new HashSet<OrderItem>();
	}

	public Customer getCustomer() {
		return customer;
	}

	public Salesman getSalesman() {
		return salesman;
	}

	public Date getOrderedOn() {
		return orderedOn;
	}

	public String getDeliveryStreet() {
		return deliveryStreet;
	}

	public String getDeliveryCity() {
		return deliveryCity;
	}

	public String getDeliveryCountry() {
		return deliveryCountry;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public float total() {
		float totalWithShipping=0;
		float totalItems = 0;
		for (OrderItem item : items) {
			float totalItem=0;
			float itemAmount = item.getProduct().getUnitPrice() * item.getQuantity();
			if (isProductCategoryAnAccessorries(item)) 
				totalItem = calculateTotalOfAccessoriesCategory(itemAmount);
			if (isProductCategoryABikes(item)) 
				totalItem = itemAmount - calculatePercentageAmount(itemAmount, 20);
			if (isProductCategoryACloathing(item)) 
				totalItem = calculateTotalOfClothingCategory(item, itemAmount);
			totalItems += totalItem;
		}
		totalWithShipping=calculateTotalWithShipping(totalItems);
		return totalWithShipping;
	}
	
	private float calculateTotalWithShipping(float totalItems){
		if (this.deliveryCountry == "USA")
			return totalItems + calculatePercentageAmount(totalItems,5);
		return totalItems + calculatePercentageAmount(totalItems,5) + 15;
		
	}

	private float calculateTotalOfClothingCategory(OrderItem item, float itemAmount) {
		float totalItem;
		float cloathingDiscount = 0;
		if (item.getQuantity() > 2) {
			cloathingDiscount = item.getProduct().getUnitPrice();
		}
		totalItem = itemAmount - cloathingDiscount;
		return totalItem;
	}

	private float calculateTotalOfAccessoriesCategory(float itemAmount) {
		float totalItem;
		float booksDiscount = 0;
		if (itemAmount >= 100) 
			booksDiscount = calculatePercentageAmount(itemAmount,10);
		totalItem = itemAmount - booksDiscount;
		return totalItem;
	}

	private boolean isProductCategoryACloathing(OrderItem item) {
		return item.getProduct().getCategory() == ProductCategory.Cloathing;
	}

	private boolean isProductCategoryABikes(OrderItem item) {
		return item.getProduct().getCategory() == ProductCategory.Bikes;
	}
	
	public float calculatePercentageAmount(float amount, float percent){
		float cent=100f;
		return amount*percent/cent;
	}
	

	private boolean isProductCategoryAnAccessorries(OrderItem item) {
		return item.getProduct().getCategory() == ProductCategory.Accessories;
	}
}
