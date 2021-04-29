package com.gjw;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author 郭经伟
 * @Date 2021/4/29
 * java7和java8StreamAPI对比
 * 如果有一个需求，需要对数据库查询到的菜肴进行一个处理：
 * <p>
 * 筛选出卡路里小于400的菜肴
 * 对筛选出的菜肴进行一个排序
 * 获取排序后菜肴的名字
 **/
public class StreamAPITest {

    /**
     * java7之前的写法来解决上述需求
     *
     * @param dishList
     * @return
     */
    private List<String> beforeJava7(List<Dish> dishList) {

        List<Dish> lowCaloricDishes = new ArrayList<Dish>();
        // 1.筛选出卡路里小于400的菜肴
        for (Dish dish : dishList) {

            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        //2.对筛选出的菜肴进行一个排序
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {

            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });
        // 3.获取排序后的菜肴名字
        List<String> lowCaloricDishesName = new ArrayList<String>();
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }


    public List<String> afterJava8(List<Dish> dishList) {

        return dishList.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(dish -> dish.getCalories()))
                .map(dish -> dish.getName())//提取菜肴名称
                .collect(Collectors.toList());//转换为List
    }

    // 对数据库查询到的菜肴根据菜肴种类进行分类，返回一个Map<Type, List<Dish>>的结果

    private static Map<Type, List<Dish>> beforeJdk8(List<Dish> dishList) {

        Map<Type, List<Dish>> result = new HashMap<>();
        for (Dish dish : dishList) {
            // 不存在则初始化
            if (result.get(dish.getType()) == null) {
                List<Dish> dishes = new ArrayList<>();
                dishes.add(dish);
                result.put(dish.getType(), dishes);
            } else {
                // 存在则追加
                result.get(dish.getType()).add(dish);
            }
        }
        return result;
    }

    private static Map<Type,List<Dish>> afterJdk8(List<Dish> dishList){
        return dishList.stream().collect(groupingBy(Dish::getType));
    }

}
