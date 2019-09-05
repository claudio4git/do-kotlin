package br.com.jccf.explorer.controller

import br.com.jccf.explorer.jdbc.BookJdbc
import br.com.jccf.explorer.model.Book
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/book")
@CacheConfig(cacheNames = ["books"])
class BookController(
    private val bookJdbc: BookJdbc
) {

    @PostMapping
    @CacheEvict(allEntries = true)
    fun insert(@RequestBody book: Book): ResponseEntity<Int> {
        return try {
            ResponseEntity.ok(bookJdbc.insert(book))
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(-1)
        }
    }

    @PutMapping
    @CacheEvict(allEntries = true)
    fun update(@RequestBody book: Book): ResponseEntity<Int> {
        return try {
            ResponseEntity.ok(bookJdbc.update(book))
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(-1)
        }
    }

    @GetMapping("/{id}")
    fun getBook(@PathVariable("id") id: String): ResponseEntity<Book> {
        val book = bookJdbc.findOne(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(book)
    }

    @GetMapping
    @Cacheable
    fun getAll(pageable: Pageable): Page<Book>? = bookJdbc.findAll(pageable)
}
