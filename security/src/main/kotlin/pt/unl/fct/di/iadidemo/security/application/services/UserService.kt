package pt.unl.fct.di.iadidemo.security.application.services

import org.springframework.stereotype.Service
import pt.unl.fct.di.iadidemo.security.domain.UserDAO
import pt.unl.fct.di.iadidemo.security.domain.UserRepository

@Service
class UserService(val users: UserRepository) {

    fun findUser(username:String) = users.findById(username)

}