package com.dsysme.community.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="loan_id_seq", sequenceName="loan_id_seq")
    private Integer id;

    @GeneratedValue
    @Column(nullable = false, insertable = false)
    private Date startDate;

    private Date returnUntil;

    private Date returnDate;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @OneToOne
    @JoinColumn(name="holder_id")
    private Loaner holder;

    @OneToOne
    @JoinColumn(name="item_id")
    private Item item;
}
