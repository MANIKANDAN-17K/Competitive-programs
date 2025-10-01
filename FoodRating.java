class FoodRatings {
    private HashMap<String,String> FoodToCuisines = new HashMap<>();
    private HashMap<String,Integer> FoodToRating = new HashMap<>();
    private HashMap<String,TreeSet<String>> Cuisines = new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
       for(int i = 0 ;i< foods.length;i++){
            FoodToCuisines.put(foods[i],cuisines[i]); 
            FoodToRating.put(foods[i],ratings[i]);   
       }
       for(int i = 0 ;i<foods.length;i++){
            Cuisines.putIfAbsent(cuisines[i],new TreeSet<> ((a,b) -> {
                int r1 = FoodToRating.get(a);
                int r2 = FoodToRating.get(b);
                if(r1 != r2) return r2 - r1;
                return a.compareTo(b);

            }));
            Cuisines.get(cuisines[i]).add(foods[i]);
       }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisines = FoodToCuisines.get(food);
        TreeSet<String> set = Cuisines.get(cuisines);
        set.remove(food);
        FoodToRating.put(food,newRating);
        set.add(food);
    }
    
    public String highestRated(String cuisine) {
        return Cuisines.get(cuisine).first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
