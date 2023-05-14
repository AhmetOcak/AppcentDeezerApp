package com.model.albumdetail

data class AlbumDetails(
    val id: Long,
    val title: String,
    val upc: String,
    val link: String,
    val share: String,
    val cover: String,
    val coverSmall: String,
    val coverMedium: String,
    val coverBig: String,
    val coverXl: String,
    val md5Image: String,
    val genreId: Int,
    val genres: AlbumGenres,
    val label: String,
    val nbTracks: Int,
    val duration: Int,
    val fans: Int,
    val releaseDate: String,
    val recordType: String,
    val available: Boolean,
    val tracklist: String,
    val explicitLyrics: Boolean,
    val explicitContentLyrics: Int,
    val explicitContentCover: Int,
    val contributors: ArrayList<AlbumContributors>,
    val artist: AlbumArtist,
    val type: String,
    val tracks: AlbumTracks
)
