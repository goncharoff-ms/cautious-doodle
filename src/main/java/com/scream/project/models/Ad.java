package com.scream.project.models;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@Data
@Entity
@Table(name = "AD",schema = "public")
public class Ad {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JoinColumn(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "descriptions")
    private String descriptions;
    @Column(name = "category")
    private String category;
    @Column(name = "numberphone")
    private long numberPhone;

    public Ad(String title, String descriptions, String category, long numberPhone, LocalDateTime date) {
        this.title = title;
        this.descriptions = descriptions;
        this.category = category;
        this.numberPhone = numberPhone;
        this.date = date;
    }

    @Column(name="date")
    private LocalDateTime date;

}
