package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
//@SequenceGenerator(name = "user_", sequenceName = "user_")
@Table(name = "tableWork")
public class tableWork {
        @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
        @GeneratedValue(generator = "increment")
        @GenericGenerator(name = "increment", strategy = "increment")
//    @GeneratedValue(generator = "user_")
        private Long usersId;
//
        @Column(name = "pacient", nullable = false, length = 36)
        private String pacient;

        @Column(name = "A1", nullable = false)
        private String A1;

        @Column(name = "A2", nullable = false)
        private String A2;

        @Column(name = "A3", nullable = false)
        private String A3;

        @Column(name = "A4", nullable = true)
        private Boolean A4;

    public tableWork(String pacient, String A1, String A2, String A3, Boolean A4) {
        this.pacient = pacient;
        this.A1 = A1;
        this.A2 = A2;
        this.A3 = A3;
        this.A4 = A4;
    }
}
