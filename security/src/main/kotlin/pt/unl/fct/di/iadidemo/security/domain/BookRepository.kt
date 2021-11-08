package pt.unl.fct.di.iadidemo.security.domain

import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookDAO, Number> {

    // must define a query to efficiently retrive reviews of a given book
}