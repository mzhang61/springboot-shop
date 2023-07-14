package com.example.cart.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Accessors(chain = true)
@Setter
@Getter
@Entity
@Table(name = "t_product")
public class Product implements Serializable {

    private static final long serialVersionUID = -4921932609253412600L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    @Length(min = 3, message = "*名称必须至少包含5个字符")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity", nullable = false)
    @Min(value = 0, message = "*数量必须为非负数")
    private Integer quantity;

    @Column(name = "price", nullable = false)
    @DecimalMin(value = "0.00", message = "*价格必须为非负数")
    private BigDecimal price;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product")
    private List<Sold> soldList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
