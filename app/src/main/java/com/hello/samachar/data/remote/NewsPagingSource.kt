package com.hello.samachar.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hello.samachar.domain.model.Article

class NewsPagingSource(
    private val newsApi:NewsApi,
    private val sources: String,

) :PagingSource<Int, Article>(){

    private var totalNewsCount=0
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        //Gonna Make request to the API and return that article
        val page=params.key?:1 //Getting the page using params argument
        return  try{
            val newsResponse=newsApi.getNews(sources=sources,page=page) //Sending Request
            totalNewsCount+=newsResponse.articles.size
            val articles=newsResponse.articles.distinctBy { it.title } //Removing Duplicates
            LoadResult.Page(
                data=articles,
                nextKey=if(totalNewsCount==newsResponse.totalResults) null else page+1,
                prevKey=null
            )
        }
        catch(e:Exception){
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )

        }
    }
    //When we use refresh or load for the first time
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        //anchorPostion is the latest access page in the list
       return state.anchorPosition?.let{anchorPosition ->
           val anchorPage=state.closestPageToPosition(anchorPosition)
           anchorPage?.prevKey?.plus(1)?:anchorPage?.nextKey?.minus(1)
       }
    }
}