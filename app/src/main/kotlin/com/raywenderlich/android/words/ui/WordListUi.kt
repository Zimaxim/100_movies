package com.raywenderlich.android.words.ui

import android.R
import android.provider.UserDictionary
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.twotone.CheckCircle
import androidx.compose.material.icons.twotone.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.raywenderlich.android.words.MainViewModel
import com.raywenderlich.android.words.data.words.RandomWords
import com.raywenderlich.android.words.data.words.Word
import com.raywenderlich.android.words.ui.bars.MainTopBar
import com.raywenderlich.android.words.ui.bars.SearchBar
import kotlinx.coroutines.flow.Flow

@Composable
//fun WordListUi(words: List<Word>) {
fun WordListUi(words: Flow<PagingData<Word>>,
               search: String?,
               onSearch: (String?) -> Unit,
               onSave: (Word) -> Unit,
               ) {
//    Log.e("MovieDialog",  "Selected: ${DialogUi()}")

    var showPopup by remember { mutableStateOf(false) }
    var selectedWord by remember { mutableStateOf(Word(value = "", id="",title="", fullTitle = "")) }
    val message = remember{mutableStateOf("")}
    val checkedState = remember { mutableStateOf(false) }

    Scaffold(
//        topBar = { MainTopBar() },
        topBar = { SearchBar(
            search = search,
            onSearch = onSearch,
        ) },
        content = {
            WordsContent(
//                words = RandomWords.map { Word(it) },       // 1
                words = words ,
                onSelected = { word -> Log.e("MoviesContent",
                    "Selected: $word ")
                    selectedWord = word
                    message.value = word.note ?:""
                    checkedState.value = (word.isSelected == 1)

                    showPopup = true


                } // 2
            )
        }
    )

    val onPopupDismissed = { showPopup = false }
    if (showPopup) {
        AlertDialog(
        onDismissRequest = onPopupDismissed,
        text = {

            Column() {
                Text("Selected movie # ${selectedWord.id}")

                Text(text = selectedWord.fullTitle ,
                    fontSize = 18.sp,
                    color = Color.Blue,
                )

                Text("Comment about:")
                TextField(
                    value = message.value,
                    enabled = true,
                    readOnly = false,
                    onValueChange = { newText -> message.value = newText;  Log.i("MovieDialog", newText)  }
                )
                Row(){
                    Checkbox(checked = checkedState.value,
                        onCheckedChange = { checkedState.value = it; Log.i("MovieDialog", """${ if(it) "Yes" else "No"} """) }
                    )
                    Text("The movie was viewed")
                }

            }


        },
        confirmButton = {
            // Button is a pre-defined Material Design implementation of a contained button -
            // https://material.io/design/components/buttons.html#contained-button.
            Button(
                onClick = {
                    selectedWord.note = message.value
                    selectedWord.isSelected = if(checkedState.value) 1 else 0
                    onSave(selectedWord)
                    Log.i("MovieSelected","$selectedWord")
//                    selectedWord.title = message.value
                    showPopup = false
                    onPopupDismissed
                }
            ) {
                Text(text = "Ok")
            }
        })
    }

}

@Composable
private fun LazyItemScope.EmptyContent() {
    Box(
        modifier = Modifier.fillParentMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "No movies")
    }
}

@Composable
private fun WordColumnItem(
    word: Word,
    onClick: () -> Unit,
) {
    Row(                                              // 1
        modifier = Modifier.clickable { onClick() },    // 2
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if( word.isSelected == 1)
        Icon(
            Icons.TwoTone.CheckCircle,
            tint = Color.Green,
            contentDescription = "Просмотрено",
            modifier = Modifier.size(30.dp), //.padding(10.dp),
        )
        else
            Icon(
                Icons.TwoTone.MoreVert,
                contentDescription = "К просмотру",
                tint = Color.LightGray,
                modifier = Modifier.size(30.dp), //.padding(10.dp),
            )

        Text(
            modifier = Modifier.padding(16.dp),           // 3
            text = word.value,
            fontSize = 16.sp,
            color = if(word.isSelected == 1) Color.Blue else Color.DarkGray,
        )
        Text(
            modifier = Modifier.padding(16.dp),           // 3
            text =  word.note?: " " ,
            fontSize = 10.sp,
            fontStyle = FontStyle.Italic,
            color = Color.LightGray
        )

    }
}

@Composable
private fun WordsContent(
    words: Flow<PagingData<Word>>,
    onSelected: (Word) -> Unit,
) {
    // 1
    val items: LazyPagingItems<Word> = words.collectAsLazyPagingItems()
    LazyColumn {
        // 2
        items(items = items) { word ->
            // 3
            if (word != null) {
                WordColumnItem(
                    word = word
                ) { onSelected( word ) }
            }
        }
        if(items.itemCount == 0) {
            item { EmptyContent() }
        }
    }
}





