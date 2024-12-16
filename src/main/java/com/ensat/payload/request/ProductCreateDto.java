package com.ensat.payload.request;

import com.ensat.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateDto {
    private String name;
    private  String image;
    private BigDecimal price; // xem lại kiểu dữ liệu thử có cần dùng BigDecimal không :v Int là đủ :v -> 2^32  2 tỷ 1
    private String title;
    private String description;
    private Integer cID;
}
