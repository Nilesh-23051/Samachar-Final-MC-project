package com.hello.samachar.presentation.location

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import com.hello.samachar.domain.model.Article
import com.hello.samachar.presentation.Dimens
import com.hello.samachar.presentation.common.ArticlesList
import com.hello.samachar.presentation.navgraph.Route
import com.hello.samachar.presentation.search.SearchEvent
import com.hello.samachar.presentation.search.SearchState


@Composable
fun LocationScreen(
    articles: LazyPagingItems<Article>,
    navigateToDetails:(Article)->Unit
){
    Column(
        modifier = Modifier
            .padding(top = Dimens.MediumPadding1, start = Dimens.MediumPadding1, end = Dimens.MediumPadding1)
            .statusBarsPadding()
            .fillMaxSize()
    ){
        ArticlesList(
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding1),
            articles = articles,
            onClick = {
                navigateToDetails(it)
            }
        )
    }

}