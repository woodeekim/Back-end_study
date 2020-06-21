package com.woodee.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// 빙고판 만들기
/*
1. 중복되지 않게
2. 5x5
 */
public class HashSetEx03 {
    public static void main(String[] args) {
        Set set = new HashSet();
        int[][] board = new int[5][5];

        for(int i=0; set.size()<26; i++){
            set.add((int)(Math.random()*50)+1+"");
        }
        System.out.println("set = " + set);
        Iterator iterator = set.iterator();
        System.out.println("iterator = " + iterator);

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++) {

                //  next()는 반환값이 Object 타입이므로 형변환해서 원래의 타입으로 되돌려 놓아야 한다.
                board[i][j] = Integer.parseInt((String)iterator.next());
                System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
            }
            System.out.println();
        }
    }
}
