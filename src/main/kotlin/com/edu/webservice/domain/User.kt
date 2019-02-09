package com.edu.webservice.domain

import javax.persistence.Entity;
import java.time.LocalDateTime
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(
    @Id
    val name: String,
    val age: Int,
    val lastUpdatetime: LocalDateTime) {

    private constructor() : this("UNKNOWN", -1, LocalDateTime.MIN)
}