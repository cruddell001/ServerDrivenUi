package com.example.models.ui

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonEncoder

@Serializable(UiSerializer::class)
open class ServerView()

@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = ServerView::class)
object UiSerializer: KSerializer<ServerView> {
    override fun deserialize(decoder: Decoder): ServerView {
        TODO("Not yet implemented")
    }

    override fun serialize(encoder: Encoder, value: ServerView) {
        val jsonEncoder = encoder as? JsonEncoder
        when(value) {
            is TextView -> jsonEncoder?.encodeSerializableValue(TextView.serializer(), value)
            is CardView -> jsonEncoder?.encodeSerializableValue(CardView.serializer(), value)
            is ColumnView -> jsonEncoder?.encodeSerializableValue(ColumnView.serializer(), value)
            is FavoriteIconView -> jsonEncoder?.encodeSerializableValue(FavoriteIconView.serializer(), value)
            is FullWidthImageView -> jsonEncoder?.encodeSerializableValue(FullWidthImageView.serializer(), value)
            is SpacerView -> jsonEncoder?.encodeSerializableValue(SpacerView.serializer(), value)
            is BoxView -> jsonEncoder?.encodeSerializableValue(BoxView.serializer(), value)
            is ListView -> jsonEncoder?.encodeSerializableValue(ListView.serializer(), value)
            is AnimatedVisibility -> jsonEncoder?.encodeSerializableValue(AnimatedVisibility.serializer(), value)
            else -> {}
        }
    }
}