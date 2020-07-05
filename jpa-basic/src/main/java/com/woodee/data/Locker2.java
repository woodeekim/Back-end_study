package com.woodee.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Locker2 {

    @Id @GeneratedValue
    private Long id;

    private String name;

}
