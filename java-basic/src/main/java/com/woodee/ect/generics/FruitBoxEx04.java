package com.woodee.ect.generics;

import com.woodee.ect.generics.dao.Apple;
import com.woodee.ect.generics.dao.FruitBox;
import com.woodee.ect.generics.dao.Grape;
import com.woodee.ect.generics.service.AppleComp;
import com.woodee.ect.generics.service.FruitComp;
import com.woodee.ect.generics.service.GrapeComp;

import java.util.Collections;
import java.util.stream.Collectors;

public class FruitBoxEx04 {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();
        FruitBox<Grape> grapeBox = new FruitBox<>();

        appleBox.add(new Apple("초록사과", 300));
        appleBox.add(new Apple("초록사과", 100));
        appleBox.add(new Apple("초록사과", 200));

        grapeBox.add(new Grape("초록포도", 400));
        grapeBox.add(new Grape("초록포도", 300));
        grapeBox.add(new Grape("초록포도", 200));

        System.out.println("정렬전");
        System.out.println("appleBox = " + appleBox);
        System.out.println("grapeBox = " + grapeBox);

        System.out.println("정렬후(내림차순)");
        //Box<T>는 ArrayList인 컬렉션 프레임워크.
        //컬렉션 프레임워크와 관련된 클래스는 Collections
        Collections.sort(appleBox.getList(), new AppleComp());
        Collections.sort(grapeBox.getList(), new GrapeComp());
        System.out.println("appleBox = " + appleBox);
        System.out.println("grapeBox = " + grapeBox);

        System.out.println("정렬후(오름차순)");
        Collections.sort(appleBox.getList(),new FruitComp());
        Collections.sort(grapeBox.getList(),new FruitComp());
        System.out.println("appleBox = " + appleBox);
        System.out.println("grapeBox = " + grapeBox);

    }
}
