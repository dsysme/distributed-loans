package com.dsysme.community.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Loan {
    @Id
    @GeneratedValue
    private Integer id;

    @GeneratedValue
    private Date startDate;

    private Date returnUntil;

    private Date returnDate;

    @OneToOne
    @JoinColumn(name="holder_id")
    private Loaner holder;

    @OneToOne
    @JoinColumn(name="item_id")
    private Item item;
}
