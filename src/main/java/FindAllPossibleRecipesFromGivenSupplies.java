import java.util.*;
import java.util.stream.Collectors;

public class FindAllPossibleRecipesFromGivenSupplies {
    boolean isRecipePossible(List<String> ingredients, Map<String, Integer> recipeMap, Set<String> supplySet) {
        for(String ingredient : ingredients) {
            if (!recipeMap.containsKey(ingredient) && !supplySet.contains(ingredient))
                return false;
        }
        return true;
    }

    boolean isRecipeDoable(boolean[] dependencies) {
        for(boolean dependency : dependencies)
            if (dependency) return false;
        return true;
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> recipeMap = new HashMap<>();
        for(int i = 0; i < recipes.length; ++i) {
            recipeMap.put(recipes[i], i);
        }
        Set<String> supplySet = Arrays.stream(supplies).collect(Collectors.toSet());

        // Map from index in recipes to recipe number (index in possible recipies)
        Map<Integer, Integer> possibleRecipes = new HashMap<>();
        List<Integer> possibleRecipeIndex = new ArrayList<>();
        for(int i = 0; i < recipes.length; ++i) {
            if (isRecipePossible(ingredients.get(i), recipeMap, supplySet)) {
                int recipeNumber = possibleRecipes.size();
                possibleRecipes.put(i, recipeNumber);
                possibleRecipeIndex.add(i);
            }
        }

        // Index by recipe number
        boolean[][] recipeDependency = new boolean[possibleRecipes.size()][possibleRecipes.size()];
        for(Map.Entry<Integer, Integer> possibleRecipe : possibleRecipes.entrySet()) {
            int recipeIndex = possibleRecipe.getKey();
            int recipeNumber = possibleRecipe.getValue();
            for(String ingredient : ingredients.get(recipeIndex)) {
                Integer ingredientIndex = recipeMap.get(ingredient);
                if (ingredientIndex != null) {
                    Integer ingredientNumber = possibleRecipes.get(ingredientIndex);
                    if (ingredientNumber != null)
                        recipeDependency[recipeNumber][possibleRecipes.get(ingredientIndex)] = true;
                    else
                        recipeDependency[recipeNumber][recipeNumber] = true;  // This recipe depends on an impossible recipe, so it's impossible as well
                }
            }
        }

        List<String> doableRecipes = new LinkedList<>();
        Set<Integer> doableRecipeNumbers = new HashSet();
        while(doableRecipes.size() < possibleRecipes.size()) {
            boolean foundNewDoableRecipe = false;
            for(int recipeNumber = 0; recipeNumber < recipeDependency.length; ++recipeNumber) {
                if (!doableRecipeNumbers.contains(recipeNumber) && isRecipeDoable(recipeDependency[recipeNumber])) {
                    foundNewDoableRecipe = true;
                    doableRecipes.add(recipes[possibleRecipeIndex.get(recipeNumber)]);
                    doableRecipeNumbers.add(recipeNumber);
                    for(boolean[] dependency : recipeDependency) {
                        dependency[recipeNumber] = false;
                    }
                }
            }
            if (!foundNewDoableRecipe) break;
        }

        return doableRecipes;
    }
}
