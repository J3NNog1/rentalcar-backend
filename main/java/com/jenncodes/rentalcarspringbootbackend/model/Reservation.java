package com.jenncodes.rentalcarspringbootbackend.model;
import com.jenncodes.rentalcarspringbootbackend.model.Customer;
import com.jenncodes.rentalcarspringbootbackend.model.RentalVehicle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Customer is required")
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @NotNull(message = "Vehicle is required")
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private RentalVehicle vehicle;

    @CreationTimestamp
    @NotNull(message = "Reservation date is required")
    @Column(name = "reservation_date")
    private LocalDateTime reservationDate;

    @CreationTimestamp
    @NotNull(message = "Start date is required")
    @Column(name = "start_date")
    private LocalDateTime startDate;

//    @UpdateTimestamp
    @NotNull(message = "End date is required")
    @Column(name = "end_date")
    private LocalDateTime endDate;



}
