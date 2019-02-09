package com.edu.webservice.service

import com.edu.webservice.domain.User
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/users")
class UserHttpEndpoint {

    private val log = LoggerFactory.getLogger(UserHttpEndpoint::class.java)

    @Autowired
    lateinit var repo: UserRepository

    @GetMapping("/ping")
    fun healthCheck(): String {
        log.info("invoke healthCheck()")
        return "pong"
    }

    @GetMapping("{name}")
    fun find(@PathVariable name: String = ""): Optional<User> {
        log.info("invoke findById($name)")
        return repo.findById(name)
    }

    @GetMapping("/")
    fun findAll(): Iterable<User> {
        log.info("invoke findAll")
        return repo.findAll()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody user: User): User {
        log.info("invoke save($user)")
        return repo.save(user)
    }
}