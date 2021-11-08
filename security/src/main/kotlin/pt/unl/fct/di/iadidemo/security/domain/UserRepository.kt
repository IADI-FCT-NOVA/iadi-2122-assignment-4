package pt.unl.fct.di.iadidemo.security.domain

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserDAO,String> {
}