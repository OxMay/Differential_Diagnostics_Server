package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Lantiets on 06.04.2017.
 */
    @Entity
//@SequenceGenerator(name = "user_", sequenceName = "user_")
    @Table(name = "TrueCyst")
    public class TrueCyst {
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
        private Double A1;

        @Column(name = "A2", nullable = false)
        private Double A2;

        @Column(name = "A3", nullable = false)
        private Double A3;

        @Column(name = "A4", nullable = true)
        private Double A4;

        public TrueCyst(String pacient, Double A1, Double A2, Double A3, Double A4) {
            this.pacient = pacient;
            this.A1 = A1;
            this.A2 = A2;
            this.A3 = A3;
            this.A4 = A4;
        }

        public TrueCyst() {
        }

        public Long getUsersId() {
            return usersId;
        }

        public void setUsersId(Long usersId) {
            this.usersId = usersId;
        }

        public String getPacient() {
            return pacient;
        }

        public void setPacient(String pacient) {
            this.pacient = pacient;
        }

        public Double getA1() {
            return A1;
        }

        public void setA1(Double a1) {
            A1 = a1;
        }

        public Double getA2() {
            return A2;
        }

        public void setA2(Double a2) {
            A2 = a2;
        }

        public Double getA3() {
            return A3;
        }

        public void setA3(Double a3) {
            A3 = a3;
        }

        public Double getA4() {
            return A4;
        }

        public void setA4(Double a4) {
            A4 = a4;
        }
    }


