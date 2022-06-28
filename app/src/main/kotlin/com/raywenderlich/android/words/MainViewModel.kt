package com.raywenderlich.android.words

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import android.util.Log
import androidx.paging.PagingData
import com.raywenderlich.android.words.data.words.Movie
import com.raywenderlich.android.words.data.words.MoviesApp
import com.raywenderlich.android.words.data.words.Word
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class MainViewModel(application: Application) : AndroidViewModel(application) {
    // 2
//    val words: List<Word> = RandomWords.map { Word(it) }
// search option
    private val _search = MutableStateFlow(null as String?)
    val search: StateFlow<String?> = _search

//    fun search(term: String?) {
//        _search.value = term
//    }
    private val allWords = MutableStateFlow(emptyFlow<PagingData<Word>>())
    private val searchWords = MutableStateFlow(emptyFlow<PagingData<Word>>())

//    private val allMovies = MutableStateFlow(emptyFlow<PagingData<Movie>>())
//    private val searchMovies = MutableStateFlow(emptyFlow<PagingData<Movie>>())

//    Log.i("Movie MVM","Step allMovies")

    //    indicator isLoading
    private val _isLoading = MutableStateFlow (true)
    val isLoading: StateFlow<Boolean> = _isLoading


    private val wordRepository = getApplication<WordsApp>().wordRepository
//    private val movieRepository = getApplication<MoviesApp>().movieRepository

//    private val _words = MutableStateFlow(emptyFlow<PagingData<Word>>())
//    private val _movies = MutableStateFlow(emptyFlow<PagingData<Movie>>())



    @OptIn(ExperimentalCoroutinesApi::class)
    val words: StateFlow<Flow<PagingData<Word>>> =
        search
            .flatMapLatest { search -> words(search) }
            .stateInViewModel(initialValue = emptyFlow())



//    val words: StateFlow<Flow<PagingData<Word>>> = _words

//    private val _words = MutableStateFlow(emptyList<Word>())
//    val words: StateFlow<List<Word>> = _words

//    private val _words =  mutableStateOf(emptyList<Word>()) //mutableStateOf(emptyList()) // 1
//    val words: State<List<Word>> = _words                  // 2

//    val words: List<Word> = runBlocking { wordRepository.allWords() }


    fun load() = effect {
        Log.i("Movie MVM","Step load")
        _isLoading.value = true
//        allMovies.value = movieRepository.allMovies()
        allWords.value = wordRepository.allWords()
        _isLoading.value = false  }

//    fun load() = effect {
//        _isLoading.value = true
//        _words.value = wordRepository.allWords()             // 3
//        _isLoading.value = false
//    }

    private fun effect(block: suspend () -> Unit) {
        Log.i("Movie MVM","Step effect")
        viewModelScope.launch(Dispatchers.IO) { block() }    // 4
    }
    // 1
    private fun words(search: String?) = when {
        search.isNullOrEmpty() -> allWords
        else -> searchWords
    }

    // 2
    private fun <T>  Flow<T>.stateInViewModel(initialValue : T): StateFlow<T> =
        stateIn(scope = viewModelScope, started = SharingStarted.Lazily, initialValue = initialValue)

    fun search(term: String?) = effect {
        _search.value = term
        // 3
        if (term != null) {
            searchWords.value = wordRepository.allWords(term)
        }
    }

    fun saveComment(word: Word) = effect {
        wordRepository.saveComment(word)
//        allWords.value = wordRepository.allWords()
    }

}