package pt.unl.fct.di.iadidemo.security

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import pt.unl.fct.di.iadidemo.security.domain.BookDAO
import pt.unl.fct.di.iadidemo.security.domain.BookRepository
import pt.unl.fct.di.iadidemo.security.domain.UserDAO
import pt.unl.fct.di.iadidemo.security.domain.UserRepository

@SpringBootApplication
class SecurityApplication(val books:BookRepository, val users:UserRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {

        val b = BookDAO(0,"LOR", emptyList(), emptyList())
        books.save(b)

        println(BCryptPasswordEncoder().encode("password1"))
        val u1 = UserDAO("user1",BCryptPasswordEncoder().encode("password1"),"USER","User 1", emptyList())
        users.save(u1)

        val u2 = UserDAO("admin1",BCryptPasswordEncoder().encode("password1"),"ADMIN","Admin 1", emptyList())
        users.save(u2)
    }

}

fun main(args: Array<String>) {
    runApplication<SecurityApplication>(*args)
}
