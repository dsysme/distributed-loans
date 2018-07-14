package com.dsysme.community.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Loaner {
    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String address;

    private String email;

    private String phone;

    @OneToMany(mappedBy = "owner")
    List<Item> ownedItems;

}