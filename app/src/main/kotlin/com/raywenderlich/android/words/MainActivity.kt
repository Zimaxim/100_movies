/*
 * Copyright (c) 2021 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.words

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.raywenderlich.android.words.ui.LoadingUi
import com.raywenderlich.android.words.ui.WordListUi
import com.raywenderlich.android.words.ui.bars.MainTopBar
import com.raywenderlich.android.words.ui.theme.WordsTheme

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Movie", "Step onCreate")
        viewModel.load()
        setContent {
            val search by viewModel.search.collectAsState()

//      val words by viewModel.words      // 2
            val words by viewModel.words.collectAsState()
            val isLoading by viewModel.isLoading.collectAsState()
            WordsTheme {
                when {
                    isLoading -> LoadingUi()
                    else -> WordListUi(
                        words,
                        search = search,
                        onSearch = viewModel::search,
                        onSave = viewModel::saveComment
                    )
                }
            }
        }
    }
}


/*
val openDialog = remember { mutableStateOf(true) }
var text by remember { mutableStateOf("") }

if (openDialog.value) {
    AlertDialog(
        onDismissRequest = {
            openDialog.value = false
        },
        title = {
            Text(text = "Title")
        },
        text = {
            Column() {
                TextField(
                    value = text,
                    onValueChange = { text = it }
                )
                Text("Custom Text")
                Checkbox(checked = false, onCheckedChange = {})
            }
        },
        buttons = {
            Row(
                modifier = Modifier.padding(all = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { openDialog.value = false }
                ) {
                    Text("Dismiss")
                }
            }
        }
    )
}


* */


//      WordsTheme {
//        WordListUi(words = words)       // 3
//      }
//    }

//    setContent {
//      WordsTheme {
//        WordListUi(words = viewModel.words)
////          WordListUi()
//
//
////        Scaffold(
////          topBar = { MainTopBar() },
////          content = {
////            Box(
////              modifier = Modifier.fillMaxSize(),
////              contentAlignment = Alignment.Center,
////            ) {
////              Text(text = "Hello Words!")
////            }
////          }
////        )
//      }
//    }
//  }

//}
