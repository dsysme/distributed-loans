package com.dsysme.community.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    List<Item> ownedItems;

}
