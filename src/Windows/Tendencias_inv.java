package Windows;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tendencias_inv {

    public static double getTotalPrice(ArrayList<Product> products) {
        double total = 0;
        for (Product product : products) {
            total += Double.parseDouble(product.getPrice().substring(1)) * Integer.parseInt(product.getQuantity());
        }
        return total;
    }

    public static ArrayList<Product> getMostAndLeastStockedProducts(ArrayList<Product> products) {
        ArrayList<Product> mostAndLeastStocked = new ArrayList<>();
        products.sort(Comparator.comparingInt(p -> Integer.parseInt(p.getQuantity())));
        if (!products.isEmpty()) {
            mostAndLeastStocked.add(products.get(products.size() - 1)); // Product with most stock
            mostAndLeastStocked.add(products.get(0)); // Product with least stock
        }
        return mostAndLeastStocked;
    }

    public static ArrayList<String> getMostUsedTools(ArrayList<Product> products) {
        HashMap<String, Integer> toolCount = new HashMap<>();
        for (Product product : products) {
            String tool = product.getCategory();
            toolCount.put(tool, toolCount.getOrDefault(tool, 0) + 1);
        }
        List<Map.Entry<String, Integer>> sortedTools = new ArrayList<>(toolCount.entrySet());
        sortedTools.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        ArrayList<String> mostUsedTools = new ArrayList<>();
        if (!sortedTools.isEmpty()) {
            mostUsedTools.add(sortedTools.get(0).getKey()); // Most used tool
            if (sortedTools.size() > 1) {
                mostUsedTools.add(sortedTools.get(1).getKey()); // Second most used tool
            }
        }
        return mostUsedTools;
    }
}