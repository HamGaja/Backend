package com.example.hamgaja.products.entity;

import com.example.hamgaja.products.dto.ProductRequestDto;
import com.example.hamgaja.products.dto.S3ResponseDto;
import com.example.hamgaja.users.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String star;
    @Column(nullable = false,length = 4000)
    private String description;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ProductType productType;

    @Column(nullable = false)
    private String ownerComment;
    //Product 의 위치
    @Column(nullable = false)
    private String address;
    //호텔 상세 주소
    @OneToOne
    @JoinColumn(name="location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(nullable = false)
    private String imageUrl;

    @OneToMany(mappedBy = "product")
    private List<Room> rooms;

    public void update(ProductRequestDto productRequestDto) {
        this.name = productRequestDto.getName();
        this.star = productRequestDto.getStar();
        this.description = productRequestDto.getDescription();
        this.ownerComment = productRequestDto.getOwnerComment();
        this.address = productRequestDto.getAddress();

    }


}
