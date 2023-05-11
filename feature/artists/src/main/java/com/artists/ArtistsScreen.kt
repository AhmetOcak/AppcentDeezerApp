package com.artists

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.designsystem.components.DeezerTopAppBar
import com.designsystem.icons.DeezerIcons
import com.model.ArtistData
import com.ui.DeezerResourceCard
import com.ui.FullScreenProgIndicator

@Composable
fun ArtistsScreen(modifier: Modifier = Modifier) {

    val viewModel: ArtistViewModel = hiltViewModel()

    val artistState by viewModel.artistState.collectAsState()

    ArtistsScreenContent(
        modifier = modifier,
        artistState = artistState,
        onArtistClicked = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ArtistsScreenContent(
    modifier: Modifier,
    artistState: ArtistState,
    onArtistClicked: (Int) -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            DeezerTopAppBar(
                title = "Category Name",
                navigationIcon = DeezerIcons.ArrowBack,
                navigationContentDescription = null,
                onNavigateClick = {}
            )
        },
    ) {
        when (artistState) {
            is ArtistState.Loading -> {
                FullScreenProgIndicator()
            }

            is ArtistState.Success -> {
                ArtistList(
                    modifier = modifier,
                    scaffoldPadding = it,
                    artists = artistState.data,
                    onArtistClicked = onArtistClicked
                )
            }

            is ArtistState.Error -> {

            }
        }
    }
}

@Composable
private fun ArtistList(
    modifier: Modifier,
    scaffoldPadding: PaddingValues,
    artists: ArrayList<ArtistData>,
    onArtistClicked: (Int) -> Unit
) {
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxSize()
            .padding(scaffoldPadding),
        columns = GridCells.Fixed(count = 2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(artists, key = { it.id }) {
            DeezerResourceCard(
                modifier = modifier,
                onClick = { onArtistClicked(it.id) },
                resourceImgUrl = it.pictureMedium,
                resourceName = it.name
            )
        }
    }
}