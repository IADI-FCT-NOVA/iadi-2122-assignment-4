package pt.unl.fct.di.iadidemo.security.presentation.api

import org.springframework.web.bind.annotation.RequestMapping
import pt.unl.fct.di.iadidemo.security.presentation.api.dto.BookDTO
import pt.unl.fct.di.iadidemo.security.presentation.api.dto.BookListDTO

@RequestMapping("admin/books")
interface BooksAdminAPI : GenAPI<BookDTO, BookListDTO, BookListDTO> {

}