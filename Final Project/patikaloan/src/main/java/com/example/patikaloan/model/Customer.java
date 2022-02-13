package com.example.patikaloan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
@ApiModel(value = "Customer Api Model Documentation",description = "Model")
public class Customer {

    @ApiModelProperty(value = "Unique id field for Customer object")
    @Id
    private Long tcId;

    @ApiModelProperty(value = "Name field of Customer object ")
    @Column(nullable = false)
    private String name;

    @ApiModelProperty(value = "Surname field for Customer object")
    @Column(nullable = false)
    private String surname;

    @ApiModelProperty(value = "Salary field for Customer object")
    @Column
    private Integer salary;

    @ApiModelProperty(value = "Phone Number field for Customer object")
    @Column(unique = true)
    private String phoneNumber;

    @ApiModelProperty(value = "Credit Note field for Customer object")
    @Column
    @Min(0)
    private Integer creditNote;
}
