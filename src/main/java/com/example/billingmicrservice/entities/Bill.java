package com.example.billingmicrservice.entities;

import com.example.billingmicrservice.model.Costumer;
import lombok.*;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//bill= facture
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Builder @Setter @Getter
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billDate;
    private Long costumerId;

    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;

    @Transient
    private Costumer costumer;
}
