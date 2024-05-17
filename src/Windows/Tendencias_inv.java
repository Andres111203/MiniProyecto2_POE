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
            String priceStr = product.getPrice();
            String quantityStr = product.getQuantity();
    
            if (priceStr.isEmpty() || quantityStr.isEmpty()) {
                continue;
            }
    
            try {
                double price = Double.parseDouble(priceStr);
                int quantity = Integer.parseInt(quantityStr);
                total += price * quantity;
            } catch (NumberFormatException e) {
                // Manejar el caso en que el precio o la cantidad no se puedan convertir a un número.
                System.err.println("Error al convertir el precio o la cantidad para el producto: " + product.getName());
            }
        }
        return total;
    }    

    public static ArrayList<Product> getMostAndLeastStockedProducts(ArrayList<Product> products) {
        ArrayList<Product> mostAndLeastStocked = new ArrayList<>();
        products.sort(Comparator.comparingInt(p -> {
            String quantityStr = p.getQuantity();
            return quantityStr.isEmpty() ? 0 : Integer.parseInt(quantityStr); 
        }));
        if (!products.isEmpty()) {
            mostAndLeastStocked.add(products.get(products.size() - 1)); 
            mostAndLeastStocked.add(products.get(0)); 
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
            mostUsedTools.add(sortedTools.get(0).getKey()); 
            if (sortedTools.size() > 1) {
                mostUsedTools.add(sortedTools.get(1).getKey()); 
            }
        }
        return mostUsedTools;
    }
}