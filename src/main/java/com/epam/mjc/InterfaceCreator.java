package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String s : x) {
                if((s.charAt(0) + "").toLowerCase().equals(s.charAt(0) + "")) return false;
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> res = new ArrayList<>();
            for (Integer integer : x) {
                if(integer % 2 == 0){
                    res.add(integer);
                }
            }
            x.addAll(res);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> res = new ArrayList<>();
            for (String value : values) {
                if(value.charAt(0) < 91 && value.endsWith(".") && value.split(" ").length > 3){
                    res.add(value);
                }
            }
            System.out.println(res);
            return res;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> res = new HashMap<>();
            for (String s : x) {
                res.put(s, s.length());
            }
            return res;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (x, y) -> {
            List<Integer> res = new ArrayList<>(x);
            res.addAll(y);
            return res;
        };
    }
}
