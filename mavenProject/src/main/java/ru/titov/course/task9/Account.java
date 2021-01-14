package ru.titov.course.task9;

import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class Account {
    private int id;
    private double balance;
    private Holder holder;
}
