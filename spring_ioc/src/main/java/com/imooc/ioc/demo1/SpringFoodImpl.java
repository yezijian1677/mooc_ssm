package com.imooc.ioc.demo1;

public class SpringFoodImpl implements SpringFood {
    private String name;
    private String tatste;
    private String foodCate;

    public String getName() {
        return name;
    }

    public String getTatste() {
        return tatste;
    }

    public String getFoodCate() {
        return foodCate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTatste(String tatste) {
        this.tatste = tatste;
    }

    public void setFoodCate(String foodCate) {
        this.foodCate = foodCate;
    }

    @Override
    public String toString() {
        return name + "属于" + foodCate + "," + " 口味" + tatste + "的";
    }
}
