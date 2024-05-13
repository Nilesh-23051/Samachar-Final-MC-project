package com.hello.samachar.presentation.location

import android.content.pm.PackageManager
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.location.LocationManagerCompat.requestLocationUpdates
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems

import com.hello.samachar.R
import com.hello.samachar.domain.model.Article
import com.hello.samachar.presentation.Dimens
import com.hello.samachar.presentation.common.ArticlesList
import com.hello.samachar.presentation.navgraph.Route
import com.hello.samachar.presentation.search.SearchEvent
import com.hello.samachar.presentation.search.SearchState


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LocationScreen(
    state: LocationState,
    event: (LocationEvent) -> Unit,
//    articles: LazyPagingItems<Article>,
    navigateToDetails:(Article)->Unit
){
//    val titles by remember {
//        derivedStateOf {
//            if (articles.itemCount > 10) {
//                articles.itemSnapshotList.items
//                    .slice(IntRange(start = 0, endInclusive = 9))
//                    .joinToString(separator = " \uD83D\uDFE5 ") { it.title }
//            } else {
//                ""
//            }
//        }
//    }
    Column(
        modifier = Modifier
            .padding(
                top = Dimens.MediumPadding1,
                start = Dimens.MediumPadding1,
                end = Dimens.MediumPadding1
            )
            .statusBarsPadding()
            .fillMaxSize()
    ){

        Spacer(modifier = Modifier.height(Dimens.MediumPadding1))

//        Button(onClick = ) {
//
//        }
//        Text(
//            text = titles, modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = Dimens.MediumPadding1)
//                .basicMarquee(), fontSize = 12.sp,
//            color = colorResource(id = R.color.placeholder)
//        )
        state.articles?.let {
            val articles = it.collectAsLazyPagingItems()
        ArticlesList(
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding1),
            articles = articles,
            onClick = {
                navigateToDetails(it)
            }
        )
        }
    }

}
