package com.example.patikaloan.model;

import com.example.patikaloan.enums.CreditStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
@ApiModel(value = "Credit Api Model Documentation",description = "Model")
public class Credit implements Serializable {

    @Id
    @GeneratedValue(generator = "creditIdGenerator",strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Unique id field for credit object")
    private Integer creditId;

    @ApiModelProperty(value = "Credit status field for credit object")
    private CreditStatus status;

    @Column(nullable = false)
    @ApiModelProperty(value = "Amount field for credit object")
    private Integer amount;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",referencedColumnName = "tcId")
    @ApiModelProperty(value = "Customer field for credit object")
    private Customer customer;

}
