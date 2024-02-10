import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Notebook {
    private String brand;
    private int ram;
    private int storage;
    private String os;
    private String color;

    // Конструктор
    public Notebook(String brand, int ram, int storage, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.os = os;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    // Метод для фильтрации
    public boolean matchCrities(Map<String, Object> criteria) {
        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            switch (key) {
                case "brand":
                    if (!brand.equalsIgnoreCase((String) value)) {
                        return false;
                    }
                    break;
                case "ram":
                    if (ram < (int) value) {
                        return false;
                    }
                    break;
                case "storage":
                    if (storage < (int) value) {
                        return false;
                    }
                    break;
                case "os":
                    if (!os.equalsIgnoreCase((String) value)) {
                        return false;
                    }
                    break;
                case "color":
                    if (!color.equalsIgnoreCase((String) value)) {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        {
            Set<Notebook> notebook = new HashSet<>();
            // Перечесление ноутбуков и характеристики
            notebook.add(new Notebook("dell", 8, 512, "Windows", "black"));
            notebook.add(new Notebook("HP", 16, 1024, "Linux", "silver"));
            notebook.add(new Notebook("Apple", 32, 256, "Mac", "grey"));
            notebook.add(new Notebook("Acer", 64, 128, "Windows", "blue"));
            notebook.add(new Notebook("Lenova", 8, 500, "Linux", "white"));

            // Запрос у пользователя критериев
            Map<String, Object> filterCriteria = new HashMap<>();
            filterCriteria.put("ram", 8);

            Set<String> osOptions = new HashSet<>();
            osOptions.add("Windows");
            osOptions.add("Linux");
            osOptions.add("Mac");
            filterCriteria.put("os", osOptions);

            Set<String> brandOption = new HashSet<>();
            brandOption.add("HP");
            brandOption.add("Lenova");
            brandOption.add("Apple");
            brandOption.add("Acer");
            brandOption.add("dell");
            filterCriteria.put("brand", brandOption);

            for (Notebook nb : notebook) {
                if (nb.matchCrities(filterCriteria)) {
                    System.out.println("Matching notebook: " + nb.getBrand());
                }
            }
        }
    }
}
