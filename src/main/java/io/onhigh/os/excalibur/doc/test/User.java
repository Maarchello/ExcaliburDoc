package io.onhigh.os.excalibur.doc.test;

import io.onhigh.os.excalibur.doc.api.ExAttribute;

/**
 * @author Marat Kadzhaev
 * @since 22 февр. 2023
 */
public class User {

//    @ExAttribute(name = "ID пользователя")
//    private long id;

    @ExAttribute(name = "Имя", order = 1)
    private String name;

    @ExAttribute(name = "Фамилия", order = 0)
    private String lastName;

//    @ExAttribute(name = "Возраст")
//    private int age;

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
}
