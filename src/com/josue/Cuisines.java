package com.josue;
import java.util.Scanner;

public class Cuisines {
	
	private static final Scanner INPUT_READER = new Scanner(System.in);
	private static final FoodFactory FOOD_FACTORY = FoodFactory.getFactory();
	
	static {
		FoodFactory.getFactory().registerCuisine("Chinese", new Chinese());
		FoodFactory.getFactory().registerCuisine("Italian", new Italian());
		FoodFactory.getFactory().registerCuisine("Japanese", new Japanese());
		FoodFactory.getFactory().registerCuisine("Mexican", new Mexican());
	}

	public static void main(String[] args) {
		
		int totalNumberOfOrders = Integer.parseInt(INPUT_READER.nextLine());
		
		while(totalNumberOfOrders-- > 0) {
			String[] food = INPUT_READER.nextLine().split(" ");
			String cuisine = food[0];
			String dish = food[1];
			
			try {
				if (FOOD_FACTORY.equals(FoodFactory.getFactory())) {
					Cuisine servedFood = FOOD_FACTORY.serveCuisine(cuisine, dish);
					
					switch(cuisine) {
					case "Chinese":
						Chinese chineseDish = (Chinese) servedFood;
						System.out.println("Serving "+chineseDish.getDish()+ "(Chinese)");
						break;
					case "Italian":
						Italian italianDish = (Italian) servedFood;
						System.out.println("Serving "+italianDish.getDish()+ "(Italian)");
						break;
					case "Japanese":
						Japanese japaneseDish = (Japanese) servedFood;
						System.out.println("Serving "+japaneseDish.getDish()+ "(Japanese)");
						break;
					case "Mexican":
						Mexican mexicanDish = (Mexican) servedFood;
						System.out.println("Serving "+mexicanDish.getDish()+ "(Mexican)");
						break;
					default:
						break;
					}
					
				}
			}catch (UnservableCuisineRequestException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

}


class UnservableCuisineRequestException extends Exception{

	private static final long serialVersionUID = 76606495705497313L;

	public UnservableCuisineRequestException(String message) {
		super(message);
	}
}

abstract class Cuisine{
	
	public abstract Cuisine serveFood(String dish);
	
}




class FoodFactory{
	private static FoodFactory foodFactory;
	
	Chinese chinese;
	Italian italian;
	Japanese japanese;
	Mexican mexican;
	
	public static FoodFactory getFactory() {
		if (foodFactory == null) {
			foodFactory = new FoodFactory();
		}
		return foodFactory;
	}

	public void registerCuisine(String name, Cuisine cuisine) {
		switch(name) {
		case "Chinese":
			chinese = (Chinese)cuisine;
			break;
		case "Italian":
			italian = (Italian)cuisine;
			break;
		case "Japanese":
			japanese = (Japanese)cuisine;
			break;
		case "Mexican":
			mexican = (Mexican)cuisine;
			default:
				break;
		}
	}

	public Cuisine serveCuisine(String _cuisine, String dish) throws UnservableCuisineRequestException {

		if ("Chinese".equals(_cuisine)) {
			return chinese.serveFood(dish);
		} else if ("Italian".equals(_cuisine)) {
			return italian.serveFood(dish);
		} else if ("Japanese".equals(_cuisine)) {
			return japanese.serveFood(dish);
		} else if ("Mexican".equals(_cuisine)) {
			return mexican.serveFood(dish);
		} else {
			String message = "Unservable cuisine ".concat(_cuisine).concat(" for dish ").concat(dish);
			throw new UnservableCuisineRequestException(message);
		}
	}
}


class Chinese extends Cuisine{
	String dish = "";
	
	public String getDish() {
		return this.dish;
	}
	
	@Override
	public Cuisine serveFood(String dish) {
		this.dish = dish;
		return this;
	}
}

class Italian extends Cuisine{
	String dish = "";
	public String getDish() {
		return this.dish;
	}
	
	@Override
	public Cuisine serveFood(String dish) {
		this.dish = dish;
		return this;
	}
}

class Japanese extends Cuisine{
	String dish = "";
	public String getDish() {
		return this.dish;
	}
	
	@Override
	public Cuisine serveFood(String dish) {
		this.dish = dish;
		return this;
	}
}

class Mexican extends Cuisine{
	String dish = "";
	public String getDish() {
		return this.dish;
	}
	
	@Override
	public Cuisine serveFood(String dish) {
		this.dish = dish;
		return this;
	}
}
