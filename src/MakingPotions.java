/* 8 Sep 2015
 *  Solve topcoder making potions problem: 
 *  http://community.topcoder.com/stat?c=problem_statement&pm=10009&rd=13695
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;


class MakingPotions {
	/*
	static class Recipe {
		String[] potions;
		int[] costs;
		String name;
		
		Recipe(String[] potions, int[] costs, String name) {
			this.potions = potions;
			this.costs = costs;
			this.name = name;
		}
		
		Recipe() {
			this(null, null, null);
		}
		
		public boolean equals(Recipe r) {
			return name.equals(r.name);
		}
		public int hashCode() {
			return name.hashCode();
		}
	}
	
	static HashMap<Recipe, Integer> recipeCosts = new HashMap<Recipe, Integer>();
	
	static void parseRecipe(String r, Recipe recipe) {
		String[] recipeSplit = r.split("=");
		
		recipe.name = recipeSplit[0];
		recipeSplit = recipeSplit[1].split("\\+");
		for (String s: recipeSplit) {
			System.out.print(s + "  ");
		}
		System.out.println();
		
		recipe.potions = new String[recipeSplit.length];
		recipe.costs = new int[recipeSplit.length];
		int i = 0;
		for (String potion: recipeSplit) {
			recipe.potions[i] = potion.substring(1);
			recipe.costs[i++] = Integer.parseInt(potion.substring(0, 1));
		}
	}
	
	public static int getCost(String[] marketGoods, int[] cost, String[] recipes) {
		int i = 0;
		for (String potion: marketGoods) {
			Recipe recipe = new Recipe(null, null, potion);
			recipeCosts.put(recipe, cost[i++]);
		}

		for (String r: recipes) {
			Recipe recipe = new Recipe();
			parseRecipe(r, recipe);
			recipeCosts.put(recipe, -1);
		}
		
		boolean changed = true;
		
		while (changed) {
			changed = false;
			for (Entry<Recipe, Integer> e: recipeCosts.entrySet()) {
				Recipe r = e.getKey();
				if (r.potions == null)
					continue;
				
				int j = 0;
				int total_cost = 0;
				for (String p: r.potions) {
					Integer c = recipeCosts.get(new Recipe(null, null, p));
					if (c == null || c == -1)
						break;
					total_cost += c * r.costs[j++];
				}
				if (total_cost != 0 && total_cost < e.getValue()) {
					changed = true;
					e.setValue(total_cost);
				}
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		
		String[] marketGoods = new String[] {"LOVE", "WATER", "HONEY"};
		int[] cost = new int[] {100, 5, 30};
		String[] recipes = new String[] {"LOVE=5WATER+3HONEY"};
		

		getCost(marketGoods, cost, recipes);
		
		
		for (Entry<Recipe, Integer> e: recipeCosts.entrySet()) {
			System.out.println(e.getKey().name + "  " + e.getValue());
		}

		//String[] potions = null;
		//int[] costs = null;
		//parseRecipe(recipes[0], potions, costs);
	
		//System.out.println(potions);
	}
	
	*/
		
	static class Recipe {
		String[] potions;
		int[] potion_costs;
		String name;
		
		Recipe(String[] potions, int[] costs, int cost) {
			this.potions = potions;
			this.potion_costs = costs;
		}
		
		Recipe() {
			this(null, null, -1);
		}
		
		public boolean equals(Recipe r) {
			return name.equals(r.name);
		}
		
		public int hashCode() {
			return name.hashCode();
		}
	}
	
	static HashMap<String, Long> recipeCosts = new HashMap<>();
	static LinkedList<Recipe> recipeList = new LinkedList<>();
	
	static String parseRecipe(String r, Recipe recipe) {
		String[] recipeSplit = r.split("=");
		
		String potion_name = recipeSplit[0];
		recipeSplit = recipeSplit[1].split("\\+");
		
		recipe.potions = new String[recipeSplit.length];
		recipe.potion_costs = new int[recipeSplit.length];
		int i = 0;
		for (String potion: recipeSplit) {
			recipe.potions[i] = potion.substring(1);
			recipe.potion_costs[i++] = Integer.parseInt(potion.substring(0, 1));
		}
		return potion_name;
	}
	
	public static int getCost(String[] marketGoods, int[] cost, String[] recipes) {
		int i = 0;
		for (String potion: marketGoods) {
			//Recipe recipe = new Recipe(null, null, cost[i++]);
			recipeCosts.put(potion, (long) cost[i++]);
		}

		for (String r: recipes) {
			Recipe recipe = new Recipe();
			recipe.name = parseRecipe(r, recipe);
			recipeList.add(recipe);
		}
		
		boolean changed = true;
		
		while (changed) {
			changed = false;
			for (Recipe r: recipeList) {
			
				int j = 0;
				long total_cost = 0;
				Long c = null;
				for (String p: r.potions) {
					c = recipeCosts.get(p);
					if (c == null)
						break;
					total_cost += c * r.potion_costs[j++];
				}
				if (c == null)
					continue;
				
				Long cost_ = recipeCosts.get(r.name);
				if (cost_ == null) {
					recipeCosts.put(r.name, total_cost);
					changed = true;
					continue;
				}
				
				if (cost_ == -1 || total_cost < cost_) {
					changed = true;
					recipeCosts.put(r.name, total_cost);
				}
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		
		String[] marketGoods = new String[] {"OH", "IG", "MN", "VR", "EA", "CV", "YI", "CI", "IH", "BY"};
		int[] cost = new int[] {79, 85, 53, 34, 49, 56, 60, 75, 89, 74};
		String[] recipes = new String[] {"IG=7IH+3IH+3MN+4YI+3IG+9VR+3VR+9CI+8CV", "BY=8EA+4QG+5WE+9UJ", "BY=5CI+9EA+4YI+2BY+4WE+4YI+7QE+3EA+7BY", "QE=7VR+9IH", "LOVE=9BY+4IG+1MN", "CI=8KN+8KN+1OH", "BY=9MN+5MN+4IG+3MN+1IH+6UJ+6QG+5VR", "MN=6IH+3IH+8YI+3YI+1BY+1QE", "WE=9CI+7YI+4QE+9EA+2CV+1IH+1CI+6YI+9KN+8EA", "UJ=9WE+7MN+8YI+4UJ+6KN+4CV", "QG=3KN", "EA=6MN", "VR=7KN+7MN+4CI+5UJ+7BY", "CI=6QE+7QG+1KN+2IH+7MN+8BY+6EA+8CI+9YI", "EA=9QE+7QE+6CI", "KN=1KN+2CV+9UJ+4KN+7VR+3BY+5OH+6EA+7WE", "YI=8QE+6BY+2OH+2KN", "QG=7MN+1QG+8EA+5WE+6KN+4MN", "VR=7QE+4IH+5VR", "CV=3EA+9KN+4IG+8EA+3UJ+2CI+6QG+4WE+9IG+5EA", "IG=9WE+2OH"};
		/*
		Scanner s = new Scanner(System.in);
		
		String line = s.nextLine();
		s.close();
		String[] segments = line.split("\\}");
		
		String[] sa = segments[0].substring(1).split(",");
		
		marketGoods = new String[sa.length];
		int i = 0;
		for (String s1: sa) {
			s1 = s1.trim();
			marketGoods[i] = s1.substring(1, s1.length()-1);
			i++;
		}


		sa = segments[1].substring(segments[1].indexOf('{') + 1).split(",");
		
		cost = new int[sa.length];
		i = 0;
		for (String s1: sa) {
			cost[i] = Integer.parseInt(s1.trim());
			i++;
		}

		sa = segments[2].substring(segments[2].indexOf('{') + 1).split(",");
		
		recipes = new String[sa.length];
		i = 0;
		for (String s1: sa) {
			s1 = s1.trim();
			recipes[i] = s1.substring(1, s1.length()-1);
			i++;
		}
		*/
		getCost(marketGoods, cost, recipes);
		
		
		//for (String r_name: recipeCosts.keySet()) {
		//	System.out.println(r_name + "  " + recipeCosts.get(r_name));
		//}

		Long cost_ = recipeCosts.get("LOVE");
		System.out.println(cost_!=null ? cost_:-1);
		//String[] potions = null;
		//int[] costs = null;
		//parseRecipe(recipes[0], potions, costs);
	
		//System.out.println(potions);
		
		System.out.println(Integer.MAX_VALUE);
	}
}
	
