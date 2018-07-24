package com.dsysme.community.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="item_id_seq", sequenceName="item_id_seq")
    private Integer id;

    private String description;

    private String status;

    // hashCode must only include primary key because it is used to find the bucket in hash structure.
    // we don't want to end up in a situation were same object according to the equal implementation
    // will be sent to different buckets
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToOne()
    @JoinColumn(name="owner_id")
    private Loaner owner;
}
