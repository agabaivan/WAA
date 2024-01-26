package com.agaba.waacourse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Logger")
public class Logger {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "TransactionId")
        private Long transactionId;

        @Column(name = "Date")
        private Date date;

        @Column(name = "Time")
        private Date time;

        @Column(name = "Principle")
        private String principle;

        @Column(name = "Operation")
        private String operation;

    }


