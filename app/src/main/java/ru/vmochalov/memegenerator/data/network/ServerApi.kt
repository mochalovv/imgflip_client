package ru.vmochalov.memegenerator.data.network

import ru.vmochalov.memegenerator.data.network.dto.MemeResponseData
import ru.vmochalov.memegenerator.data.network.dto.Response

/**
 * Created by Vladimir Mochalov on 22.09.2019.
 */
interface ServerApi {

    fun getMemes() : Response<MemeResponseData>

    fun captionImage()
}