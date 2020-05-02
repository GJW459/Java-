package com.gjw;

/**
 * 商品类
 */
public class Goods implements Comparable {

    private String name;
    private double price;

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //按照价格从低到高排序
    @Override
    public int compareTo(Object o) {
        //方式一
        if (o instanceof Goods){
            Goods goods = (Goods) o;
            if (this.price>goods.price){
                return 1;
            }else if (this.price<goods.price){
                return -1;
            }else {
                return this.name.compareTo(goods.name);//降序 添加一个负号
            }
        }
        //法二Double.compare(this.price,good.price);
       throw new RuntimeException("传入数据类型不对");
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
