package pt.unl.fct.di.iadidemo.security.presentation.controllers

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import pt.unl.fct.di.iadidemo.security.domain.BookDAO
import pt.unl.fct.di.iadidemo.security.application.services.BookService
import pt.unl.fct.di.iadidemo.security.presentation.api.BooksAPI
import pt.unl.fct.di.iadidemo.security.presentation.api.dto.*

/**
 * This is a sample class implementing the presentation logic layer for REST services,
 * the controller layer.
 *
 * Each controller implements a set of endpoints declared in a API interface. It performs
 * data format transformation and prepares answers to the REST clients.
 *
 * This controller implements two sample endpoints that use and orchestrate methods
 * from one or more components from the service layer. Notice the use of DTO classes
 * to define the types of the enpoint parameters and results. Data transformations are
 * necessary in all cases.
 */

@RestController
class BookController(val books: BookService) : BooksAPI {

    override fun getAll(): List<BookListDTO> =
        books.getAll().map { BookListDTO(it.id, it.title, emptyList(), emptyList()); };

    override fun addOne(book: BookDTO):Unit =
        books.addOne(BookDAO(0,book.title, emptyList(), emptyList()));

    override fun getOne(id:Long): BookListDTO =
        books
            .getOne(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found ${id}") }
            .let {
                BookListDTO(
                    it.id,
                    it.title,
                    it.authors.map { AuthorsBookDTO(it.name) },
                    it.reviews.map { ReviewBookDTO(it.id, it.review, it.rating, it.user.username) }
                )
            }

    override fun updateOne(id: Long, elem: BookDTO) {
        TODO("Not yet implemented")
    }

    override fun deleteOne(id: Long) {
        TODO("Not yet implemented")
    }

    override fun getReviews(id: Long): List<ReviewBookDTO> {
        TODO("Not yet implemented")
    }

    override fun addReview(id: Long, review: ReviewDTO): List<ReviewBookDTO> {
        TODO("Not yet implemented")
    }

    override fun getReviewOfBook(id: Long, bid: Long): ReviewBookLongDTO {
        TODO("Not yet implemented")
    }

    override fun updateReviewOfBook(id: Long, bid: Long, review: ReviewDTO) {
        TODO("Not yet implemented")
    }

    override fun deleteReviewOfBook(id: Long, bid: Long) {
        TODO("Not yet implemented")
    }
}