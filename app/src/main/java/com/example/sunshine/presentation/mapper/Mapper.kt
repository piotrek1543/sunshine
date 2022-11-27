package com.example.sunshine.presentation.mapper

import com.example.sunshine.domain.model.List

/**
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer layers
 *
 * @param <V> the view model input type
 * @param <D> the domain model output type
 */
interface Mapper<out V, in D> {

    fun mapToView(type: D): V

}