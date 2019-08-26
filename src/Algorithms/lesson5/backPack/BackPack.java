package Algorithms.lesson5.backPack;


import java.util.ArrayList;
import java.util.List;

public class BackPack {

    private int weightPack;
    private int pricePack;
    private List<Item> poolItems;

    public BackPack(int weight) {
        this.weightPack = weight;
    }

    private int totalWeight(List<Item> items) {
        int total = 0;

        for (Item item : items) {
            total+= item.weight;
        }

        return total;
    }

    private int totalPrice(List<Item> items) {
        int total = 0;

        for (Item item : items) {
            total+= item.price;
        }

        return total;
    }

    private void checkBest(List<Item> items) {
        if (poolItems == null) {
            if (totalWeight(items) <= weightPack) {
                poolItems = items;
                pricePack = totalPrice(items);
            }
        } else {
            if (totalWeight(items) <= weightPack && totalPrice(items) > pricePack) {
                poolItems = items;
                pricePack = totalPrice(items);
            }
        }
    }

    public void makePools(List<Item> items) {
        if (items.size() > 0) {
            checkBest(items);
        }

        for (int i = 0; i < items.size(); i++) {
            List<Item> newPool = new ArrayList<>(items);
            newPool.remove(i);
            makePools(newPool);
        }
    }

    public void displayContains() {
        System.out.printf("Цена рюкзака - %d, вес рюкзака - %d\n" +
                "Содержание рюкзака:\n", pricePack, weightPack);
        for (Item item : poolItems) {
            System.out.printf(" %s : вес %d, цена %d \n", item.name, item.weight, item.price);
        }
    }

    public static class Item {
        String name;
        int weight;
        int price;

        public Item(String name, int weight, int price) {
            this.name = name;
            this.weight = weight;
            this.price = price;
        }

    }
}
